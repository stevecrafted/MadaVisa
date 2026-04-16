package com.visa.mada.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visa.mada.DTO.DemandeWrapper;
import com.visa.mada.Model.Demande;
import com.visa.mada.Model.DemandeStatutHistorique;
import com.visa.mada.Model.Demandeur;
import com.visa.mada.Model.DocumentType;
import com.visa.mada.Model.Passport;
import com.visa.mada.Model.StatutDemande;
import com.visa.mada.Model.VisaDocument;
import com.visa.mada.Model.VisaTransformable;
import com.visa.mada.Repository.DemandeRepository;
import com.visa.mada.Repository.DemandeStatutHistoriqueRepository;
import com.visa.mada.Repository.DemandeurRepository;
import com.visa.mada.Repository.DocumentTypeRepository;
import com.visa.mada.Repository.PassportRepository;
import com.visa.mada.Repository.StatutDemandeRepository;
import com.visa.mada.Repository.TypeDemandeRepository;
import com.visa.mada.Repository.VisaDocumentRepository;
import com.visa.mada.Repository.VisaTransformableRepository;

import jakarta.transaction.Transactional;

@Service
public class DemandeService {

    private final PassportRepository passportRepository;
    private final VisaTransformableRepository visaTransformableRepository;
    private final DocumentTypeRepository documentTypeRepository;
    private final DemandeRepository demandeRepository;
    private final VisaDocumentRepository visaDocumentRepository;
    private final DemandeurRepository demandeurRepository;
    private final StatutDemandeRepository statutDemandeRepository;
    private final DemandeStatutHistoriqueRepository demandeStatutHistoriqueRepository;
    private final TypeDemandeRepository typeDemandeRepository;

    public DemandeService(PassportRepository passportRepository,
            VisaTransformableRepository visaTransformableRepository,
            DemandeRepository demandeRepository, DocumentTypeRepository documentTypeRepository,
            VisaDocumentRepository visaDocumentRepository, DemandeurRepository demandeurRepository,
            StatutDemandeRepository statutDemandeRepository,
            DemandeStatutHistoriqueRepository demandeStatutHistoriqueRepository,
            TypeDemandeRepository typeDemandeRepository) {
        this.demandeRepository = demandeRepository;
        this.documentTypeRepository = documentTypeRepository;
        this.visaDocumentRepository = visaDocumentRepository;
        this.passportRepository = passportRepository;
        this.visaTransformableRepository = visaTransformableRepository;
        this.demandeurRepository = demandeurRepository;
        this.statutDemandeRepository = statutDemandeRepository;
        this.demandeStatutHistoriqueRepository = demandeStatutHistoriqueRepository;
        this.typeDemandeRepository = typeDemandeRepository;
    }

    // Creation demande :
    // - Obtention info Demandeur, Visa transformable, passeport, List documents

    // Function createDemande : (Demandeur, Visatransformable, Passeport,
    // ListDocumentsId)
    // - Verifie si Perssonne, VisaTransformable, passeport, listDocuments != null
    // - Tous les ListDocuments ont tous les doc obligatoire

    // - Créena le List doc
    // - Créena le Demande
    // - Créena le Historique_demande avec status pending

    // Crée wrapper :
    // - Demandeur
    // - VisaTransofrmable
    // - Passeport
    // - List Documents

    @Transactional
    public Demande creationDemande(DemandeWrapper demandeWrapper, List<Integer> documentIds, int visaOption)
            throws Exception {

        Demandeur demandeur = demandeWrapper.getDemandeur();
        VisaTransformable visaTransformable = demandeWrapper.getVisaTransformable();
        Passport passport = demandeWrapper.getPassport();

        passport = passportRepository.save(passport);
        demandeur = demandeurRepository.save(demandeur);

        // VISATRANSFO
        visaTransformable.setIdDemandeur(demandeur.getIdDemandeur());
        visaTransformable.setIdPasseport(passport.getIdPasseport());
        visaTransformable.setIdVisaTransformable(visaTransformable.getIdVisaTransformable());
        visaTransformable = visaTransformableRepository.save(visaTransformable);

        // -- insertion
        visaTransformableRepository.save(visaTransformable);
        demandeurRepository.save(demandeur);

        List<DocumentType> documentObligatoire = documentTypeRepository
                .findByEstObligatoireTrueAndIdVisaType(visaOption);
        List<DocumentType> documentSoumis = documentTypeRepository.findAllById(documentIds);

        // ---- Verification des documents obligatoire
        if (!documentObligatoire.containsAll(documentSoumis)) {
            throw new Exception("Vous devez imperativement fournir tous les documents obligatoires");
        }

        // --- Creation de la demande
        Demande demande = new Demande();
        demande.setDateDemande(LocalDate.now());
        demande.setIdDemandeur(demandeur.getIdDemandeur());
        demande.setIdTypeDemande(typeDemandeRepository.findByLibelle("Nouveau titre").getIdTypeDemande());
        demande.setIdVisaType(visaOption);
        demande.setIdVisaTransformable(visaTransformable.getIdVisaTransformable());

        demandeRepository.save(demande);

        // Creation de l'historique et son statut
        DemandeStatutHistorique demandeStatutHistorique = new DemandeStatutHistorique();
        demandeStatutHistorique.setIdDemande(demande.getIdDemande());
        demandeStatutHistorique
                .setIdStatutDemande(statutDemandeRepository.findByLibelle("En attente").getIdStatutDemande());
        demandeStatutHistorique.setMotif("Nouveau demande");
        demandeStatutHistoriqueRepository.save(demandeStatutHistorique);

        // Insertion Documents soumis
        for (DocumentType documentType : documentSoumis) {
            VisaDocument visaDocument = new VisaDocument();
            visaDocument.setIdTypeDocument(documentType.getIdTypeDocument());
            visaDocument.setIdVisaDoc(documentType.getId());
            visaDocument.setIdDemande(demande.getIdDemande());

            visaDocumentRepository.save(visaDocument);
        }

        return demande;
    }

    public Demande create(Demande demande) {
        return demandeRepository.save(demande);
    }

    public List<Demande> getAll() {
        return demandeRepository.findAll();
    }

    public Optional<Demande> getById(Integer id) {
        return demandeRepository.findById(id);
    }

    public Demande update(Demande demande) {
        return demandeRepository.save(demande);
    }

    public void delete(Integer id) {
        demandeRepository.deleteById(id);
    }
}
