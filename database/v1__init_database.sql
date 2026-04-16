-- Connexion (à exécuter dans psql, ou supprimer ces lignes)
\c postgres
DROP DATABASE IF EXISTS madavisa;
CREATE DATABASE madavisa;
\c madavisa

CREATE TABLE visa_type(
   id_visa_type INTEGER ,
   libelle VARCHAR(250) ,
   est_a_choisir BOOLEAN,
   PRIMARY KEY(id_visa_type)
);

CREATE TABLE type_document(
   id_type_document INTEGER ,
   nom_document VARCHAR(250) ,
   est_obligatoire BOOLEAN,
   est_commun BOOLEAN,
   id_visa_type INTEGER NOT NULL,
   PRIMARY KEY(id_type_document),
   -- UNIQUE(id_visa_type),
   FOREIGN KEY(id_visa_type) REFERENCES visa_type(id_visa_type)
);

CREATE TABLE situation_familiale(
   id_situation_familiale INTEGER ,
   nom VARCHAR(250) ,
   PRIMARY KEY(id_situation_familiale)
);

CREATE TABLE nationalite(
   id_nationalite INTEGER ,
   nom VARCHAR(250) ,
   PRIMARY KEY(id_nationalite)
);

CREATE TABLE statut_demande(
   id_statut_demande INTEGER ,
   libelle VARCHAR(250) ,
   PRIMARY KEY(id_statut_demande)
);

CREATE TABLE type_demande(
   id_type_demande INTEGER ,
   libelle VARCHAR(250) ,
   PRIMARY KEY(id_type_demande)
);

CREATE TABLE demandeur(
   id_demandeur INTEGER ,
   nom VARCHAR(250) ,
   prenom VARCHAR(250) ,
   datenaissance DATE,
   lieunaissance VARCHAR(250) ,
   adresse_mada VARCHAR(250) ,
   email VARCHAR(250) ,
   id_situation_familiale INTEGER NOT NULL,
   id_nationalite INTEGER NOT NULL,
   PRIMARY KEY(id_demandeur),
   UNIQUE(email),
   FOREIGN KEY(id_situation_familiale) REFERENCES situation_familiale(id_situation_familiale),
   FOREIGN KEY(id_nationalite) REFERENCES nationalite(id_nationalite)
);

CREATE TABLE passport(
   id_passport INTEGER ,
   date_delivrance DATE,
   date_expiration DATE,
   numero VARCHAR(250)  NOT NULL,
   pays_delivrance VARCHAR(250) ,
   id_demandeur INTEGER NOT NULL,
   PRIMARY KEY(id_passport),
   UNIQUE(numero),
   FOREIGN KEY(id_demandeur) REFERENCES demandeur(id_demandeur)
);

CREATE TABLE visa_transformable(
   id_visa_transformable INTEGER ,
   numero VARCHAR(250) ,
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
   id_demande INTEGER ,
   date_demande DATE,
   id_visa_transformable INTEGER NOT NULL,
   id_type_demande INTEGER NOT NULL,
   id_demandeur INTEGER NOT NULL,
   id_visa_type INTEGER NOT NULL,
   PRIMARY KEY(id_demande),
   UNIQUE(id_visa_type),
   FOREIGN KEY(id_visa_transformable) REFERENCES visa_transformable(id_visa_transformable),
   FOREIGN KEY(id_type_demande) REFERENCES type_demande(id_type_demande),
   FOREIGN KEY(id_demandeur) REFERENCES demandeur(id_demandeur),
   FOREIGN KEY(id_visa_type) REFERENCES visa_type(id_visa_type)
);

CREATE TABLE visa_document(
   id_visa_doc INTEGER ,
   id_type_document INTEGER NOT NULL,
   id_demande INTEGER NOT NULL,
   PRIMARY KEY(id_visa_doc),
   FOREIGN KEY(id_type_document) REFERENCES type_document(id_type_document),
   FOREIGN KEY(id_demande) REFERENCES demande(id_demande)
);

CREATE TABLE carte_resident(
   id_carte_resident INTEGER ,
   livraison_date DATE,
   date_expiration DATE,
   reference VARCHAR(250) ,
   id_passport INTEGER NOT NULL,
   id_demande INTEGER NOT NULL,
   PRIMARY KEY(id_carte_resident),
   FOREIGN KEY(id_passport) REFERENCES passport(id_passport),
   FOREIGN KEY(id_demande) REFERENCES demande(id_demande)
);

CREATE TABLE visa(
   id_visa INTEGER ,
   livraison_date DATE,
   date_expiration DATE,
   reference VARCHAR(250) ,
   id_passport INTEGER NOT NULL,
   id_demande INTEGER NOT NULL,
   PRIMARY KEY(id_visa),
   FOREIGN KEY(id_passport) REFERENCES passport(id_passport),
   FOREIGN KEY(id_demande) REFERENCES demande(id_demande)
);

CREATE TABLE demande_statut_historique(
   id_demande INTEGER ,
   id_statut_demande INTEGER,
   motif VARCHAR(250) ,
   PRIMARY KEY(id_demande, id_statut_demande),
   FOREIGN KEY(id_demande) REFERENCES demande(id_demande),
   FOREIGN KEY(id_statut_demande) REFERENCES statut_demande(id_statut_demande)
);

