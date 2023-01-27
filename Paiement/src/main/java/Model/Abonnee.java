package Model;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity @Table( name="abonnee" )
public class Abonnee  implements Serializable{

	public Abonnee(int id, String firstname, String lastname, String email, String phone, String password,
			String etat) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.etat = etat;
	}
	public Abonnee() {
		this.id=0;
		this.firstname="x";
		this.lastname="x";
		this.email="x";
		this.phone="0";
		this.password="x";
		this.etat="x";
	}
	@Override
	public String toString() {
		return "Abonnee [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", phone=" + phone + ", password=" + password + ", etat=" + etat + "]";
	}
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue( strategy=GenerationType.IDENTITY )
	private int id;
	private String firstname;
	private String lastname;
	private String email;
	@Column(length=50)
	private String phone;
	private String password;
	private String etat;
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
