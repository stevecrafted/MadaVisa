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
@Table(name = "visa_transformable")
public class VisaTransformable {

    @Id
    @Column(name = "id_visa_transformable")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idVisaTransformable;

    @Column(name = "numero")
    @NotBlank
    private String numero;

    @Column(name = "date_livraison")
    @NotNull
    @PastOrPresent
    private LocalDate dateLivraison;

    @Column(name = "date_expiration")
    @NotNull
    @FutureOrPresent
    private LocalDate dateExpiration;

    @ManyToOne
    @JoinColumn(name = "id_passport")
    private Passport passport;

    @ManyToOne
    @JoinColumn(name = "id_demandeur")
    private Demandeur demandeur;

    public VisaTransformable() {
    }

    public VisaTransformable(Integer idVisaTransformable, String numero, LocalDate dateLivraison,
            LocalDate dateExpiration, Passport passport, Demandeur demandeur) {
        this.idVisaTransformable = idVisaTransformable;
        this.numero = numero;
        this.dateLivraison = dateLivraison;
        this.dateExpiration = dateExpiration;
        this.passport = passport;
        this.demandeur = demandeur;
    }

    public Integer getIdVisaTransformable() {
        return idVisaTransformable;
    }

    public void setIdVisaTransformable(Integer idVisaTransformable) {
        this.idVisaTransformable = idVisaTransformable;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
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

    public Integer getIdDemandeur() {
        return demandeur != null ? demandeur.getIdDemandeur() : null;
    }

    public void setIdDemandeur(Integer idDemandeur) {
        // This is handled by demandeur relationship
    }

    public Demandeur getDemandeur() {
        return demandeur;
    }

    public void setDemandeur(Demandeur demandeur) {
        this.demandeur = demandeur;
    }

    public Integer getIdPassport() {
        return getIdPasseport();
    }

    public void setIdPassport(Integer idPassport) {
        setIdPasseport(idPassport);
    }
}
