package no.hvl.dat108;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(schema = "public", name = "deltakere")
public class Deltaker {
	
	@Column(name = "kjonn")
	private String kjonn;
	@Column(name = "navn")
	private String navn;
	@Column(name = "hashpassord")
	private String hashpassord;
	@Id
	@Column(name = "mobil")
	private String mobil;
	
	@ManyToOne
	private Deltakerliste deltakerliste;
	
	public Deltaker() {
		
	}
	
	public Deltaker(String kjonn, String navn, String hashpassord, String mobil) {
		super();
		this.kjonn = kjonn;
		this.navn = navn;
		this.hashpassord = hashpassord;
		this.mobil = mobil;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	public String getNavn() {
		return navn;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public String getHashpassord() {
		return hashpassord;
	}

	public void setHashpassord(String hashpassord) {
		this.hashpassord = hashpassord;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}
	
	public void setListe(Deltakerliste deltakerliste) {
		this.deltakerliste = deltakerliste;
	}

}
