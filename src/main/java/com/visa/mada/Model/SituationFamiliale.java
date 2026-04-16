package com.visa.mada.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "situation_familiale")
public class SituationFamiliale {

    @Id
    @Column(name = "id_situation_familiale")
    private Integer idSituationFamiliale;

    @Column(name = "nom")
    private String nom;

    public SituationFamiliale() {
    }

    public SituationFamiliale(Integer idSituationFamiliale, String nom) {
        this.idSituationFamiliale = idSituationFamiliale;
        this.nom = nom;
    }

    public Integer getIdSituationFamiliale() {
        return idSituationFamiliale;
    }

    public void setIdSituationFamiliale(Integer idSituationFamiliale) {
        this.idSituationFamiliale = idSituationFamiliale;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
