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
@Table(name = "passeport")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "numero", nullable = false, length = 50)
    private String numero;

    @Column(name = "date_creation")
    private LocalDate creationDate;

    @Column(name = "date_expiration")
    private LocalDate expirationDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "personne_id", nullable = false)
    private Personne personne;

    public Passport() {
    }

    public Passport(int id, String numero, LocalDate creationDate, LocalDate expirationDate, Personne personne) {
        this.id = id;
        this.numero = numero;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.personne = personne;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Personne getPersonne() {
        return personne;
    }

    public void setPersonne(Personne personne) {
        this.personne = personne;
    }
}