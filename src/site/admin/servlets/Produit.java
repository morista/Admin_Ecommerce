package site.admin.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Produit extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		site.admin.bdd.Produit tableProduit = new site.admin.bdd.Produit();
		
		request.setAttribute("ListProduit", tableProduit.recupererProduit());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/afficherProduits.jsp").forward(request, response);

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		
		this.getServletContext().getRequestDispatcher("/WEB-INF/afficherProduits.jsp").forward(request, response);
		
	}

}
