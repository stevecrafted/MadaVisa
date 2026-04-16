package com.visa.mada.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "passport")
public class Passport {

    @Id
    @Column(name = "id_passport")
    private Integer idPasseport;

    @Column(name = "date_delivrance")
    private LocalDate dateDelivrance;

    @Column(name = "date_expiration")
    private LocalDate dateExpiration;

    @Column(name = "numero")
    private String numero;

    @Column(name = "pays_delivrance")
    private String paysDelivrance;

    @Column(name = "id_demandeur")
    private Integer idDemandeur;

    public Passport() {
    }

    public Passport(Integer idPasseport, LocalDate dateDelivrance, LocalDate dateExpiration, String numero,
            String paysDelivrance, Integer idDemandeur) {
        this.idPasseport = idPasseport;
        this.dateDelivrance = dateDelivrance;
        this.dateExpiration = dateExpiration;
        this.numero = numero;
        this.paysDelivrance = paysDelivrance;
        this.idDemandeur = idDemandeur;
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
        return idDemandeur;
    }

    public void setIdDemandeur(Integer idDemandeur) {
        this.idDemandeur = idDemandeur;
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