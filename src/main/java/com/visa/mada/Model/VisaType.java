package com.visa.mada.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "visa_type")
public class VisaType {

    @Id
    @Column(name = "id_visa_type")
    @NotNull
    private Integer idVisaType;

    @Column(name = "libelle")
    @NotBlank
    private String libelle;

    @Column(name = "est_a_choisir")
    @NotNull
    private Boolean estAChoisir;

    public VisaType() {
    }

    public VisaType(Integer idVisaType, String libelle, Boolean estAChoisir) {
        this.idVisaType = idVisaType;
        this.libelle = libelle;
        this.estAChoisir = estAChoisir;
    }

    public Integer getIdVisaType() {
        return idVisaType;
    }

    public void setIdVisaType(Integer idVisaType) {
        this.idVisaType = idVisaType;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Boolean getEstAChoisir() {
        return estAChoisir;
    }

    public void setEstAChoisir(Boolean estAChoisir) {
        this.estAChoisir = estAChoisir;
    } 

    public Integer getId() {
        return idVisaType;
    }

    public Boolean getIsToChoose() {
        return getEstAChoisir();
    }

    public void setIsToChoose(Boolean isToChoose) {
        setEstAChoisir(isToChoose);
    }
}