package com.visa.mada.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "type_document")
public class DocumentType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "nom_document", nullable = false, unique = true, length = 50)
    private String documentName;

    @ManyToOne(optional = false)
    @JoinColumn(name = "idvisatype", nullable = false)
    private VisaType visaType;

    public DocumentType() {
    }

    public DocumentType(int id, String documentName) {
        this.id = id;
        this.documentName = documentName;
    }

    public DocumentType(int id, String documentName, VisaType visaType) {
        this.id = id;
        this.documentName = documentName;
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

    public VisaType getVisaType() {
        return visaType;
    }

    public void setVisaType(VisaType visaType) {
        this.visaType = visaType;
    }
}