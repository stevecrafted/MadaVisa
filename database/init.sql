-- Connexion (à exécuter dans psql, ou supprimer ces lignes)
\c postgres
DROP DATABASE IF EXISTS madavisa;
CREATE DATABASE madavisa;
\c madavisa

-- Personne
CREATE TABLE personne (
    id SERIAL PRIMARY KEY,
    nom VARCHAR(250),
    prenom VARCHAR(250),
    date_naissance DATE,
    lieu_naissance VARCHAR(250),
    situation_familiale VARCHAR(50),
    ancienne_adresse VARCHAR(250),
    adresse_actuelle VARCHAR(250),
    nationalite VARCHAR(50),
    profession VARCHAR(50)
);

-- Passeport
CREATE TABLE passeport (
    id SERIAL PRIMARY KEY,
    numero VARCHAR(50) NOT NULL,
    date_creation DATE,
    date_expiration DATE,
    personne_id INT NOT NULL,
    FOREIGN KEY (personne_id) REFERENCES personne(id)
);

-- Type de visa
CREATE TABLE type_visa (
    id SERIAL PRIMARY KEY,
    libelle VARCHAR(50) UNIQUE NOT NULL,
    est_transformable BOOLEAN
);

-- Visa
CREATE TABLE visa (
    id SERIAL PRIMARY KEY,
    reference VARCHAR(50) NOT NULL,
    date_creation DATE,
    date_expiration DATE,
    personne_id INT NOT NULL,
    type_visa_id INT NOT NULL,
    FOREIGN KEY (personne_id) REFERENCES personne(id),
    FOREIGN KEY (type_visa_id) REFERENCES type_visa(id)
);

-- Historique des changements de type
CREATE TABLE visa_historique_type (
    id SERIAL PRIMARY KEY,
    visa_id INT NOT NULL,
    date_changement DATE NOT NULL,
    ancien_type_id INT,
    nouveau_type_id INT NOT NULL,
    FOREIGN KEY (visa_id) REFERENCES visa(id),
    FOREIGN KEY (ancien_type_id) REFERENCES type_visa(id),
    FOREIGN KEY (nouveau_type_id) REFERENCES type_visa(id)
);

-- Type de document
CREATE TABLE type_document (
    id SERIAL PRIMARY KEY,
    nom_document VARCHAR(50) UNIQUE NOT NULL
);

-- Documents fournis pour un visa
CREATE TABLE visa_document (
    id SERIAL PRIMARY KEY,
    visa_id INT NOT NULL,
    type_document_id INT NOT NULL,
    date_depot DATE,
    FOREIGN KEY (visa_id) REFERENCES visa(id),
    FOREIGN KEY (type_document_id) REFERENCES type_document(id)
);