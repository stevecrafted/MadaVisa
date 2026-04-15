package com.visa.mada.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.DocumentType;
import com.visa.mada.Repository.DocumentTypeRepository;

@Service
public class DocumentTypeService {

    private final DocumentTypeRepository documentTypeRepository;

    public DocumentTypeService(DocumentTypeRepository documentTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
    }

    public DocumentType creerTypeDocument(DocumentType documentType) {
        return documentTypeRepository.save(documentType);
    }

    public List<DocumentType> getAllTypesDocument() {
        return documentTypeRepository.findAll();
    }

    public Optional<DocumentType> getTypeDocumentById(int id) {
        return documentTypeRepository.findById(id);
    }

    public void deleteTypeDocument(int id) {
        documentTypeRepository.deleteById(id);
    }
}
