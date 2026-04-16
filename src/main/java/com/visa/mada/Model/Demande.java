package com.visa.mada.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "demande")
public class Demande {

    @Id
    @Column(name = "id_demande")
    private Integer idDemande;

    @Column(name = "date_demande")
    private LocalDate demandeDate;

    @Column(name = "id_visa_transformable")
    private Integer idVisaTransformable;

    @Column(name = "id_type_demande")
    private Integer idTypeDemande;

    @Column(name = "id_demandeur")
    private Integer idDemandeur;

    public Demande() {
    }

    public Demande(Integer idDemande, LocalDate demandeDate, Integer idVisaTransformable, Integer idTypeDemande,
            Integer idDemandeur) {
        this.idDemande = idDemande;
        this.demandeDate = demandeDate;
        this.idVisaTransformable = idVisaTransformable;
        this.idTypeDemande = idTypeDemande;
        this.idDemandeur = idDemandeur;
    }

    public Integer getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public LocalDate getDemandeDate() {
        return demandeDate;
    }

    public void setDemandeDate(LocalDate demandeDate) {
        this.demandeDate = demandeDate;
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
}
