package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import DAO.JPA;
import Model.Abonnee;
import Model.Facture;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
public class DetailsServlet extends HttpServlet {
	JPA jpa= new JPA();
	private static final long serialVersionUID = 1L;
    public DetailsServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		int id = Integer.parseInt(request.getParameter("id"));
		String email = request.getParameter("email");
		String firstname = request.getParameter("firstname");
		String lastname= request.getParameter("lastname");
		String etat = request.getParameter("etat");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		Abonnee a=new Abonnee(id,firstname,lastname,email,phone,password,etat);
		List<Facture> list=new ArrayList<Facture>();
		list=jpa.getFacturesList(a.getId());
		int nbfacture=nbFacture(list);
		session.setAttribute("abonnee", a);
		session.setAttribute("listfacture", list);
		session.setAttribute("nbfacture", nbfacture);
		response.sendRedirect("Details.jsp");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}
	public int nbFacture(List<Facture> list) {
		int nb=0;
		for(Facture f:list) {
			if(f.getEtat().equals("non payée")) {
				nb++;
			}
		}
		return nb;
		
	}

}
