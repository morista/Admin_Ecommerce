package site.admin.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import site.admin.bdd.Categorie;
import site.admin.bdd.Fournisseur;


public class AjouterProduit extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		/**
		 * R�cup�ration de la table cat�gorie
		 */
		Categorie tableCategorie = new Categorie();
		request.setAttribute("listeCategorie", tableCategorie.listeCategorie());
		
		/**
		 * Recuperation de la table fournisseur
		 */
		Fournisseur tableFournisseur = new Fournisseur();
		request.setAttribute("listeFournisseur", tableFournisseur.listeFournisseur());
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterProduit.jsp").forward(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		site.admin.beans.Produit produit = new site.admin.beans.Produit();
		produit.setNom(request.getParameter("nom"));

		
		int type;
		int fournisseur;
		type = Integer.parseInt(request.getParameter("type"));
		fournisseur = Integer.parseInt(request.getParameter("fournisseur"));
		produit.setType(type);
		produit.setFournisseur(fournisseur);
		
		// R�cup�ration montants et nombre vendu:
		float montantAchat;
		float montantVente;
		int qtt;
		
		montantAchat = Float.parseFloat(request.getParameter("montantAchat"));
		montantVente = Float.parseFloat(request.getParameter("montantVente"));
		qtt = Integer.parseInt(request.getParameter("qtt"));
		
		produit.setMontantAchat(montantAchat);
		produit.setMontantVente(montantVente);
		produit.setQtt(qtt);
		
		site.admin.bdd.Produit tableProduits = new site.admin.bdd.Produit();
		tableProduits.ajouterProduit(produit);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterProduit.jsp").forward(request, response);
	}

}
