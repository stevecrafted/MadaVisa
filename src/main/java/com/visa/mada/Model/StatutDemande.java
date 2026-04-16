package com.visa.mada.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "statut_demande")
public class StatutDemande {

    @Id
    @Column(name = "id_statut_demande")
    @NotNull
    private Integer idStatutDemande;

    @Column(name = "libelle")
    @NotBlank
    private String libelle;

    public StatutDemande() {
    }

    public StatutDemande(Integer idStatutDemande, String libelle) {
        this.idStatutDemande = idStatutDemande;
        this.libelle = libelle;
    }

    public Integer getIdStatutDemande() {
        return idStatutDemande;
    }

    public void setIdStatutDemande(Integer idStatutDemande) {
        this.idStatutDemande = idStatutDemande;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
