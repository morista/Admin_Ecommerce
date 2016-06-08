package site.admin.beans;

public class Utilisateur {
	
	private String nom;
	private String motDePasse;
	private String login;
	private String typeU; 
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
	
	public String getTypeU() {
		return typeU;
	}
	public void setTypeU(String typeU) {
		this.typeU = typeU;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	

}
