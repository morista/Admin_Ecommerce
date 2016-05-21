package mor.form.servlets;

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
		 * Récupération et ajout de catégorie au beans
		 */
		mor.form.beans.Categorie categorie = new mor.form.beans.Categorie();
		categorie.setNom(request.getParameter("nom"));
		categorie.setDescription(request.getParameter("description"));
		/**
		 * Ajout de catégorie à la base
		 */
		mor.form.bdd.Categorie tableCategorie = new mor.form.bdd.Categorie();
		tableCategorie.ajouterCategorie(categorie);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterCategori.jsp").forward(request, response);

}
}