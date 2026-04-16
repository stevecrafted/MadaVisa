package com.visa.mada.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "type_document")
public class DocumentType {

    @Id
    @Column(name = "id_type_document")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idTypeDocument;

    @Column(name = "nom_document")
    @NotBlank
    private String nomDocument;

    @Column(name = "est_obligatoire")
    @NotNull
    private Boolean estObligatoire;

    @Column(name = "est_commun")
    @NotNull
    private Boolean estCommun;

    @ManyToOne
    @JoinColumn(name = "id_visa_type")
    private VisaType visaType;

    public DocumentType() {
    }

    public DocumentType(Integer idTypeDocument, String nomDocument, Boolean estObligatoire, Boolean estCommun,
            VisaType visaType) {
        this.idTypeDocument = idTypeDocument;
        this.nomDocument = nomDocument;
        this.estObligatoire = estObligatoire;
        this.estCommun = estCommun;
        this.visaType = visaType;
    }

    public Integer getIdTypeDocument() {
        return idTypeDocument;
    }

    public void setIdTypeDocument(Integer idTypeDocument) {
        this.idTypeDocument = idTypeDocument;
    }

    public String getNomDocument() {
        return nomDocument;
    }

    public void setNomDocument(String nomDocument) {
        this.nomDocument = nomDocument;
    }

    public Boolean getEstObligatoire() {
        return estObligatoire;
    }

    public void setEstObligatoire(Boolean estObligatoire) {
        this.estObligatoire = estObligatoire;
    }

    public Boolean getEstCommun() {
        return estCommun;
    }

    public void setEstCommun(Boolean estCommun) {
        this.estCommun = estCommun;
    }

    public VisaType getVisaType() {
        return visaType;
    }

    public void setVisaType(VisaType visaType) {
        this.visaType = visaType;
    }

    public VisaType getIdVisaType() {
        return visaType;
    }
 

    public Integer getId() {
        return idTypeDocument;
    }

    public Boolean getIsCommun() {
        return estCommun;
    }

    public String getDocumentName() {
        return getNomDocument();
    }

    public void setDocumentName(String documentName) {
        setNomDocument(documentName);
    }
}