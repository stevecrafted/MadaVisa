package com.visa.mada.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;

@Entity
@Table(name = "demande_statut_historique")
@IdClass(DemandeStatutHistoriqueId.class)
public class DemandeStatutHistorique {

    @Id
    @Column(name = "id_demande")
    private Integer idDemande;

    @Id
    @Column(name = "id_statut_demande")
    private Integer idStatutDemande;

    @Column(name = "motif")
    private String motif;

    public DemandeStatutHistorique() {
    }

    public DemandeStatutHistorique(Integer idDemande, Integer idStatutDemande, String motif) {
        this.idDemande = idDemande;
        this.idStatutDemande = idStatutDemande;
        this.motif = motif;
    }

    public Integer getIdDemande() {
        return idDemande;
    }

    public void setIdDemande(Integer idDemande) {
        this.idDemande = idDemande;
    }

    public Integer getIdStatutDemande() {
        return idStatutDemande;
    }

    public void setIdStatutDemande(Integer idStatutDemande) {
        this.idStatutDemande = idStatutDemande;
    }

    public String getMotif() {
        return motif;
    }

    public void setMotif(String motif) {
        this.motif = motif;
    }
}
