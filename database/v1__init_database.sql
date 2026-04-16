-- Connexion (à exécuter dans psql, ou supprimer ces lignes)
\c postgres
DROP DATABASE IF EXISTS madavisa;
CREATE DATABASE madavisa;
\c madavisa

CREATE TABLE situation_familiale(
   id_situation_familiale INTEGER,
   nom VARCHAR(50) ,
   PRIMARY KEY(id_situation_familiale)
);

CREATE TABLE nationalite(
   id_nationalite INTEGER,
   nom VARCHAR(50) ,
   PRIMARY KEY(id_nationalite)
);

CREATE TABLE statut_demande(
   id_statut_demande INTEGER,
   libelle VARCHAR(50) ,
   PRIMARY KEY(id_statut_demande)
);

CREATE TABLE type_demande(
   id_type_demande INTEGER,
   libelle VARCHAR(50) ,
   PRIMARY KEY(id_type_demande)
);

CREATE TABLE demandeur(
   id_demandeur INTEGER,
   name VARCHAR(250) ,
   last_name VARCHAR(250) ,
   birthdate DATE,
   location_birth VARCHAR(250) ,
   adresse_mada VARCHAR(50) ,
   email VARCHAR(50) ,
   id_situation_familiale INTEGER NOT NULL,
   id_nationalite INTEGER NOT NULL,
   PRIMARY KEY(id_demandeur),
   UNIQUE(email),
   FOREIGN KEY(id_situation_familiale) REFERENCES situation_familiale(id_situation_familiale),
   FOREIGN KEY(id_nationalite) REFERENCES nationalite(id_nationalite)
);

CREATE TABLE passport(
   id_passport INTEGER,
   date_delivrance DATE,
   expiration_date DATE,
   numero VARCHAR(50)  NOT NULL,
   pays_delivrance VARCHAR(50) ,
   id_demandeur INTEGER NOT NULL,
   PRIMARY KEY(id_passport),
   UNIQUE(numero),
   FOREIGN KEY(id_demandeur) REFERENCES demandeur(id_demandeur)
);

CREATE TABLE visa_transformable(
   id_visa_transformable INTEGER,
   numero VARCHAR(50) ,
   date_livraison DATE,
   date_expiration DATE,
   id_passport INTEGER NOT NULL,
   id_demandeur INTEGER NOT NULL,
   PRIMARY KEY(id_visa_transformable),
   UNIQUE(numero),
   FOREIGN KEY(id_passport) REFERENCES passport(id_passport),
   FOREIGN KEY(id_demandeur) REFERENCES demandeur(id_demandeur)
);

CREATE TABLE demande(
   id_demande INTEGER,
   demande_date DATE,
   id_visa_transformable INTEGER NOT NULL,
   id_type_demande INTEGER NOT NULL,
   id_demandeur INTEGER NOT NULL,
   PRIMARY KEY(id_demande),
   FOREIGN KEY(id_visa_transformable) REFERENCES visa_transformable(id_visa_transformable),
   FOREIGN KEY(id_type_demande) REFERENCES type_demande(id_type_demande),
   FOREIGN KEY(id_demandeur) REFERENCES demandeur(id_demandeur)
);

CREATE TABLE carte_resident(
   id_carte_resident INTEGER,
   livraison_date DATE,
   exit_date DATE,
   reference VARCHAR(50) ,
   id_passport INTEGER NOT NULL,
   id_demande INTEGER NOT NULL,
   PRIMARY KEY(id_carte_resident),
   FOREIGN KEY(id_passport) REFERENCES passport(id_passport),
   FOREIGN KEY(id_demande) REFERENCES demande(id_demande)
);

CREATE TABLE visa(
   id_visa INTEGER,
   livraison_date DATE,
   exit_date DATE,
   reference VARCHAR(50) ,
   id_passport INTEGER NOT NULL,
   id_demande INTEGER NOT NULL,
   PRIMARY KEY(id_visa),
   FOREIGN KEY(id_passport) REFERENCES passport(id_passport),
   FOREIGN KEY(id_demande) REFERENCES demande(id_demande)
);

CREATE TABLE visa_type(
   id_visa_type INTEGER,
   libelle VARCHAR(50) ,
   is_to_choose BOOLEAN,
   id_demande INTEGER NOT NULL,
   PRIMARY KEY(id_visa_type),
   UNIQUE(id_demande),
   FOREIGN KEY(id_demande) REFERENCES demande(id_demande)
);

CREATE TABLE type_document(
   id_type_document INTEGER,
   document_name VARCHAR(50) ,
   est_obligatoire BOOLEAN,
   est_commun BOOLEAN,
   id_visa_type INTEGER NOT NULL,
   PRIMARY KEY(id_type_document),
   UNIQUE(id_visa_type),
   FOREIGN KEY(id_visa_type) REFERENCES visa_type(id_visa_type)
);

CREATE TABLE visa_doc(
   id_visa_doc INTEGER,
   id_type_document INTEGER NOT NULL,
   id_demande INTEGER NOT NULL,
   PRIMARY KEY(id_visa_doc),
   FOREIGN KEY(id_type_document) REFERENCES type_document(id_type_document),
   FOREIGN KEY(id_demande) REFERENCES demande(id_demande)
);

CREATE TABLE demande_statut_historique(
   id_demande INTEGER,
   id_statut_demande INTEGER,
   motif VARCHAR(50) ,
   PRIMARY KEY(id_demande, id_statut_demande),
   FOREIGN KEY(id_demande) REFERENCES demande(id_demande),
   FOREIGN KEY(id_statut_demande) REFERENCES statut_demande(id_statut_demande)
);
