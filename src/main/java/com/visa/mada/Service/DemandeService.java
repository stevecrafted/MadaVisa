package com.visa.mada.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.visa.mada.DTO.DemandeWrapper;
import com.visa.mada.Model.Demande;
import com.visa.mada.Model.DemandeStatutHistorique;
import com.visa.mada.Model.Demandeur;
import com.visa.mada.Model.DocumentType;
import com.visa.mada.Model.Passport;
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
import com.visa.mada.Repository.VisaTypeRepository;

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
    private final VisaTypeRepository visaTypeRepository;

    public DemandeService(PassportRepository passportRepository,
            VisaTransformableRepository visaTransformableRepository,
            DemandeRepository demandeRepository, DocumentTypeRepository documentTypeRepository,
            VisaDocumentRepository visaDocumentRepository, DemandeurRepository demandeurRepository,
            StatutDemandeRepository statutDemandeRepository,
            DemandeStatutHistoriqueRepository demandeStatutHistoriqueRepository,
            TypeDemandeRepository typeDemandeRepository, VisaTypeRepository visaTypeRepository) {
        this.demandeRepository = demandeRepository;
        this.documentTypeRepository = documentTypeRepository;
        this.visaDocumentRepository = visaDocumentRepository;
        this.passportRepository = passportRepository;
        this.visaTransformableRepository = visaTransformableRepository;
        this.demandeurRepository = demandeurRepository;
        this.statutDemandeRepository = statutDemandeRepository;
        this.demandeStatutHistoriqueRepository = demandeStatutHistoriqueRepository;
        this.typeDemandeRepository = typeDemandeRepository;
        this.visaTypeRepository = visaTypeRepository;
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

    @Transactional()
    public Demande creationDemande(DemandeWrapper demandeWrapper, List<Integer> documentIds, int visaOption)
            throws Exception {

        Demandeur demandeur = demandeWrapper.getDemandeur();
        VisaTransformable visaTransformable = demandeWrapper.getVisaTransformable();
        Passport passport = demandeWrapper.getPassport();

        demandeur = demandeurRepository.save(demandeur);

        passport.setDemandeur(demandeur);
        passport = passportRepository.save(passport);

        // VISATRANSFO
        visaTransformable.setDemandeur(demandeur);
        visaTransformable.setPassport(passport);

        visaTransformable = visaTransformableRepository.save(visaTransformable);

        if (visaTransformable.getIdVisaTransformable() == null) {
            throw new RuntimeException("Tsy misy id visa transformable !");
        }

        // -- insertion
        visaTransformableRepository.save(visaTransformable);

        List<DocumentType> documentObligatoire = documentTypeRepository
                .findByEstObligatoireTrueAndVisaTypeIdVisaType(visaOption);
        
        System.out.println("document obligatoires : ");
        for (DocumentType documentType : documentObligatoire) {
            System.out.println(documentType.getDocumentName());
        }

        List<DocumentType> documentSoumis = documentTypeRepository.findAllById(documentIds);
        System.out.println("documents soummis : ");
        for (DocumentType documentType : documentSoumis) {
            System.out.println(documentType.getDocumentName());
        }

        // ---- Verification des documents obligatoire
        if (!documentSoumis.containsAll(documentObligatoire)) {
            throw new RuntimeException("Vous devez imperativement fournir tous les documents obligatoires");
        }

        // --- Creation de la demande
        Demande demande = new Demande();
        demande.setDateDemande(LocalDate.now());
        demande.setDemandeur(demandeur);
        demande.setTypeDemande(typeDemandeRepository.findByLibelle("Nouveau titre"));
        demande.setVisaType(visaTypeRepository.findById(visaOption).get());
        demande.setVisaTransformable(visaTransformable);

        demande = demandeRepository.save(demande);

        if (demande.getIdDemande() == null) {
            throw new RuntimeException("TSY MISY ID LE DEMANDE");
        }

        // Creation de l'historique et son statut
        DemandeStatutHistorique demandeStatutHistorique = new DemandeStatutHistorique();
        demandeStatutHistorique.setIdDemande(demande.getIdDemande());
        demandeStatutHistorique
                .setIdStatutDemande(statutDemandeRepository.findByLibelle("En attente").getIdStatutDemande());
        demandeStatutHistorique.setMotif("Nouveau demande");
        demandeStatutHistorique = demandeStatutHistoriqueRepository.save(demandeStatutHistorique);

        // Insertion Documents soumis
        for (DocumentType documentType : documentSoumis) {
            VisaDocument visaDocument = new VisaDocument();
            visaDocument.setDocumentType(documentType);
            visaDocument.setDemande(demande);

            visaDocumentRepository.save(visaDocument);
        }

        System.out.println("Crée soamatsara ilay demande");
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
