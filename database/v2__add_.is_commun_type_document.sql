
-- Insertion des types de visa (s'ils n'existent pas)
INSERT INTO visa_type (id_visa_type, libelle, est_a_choisir) VALUES
(1, 'Investisseur', true),
(2, 'Travailleur', true);

-- Pour Investisseur (id_visa_type = 1)
INSERT INTO type_document (id_type_document, nom_document, est_obligatoire, est_commun, id_visa_type) VALUES
(1, '02 photos d identite', true, true, 1),
(2, 'Notice de renseignement', true, true, 1),
(3, 'Demande adressee à Mr le Ministère de l Interieur et de la Decentralisation avec adresse e-mail et numero telephone portable', true, true, 1),
(4, 'Photocopie certifiee du visa en cours de validite', true, true, 1),
(5, 'Photocopie certifiee de la première page du passeport', true, true, 1),
(6, 'Photocopie certifiee de la carte resident en cours de validite', true, true, 1),
(7, 'Certificat de residence à Madagascar', true, true, 1),
(8, 'Extrait de casier judiciaire moins de 3 mois', true, true, 1);

-- Pour Travailleur (id_visa_type = 2)
INSERT INTO type_document (id_type_document, nom_document, est_obligatoire, est_commun, id_visa_type) VALUES
(9, '02 photos d identite', true, true, 2),
(10, 'Notice de renseignement', true, true, 2),
(11, 'Demande adressee à Mr le Ministère de l Interieur et de la Decentralisation avec adresse e-mail et numero telephone portable', true, true, 2),
(12, 'Photocopie certifiee du visa en cours de validite', true, true, 2),
(13, 'Photocopie certifiee de la première page du passeport', true, true, 2),
(14, 'Photocopie certifiee de la carte resident en cours de validite', true, true, 2),
(15, 'Certificat de residence à Madagascar', true, true, 2),
(16, 'Extrait de casier judiciaire moins de 3 mois', true, true, 2);

-- Investisseur (id_visa_type = 1)
INSERT INTO type_document (id_type_document, nom_document, est_obligatoire, est_commun, id_visa_type) VALUES
(17, 'Statut de la Societe', true, false, 1),
(18, 'Extrait d inscription au registre de commerce', true, false, 1),
(19, 'Carte fiscale', true, false, 1);

-- Travailleur (id_visa_type = 2)
INSERT INTO type_document (id_type_document, nom_document, est_obligatoire, est_commun, id_visa_type) VALUES
(20, 'Autorisation emploi delivree à Madagascar par le Ministère de la Fonction publique', true, false, 2),
(21, 'Attestation d emploi delivre par l employeur (Original)', true, false, 2);

INSERT INTO statut_demande (id_statut_demande, libelle) VALUES
(1, 'En attente'), 
(2, 'Approuvée'),
(3, 'Rejetée'),
(4, 'Expirée');

INSERT INTO type_demande (id_type_demande, libelle) VALUES
(1, 'Nouveau titre'),
(2, 'Duplicata'),
(3, 'Transfert de visa');

INSERT INTO nationalite (id_nationalite, nom) VALUES
(1, 'Malgache'),
(2, 'Française'),
(3, 'Chinoise'),
(4, 'Indienne'),
(5, 'Américaine'),
(6, 'Britannique'),
(7, 'Allemande'),
(8, 'Italienne'),
(9, 'Espagnole'),
(10, 'Canadienne'),
(11, 'Belge'),
(12, 'Suisse'),
(13, 'Sénégalaise'),
(14, 'Ivoirienne'),
(15, 'Camerounaise'),
(16, 'Marocaine'),
(17, 'Tunisienne'),
(18, 'Algérienne'),
(19, 'Mauricienne'),
(20, 'Réunionnaise');

INSERT INTO situation_familiale (id_situation_familiale, nom) VALUES
(1, 'Celibataire'),
(2, 'Marie(e)'),
(3, 'Divorce(e)');