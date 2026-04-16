package com.visa.mada.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "statut_demande")
public class StatutDemande {

    @Id
    @Column(name = "id_statut_demande")
    private Integer idStatutDemande;

    @Column(name = "libelle")
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
