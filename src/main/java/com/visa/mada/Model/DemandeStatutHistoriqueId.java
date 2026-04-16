package com.visa.mada.Model;

import java.io.Serializable;
import java.util.Objects;
import jakarta.validation.constraints.NotNull;

public class DemandeStatutHistoriqueId implements Serializable {

    @NotNull
    private Integer idDemande;
    @NotNull
    private Integer idStatutDemande;

    public DemandeStatutHistoriqueId() {
    }

    public DemandeStatutHistoriqueId(Integer idDemande, Integer idStatutDemande) {
        this.idDemande = idDemande;
        this.idStatutDemande = idStatutDemande;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DemandeStatutHistoriqueId that)) {
            return false;
        }
        return Objects.equals(idDemande, that.idDemande)
                && Objects.equals(idStatutDemande, that.idStatutDemande);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idDemande, idStatutDemande);
    }
}
