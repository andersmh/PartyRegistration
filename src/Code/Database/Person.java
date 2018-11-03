package Code.Database;

import Code.Schemas.RegistrerSchema;
import javax.persistence.*;

@Entity
@Table(schema = "dat108oblig3", name = "attendees")
public class Person {

	@Id
	private String mobilnr;
	private String first_name, last_name, password, kjonn, icon = "";

	public Person() {
	}

	public Person(RegistrerSchema schema) {
		this.mobilnr = schema.getMobile();
		this.first_name = schema.getFirstName();
		this.last_name = schema.getLastName();
		this.password = schema.getPassword();
		this.kjonn = schema.getKjonn();
		icon = kjonn.equals("kvinne") ? "&#9792;" : "&#9794;";
	}

	public String getMobilnr() {
		return prettify(mobilnr);
	}

	public void setMobilnr(String mobilnr) {
		this.mobilnr = mobilnr;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getKjonn() {
		return kjonn;
	}

	public void setKjonn(String kjonn) {
		this.kjonn = kjonn;
	}

	public String geticon() {
		return icon;
	}

	private String prettify(String mobilnr) {
		StringBuilder builder = new StringBuilder();
		builder.append(mobilnr, 0, 3).append(" ").append(mobilnr, 3, 5).append(" ").append(mobilnr, 5, 8);
		return builder.toString();
	}

	@Override
	public String toString() {
		return "Person{" + "mobilnr='" + mobilnr + '\'' + ", first_name='" + first_name + '\'' + ", last_name='"
				+ last_name + '\'' + ", password='" + password + '\'' + ", kjonn='" + kjonn + '\'' + ", icon='" + icon
				+ '\'' + '}';
	}
}
