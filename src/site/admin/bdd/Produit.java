package site.admin.bdd;



import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Produit {
	
	private java.sql.Connection connexion;
	
	public List<site.admin.beans.Produit> recupererProduit(){ // Fonction pour avoir la liste des produits
		
		//Array des produits
		List<site.admin.beans.Produit> produits = new ArrayList<site.admin.beans.Produit>();
	
		//Connexion � la base
		
		java.sql.Statement  statement = null;
		ResultSet resultat = null;
		loadDatabase();
		try{
			statement = connexion.createStatement();
			resultat = statement.executeQuery("SELECT p.Id, p.NomP, c.Nom, p.MontantAchat, p.MontantVente, p.Qtt, f.Nom FROM produits AS p INNER JOIN categories AS c ON p.Categorie = c.Id INNER JOIN fournisseurs AS f ON p.FournisseurP = f.Id");
			
			//R�cup�ration des donn�es
			while(resultat.next()){
				int id		= resultat.getInt("p.Id");
				String nom = resultat.getString("p.NomP");
				String categorie = resultat.getString("c.Nom");
				float  montantAchat = resultat.getFloat("p.MontantAchat");
				float  montantVente = resultat.getFloat("p.MontantVente");
				int	   qtt 		= resultat.getInt("p.Qtt");
				String fournisseurs  = resultat.getString("f.Nom");
				
				// Instanciation de la classe site.admin.beans.Produit
				site.admin.beans.Produit produit = new site.admin.beans.Produit();
				produit.setId(id);
				produit.setNom(nom);
				produit.setCategorie(categorie);
				produit.setMontantAchat(montantAchat);
				produit.setMontantVente(montantVente);
				produit.setQtt(qtt);
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
	
    public void ajouterProduit(site.admin.beans.Produit produits) {
        loadDatabase();
        
        try {
            java.sql.PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO produits(NomP, Categorie, MontantAchat, MontantVente, Qtt, FournisseurP) VALUES(?, ?, ?, ?, ?, ?);");
            preparedStatement.setString(1, produits.getNom());
            preparedStatement.setInt(2, produits.getType());
            preparedStatement.setFloat(3, produits.getMontantAchat());
            preparedStatement.setFloat(4, produits.getMontantVente());
            preparedStatement.setInt(5, produits.getQtt());
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

