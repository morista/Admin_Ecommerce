package mor.form.beans;

public class Produit {
	private int id;
	private int type;
	private float montantAchat;
	private float montantVente;
	private int vendu;
	private int fournisseur;
	private String nom;
	private String categorie;
	private String fournisseurs;
	
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public String getFournisseurs() {
		return fournisseurs;
	}
	public void setFournisseurs(String fournisseurs) {
		this.fournisseurs = fournisseurs;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public float getMontantAchat() {
		return montantAchat;
	}
	public void setMontantAchat(float montantAchat) {
		this.montantAchat = montantAchat;
	}
	public float getMontantVente() {
		return montantVente;
	}
	public void setMontantVente(float montantVente) {
		this.montantVente = montantVente;
	}
	public int getVendu() {
		return vendu;
	}
	public void setVendu(int vendu) {
		this.vendu = vendu;
	}
	public int getFournisseur() {
		return fournisseur;
	}
	public void setFournisseur(int fournisseur) {
		this.fournisseur = fournisseur;
	}

}
