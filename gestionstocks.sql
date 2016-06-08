create database IF NOT EXISTS GESTIONSTOCKS;
use GESTIONSTOCKS;

DROP TABLE IF EXISTS PANIER_ARTICLES;
DROP TABLE IF EXISTS PANIERS;
DROP TABLE IF EXISTS PRODUITS;
DROP TABLE IF EXISTS FOURNISSEURS;
DROP TABLE IF EXISTS CATEGORIES;
DROP TABLE IF EXISTS UTILISATEURS;
DROP TABLE IF EXISTS TYPEUSER;


CREATE TABLE TYPEUSER (	
	Id INT NOT NULL, -- 99 = Administrateur, 1 = Interne, 2 = Client, 3 = Fournisseur --
	Label VARCHAR(30) NOT NULL, -- Interne, client, Fournisseur, Admin, SuperAdmin, ... | Pour gerer les droits de chaque users sur le site --
	Description VARCHAR(50), 	
	CONSTRAINT PK_TYPEUSER PRIMARY KEY (Id)
);

CREATE TABLE UTILISATEURS (	
	Id INT auto_increment,
	TypeU INT,
	Nom VARCHAR(40) NOT NULL,
	Login VARCHAR(40),
	Mdp VARCHAR(40) NOT NULL,
	CONSTRAINT PK_UTILISATEURS PRIMARY KEY (Id),
	CONSTRAINT FK_Type_U FOREIGN KEY (TypeU) REFERENCES TYPEUSER (Id)
);

CREATE TABLE CATEGORIES (	
	Id INT auto_increment,
	Nom VARCHAR(25),
	Description VARCHAR(200), 	
	CONSTRAINT PK_CATEGORIES PRIMARY KEY (Id)
);

CREATE TABLE FOURNISSEURS (	
	Id INT,
	Nom VARCHAR(40) NOT NULL,
	TypeF VARCHAR(100),
	AdresseF VARCHAR(40) NOT NULL,
	mailF	VARCHAR(15) NOT NULL,
	CONSTRAINT PK_FOURNISSEURS PRIMARY KEY (Id)
);

CREATE TABLE PRODUITS (
	Id INT auto_increment, 
	NomP Varchar(40) NOT NULL,
	Categorie Int,
	MontantAchat FLOAT, 
	MontantVente FLOAT,
	Qtt INT,  -- Quantite du produit
	FournisseurP Int,
	CONSTRAINT PK_PRODUITS PRIMARY KEY (Id),
	CONSTRAINT FK_CATE_P FOREIGN KEY (Categorie) REFERENCES CATEGORIES (Id),
	CONSTRAINT FK_FOURNI_P FOREIGN KEY (FournisseurP) REFERENCES FOURNISSEURS (Id)	
);

CREATE TABLE PANIERS (
	Id INT,
	UserP INT,
	CONSTRAINT PK_PANIERS PRIMARY KEY (Id),
	CONSTRAINT FK_USER_PANIER FOREIGN KEY (UserP) REFERENCES UTILISATEURS (Id)
);

CREATE TABLE PANIER_ARTICLES (
	Id INT,
	IdPaniers INT, -- Id du paniers de l'utilisateur pour cette commande (garder le même IdPaniers si plusieurs articles) -- 
	NombreProduit INT,
	IdProduit INT,
	CONSTRAINT PK_PANIER_ARTICLES PRIMARY KEY (Id),
	CONSTRAINT FK_ID_PANIER FOREIGN KEY (IdPaniers) REFERENCES PANIERS (Id),
	CONSTRAINT FK_ID_Produit FOREIGN KEY (IdProduit) REFERENCES PRODUITS (Id)
);

INSERT INTO TYPEUSER VALUES (99, "ADMIN", "Administrateur");

INSERT INTO UTILISATEURS VALUES (1, 99, "YOUSSEF", "youssef", "youssef");
INSERT INTO UTILISATEURS VALUES (2, 99, "MOR", "mor", "mor");
INSERT INTO UTILISATEURS VALUES (3, 99, "GREG", "greg", "greg");
INSERT INTO UTILISATEURS VALUES (4, 99, "YASSIR", "yassir", "yassir");

INSERT INTO FOURNISSEURS VALUES (1, "MICROSOFT", "Editeurs logiciels informatiques", "1 rue tests", "1@test.com");
INSERT INTO FOURNISSEURS VALUES (2, "IBM", "Constructeurs informatiques", "1 rue tests", "1@test.com");
INSERT INTO FOURNISSEURS VALUES (3, "IKEA", "Concepteur de mobilier et objets de decoration", "1 rue tests", "1@test.com");
INSERT INTO FOURNISSEURS VALUES (4, "HACHETTE LIVRE", "Groupe d edition francais", "1 rue tests", "1@test.com");
INSERT INTO FOURNISSEURS VALUES (5, "ADIDAS", "Fabrication d articles de sport", "1 rue tests", "1@test.com");

INSERT INTO CATEGORIES VALUES (1, 'INFORMATIQUE','Decouvrez une larges selections de Tablettes tactiles, Ordinateurs portables, Ordinateurs de bureau ...');
INSERT INTO CATEGORIES VALUES (2, 'AMEUBLEMENT','Decouvrez notre selection de meubles pour toute la maison : meuble de salon, meuble de cuisine, meuble de chambre, meuble de salle de bain ...');
INSERT INTO CATEGORIES VALUES (3, 'LIVRES','Retrouvez des milliers de livres disponibles et livres rapidement ...');
INSERT INTO CATEGORIES VALUES (4, 'VETEMENTS','Decouvrez des milliers de vetements pour femme, homme ...');

COMMIT;