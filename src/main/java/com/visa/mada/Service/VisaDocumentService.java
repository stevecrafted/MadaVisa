package com.visa.mada.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.VisaDocument;
import com.visa.mada.Repository.VisaDocumentRepository;

@Service
public class VisaDocumentService {

    private final VisaDocumentRepository visaDocumentRepository;

    public VisaDocumentService(VisaDocumentRepository visaDocumentRepository) {
        this.visaDocumentRepository = visaDocumentRepository;
    }

    public VisaDocument creerVisaDocument(VisaDocument visaDocument) {
        return visaDocumentRepository.save(visaDocument);
    }

    public List<VisaDocument> getAllVisaDocuments() {
        return visaDocumentRepository.findAll();
    }

    public Optional<VisaDocument> getVisaDocumentById(int id) {
        return visaDocumentRepository.findById(id);
    }

    public void deleteVisaDocument(int id) {
        visaDocumentRepository.deleteById(id);
    }
}
