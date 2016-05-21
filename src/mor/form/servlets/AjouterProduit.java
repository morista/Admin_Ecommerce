package mor.form.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mor.form.bdd.Categorie;
import mor.form.bdd.Fournisseur;


public class AjouterProduit extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		/**
		 * Récupération de la table catégorie
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

		mor.form.beans.Produit produit = new mor.form.beans.Produit();
		produit.setNom(request.getParameter("nom"));

		
		int type;
		int fournisseur;
		type = Integer.parseInt(request.getParameter("type"));
		fournisseur = Integer.parseInt(request.getParameter("fournisseur"));
		produit.setType(type);
		produit.setFournisseur(fournisseur);
		
		// Récupération montants et nombre vendu:
		float montantAchat;
		float montantVente;
		int vendu;
		
		montantAchat = Float.parseFloat(request.getParameter("montantAchat"));
		montantVente = Float.parseFloat(request.getParameter("montantVente"));
		vendu = Integer.parseInt(request.getParameter("vendu"));
		
		produit.setMontantAchat(montantAchat);
		produit.setMontantVente(montantVente);
		produit.setVendu(vendu);
		
		mor.form.bdd.Produit tableProduits = new mor.form.bdd.Produit();
		tableProduits.ajouterProduit(produit);
		
		this.getServletContext().getRequestDispatcher("/WEB-INF/ajouterProduit.jsp").forward(request, response);
	}

}
