package com.visa.mada.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "visa_doc")
public class VisaDocument {

    @Id
    @Column(name = "id_visa_doc")
    @NotNull
    private Integer idVisaDoc;

    @Column(name = "id_type_document")
    @NotNull
    private Integer idTypeDocument;

    @Column(name = "id_demande")
    @NotNull
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