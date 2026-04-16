ALTER TABLE type_document ADD COLUMN IF NOT EXISTS is_commun BOOLEAN NOT NULL DEFAULT false;
ALTER TABLE type_document DROP CONSTRAINT type_document_nom_document_key;

-- Insertion des types de visa (s'ils n'existent pas)
INSERT INTO type_visa (libelle, est_transformable) VALUES
('Investisseur', true),
('Travailleur', true)
ON CONFLICT (libelle) DO NOTHING;

-- Recuperation des IDs
DO $$
DECLARE
    invest_id INT;
    travail_id INT;
BEGIN
    SELECT id INTO invest_id FROM type_visa WHERE libelle = 'Investisseur';
    SELECT id INTO travail_id FROM type_visa WHERE libelle = 'Travailleur';

    -- Pieces communes (à inserer pour chaque type de visa)
    INSERT INTO type_document (nom_document, idvisatype, is_commun) VALUES
    ('02 photos d identite', invest_id, true),
    ('02 photos d identite', travail_id, true),
    ('Notice de renseignement', invest_id, true),
    ('Notice de renseignement', travail_id, true),
    ('Demande adressee à Mr le Ministere de l Interieur et de la Decentralisation avec adresse e-mail et numero telephone portable', invest_id, true),
    ('Demande adressee à Mr le Ministere de l Interieur et de la Decentralisation avec adresse e-mail et numero telephone portable', travail_id, true),
    ('Photocopie certifiee du visa en cours de validite', invest_id, true),
    ('Photocopie certifiee du visa en cours de validite', travail_id, true),
    ('Photocopie certifiee de la premiere page du passeport', invest_id, true),
    ('Photocopie certifiee de la premiere page du passeport', travail_id, true),
    ('Photocopie certifiee de la carte resident en cours de validite', invest_id, true),
    ('Photocopie certifiee de la carte resident en cours de validite', travail_id, true),
    ('Certificat de residence à Madagascar', invest_id, true),
    ('Certificat de residence à Madagascar', travail_id, true),
    ('Extrait de casier judiciaire moins de 3 mois', invest_id, true),
    ('Extrait de casier judiciaire moins de 3 mois', travail_id, true);

    -- Pieces specifiques Investisseur
    INSERT INTO type_document (nom_document, idvisatype, is_commun) VALUES
    ('Statut de la Societe', invest_id, false),
    ('Extrait d inscription au registre de commerce', invest_id, false),
    ('Carte fiscale', invest_id, false);

    -- Pieces specifiques Travailleur
    INSERT INTO type_document (nom_document, idvisatype, is_commun) VALUES
    ('Autorisation emploi delivree à Madagascar par le Ministere de la Fonction publique', travail_id, false),
    ('Attestation d emploi delivre par l employeur (Original)', travail_id, false);
END $$;