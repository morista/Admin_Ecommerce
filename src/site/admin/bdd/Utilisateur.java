package site.admin.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class Utilisateur {
	
	private Connection connexion;
	
	//Methode de R�cup�ration User
	public List<site.admin.beans.Utilisateur> listeUtilisateur(){
		
		//Array User:
		List<site.admin.beans.Utilisateur> utilisateurs = new ArrayList<site.admin.beans.Utilisateur>();
				
				//Connexion � la base
				
				java.sql.Statement  statement = null;
				ResultSet resultat = null;
				loadDatabase();
				try{
						
					statement = connexion.createStatement();
					
					resultat = statement.executeQuery("SELECT Nom, TypeU, Login, Mdp");
					
					//R�cup�ration des donn�es
					while(resultat.next()){
						
					String nom = resultat.getString("Nom");
					String typeU = resultat.getString("TypeU");
					String login = resultat.getString("Login");
					String motDePasse = resultat.getString("Mdp");
					
					site.admin.beans.Utilisateur utilisateur = new site.admin.beans.Utilisateur();
					utilisateur.setNom(nom);
					utilisateur.setTypeU(typeU);
					utilisateur.setLogin(login);
					utilisateur.setMotDePasse(motDePasse);
					
					utilisateurs.add(utilisateur);
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
				return utilisateurs;
	}
	//M�thode d'ajout de User
    public void ajouterUtilisateur(site.admin.beans.Utilisateur utilisateurs) {
        loadDatabase();
        
        try {
            java.sql.PreparedStatement preparedStatement = connexion.prepareStatement("INSERT INTO utilisateurs(Nom, TypeU, Login, Mdp) VALUES(?, ?, ?, MD5(?));");
            preparedStatement.setString(1, utilisateurs.getNom());
            preparedStatement.setString(2, utilisateurs.getTypeU());
            preparedStatement.setString(3, utilisateurs.getLogin());
            preparedStatement.setString(4, utilisateurs.getMotDePasse());
          
  
            
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
