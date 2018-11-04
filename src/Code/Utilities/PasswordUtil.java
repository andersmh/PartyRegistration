package Code.Utilities;

import java.security.MessageDigest;
import java.security.SecureRandom;
import java.util.Arrays;

import javax.xml.bind.DatatypeConverter;

/**
 * @author Lars-Petter Helland
 */
public class PasswordUtil {

    /*
     * Man kunne godt gjort denne klassen mer fleksibel ved å bytte ut
     * konstanter med konstruktørparametre. P� den annen side: MAN MÅ BRUKE
     * SAMME OPPSETT OVERALT I EN APPLIKASJON.
     */

    private static final int SALTLENGDE = 32;
    private static final String PASSORD_TEGNSETT = "UTF-8";
    private static final String HASH_ALGORITME = "SHA-256";
    private static final int HASH_ITERATIONS = 1000;

    // ".{10,}" means that the length must be at least 10 chars. Nothing else.
//    private static final String VALID_PASSWORD_PATTERN = ".{10,}";

    // ".+" means that the length must be at least 1 chars. Nothing else.
    private static final String VALID_PASSWORD_PATTERN = ".+";

    // ".{4,}" means that the length must be at least 10 chars. Nothing else.
//    private static final String VALID_PASSWORD_PATTERN = ".{4,}";

    /**
     * Denne metoden genererer en passordstreng for sikker lagring av passord.
     * Passordstrengen inneholder både saltet som ble brukt i hashingen og
     * resultatet (digest-et) av hashingen.
     * <p>
     * Det er ikke noen spesiell grunn til at salt og digest bør slås sammen
     * til en streng. De kunne godt vært returnert som to verdier (som et par).
     * Det er gjort slik fordi det gjorde API-et enkelt å bruke, en verdi inn,
     * en verdi ut.
     *
     * @param passord Passord som skal krypteres
     * @return (salt + digest) kodet som en base64-streng.
     */
    public static String krypterPassord(String passord) throws IllegalArgumentException {
        if (passord == null || !passord.matches(VALID_PASSWORD_PATTERN)) {
            throw new IllegalArgumentException("Ugyldig passord. Passordet m� matche " + VALID_PASSWORD_PATTERN);
        }
        byte[] salt = genererTilfeldigSalt();
        return krypterMedSalt(salt, passord);
    }

    /**
     * Denne metoden sjekker om angitt passord matcher kryptert passord
     * (dvs. salt + digest) som tidligere er generert med {@link #krypterPassord(String)}.
     *
     * @param passord  Passord som skal sjekkes
     * @param kryptert (salt + digest) tidligere generert med {@link #krypterPassord(String)}
     * @return om passordet matcher det krypterte passordet
     */
    public static boolean sjekkPassord(String passord, String kryptert) {
        if (passord == null || !passord.matches(VALID_PASSWORD_PATTERN)) {
            throw new IllegalArgumentException("Ugyldig passord. Passordet m� matche " + VALID_PASSWORD_PATTERN);
        }
        if (kryptert == null) {
            throw new IllegalArgumentException("Kryptert passord kan ikke v�re null");
        }
        byte[] salt = hentUtSaltFraKryptertStreng(kryptert);
        return krypterMedSalt(salt, passord).equals(kryptert);
    }

    /*--- Private hjelpemetoder ---*/

    private static byte[] genererTilfeldigSalt() {
        byte[] salt = new byte[SALTLENGDE];
        new SecureRandom().nextBytes(salt);
        return salt;
    }

    private static byte[] hentUtSaltFraKryptertStreng(String kryptert) {
        byte[] saltPlusDigest = DatatypeConverter.parseBase64Binary(kryptert);
        byte[] salt = Arrays.copyOf(saltPlusDigest, SALTLENGDE);
        return salt;
    }

    private static String krypterMedSalt(byte[] salt, String passord) {

        String kryptert = "";

        try {
            byte[] passordBytes = passord.getBytes(PASSORD_TEGNSETT);

            byte[] saltPlusPassord = leggSammen(salt, passordBytes);

            MessageDigest md = MessageDigest.getInstance(HASH_ALGORITME);

            byte[] digest = saltPlusPassord;
            for (int i = 1; i <= HASH_ITERATIONS; i++) {
                digest = md.digest(digest);
            }

            byte[] saltPlusDigest = leggSammen(salt, digest);

            kryptert = DatatypeConverter.printBase64Binary(saltPlusDigest);

        } catch (Exception e) {

            /* Eventuelle unntak her skyldes ugyldig angivelse av tegnsett i
             * passord.getBytes(PASSORD_TEGNSETT) eller ugyldig angivelse av
             * hash-algoritme i MessageDigest.getInstance(HASH_ALGORITME).
             * Unntak vil normalt ikke plutselig oppstå under kjøring, og det er
             * derfor kanskje ikke nødvendig å håndtere dem her. Eller...?
             
             * Hvis det skjer en feil, f.eks. at SHA-2 ikke er implementert
             * i aktuell JVM, vil resultatet av å sluke unntaket bli at vi
             * returnerer en tom streng. Ved senere passord-matching vil alle
             * passord matche de som er generert med denne feilen.
             *
             * Det er jo litt skummelt :(
             *
             * Hva burde vi gjort? ... Tja ... Noe burde vært gjort!
             */
        }
        return kryptert;
    }

    private static byte[] leggSammen(byte[] tabell1, byte[] tabell2) {

        byte[] enOgTo = new byte[tabell1.length + tabell2.length];
        System.arraycopy(tabell1, 0, enOgTo, 0, tabell1.length);
        System.arraycopy(tabell2, 0, enOgTo, tabell1.length, tabell2.length);
        return enOgTo;
    }
}
