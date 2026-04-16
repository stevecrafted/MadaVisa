package com.visa.mada.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.Personne;
import com.visa.mada.Model.DocumentType;
import com.visa.mada.Model.Visa;
import com.visa.mada.Model.VisaDocument;
import com.visa.mada.Model.VisaHistory;
import com.visa.mada.Model.VisaType;
import com.visa.mada.Repository.DocumentTypeRepository;
import com.visa.mada.Repository.PersonneRepository;
import com.visa.mada.Repository.VisaHistoryRepository;
import com.visa.mada.Repository.VisaRepository;

import jakarta.transaction.Transactional;

@Service
public class VisaService {

    private final VisaRepository visaRepository;
    private final PersonneRepository personneRepository;
    private final VisaHistoryService visaHistoryService;
    private final VisaDocumentService visaDocumentService;
    private final VisaHistoryRepository visaHistoryRepository;
    private final DocumentTypeRepository documentTypeRepository;

    public VisaService(VisaRepository visaRepository, PersonneRepository personneRepository,
            VisaHistoryService visaHistoryService, VisaDocumentService visaDocumentService,
            VisaHistoryRepository visaHistoryRepository, DocumentTypeRepository documentTypeRepository) {
        this.visaRepository = visaRepository;
        this.personneRepository = personneRepository;
        this.visaHistoryService = visaHistoryService;
        this.visaDocumentService = visaDocumentService;
        this.visaHistoryRepository = visaHistoryRepository;
        this.documentTypeRepository = documentTypeRepository;
    }

    @Transactional
    public Visa creerVisa(Personne personne, VisaType visaType, List<Integer> documentIds) {

        Personne savedPersonne = personneRepository.save(personne);

        Visa visa = new Visa();
        visa.setCreationDate(LocalDate.now());
        visa.setExitDate(LocalDate.now().plusDays(30));
        visa.setPersonne(savedPersonne);
        visa.setReference(generateReference());
        visa.setTypeVisa(visaType);

        Visa savedVisa = visaRepository.save(visa);

        VisaHistory visaHistory = new VisaHistory();
        visaHistory.setChangeDate(LocalDate.now());
        visaHistory.setVisa(savedVisa);
        visaHistory.setNewType(visaType);
        visaHistory.setOldType(null);

        visaHistoryRepository.save(visaHistory);

        if (documentIds != null && !documentIds.isEmpty()) {
            List<DocumentType> documentTypes = documentTypeRepository.findAllById(documentIds);
            for (DocumentType documentType : documentTypes) {
                VisaDocument visaDocument = new VisaDocument();
                visaDocument.setVisa(visaHistory);
                visaDocument.setDocumentType(documentType);
                visaDocument.setDateDepot(LocalDate.now());
                visaDocumentService.creerVisaDocument(visaDocument);
            }
        }

        return savedVisa;
    }

    private String generateReference() {
        return "REF-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }

    public Visa saveVisa(Visa visa) {
        return visaRepository.save(visa);
    }

    // Récupérer tous les visas
    public List<Visa> getAllVisas() {
        return visaRepository.findAll();
    }

    // Récupérer un visa par son ID
    public Optional<Visa> getVisaById(int id) {
        return visaRepository.findById(id);
    }

    // Récupérer par référence
    public Optional<Visa> getVisaByReference(String reference) {
        return visaRepository.findByReference(reference);
    }

    // Supprimer un visa
    public void deleteVisa(int id) {
        visaRepository.deleteById(id);
    }

}
