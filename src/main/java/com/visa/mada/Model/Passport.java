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
@Table(name = "passport")
public class Passport {

    @Id
    @Column(name = "id_passport")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idPasseport;

    @Column(name = "date_delivrance")
    @NotNull
    @PastOrPresent
    private LocalDate dateDelivrance;

    @Column(name = "date_expiration")
    @NotNull
    @FutureOrPresent
    private LocalDate dateExpiration;

    @Column(name = "numero")
    @NotBlank
    private String numero;

    @Column(name = "pays_delivrance")
    @NotBlank
    private String paysDelivrance;

    @ManyToOne
    @JoinColumn(name = "id_demandeur")
    private Demandeur demandeur;

    public Passport() {
    }

    public Passport(Integer idPasseport, LocalDate dateDelivrance, LocalDate dateExpiration, String numero,
            String paysDelivrance, Demandeur demandeur) {
        this.idPasseport = idPasseport;
        this.dateDelivrance = dateDelivrance;
        this.dateExpiration = dateExpiration;
        this.numero = numero;
        this.paysDelivrance = paysDelivrance;
        this.demandeur = demandeur;
    }

    public Integer getIdPasseport() {
        return idPasseport;
    }

    public void setIdPasseport(Integer idPasseport) {
        this.idPasseport = idPasseport;
    }

    public LocalDate getDateDelivrance() {
        return dateDelivrance;
    }

    public void setDateDelivrance(LocalDate dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public LocalDate getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(LocalDate dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public String getPaysDelivrance() {
        return paysDelivrance;
    }

    public void setPaysDelivrance(String paysDelivrance) {
        this.paysDelivrance = paysDelivrance;
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

    public LocalDate getExpirationDate() {
        return getDateExpiration();
    }

    public void setExpirationDate(LocalDate expirationDate) {
        setDateExpiration(expirationDate);
    }
}