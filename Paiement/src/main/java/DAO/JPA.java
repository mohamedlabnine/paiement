package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import Model.Abonnee;
import Model.Agent;
import Model.Facture;
import Model.Payment;
import jakarta.servlet.http.HttpSession;

public class JPA {
	@PersistenceContext (unitName="paiement")
	private EntityManager entitymanager;
	@PersistenceUnit(unitName="paiement")
	private EntityManagerFactory entitymanagerfactory;
	public static final String ACCOUNT_SID = "ACf692c6f6c0d7d550adf4c5040b2b980f";
	 public static final String AUTH_TOKEN = "db19ba5d87e1177b73c9a55f1a16c706";
	public JPA() {
	
	}
	public void sendSMS(String context,String number) {
		 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
	     Message message = Message.creator(
	             new com.twilio.type.PhoneNumber("whatsapp:+212"+number),
	             new com.twilio.type.PhoneNumber("whatsapp:+14155238886"),
	             context)
	         .create();
	}
	public int register(Abonnee abonnee) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entitymanagerfactory  = Persistence.createEntityManagerFactory( "Paiement" );
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		entitymanager.persist(abonnee);
		entitymanager.getTransaction().commit();
		int id=abonnee.getId();
		entitymanager.close();	
		return id;
	}
	public void validerPayment(Payment payment,int idfacture) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entitymanagerfactory  = Persistence.createEntityManagerFactory( "Paiement" );
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("update Facture f set f.etat=:e where f.id=:i ");
		query.setParameter("e","payée");
		query.setParameter("i",idfacture);
		int rowsUpdated = query.executeUpdate();
		entitymanager.persist(payment);
		entitymanager.getTransaction().commit();
		
	}
	
	public void createDefaultFacture(int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entitymanagerfactory  = Persistence.createEntityManagerFactory( "Paiement" );
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Facture f1=new Facture("janvier",500.0,"non payée",id,"file.pdf");
		Facture f2=new Facture("Décembre",500.0,"non payée",id,"file.pdf");
		Facture f3=new Facture("Novembre",500.0,"non payée",id,"file.pdf");
		Facture f4=new Facture("Octobre",500.0,"non payée",id,"file.pdf");
		Facture f5=new Facture("Septembre",500.0,"non payée",id,"file.pdf");
		entitymanager.persist(f1);
		entitymanager.persist(f2);
		entitymanager.persist(f3);
		entitymanager.persist(f4);
		entitymanager.persist(f5);
		entitymanager.getTransaction().commit();
		entitymanager.close();	
	}
	public Abonnee login(Abonnee abonnee) {
        Abonnee match=new Abonnee();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entitymanagerfactory  = Persistence.createEntityManagerFactory( "Paiement" );
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		Query query = entitymanager.createQuery("select a from Abonnee a where a.email=:e and a.password=:p");
		query.setParameter("e",abonnee.getEmail() );
		query.setParameter("p", abonnee.getPassword());
		List<Abonnee> list = (List<Abonnee>) query.getResultList();
		if(list.size()!=0) {
			match=list.get(0);
				
		}
		entitymanager.getTransaction().commit();
		entitymanager.close();
		return match;	
	}
	
	public Agent loginAgent(Agent agent) {
        Agent match=new Agent();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entitymanagerfactory  = Persistence.createEntityManagerFactory( "Paiement" );
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		Query query = entitymanager.createQuery("select a from Agent a where a.email=:e and a.password=:p");
		query.setParameter("e",agent.getEmail() );
		query.setParameter("p", agent.getPassword());
		List<Agent> list = (List<Agent>) query.getResultList();
		if(list.size()!=0) {
			match=list.get(0);
				
		}
		entitymanager.getTransaction().commit();
		entitymanager.close();
		return match;	
	}
public Payment getPayment(int id) {		
        Payment match=new Payment();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entitymanagerfactory  = Persistence.createEntityManagerFactory( "Paiement" );
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		
		Query query = entitymanager.createQuery("select p from Payment p where p.idfacture=:i");
		query.setParameter("i",id);
		List<Payment> list = (List<Payment>) query.getResultList();
		if(list.size()!=0) {
			match=list.get(0);
				
		}
		entitymanager.getTransaction().commit();
		entitymanager.close();
		return match;	
	}
	public List<Facture> getFacturesList(int  id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entitymanagerfactory  = Persistence.createEntityManagerFactory( "Paiement" );
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("select f from Facture f where f.idabonnee=:i ");
		query.setParameter("i",id);
		List<Facture> list = (List<Facture>) query.getResultList();
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		return list;	
	}
	public List<Abonnee> getAbonneeList() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entitymanagerfactory  = Persistence.createEntityManagerFactory( "Paiement" );
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("select a from Abonnee a  ");
		List<Abonnee> list = (List<Abonnee>) query.getResultList();
		
		entitymanager.getTransaction().commit();
		entitymanager.close();
		return list;	
	}
	public Boolean verifyEmail(String email) {
		Abonnee match=new Abonnee();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entitymanagerfactory  = Persistence.createEntityManagerFactory( "Paiement" );
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("select a from Abonnee a where a.email=:e ");
		query.setParameter("e",email );
		List<Abonnee> list = (List<Abonnee>) query.getResultList();
		if(list.size()!=0) {
			match=list.get(0);
			
		}
		entitymanager.getTransaction().commit();
		entitymanager.close();
		if(match.getEmail()!=null) {
			return true;
		}
		else {
			return false;
		}
			
	}
	public Boolean ResetPassword(String email,String password) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entitymanagerfactory  = Persistence.createEntityManagerFactory( "Paiement" );
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("update Abonnee a set a.password=:p where a.email=:e ");
		query.setParameter("e",email );
		query.setParameter("p",password );
		int rowsUpdated = query.executeUpdate();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		return true;
		
		
	}
	public Boolean ChangeState(String state,int id) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		entitymanagerfactory  = Persistence.createEntityManagerFactory( "Paiement" );
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		entitymanager.getTransaction().begin();
		Query query = entitymanager.createQuery("update Abonnee a set a.etat=:e where a.id=:i ");
		query.setParameter("e",state );
		query.setParameter("i",id );
		int rowsUpdated = query.executeUpdate();
		entitymanager.getTransaction().commit();
		entitymanager.close();
		return true;
	}
	
	

}
