
-- Insertion des types de visa (s'ils n'existent pas)
INSERT INTO type_visa (libelle, est_transformable) VALUES
('Investisseur', true),
('Travailleur', true)
ON CONFLICT (libelle) DO NOTHING;
