package site.admin.servlets;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import site.admin.beans.Utilisateur;
import site.admin.forms.ConnexionForm;

public class Connexion extends HttpServlet {
    public static final String USER         = "utilisateur";
    public static final String FORM         = "form";
    public static final String SESSION_USER = "sessionUtilisateur";
    public static final String VUE          = "/WEB-INF/connexion.jsp";
    public static final String ACCUEIL 		= "/accueil";	

    public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
    	
		site.admin.bdd.Utilisateur tableUser = new site.admin.bdd.Utilisateur();
		
		request.setAttribute("User", tableUser.listeUtilisateur());
    	
        /**
         * Affichage de la page de connexion 
         */
        this.getServletContext().getRequestDispatcher( VUE ).forward( request, response );
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        /**
         *  Pr�paration de l'objet formulaire 
         */
        ConnexionForm form = new ConnexionForm();

      
        Utilisateur utilisateur = form.connecterUtilisateur( request );

        /**
         *  R�cup�ration de la session depuis la requ�te 
         */
        HttpSession session = request.getSession();

        
        if(form.getErreurs().isEmpty()){
        	session.setAttribute(SESSION_USER, utilisateur);
        }else{
        	session.setAttribute(SESSION_USER, null);
        }


        response.sendRedirect(response.encodeRedirectURL(request.getContextPath() + "/accueil") );
    }
}
