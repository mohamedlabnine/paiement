package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import DAO.JPA;
import Model.Abonnee;
import Model.Facture;

public class ChangeStateServlet extends HttpServlet {
	JPA jpa= new JPA();
	private static final long serialVersionUID = 1L;
    public ChangeStateServlet() {
        super(); 
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String purpose = (String)request.getParameter("purpose");
		if(purpose.equals("abonné")) {
		HttpSession session= request.getSession();
		Abonnee abonnee=(Abonnee)session.getAttribute("user");
		String state = (String)request.getParameter("submit");
		if(jpa.ChangeState(state, abonnee.getId())) {
			abonnee.setEtat(state);
			session.setAttribute("user",abonnee);
			request.setAttribute("status", state);
			RequestDispatcher dispatcher=request.getRequestDispatcher("Index.jsp");
			dispatcher.forward(request, response);
		}
		}
		else if(purpose.equals("suspend")) {
			HttpSession session= request.getSession();
			Abonnee abonnee=(Abonnee)session.getAttribute("abonnee");
			List<Abonnee> listabonne=(List<Abonnee>)session.getAttribute("listabonne");
			if(jpa.ChangeState("suspendu", abonnee.getId())) {
				jpa.sendSMS("vous etes suspendu", abonnee.getPhone().substring(1));
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
					message.setSubject("SUSPENSION");
					message.setText("you are suspended, you should check you bills payment.");
					// send message
					Transport.send(message);
					System.out.println("message sent successfully");
				}

				catch (MessagingException e) {
					throw new RuntimeException(e);
				}
				
				for(Abonnee a :listabonne) {
					if(a.getId()==abonnee.getId()) {
						a.setEtat("suspendu");
					}
					
				}
				session.setAttribute("listabonne", listabonne);
				request.setAttribute("status", "suspendu");
				RequestDispatcher dispatcher=request.getRequestDispatcher("Agent.jsp");
				dispatcher.forward(request, response);
			}
			}
		else if(purpose.equals("payment")) {
			HttpSession session= request.getSession();
			Abonnee abonnee=(Abonnee)session.getAttribute("user");
			int id = Integer.parseInt(request.getParameter("id"));
			String mois = (String) request.getParameter("mois");
			String etat = (String) request.getParameter("etat");
			String file= (String) request.getParameter("file");
			Double montant=Double.parseDouble(request.getParameter("montant"));
			Facture f=new Facture(id,mois,montant,etat,abonnee.getId(),file);
			session.setAttribute("facture",f);
			response.sendRedirect("Payment.jsp");
			
			
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
