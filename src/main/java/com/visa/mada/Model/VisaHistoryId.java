package com.visa.mada.Model;

import java.io.Serializable;
import java.util.Objects;

public class VisaHistoryId implements Serializable {

    private Integer idDemande;
    private Integer idStatutDemande;

    public VisaHistoryId() {
    }

    public VisaHistoryId(Integer idDemande, Integer idStatutDemande) {
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
        if (!(o instanceof VisaHistoryId that)) {
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
