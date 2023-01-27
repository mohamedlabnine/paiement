package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfDiv;
import com.itextpdf.text.pdf.PdfWriter;

import DAO.JPA;
import Model.Abonnee;
import Model.Agent;
import Model.Facture;

public class LoginServlet extends HttpServlet {
	JPA jpa= new JPA();
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		if(request.getParameter("admin") == null){
		Abonnee abonnee=new Abonnee();
		abonnee.setEmail(request.getParameter("email"));
		abonnee.setPassword(request.getParameter("password"));
		Abonnee user=jpa.login(abonnee);
		if(!user.getEmail().equals("x")) {
			List<Facture> list=new ArrayList<Facture>();
			list=jpa.getFacturesList(user.getId());
			HttpSession session = request.getSession();
			session.setAttribute("user",user);
			session.setAttribute("list",list);
			response.sendRedirect("Index.jsp");
			
		}
		else {
			request.setAttribute("status", "failed");
			RequestDispatcher dispatcher=request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);
			
		}
		}
		else {
			Agent agent=new Agent();
			agent.setEmail(request.getParameter("email"));
			agent.setPassword(request.getParameter("password"));
			Agent user=jpa.loginAgent(agent);
			if(!user.getEmail().equals("x")) {
				List<Abonnee> list=new ArrayList<Abonnee>();
				list=jpa.getAbonneeList();
				HttpSession session = request.getSession();
				session.setAttribute("agent",user);
				session.setAttribute("listabonne",list);
				response.sendRedirect("Agent.jsp");
				
			}
			else {
				request.setAttribute("status", "failed");
				RequestDispatcher dispatcher=request.getRequestDispatcher("Login.jsp");
				dispatcher.forward(request, response);
				
			}
			
		}
		 
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
