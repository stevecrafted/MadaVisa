package com.visa.mada.Model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "type_visa")
public class VisaType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "libelle", nullable = false, length = 50)
    private String libelle;

    @Column(name = "est_transformable")
    private Boolean estTransformable;

    @OneToMany(mappedBy = "visaType")
    @JsonIgnore
    private List<DocumentType> documentTypes;

    public VisaType() {
    }

    public VisaType(int id, String libelle, Boolean estTransformable) {
        this.id = id;
        this.libelle = libelle;
        this.estTransformable = estTransformable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Boolean getEstTransformable() {
        return estTransformable;
    }

    public void setEstTransformable(Boolean estTransformable) {
        this.estTransformable = estTransformable;
    }

    public List<DocumentType> getDocumentTypes() {
        return documentTypes;
    }

    public void setDocumentTypes(List<DocumentType> documentTypes) {
        this.documentTypes = documentTypes;
    }
}