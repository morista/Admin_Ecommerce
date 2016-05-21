package mor.form.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Utilisateur extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/addUser.jsp").forward(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		mor.form.beans.Utilisateur utilisateurs = new mor.form.beans.Utilisateur();
		utilisateurs.setNom(request.getParameter("nom"));
		utilisateurs.setTypeU(request.getParameter("typeU"));
		utilisateurs.setLogin(request.getParameter("login"));
		utilisateurs.setMotDePasse(request.getParameter("pass"));
		
		mor.form.bdd.Utilisateur tableUser = new mor.form.bdd.Utilisateur();
		tableUser.ajouterUtilisateur(utilisateurs);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/addUser.jsp").forward(request, response);
	}

}
