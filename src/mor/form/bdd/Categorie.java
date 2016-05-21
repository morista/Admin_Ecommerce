package mor.form.bdd;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Categorie {
private java.sql.Connection connexion;
	
	public List<mor.form.beans.Categorie> listeCategorie(){ // Fonction pour avoir la liste des catégories
		
		//Array des catégories
		List<mor.form.beans.Categorie> categories = new ArrayList<mor.form.beans.Categorie>();
	
		//Connexion à la base
		
		java.sql.Statement  statement = null;
		ResultSet resultat = null;
		loadDatabase();
		try{
				
			statement = connexion.createStatement();
			
			resultat = statement.executeQuery("SELECT Id, Nom, Description FROM Categories");
			
			//Récupération des données
			while(resultat.next()){
				int id		= resultat.getInt("Id");
				String nom = resultat.getString("Nom");
				String description = resultat.getString("Description");
				
				
				// Instanciation de la classe mor.form.beans.Produit
				mor.form.beans.Categorie categorie = new mor.form.beans.Categorie();
				categorie.setId(id);
				categorie.setNom(nom);
				categorie.setDescription(description);
	
			
				categories.add(categorie);
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
		
		return categories;
	}
	
    public void ajouterCategorie(mor.form.beans.Categorie categorie) {
        loadDatabase();
        
        try {
            java.sql.PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO categories(Nom, Description) VALUES(?, ?);");
          
            preparedStatement.setString(1, categorie.getNom());
            preparedStatement.setString(2, categorie.getDescription());
            
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
