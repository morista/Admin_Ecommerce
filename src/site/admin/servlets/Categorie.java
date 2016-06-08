package site.admin.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Categorie extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterCategori.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/**
		 * R�cup�ration et ajout de cat�gorie au beans
		 */
		site.admin.beans.Categorie categorie = new site.admin.beans.Categorie();
		categorie.setNom(request.getParameter("nom"));
		categorie.setDescription(request.getParameter("description"));
		/**
		 * Ajout de cat�gorie � la base
		 */
		site.admin.bdd.Categorie tableCategorie = new site.admin.bdd.Categorie();
		tableCategorie.ajouterCategorie(categorie);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterCategori.jsp").forward(request, response);

}
}