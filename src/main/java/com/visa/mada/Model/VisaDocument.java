package com.visa.mada.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "visa_document")
public class VisaDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "visa_id", nullable = false)
    private Visa visa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_document_id", nullable = false)
    private DocumentType documentType;

    @Column(name = "date_depot")
    private LocalDate dateDepot;

    public VisaDocument() {
    }

    public VisaDocument(int id, Visa visa, DocumentType documentType, LocalDate dateDepot) {
        this.id = id;
        this.visa = visa;
        this.documentType = documentType;
        this.dateDepot = dateDepot;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Visa getVisa() {
        return visa;
    }

    public void setVisa(Visa visa) {
        this.visa = visa;
    }

    public DocumentType getDocumentType() {
        return documentType;
    }

    public void setDocumentType(DocumentType documentType) {
        this.documentType = documentType;
    }

    public LocalDate getDateDepot() {
        return dateDepot;
    }

    public void setDateDepot(LocalDate dateDepot) {
        this.dateDepot = dateDepot;
    }
}