package com.visa.mada.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "carte_resident")
public class CarteResident {

    @Id
    @Column(name = "id_carte_resident")
    @NotNull
    private Integer idCarteResident;

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

    @Column(name = "id_passport")
    @NotNull
    private Integer idPasseport;

    @Column(name = "id_demande")
    @NotNull
    private Integer idDemande;

    public CarteResident() {
    }

    public CarteResident(Integer idCarteResident, LocalDate dateLivraison, LocalDate dateExpiration, String reference,
            Integer idPasseport, Integer idDemande) {
        this.idCarteResident = idCarteResident;
        this.dateLivraison = dateLivraison;
        this.dateExpiration = dateExpiration;
        this.reference = reference;
        this.idPasseport = idPasseport;
        this.idDemande = idDemande;
    }

    public Integer getIdCarteResident() {
        return idCarteResident;
    }

    public void setIdCarteResident(Integer idCarteResident) {
        this.idCarteResident = idCarteResident;
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
        return idPasseport;
    }

    public void setIdPasseport(Integer idPasseport) {
        this.idPasseport = idPasseport;
    }

    public Integer getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Integer idDemande) {
        this.idDemande = idDemande;
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
