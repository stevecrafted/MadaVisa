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
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "demande")
public class Demande {

    @Id
    @Column(name = "id_demande")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idDemande;

    @Column(name = "date_demande")
    @NotNull
    @PastOrPresent
    private LocalDate dateDemande;

    @ManyToOne
    @JoinColumn(name = "id_visa_transformable")
    private VisaTransformable visaTransformable;

    @ManyToOne
    @JoinColumn(name = "id_type_demande")
    private TypeDemande typeDemande;

    @ManyToOne
    @JoinColumn(name = "id_demandeur")
    private Demandeur demandeur;

    @ManyToOne
    @JoinColumn(name = "id_visa_type")
    private VisaType visaType;

    public Demande() {
    }

    public Demande(Integer idDemande, LocalDate dateDemande, VisaTransformable visaTransformable, TypeDemande typeDemande,
            Demandeur demandeur, VisaType visaType) {
        this.idDemande = idDemande;
        this.dateDemande = dateDemande;
        this.visaTransformable = visaTransformable;
        this.typeDemande = typeDemande;
        this.demandeur = demandeur;
        this.visaType = visaType;
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
        return visaTransformable != null ? visaTransformable.getIdVisaTransformable() : null;
    }

    public void setIdVisaTransformable(Integer idVisaTransformable) {
        // This is handled by visaTransformable relationship
    }

    public VisaTransformable getVisaTransformable() {
        return visaTransformable;
    }

    public void setVisaTransformable(VisaTransformable visaTransformable) {
        this.visaTransformable = visaTransformable;
    }

    public Integer getIdTypeDemande() {
        return typeDemande != null ? typeDemande.getIdTypeDemande() : null;
    }

    public void setIdTypeDemande(Integer idTypeDemande) {
        // This is handled by typeDemande relationship
    }

    public TypeDemande getTypeDemande() {
        return typeDemande;
    }

    public void setTypeDemande(TypeDemande typeDemande) {
        this.typeDemande = typeDemande;
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

    public Integer getIdVisaType() {
        return visaType != null ? visaType.getIdVisaType() : null;
    }

    public void setIdVisaType(Integer idVisaType) {
        // This is handled by visaType relationship
    }

    public VisaType getVisaType() {
        return visaType;
    }

    public void setVisaType(VisaType visaType) {
        this.visaType = visaType;
    }

    public LocalDate getDemandeDate() {
        return getDateDemande();
    }

    public void setDemandeDate(LocalDate demandeDate) {
        setDateDemande(demandeDate);
    }
}
