package com.visa.mada.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.visa.mada.Model.DocumentType;
import com.visa.mada.Repository.DocumentTypeRepository;
import com.visa.mada.Repository.VisaTypeRepository;

@Service
public class DocumentTypeService {

    private final DocumentTypeRepository documentTypeRepository;
    private final VisaTypeRepository visaTypeRepository;
    

    public DocumentTypeService(DocumentTypeRepository documentTypeRepository, VisaTypeRepository visaTypeRepository) {
        this.documentTypeRepository = documentTypeRepository;
        this.visaTypeRepository = visaTypeRepository;
    }

    public DocumentType create(DocumentType documentType) {
        return documentTypeRepository.save(documentType);
    }

    public List<DocumentType> getAll() {
        return documentTypeRepository.findAll();
    }

    public Optional<DocumentType> getById(Integer id) {
        return documentTypeRepository.findById(id);
    }

    public DocumentType update(DocumentType documentType) {
        return documentTypeRepository.save(documentType);
    }

    public void delete(Integer id) {
        documentTypeRepository.deleteById(id);
    }

    public DocumentType creerTypeDocument(DocumentType documentType) {
        return create(documentType);
    }

    public List<DocumentType> getAllTypesDocument() {
        return getAll();
    }

    public List<DocumentType> getAllTypesDocumentByVisaTypeId(int visaTypeId) {
        return documentTypeRepository.findByVisaType(visaTypeRepository.findById(visaTypeId).get());
    }

    public Optional<DocumentType> getTypeDocumentById(int id) {
        return getById(id);
    }

    public void deleteTypeDocument(int id) {
        delete(id);
    }
}
