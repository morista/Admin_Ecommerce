package mor.form.bdd;



import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;



public class Produit {
	
	private java.sql.Connection connexion;
	
	public List<mor.form.beans.Produit> recupererProduit(){ // Fonction pour avoir la liste des produits
		
		//Array des produits
		List<mor.form.beans.Produit> produits = new ArrayList<mor.form.beans.Produit>();
	
		//Connexion à la base
		
		java.sql.Statement  statement = null;
		ResultSet resultat = null;
		loadDatabase();
		try{
				
			statement = connexion.createStatement();
			
			resultat = statement.executeQuery("SELECT p.Id, p.NomP, c.Nom, p.MontantAchat, p.MontantVente, p.Vendu, f.Nom FROM produits AS p INNER JOIN categories AS c ON p.Categorie = c.Id INNER JOIN fournisseurs AS f ON p.FournisseurP = f.Id WHERE p.Categorie = 1");
			
			//Récupération des données
			while(resultat.next()){
				int id		= resultat.getInt("p.Id");
				String nom = resultat.getString("p.NomP");
				String categorie = resultat.getString("c.Nom");
				float  montantAchat = resultat.getFloat("p.MontantAchat");
				float  montantVente = resultat.getFloat("p.MontantVente");
				int	   vendu 		= resultat.getInt("p.Vendu");
				String fournisseurs  = resultat.getString("f.Nom");
				
				
				// Instanciation de la classe mor.form.beans.Produit
				mor.form.beans.Produit produit = new mor.form.beans.Produit();
				produit.setId(id);
				produit.setNom(nom);
				produit.setCategorie(categorie);
				produit.setMontantAchat(montantAchat);
				produit.setMontantVente(montantVente);
				produit.setVendu(vendu);
				produit.setFournisseurs(fournisseurs);
				
				produits.add(produit);
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
		
		return produits;
	}
	
    public void ajouterProduit(mor.form.beans.Produit produits) {
        loadDatabase();
        
        try {
            java.sql.PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO produits(NomP, Categorie, MontantAchat, MontantVente, Vendu, FournisseurP) VALUES(?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, produits.getNom());
            preparedStatement.setInt(2, produits.getType());
            preparedStatement.setFloat(3, produits.getMontantAchat());
            preparedStatement.setFloat(4, produits.getMontantVente());
            preparedStatement.setInt(5, produits.getVendu());
            preparedStatement.setInt(6, produits.getFournisseur());
  
            
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

