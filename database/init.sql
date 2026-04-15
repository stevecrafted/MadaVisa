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
    nom_document VARCHAR(50) UNIQUE NOT NULL,
    idvisatype INT NOT NULL,
    FOREIGN KEY (idvisatype) REFERENCES type_visa(id)
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

-- Donnees de test

-- Types de visa
INSERT INTO type_visa (id, libelle, est_transformable) VALUES
(1, 'travailleur', true),
(2, 'investisseur', true),
(3, 'etudiant', false);

-- Personnes
INSERT INTO personne (
    id, nom, prenom, date_naissance, lieu_naissance, situation_familiale,
    ancienne_adresse, adresse_actuelle, nationalite, profession
) VALUES
(1, 'Rakoto', 'Aina', '1992-03-14', 'Antananarivo', 'celibataire', 'Fianarantsoa', 'Antananarivo', 'MG', 'Developpeur'),
(2, 'Rabe', 'Miora', '1988-11-02', 'Toamasina', 'mariee', 'Mahajanga', 'Antananarivo', 'MG', 'Entrepreneur');

-- Passeports
INSERT INTO passeport (id, numero, date_creation, date_expiration, personne_id) VALUES
(1, 'MG1234567', '2021-01-10', '2031-01-10', 1),
(2, 'MG7654321', '2020-06-20', '2030-06-20', 2);

-- Visas
INSERT INTO visa (id, reference, date_creation, date_expiration, personne_id, type_visa_id) VALUES
(1, 'VISA-TRAV-0001', '2025-01-15', '2026-01-15', 1, 1),
(2, 'VISA-INV-0001', '2025-02-01', '2027-02-01', 2, 2);

-- Historique des types de visa
INSERT INTO visa_historique_type (id, visa_id, date_changement, ancien_type_id, nouveau_type_id) VALUES
(1, 1, '2025-08-01', 3, 1),
(2, 2, '2025-09-10', NULL, 2);

-- Types de document (associes a un type de visa via idvisatype)
INSERT INTO type_document (id, nom_document, idvisatype) VALUES
(1, 'Contrat de travail', 1),
(2, 'Certificat medical', 1),
(3, 'Statuts societes', 2),
(4, 'Attestation bancaire', 2),
(5, 'Attestation inscription', 3);

-- Documents deposes pour les visas
INSERT INTO visa_document (id, visa_id, type_document_id, date_depot) VALUES
(1, 1, 1, '2025-01-20'),
(2, 1, 2, '2025-01-21'),
(3, 2, 3, '2025-02-03'),
(4, 2, 4, '2025-02-05');