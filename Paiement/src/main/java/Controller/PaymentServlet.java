package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import com.twilio.Twilio;

import DAO.JPA;
import Model.Abonnee;
import Model.Facture;
import Model.Payment;

public class PaymentServlet extends HttpServlet {
	JPA jpa= new JPA();
	private static final long serialVersionUID = 1L;
   
    public PaymentServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		Abonnee abonnee=(Abonnee)session.getAttribute("user");
		Payment payment=new Payment();
		payment.setCardnumber(request.getParameter("cardnumber"));
		payment.setCvv(request.getParameter("cvv"));
		payment.setExpire(Date.valueOf(request.getParameter("expire")));
		payment.setIdabonnee(abonnee.getId());
		int idfacture=Integer.parseInt(request.getParameter("idfacture"));
		payment.setIdfacture(idfacture);
		Double montant=Double.parseDouble(request.getParameter("montant"));
		payment.setMontant(montant);
		payment.setCurrent(new java.sql.Date(System.currentTimeMillis()));
		jpa.validerPayment(payment,idfacture);
		jpa.sendSMS("vous avez payée votre facture ",abonnee.getPhone().substring(1));
		
		List<Facture>list=(List<Facture>)session.getAttribute("list");
		for( Facture f :list) {
			if(f.getId()==idfacture) {
				f.setEtat("payée");
			}
		}
		
		
		int nb=0;
		for( Facture f :list) {
			if(f.getEtat().equals("payée")) {
				nb++;
			}
		}
		if(nb==5) {
			jpa.ChangeState("abonné", abonnee.getId());
			abonnee.setEtat("abonné");
		}
		
		session.setAttribute("list", list);
		session.setAttribute("user", abonnee);
		
		String to = abonnee.getEmail();
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		Session session1 = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("nasriyasser007@gmail.com", "vacbmjgsvufxtrhk");
			}
		});
		try {
			MimeMessage message = new MimeMessage(session1);
			//message.setFrom(new InternetAddress(email));// change accordingly
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			message.setSubject("Payement");
			message.setText("you have paid your bill "+montant +"$"+"you can check the pdf in your account");
			// send message
			Transport.send(message);
			System.out.println("message sent successfully");
		}

		catch (MessagingException e) {
			throw new RuntimeException(e);
		}
		
		request.setAttribute("status", "payée");
		RequestDispatcher dispatcher=request.getRequestDispatcher("Index.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
