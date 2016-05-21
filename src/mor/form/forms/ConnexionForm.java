package mor.form.forms;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import mor.form.beans.Utilisateur;

public final class ConnexionForm {
	
    private static final String CHAMP_LOGIN  	= "login";
    private static final String CHAMP_PASS   	= "motdepasse";
    
    private Connection connexion;
    private String  resultat;
    /**
     * Tableau des erreurs
     */
    private Map<String, String> erreurs      = new HashMap<String, String>();
    /**
     * Resultat si bien connecté ou pas 
     * @return  
     */
    public String getResultat() {
        return resultat;
    }
    /**
     * tableau des erreurs de connexion
     * @return
     */
    public Map<String, String> getErreurs() {
        return erreurs;
    }
    /**
     * Méthide pour connecter un utilisateur
     * @param request
     * @return
     */

    public Utilisateur connecterUtilisateur( HttpServletRequest request )  {
        /**
         * Récupération des champs du formulaire 
         * 
         */
        String login = getValeurChamp( request, CHAMP_LOGIN );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );
        /**
         * Création d'un objet Utilisateur
         */
        Utilisateur utilisateur = new Utilisateur();
		
		/**
		 * Connexion à la base
		 */
		
		java.sql.Statement  statement = null;
		ResultSet resultats = null;
		loadDatabase();
		/**
		 * Execution requete 
		 */
		try{	
			statement = connexion.createStatement();
			resultats = statement.executeQuery("SELECT Login, Mdp FROM utilisateurs");
			
			/**
			 * Récupération des données et validation informations
			 */
			while(resultats.next()){
				
				String log = resultats.getString("Login");
				String pass = resultats.getString("Mdp");
				/**
				 * Test si login et mot de passe sont valide
				 */
				try{
					validation(login, log, motDePasse, pass);
				}catch(Exception e){
					setErreur(CHAMP_LOGIN, e.getMessage());
				}        
		        //if ( erreurs.isEmpty() ) {
		           utilisateur.setLogin(login);
		           utilisateur.setMotDePasse(motDePasse);
		       // }
		    
			}		
			}catch(SQLException e){
		
			} finally {
				/**
				 * Fermeture de la connexion
				 */
				try{
					if(resultats != null) resultats.close();
					if(statement != null) statement.close();
					if(connexion != null) connexion.close();
				}catch(SQLException ignore){
					
				}
			}
		return utilisateur;
    }
    private void validation(String log, String log1, String pass, String pass1) throws Exception {
    	if(!log.equals("mor.samb") || !pass.equals("A1234B")){
    		
    		throw new Exception("Erreur!");
    	}
    }
    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }
    
   /**
    * Récupération des données depuis le formulaire
    * @param request
    * @param nomChamp
    * @return
    */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
	private void loadDatabase() {
        /**
         * Chargement du driver
         */
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