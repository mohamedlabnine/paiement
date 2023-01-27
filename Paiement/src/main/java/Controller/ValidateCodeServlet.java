package Controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class ValidateCodeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public ValidateCodeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int value=Integer.parseInt(request.getParameter("code"));
		HttpSession session=request.getSession();
		int code=(int)session.getAttribute("code");
		RequestDispatcher dispatcher=null;
		if (value==code) 
		{
				
				request.setAttribute("status", "Verification Code is Correct");
			  dispatcher=request.getRequestDispatcher("ResetPassword.jsp");
			dispatcher.forward(request, response);
			
		}
		else
		{
			request.setAttribute("status","wrong Code ");
			
		   dispatcher=request.getRequestDispatcher("CodeVerification.jsp");
			dispatcher.forward(request, response);
		
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
