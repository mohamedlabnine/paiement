package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.awt.Color;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import DAO.JPA;
import Model.Abonnee;
import Model.Payment;

public class GenerateFacturePdf extends HttpServlet {
	JPA jpa=new JPA();
	
	private static final long serialVersionUID = 1L;
    public GenerateFacturePdf() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session= request.getSession();
		Abonnee abonnee=(Abonnee)session.getAttribute("user");
		String mois = (String) request.getParameter("mois");
		int id=Integer.parseInt(request.getParameter("id"));
		Payment p=jpa.getPayment(id);
		String firstname=abonnee.getFirstname();
		String lastname=abonnee.getLastname();
		String montant=(String)request.getParameter("montant");
		Font b40 = new Font(FontFamily.TIMES_ROMAN, 40); 
		Font b30=new Font(FontFamily.TIMES_ROMAN, 30); 
        response.setContentType("application/pdf");
        response.setHeader(
            "Content-disposition",
            "inline; filename='Downloaded.pdf'");
        try {
            Document document = new Document();
            PdfWriter.getInstance(
                document, response.getOutputStream());
            document.open();
            document.add(new Paragraph("Facture",b40));
            document.add(new Paragraph("Mr "+firstname+" "+lastname,b30));
            document.add(new Paragraph("Mois : "+mois,b30));
            document.add(new Paragraph("Montant : "+montant+" $",b30));
            document.add(new Paragraph("Payment a la date : "+p.getCurrent().toString()+" ",b30));
            document.add(new Paragraph("Numéro de carte : "+p.getCardnumber()+" ",b30));
            document.close();
        }
        catch (DocumentException de) {
            throw new IOException(de.getMessage());
        }
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
