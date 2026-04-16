package com.visa.mada.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "demande")
public class Demande {

    @Id
    @Column(name = "id_demande")
    @NotNull
    private Integer idDemande;

    @Column(name = "date_demande")
    @NotNull
    @PastOrPresent
    private LocalDate dateDemande;

    @Column(name = "id_visa_transformable")
    @NotNull
    private Integer idVisaTransformable;

    @Column(name = "id_type_demande")
    @NotNull
    private Integer idTypeDemande;

    @Column(name = "id_demandeur")
    @NotNull
    private Integer idDemandeur;

    @Column(name = "id_visa_type")
    @NotNull
    private Integer idVisaType;

    public Demande() {
    }

    public Demande(Integer idDemande, LocalDate dateDemande, Integer idVisaTransformable, Integer idTypeDemande,
            Integer idDemandeur, Integer idVisaType) {
        this.idDemande = idDemande;
        this.dateDemande = dateDemande;
        this.idVisaTransformable = idVisaTransformable;
        this.idTypeDemande = idTypeDemande;
        this.idDemandeur = idDemandeur;
        this.idVisaType = idVisaType;
    }

    public Integer getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public LocalDate getDateDemande() {
        return dateDemande;
    }

    public void setDateDemande(LocalDate dateDemande) {
        this.dateDemande = dateDemande;
    }

    public Integer getIdVisaTransformable() {
        return idVisaTransformable;
    }

    public void setIdVisaTransformable(Integer idVisaTransformable) {
        this.idVisaTransformable = idVisaTransformable;
    }

    public Integer getIdTypeDemande() {
        return idTypeDemande;
    }

    public void setIdTypeDemande(Integer idTypeDemande) {
        this.idTypeDemande = idTypeDemande;
    }

    public Integer getIdDemandeur() {
        return idDemandeur;
    }

    public void setIdDemandeur(Integer idDemandeur) {
        this.idDemandeur = idDemandeur;
    }

    public Integer getIdVisaType() {
        return idVisaType;
    }

    public void setIdVisaType(Integer idVisaType) {
        this.idVisaType = idVisaType;
    }

    public LocalDate getDemandeDate() {
        return getDateDemande();
    }

    public void setDemandeDate(LocalDate demandeDate) {
        setDateDemande(demandeDate);
    }
}
