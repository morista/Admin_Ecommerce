package site.admin.bdd;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Fournisseur {
	private java.sql.Connection connexion;
	
	public List<site.admin.beans.Fournisseur> listeFournisseur(){ // Fonction pour avoir la liste des cat�gories
		
		//Array des cat�gories
		List<site.admin.beans.Fournisseur> fournisseurs = new ArrayList<site.admin.beans.Fournisseur>();
	
		//Connexion � la base
		
		java.sql.Statement  statement = null;
		ResultSet resultat = null;
		loadDatabase();
		try{
				
			statement = connexion.createStatement();
			
			resultat = statement.executeQuery("SELECT Id, Nom, TypeF, AdresseF, mailF FROM fournisseurs");
			
			//R�cup�ration des donn�es
			while(resultat.next()){
				int id		= resultat.getInt("Id");
				String nom = resultat.getString("Nom");
				String typeF = resultat.getString("TypeF");
				String adresseF = resultat.getString("AdresseF");
				String mailF = resultat.getString("mailF");
				
				
				// Instanciation de la classe site.admin.beans.Produit
				site.admin.beans.Fournisseur fournisseur = new site.admin.beans.Fournisseur();
				fournisseur.setId(id);
				fournisseur.setNom(nom);
				fournisseur.setTypeF(typeF);
				fournisseur.setAdresseF(adresseF);
				fournisseur.setMailF(mailF);
	
			
				fournisseurs.add(fournisseur);
			}
		}catch(SQLException e){
			
		} finally {
			//Fermeture connexion
			try{
				if(resultat != null) resultat.close();
				if(statement != null) statement.close();
				if(connexion != null) connexion.close();
			}catch(SQLException ignore){
				
			}
		}
		
		return fournisseurs;
	}
	
    public void ajouterProduit(site.admin.beans.Fournisseur fournisseur) {
        loadDatabase();
        
        try {
            java.sql.PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO Categorie(Id, Nom, TypeF, AdresseF, mailF) VALUES(?, ?, ?, ?, ?);");
            preparedStatement.setInt(1, fournisseur.getId());
            preparedStatement.setString(2, fournisseur.getNom());
            preparedStatement.setString(3, fournisseur.getTypeF());
            preparedStatement.setString(4, fournisseur.getAdresseF());
            preparedStatement.setString(5, fournisseur.getMailF());
            
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	
    private void loadDatabase() {
        // Chargement du driver
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
        }

        try {
            connexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionstocks", "root", "");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
