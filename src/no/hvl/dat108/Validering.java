package no.hvl.dat108;

import javax.servlet.http.HttpServletRequest;

public class Validering {
	
	private String fornavn;
	private String etternavn;
	private String mobil;
	private String passord;
	private String passord2;
	private String kjonn;

	public Validering(HttpServletRequest request) {
		this.fornavn = request.getParameter("fornavn");
		this.etternavn = request.getParameter("etternavn");
		this.mobil = request.getParameter("mobil");
		this.passord = request.getParameter("passord");
		this.passord2 = request.getParameter("passordRepetert");
		this.kjonn = request.getParameter("kjonn");
	}
	
	public boolean isAllInputGyldig() {
		return isFornavnGyldig() && 
				isEtternavnGylig() && 
				isMobilGyldig() && 
				isPassordGyldig() &&
				isPassord2Gyldig() &&
				isKjonnGyldig();
	}

	public boolean isKjonnGyldig() {
		return kjonn != null;
	}

	public boolean isPassord2Gyldig() {
		return passord2.equals(passord);
	}

	public boolean isPassordGyldig() {
		return passord.length() > 5;
	}

	public boolean isMobilGyldig() {
		return mobil != null && mobil.matches("^\\d{8}$");
	}

	public boolean isEtternavnGylig() {
		return etternavn.length() > 1 && Character.isUpperCase(etternavn.charAt(0));
	}

	public boolean isFornavnGyldig() {
		return fornavn.length() > 1 && Character.isUpperCase(fornavn.charAt(0));
	}

	public String getFornavn() {
		return fornavn;
	}

	public void setFornavn(String fornavn) {
		this.fornavn = fornavn;
	}


	public String getEtternavn() {
		return etternavn;
	}

	public void setEtternavn(String etternavn) {
		this.etternavn = etternavn;
	}

	public String getMobil() {
		return mobil;
	}

	public void setMobil(String mobil) {
		this.mobil = mobil;
	}


	public String getPassord() {
		return passord;
	}

	public void setPassord(String passord) {
		this.passord = passord;
	}

	public String getPassord2() {
		return passord2;
	}

	public void setPassord2(String passord2) {
		this.passord2 = passord2;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}


}
