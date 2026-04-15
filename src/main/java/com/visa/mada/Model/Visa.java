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
@Table(name = "visa")
public class Visa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @Column(name = "date_expiration")
    private LocalDate exitDate;

    @Column(name = "reference", nullable = false, unique = true, length = 50)
    private String reference;

    @ManyToOne(optional = false)
    @JoinColumn(name = "personne_id", nullable = false)
    private Personne personne;

    @ManyToOne(optional = false)
    @JoinColumn(name = "type_visa_id", nullable = false)
    private VisaType typeVisa;

    public Visa() {
    }

    public Visa(int id, LocalDate creationDate, LocalDate exitDate, String reference, Personne personne,
            VisaType typeVisa) {
        this.id = id;
        this.creationDate = creationDate;
        this.exitDate = exitDate;
        this.reference = reference;
        this.personne = personne;
        this.typeVisa = typeVisa;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getExitDate() {
        return exitDate;
    }

    public void setExitDate(LocalDate exitDate) {
        this.exitDate = exitDate;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }

    public VisaType getTypeVisa() {
        return typeVisa;
    }

    public void setTypeVisa(VisaType typeVisa) {
        this.typeVisa = typeVisa;
    }
}