
-- Insertion des types de visa (s'ils n'existent pas)
INSERT INTO visa_type ( libelle, est_a_choisir) VALUES
('Investisseur', true),
('Travailleur', true);

-- Pour Investisseur (id_visa_type = 1)
INSERT INTO type_document (nom_document, est_obligatoire, est_commun, id_visa_type) VALUES
('02 photos d identite', true, true, 1),
('Notice de renseignement', true, true, 1),
('Demande adressee à Mr le Ministère de l Interieur et de la Decentralisation avec adresse e-mail et numero telephone portable', true, true, 1),
('Photocopie certifiee du visa en cours de validite', true, true, 1),
('Photocopie certifiee de la première page du passeport', true, true, 1),
('Photocopie certifiee de la carte resident en cours de validite', true, true, 1),
('Certificat de residence à Madagascar', true, true, 1),
('Extrait de casier judiciaire moins de 3 mois', true, true, 1);

-- Pour Travailleur (id_visa_type = 2)
INSERT INTO type_document (nom_document, est_obligatoire, est_commun, id_visa_type) VALUES
( '02 photos d identite', true, true, 2),
('Notice de renseignement', true, true, 2),
('Demande adressee à Mr le Ministère de l Interieur et de la Decentralisation avec adresse e-mail et numero telephone portable', true, true, 2),
('Photocopie certifiee du visa en cours de validite', true, true, 2),
('Photocopie certifiee de la première page du passeport', true, true, 2),
('Photocopie certifiee de la carte resident en cours de validite', true, true, 2),
( 'Certificat de residence à Madagascar', true, true, 2),
( 'Extrait de casier judiciaire moins de 3 mois', true, true, 2);

-- Investisseur (id_visa_type = 1)
INSERT INTO type_document (nom_document, est_obligatoire, est_commun, id_visa_type) VALUES
( 'Statut de la Societe', true, false, 1),
('Extrait d inscription au registre de commerce', true, false, 1),
( 'Carte fiscale', true, false, 1);

-- Travailleur (id_visa_type = 2)
INSERT INTO type_document (nom_document, est_obligatoire, est_commun, id_visa_type) VALUES
('Autorisation emploi delivree à Madagascar par le Ministère de la Fonction publique', true, false, 2),
( 'Attestation d emploi delivre par l employeur (Original)', true, false, 2);

INSERT INTO statut_demande (libelle) VALUES
( 'En attente'), 
( 'Approuvée'),
( 'Rejetée'),
( 'Expirée');

INSERT INTO type_demande ( libelle) VALUES
( 'Nouveau titre'),
( 'Duplicata'),
( 'Transfert de visa');

INSERT INTO nationalite ( nom) VALUES
( 'Malgache'),
( 'Française'),
( 'Chinoise'),
( 'Indienne'),
( 'Américaine'),
( 'Britannique'),
( 'Allemande'),
( 'Italienne'),
( 'Espagnole'),
('Canadienne'),
( 'Belge'),
( 'Suisse'),
( 'Sénégalaise'),
('Ivoirienne'),
( 'Camerounaise'),
( 'Marocaine'),
( 'Tunisienne'),
( 'Algérienne'),
( 'Mauricienne'),
( 'Réunionnaise');

INSERT INTO situation_familiale ( nom) VALUES
( 'Celibataire'),
( 'Marie(e)'),
( 'Divorce(e)');