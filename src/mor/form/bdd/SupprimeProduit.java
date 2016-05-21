package mor.form.bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

public class SupprimeProduit {
	private int ID ; 
	private java.sql.Connection connexion;
	/**
	 * Méthode pour supprimer un produit
	 */
	public void supprimeProduit(HttpServletRequest request){
		
		int id = getValeurId(request, ID);
		/**
		 * Connexion à la base de donnée
		 */
		java.sql.Statement statement = null;
		ResultSet resultat  = null;
		loadDatabase();
		try{
			statement =  connexion.createStatement();
			java.sql.PreparedStatement preparedStatement =  connexion.prepareStatement("DELETE FROM produits WHERE Id = ?;");
				preparedStatement.setInt(1, id);
			 preparedStatement.executeUpdate();
			 
		}catch(SQLException ignore){
			
		}
	}
	public static int getValeurId(HttpServletRequest request, int valeurId){
		String valeur = request.getParameter("idProduit");
		valeurId = Integer.parseInt(valeur);
		return valeurId;
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
