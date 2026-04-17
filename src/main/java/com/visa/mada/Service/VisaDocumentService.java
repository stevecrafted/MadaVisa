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

    public VisaDocument create(VisaDocument visaDocument) {
        return visaDocumentRepository.save(visaDocument);
    }

    public List<VisaDocument> getAll() {
        return visaDocumentRepository.findAll();
    }

    public Optional<VisaDocument> getById(Integer id) {
        return visaDocumentRepository.findById(id);
    }

    public VisaDocument update(VisaDocument visaDocument) {
        return visaDocumentRepository.save(visaDocument);
    }

    public void delete(Integer id) {
        visaDocumentRepository.deleteById(id);
    }

    public VisaDocument creerVisaDocument(VisaDocument visaDocument) {
        return create(visaDocument);
    }

    public List<VisaDocument> getAllVisaDocuments() {
        return getAll();
    }

    public Optional<VisaDocument> getVisaDocumentById(int id) {
        return getById(id);
    }

    public void deleteVisaDocument(int id) {
        delete(id);
    }
}
