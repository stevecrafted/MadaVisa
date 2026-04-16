package com.visa.mada.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "visa")
public class Visa {

    @Id
    @Column(name = "id_visa")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idVisa;

    @Column(name = "livraison_date")
    @NotNull
    @PastOrPresent
    private LocalDate dateLivraison;

    @Column(name = "date_expiration")
    @NotNull
    @FutureOrPresent
    private LocalDate dateExpiration;

    @Column(name = "reference")
    @NotBlank
    private String reference;

    @ManyToOne
    @JoinColumn(name = "id_passport")
    private Passport passport;

    @ManyToOne
    @JoinColumn(name = "id_demande")
    private Demande demande;

    public Visa() {
    }

    public Visa(Integer idVisa, LocalDate dateLivraison, LocalDate dateExpiration, String reference,
            Passport passport, Demande demande) {
        this.idVisa = idVisa;
        this.dateLivraison = dateLivraison;
        this.dateExpiration = dateExpiration;
        this.reference = reference;
        this.passport = passport;
        this.demande = demande;
    }

    public Integer getIdVisa() {
        return idVisa;
    }

    public void setIdVisa(Integer idVisa) {
        this.idVisa = idVisa;
    }

    public LocalDate getDateLivraison() {
        return dateLivraison;
    }

    public void setDateLivraison(LocalDate dateLivraison) {
        this.dateLivraison = dateLivraison;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Integer getIdPasseport() {
        return passport != null ? passport.getIdPasseport() : null;
    }

    public void setIdPasseport(Integer idPasseport) {
        // This is handled by passport relationship
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Integer getIdDemande() {
        return demande != null ? demande.getIdDemande() : null;
    }

    public void setIdDemande(Integer idDemande) {
        // This is handled by demande relationship
    }

    public Demande getDemande() {
        return demande;
    }

    public void setDemande(Demande demande) {
        this.demande = demande;
    }

    public LocalDate getLivraisonDate() {
        return getDateLivraison();
    }

    public void setLivraisonDate(LocalDate livraisonDate) {
        setDateLivraison(livraisonDate);
    }

    public LocalDate getExitDate() {
        return getDateExpiration();
    }

    public void setExitDate(LocalDate exitDate) {
        setDateExpiration(exitDate);
    }

    public Integer getIdPassport() {
        return getIdPasseport();
    }

    public void setIdPassport(Integer idPassport) {
        setIdPasseport(idPassport);
    }
}
