package com.visa.mada.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "visa_doc")
public class VisaDocument {

    @Id
    @Column(name = "id_visa_doc")
    private Integer idVisaDoc;

    @Column(name = "id_type_document")
    private Integer idTypeDocument;

    @Column(name = "id_demande")
    private Integer idDemande;

    public VisaDocument() {
    }

    public VisaDocument(Integer idVisaDoc, Integer idTypeDocument, Integer idDemande) {
        this.idVisaDoc = idVisaDoc;
        this.idTypeDocument = idTypeDocument;
        this.idDemande = idDemande;
    }

    public Integer getIdVisaDoc() {
        return idVisaDoc;
    }

    public void setIdVisaDoc(Integer idVisaDoc) {
        this.idVisaDoc = idVisaDoc;
    }

    public Integer getIdTypeDocument() {
        return idTypeDocument;
    }

    public void setIdTypeDocument(Integer idTypeDocument) {
        this.idTypeDocument = idTypeDocument;
    }

    public Integer getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public Integer getId() {
        return idVisaDoc;
    }
}