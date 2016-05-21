package mor.form.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mor.form.beans.Utilisateur;
import mor.form.forms.ConnexionForm;

public class Connexion extends HttpServlet {
    public static final String USER         = "utilisateur";
    public static final String FORM         = "form";
    public static final String SESSION_USER = "sessionUtilisateur";
    public static final String VUE          = "/WEB-INF/connexion.jsp";
    public static final String ACCUEIL 		= "/accueil";	

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	
		mor.form.bdd.Utilisateur tableUser = new mor.form.bdd.Utilisateur();
		
		request.setAttribute("User", tableUser.listeUtilisateur());
    	
        /**
         * Affichage de la page de connexion 
         */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /**
         *  Préparation de l'objet formulaire 
         */
        ConnexionForm form = new ConnexionForm();

      
        Utilisateur utilisateur = form.connecterUtilisateur( request );

        /**
         *  Récupération de la session depuis la requête 
         */
        HttpSession session = request.getSession();

        /**
         * Si aucune erreur de validation n'a eu lieu, alors ajout du bean
         * Utilisateur à la session, sinon suppression du bean de la session.
         */

        if(form.getErreurs().isEmpty()){
        	session.setAttribute(SESSION_USER, utilisateur);
        	response.sendRedirect(request.getContextPath() + ACCUEIL);
        }
        /* Stockage du formulaire et du bean dans l'objet request */
        request.setAttribute( FORM, form );
        request.setAttribute( USER, utilisateur );

    }
}
