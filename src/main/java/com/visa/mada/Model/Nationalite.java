package com.visa.mada.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "nationalite")
public class Nationalite {

    @Id
    @Column(name = "id_nationalite")
    private Integer idNationalite;

    @Column(name = "nom")
    private String nom;

    public Nationalite() {
    }

    public Nationalite(Integer idNationalite, String nom) {
        this.idNationalite = idNationalite;
        this.nom = nom;
    }

    public Integer getIdNationalite() {
        return idNationalite;
    }

    public void setIdNationalite(Integer idNationalite) {
        this.idNationalite = idNationalite;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
