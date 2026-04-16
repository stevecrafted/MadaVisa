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
@Table(name = "carte_resident")
public class CarteResident {

    @Id
    @Column(name = "id_carte_resident")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne
    @JoinColumn(name = "id_passport")
    private Passport passport;

    @ManyToOne
    @JoinColumn(name = "id_demande")
    private Demande demande;

    public CarteResident() {
    }

    public CarteResident(Integer idCarteResident, LocalDate dateLivraison, LocalDate dateExpiration, String reference,
            Passport passport, Demande demande) {
        this.idCarteResident = idCarteResident;
        this.dateLivraison = dateLivraison;
        this.dateExpiration = dateExpiration;
        this.reference = reference;
        this.passport = passport;
        this.demande = demande;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
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

    public Passport getPasseport() {
        return this.passport;
    }

    public void setPasseport(Passport Passeport) {
        this.passport = Passeport;
    }

    public Demande getDemande() {
        return this.demande;
    }

    public void setDemande(Demande Demande) {
        this.demande = Demande;
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
 
}
