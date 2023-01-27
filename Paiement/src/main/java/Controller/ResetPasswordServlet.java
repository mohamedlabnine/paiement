package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import DAO.JPA;

public class ResetPasswordServlet extends HttpServlet {
	JPA jpa= new JPA();
	private static final long serialVersionUID = 1L;
  
    public ResetPasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		RequestDispatcher dispatcher=null;
		String password1 = (String)request.getParameter("password1");
		String password2 = (String) request.getParameter("password2");
		String email= (String) session.getAttribute("email");
		if(password1.equals(password2)) {
			jpa.ResetPassword(email, password2);
			request.setAttribute("status", "reset Successfully");
			dispatcher = request.getRequestDispatcher("Login.jsp");
			dispatcher.forward(request, response);	
		}
		else {
			request.setAttribute("status","Not Same Password ");
			 dispatcher=request.getRequestDispatcher("ResetPassword.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
