package Code.Schemas;

import javax.servlet.http.HttpServletRequest;

public class RegistrerSchema {

	private String firstName, lastName, kjonn, password, repetedPassword, mobile, mannChecked = "", kvinneChecked = "",
			errorFirstName = "", errorLastName = "", errorKjonn = "", errorMobile = "", errorPassword = "",
			errorRepetedPassword = "";

	public RegistrerSchema(HttpServletRequest request) {

		this.firstName = request.getParameter("fornavn");
		this.lastName = request.getParameter("etternavn");
		this.kjonn = request.getParameter("kjonn");
		this.mobile = request.getParameter("mobil");
		this.password = request.getParameter("passord");
		this.repetedPassword = request.getParameter("passordRepetert");

		System.out.println(password + " detter er passord");

		isfirstNameValid();
		islastNameValid();
		iskjonnValid();
		ismobilValid();
		ispasswordValid();
		isrepetedPasswordValid();
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getKjonn() {
		return kjonn;
	}

	public String getMobile() {
		return mobile;
	}

	public String getErrorPassword() {
		return errorPassword;
	}

	public String getErrorRepetedPassword() {
		return errorRepetedPassword;
	}

	public String getErrorFirstName() {
		return errorFirstName;
	}

	public String getErrorLastName() {
		return errorLastName;
	}

	public String getErrorKjonn() {
		return errorKjonn;
	}

	public String getErrorMobile() {
		return errorMobile;
	}

	public String getPassword() {
		return password;
	}

	public String getRepetedPassword() {
		return repetedPassword;
	}

	public String getMannChecked() {
		return mannChecked;
	}

	public String getKvinneChecked() {
		return kvinneChecked;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public void setErrorMobile(String errorMobile) {
		this.errorMobile = errorMobile;

	}

	public boolean isValid() {
		return isfirstNameValid() && islastNameValid() && iskjonnValid() && ismobilValid() && ispasswordValid()
				&& isrepetedPasswordValid();
	}

	private boolean ismobilValid() {

		if (String.valueOf(mobile).matches("^\\d{8}$")) {
			errorMobile = "";
			return true;
		}

		errorMobile = "Telefon nummeret er feil!";
		return false;
	}

	private boolean iskjonnValid() {
		if (kjonn == null) {
			errorKjonn = "Du må oppgi kjonn";
			return false;
		}

		if (kjonn.equals("kvinne"))
			kvinneChecked = "checked";
		else
			mannChecked = "checked";
		return true;
	}

	private boolean isfirstNameValid() {
		if (firstName.matches("^[A-ZÆØÅ][a-zæøå\\-\\sA-ZÆØÅ]{2,20}$")) {
			errorFirstName = "";
			return true;
		}
		errorFirstName = "Navnet er ugyldig!";
		return false;
	}

	private boolean islastNameValid() {
		if (lastName.matches("^[A-ZÆØÅ][a-zA-Z\\-ÆØÅæøå]{2,20}$")) {
			errorLastName = "";
			return true;
		}

		errorLastName = "Ugyldig etternavn!";
		return false;

	}

	private boolean ispasswordValid() {
		if (password.length() >= 8) {
			errorPassword = "";
			return true;
		}

		errorPassword = "Passord er ikke gyldig";
		return false;
	}

	private boolean isrepetedPasswordValid() {
		if (repetedPassword.equals(getPassword()) && !repetedPassword.equals("")) {
			errorRepetedPassword = "";
			return true;
		}

		errorRepetedPassword = "Passordet er ikke likt!";
		return false;
	}
}
