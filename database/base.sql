-- Table personne
CREATE TABLE personne (
    id SERIAL PRIMARY KEY,
    name VARCHAR(250) NOT NULL,
    last_name VARCHAR(250) NOT NULL,
    birthdate DATE,
    location_birth VARCHAR(250),
    family_situation VARCHAR(50),
    old_address VARCHAR(255),
    actual_address VARCHAR(255),
    nationalite VARCHAR(50),
    profession VARCHAR(50)
);

-- Table passport
CREATE TABLE passport (
    id SERIAL PRIMARY KEY,
    creation_date DATE,
    expiration_date DATE,
    personne_id INT NOT NULL REFERENCES personne(id)
);

-- Table visa_type (libellés : touriste, travailleur, visiteur, etc.)
CREATE TABLE visa_type (
    id SERIAL PRIMARY KEY,
    libelle VARCHAR(50) NOT NULL,
    is_to_choose BOOLEAN   -- TRUE si ce type est à choisir, FALSE sinon
);

-- Table visa (le visa principal)
CREATE TABLE visa (
    id SERIAL PRIMARY KEY,
    creation_date DATE,
    exit_date DATE,          -- date d'expiration
    reference VARCHAR(50) UNIQUE NOT NULL,
    personne_id INT NOT NULL REFERENCES personne(id)
);

-- Table visa_history (traçabilité des changements de type)
CREATE TABLE visa_history (
    id SERIAL PRIMARY KEY,
    visa_id INT NOT NULL REFERENCES visa(id),
    old_type_id INT REFERENCES visa_type(id),   -- NULL pour le premier enregistrement
    new_type_id INT NOT NULL REFERENCES visa_type(id),
    change_date DATE NOT NULL
);

-- Table document_type (référentiel des documents : "contrat", "casier judiciaire", etc.)
CREATE TABLE document_type (
    id SERIAL PRIMARY KEY,
    document_name VARCHAR(100) NOT NULL
);

-- Table de liaison many-to-many entre visa_history et document_type
CREATE TABLE visa_history_document (
    visa_history_id INT NOT NULL REFERENCES visa_history(id),
    document_type_id INT NOT NULL REFERENCES document_type(id),
    PRIMARY KEY (visa_history_id, document_type_id)
);