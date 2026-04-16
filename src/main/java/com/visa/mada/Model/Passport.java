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
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "passeport")
public class Passport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "numero", nullable = false, length = 50)
    @NotBlank(message = "Le numero de passeport est obligatoire")
    @Size(max = 50, message = "Le numero de passeport ne peut pas depasser 50 caracteres")
    private String numero;

    @Column(name = "date_creation")
    @NotNull(message = "La date de creation du passeport est obligatoire")
    private LocalDate creationDate;

    @Column(name = "date_expiration")
    @NotNull(message = "La date d'expiration du passeport est obligatoire")
    @Future(message = "La date d'expiration du passeport doit etre dans le futur")
    private LocalDate expirationDate;

    @ManyToOne(optional = false)
    @JoinColumn(name = "personne_id", nullable = false)
    @NotNull(message = "La personne est obligatoire")
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