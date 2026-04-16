package com.visa.mada.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "type_document")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nom_document", nullable = false, unique = true, length = 50)
    @NotBlank(message = "Le nom du document est obligatoire")
    @Size(max = 50, message = "Le nom du document ne peut pas depasser 50 caracteres")
    private String documentName;

    @Column(name = "is_commun", nullable = false)
    @NotNull(message = "Le champ is_commun est obligatoire")
    private Boolean isCommun;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idvisatype", nullable = false)
    @NotNull(message = "Le type de visa associe est obligatoire")
    private VisaType visaType;

    public DocumentType() {
    }

    public DocumentType(int id, String documentName) {
        this.id = id;
        this.documentName = documentName;
    }

    public DocumentType(int id, String documentName, Boolean isCommun) {
        this.id = id;
        this.documentName = documentName;
        this.isCommun = isCommun;
    }

    public DocumentType(int id, String documentName, VisaType visaType) {
        this.id = id;
        this.documentName = documentName;
        this.visaType = visaType;
    }

    public DocumentType(int id, String documentName, Boolean isCommun, VisaType visaType) {
        this.id = id;
        this.documentName = documentName;
        this.isCommun = isCommun;
        this.visaType = visaType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Boolean getIsCommun() {
        return isCommun;
    }

    public void setIsCommun(Boolean isCommun) {
        this.isCommun = isCommun;
    }

    public VisaType getVisaType() {
        return visaType;
    }

    public void setVisaType(VisaType visaType) {
        this.visaType = visaType;
    }
}