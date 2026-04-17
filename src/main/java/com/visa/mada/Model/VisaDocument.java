package com.visa.mada.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "visa_document")
public class VisaDocument {

    @Id
    @Column(name = "id_visa_doc")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idVisaDoc;

    @ManyToOne
    @JoinColumn(name = "id_type_document")
    private DocumentType documentType;

    @ManyToOne
    @JoinColumn(name = "id_demande")
    private Demande demande;

    public VisaDocument() {
    }

    public VisaDocument(Integer idVisaDoc, DocumentType documentType, Demande demande) {
        this.idVisaDoc = idVisaDoc;
        this.documentType = documentType;
        this.demande = demande;
    }

    public Integer getIdVisaDoc() {
        return idVisaDoc;
    }

    public void setIdVisaDoc(Integer idVisaDoc) {
        this.idVisaDoc = idVisaDoc;
    }

    public Integer getIdTypeDocument() {
        return documentType != null ? documentType.getIdTypeDocument() : null;
    }

    public void setIdTypeDocument(Integer idTypeDocument) {
        // This is handled by documentType relationship
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public Integer getIdDemande() {
        return demande != null ? demande.getIdDemande() : null;
    }

    public void setIdDemande(Integer idDemande) {
        // This is handled by demande relationship
    }

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    public Integer getId() {
        return idVisaDoc;
    }
}