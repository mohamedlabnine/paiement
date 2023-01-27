package Model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity @Table( name="facture")
public class Facture  implements Serializable{
	private static final long serialVersionUID = 2L;
	@Id @GeneratedValue( strategy=GenerationType.IDENTITY )
	private int id;
	private String mois;
	private Double montant;
	private String etat;
	private int idabonnee;
	private String file;
	public int getIdabonnee() {
		return idabonnee;
	}
	public void setIdabonnee(int idabonnee) {
		this.idabonnee = idabonnee;
	}
	public Facture() {
		this.id=0;
		this.mois="janvier";
		this.montant=500.0;
		this.idabonnee=0;
		this.etat="non payée";
	}
	public Facture( int id,String mois, Double montant, String etat,int idabonnee,String file) {
		this.id=id;
		this.mois = mois;
		this.montant = montant;
		this.idabonnee=idabonnee;
		this.etat = etat;
		this.file=file;
	}
	public Facture( String mois, Double montant, String etat,int idabonnee,String file) {
		this.mois = mois;
		this.montant = montant;
		this.idabonnee=idabonnee;
		this.etat = etat;
		this.file=file;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMois() {
		return mois;
	}
	public void setMois(String mois) {
		this.mois = mois;
	}
	public Double getMontant() {
		return montant;
	}
	public void setMontant(Double montant) {
		this.montant = montant;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	
}
