package Model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table( name="payment")
public class Payment  implements Serializable{
	private static final long serialVersionUID = 3L;
	@Id @GeneratedValue( strategy=GenerationType.IDENTITY )
	private int id;
	private String cardnumber;
	private Date expire;
	private String cvv;
	private Double montant;
	private int idabonnee;
	private int idfacture;
	private Date current;
	public Payment() {
		
	}
	public Payment(int id, String cardnumber, Date expire, String cvv, Double montant, int idabonnee, int idfacture,
			Date current) {
		
		this.id = id;
		this.cardnumber = cardnumber;
		this.expire = expire;
		this.cvv = cvv;
		this.montant = montant;
		this.idabonnee = idabonnee;
		this.idfacture = idfacture;
		this.current = current;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardnumber() {
		return cardnumber;
	}
	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
	public Date getExpire() {
		return expire;
	}
	public void setExpire(Date expire) {
		this.expire = expire;
	}
	public String getCvv() {
		return cvv;
	}
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public int getIdabonnee() {
		return idabonnee;
	}
	public void setIdabonnee(int idabonnee) {
		this.idabonnee = idabonnee;
	}
	public int getIdfacture() {
		return idfacture;
	}
	public void setIdfacture(int idfacture) {
		this.idfacture = idfacture;
	}
	public Date getCurrent() {
		return current;
	}
	public void setCurrent(Date current) {
		this.current = current;
	}
	
	

}
