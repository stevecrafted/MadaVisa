package com.visa.mada.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "visa_transformable")
public class VisaTransformable {

    @Id
    @Column(name = "id_visa_transformable")
    private Integer idVisaTransformable;

    @Column(name = "numero")
    private String numero;

    @Column(name = "date_livraison")
    private LocalDate dateLivraison;

    @Column(name = "date_expiration")
    private LocalDate dateExpiration;

    @Column(name = "id_passport")
    private Integer idPasseport;

    @Column(name = "id_demandeur")
    private Integer idDemandeur;

    public VisaTransformable() {
    }

    public VisaTransformable(Integer idVisaTransformable, String numero, LocalDate dateLivraison,
            LocalDate dateExpiration, Integer idPasseport, Integer idDemandeur) {
        this.idVisaTransformable = idVisaTransformable;
        this.numero = numero;
        this.dateLivraison = dateLivraison;
        this.dateExpiration = dateExpiration;
        this.idPasseport = idPasseport;
        this.idDemandeur = idDemandeur;
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
        return idPasseport;
    }

    public void setIdPasseport(Integer idPasseport) {
        this.idPasseport = idPasseport;
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
}
