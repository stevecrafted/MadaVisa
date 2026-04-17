package com.visa.mada.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "type_demande")
public class TypeDemande {

    @Id
    @Column(name = "id_type_demande")
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Integer idTypeDemande;

    @Column(name = "libelle")
    @NotBlank
    private String libelle;

    public TypeDemande() {
    }

    public TypeDemande(Integer idTypeDemande, String libelle) {
        this.idTypeDemande = idTypeDemande;
        this.libelle = libelle;
    }

    public Integer getIdTypeDemande() {
        return idTypeDemande;
    }

    public void setIdTypeDemande(Integer idTypeDemande) {
        this.idTypeDemande = idTypeDemande;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
