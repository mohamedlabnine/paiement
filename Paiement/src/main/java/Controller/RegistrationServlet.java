package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import DAO.JPA;
import Model.Abonnee;

public class RegistrationServlet extends HttpServlet {
	JPA jpa= new JPA();
	private static final long serialVersionUID = 1L;
    
    public RegistrationServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Abonnee abonnee=new Abonnee();
		abonnee.setFirstname(request.getParameter("firstname"));
		abonnee.setLastname(request.getParameter("lastname"));
		abonnee.setEmail(request.getParameter("email"));
		abonnee.setPassword(request.getParameter("password"));
		abonnee.setPhone(request.getParameter("phone"));
		abonnee.setEtat("abonné");
		int id=jpa.register(abonnee);
		jpa.createDefaultFacture(id);
		request.setAttribute("status", "You have Been Registered");
		RequestDispatcher dispatcher=request.getRequestDispatcher("Login.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
