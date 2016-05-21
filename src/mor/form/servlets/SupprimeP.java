package mor.form.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mor.form.bdd.SupprimeProduit;

public class SupprimeP extends HttpServlet {
		
	public static final String URL_REDIRECTION="/Pro/accueil/produit";

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SupprimeProduit produit = new SupprimeProduit();
		produit.supprimeProduit(request);
		response.sendRedirect(URL_REDIRECTION);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
