package com.visa.mada.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

@Entity
@Table(name = "demandeur")
public class Demandeur {

    @Id
    @Column(name = "id_demandeur")
    @NotNull
    private Integer idDemandeur;

    @Column(name = "nom")
    @NotBlank
    private String nom;

    @Column(name = "prenom")
    @NotBlank
    private String prenom;

    @Column(name = "datenaissance")
    @NotNull
    @PastOrPresent
    private LocalDate dateNaissance;

    @Column(name = "lieunaissance")
    @NotBlank
    private String lieuNaissance;

    @Column(name = "adresse_mada")
    @NotBlank
    private String adresseMada;

    @Column(name = "email")
    @NotBlank
    @Email
    private String email;

    @Column(name = "id_situation_familiale")
    @NotNull
    private Integer idSituationFamiliale;

    @Column(name = "id_nationalite")
    @NotNull
    private Integer idNationalite;

    public Demandeur() {
    }

    public Demandeur(Integer idDemandeur, String nom, String prenom, LocalDate dateNaissance, String lieuNaissance,
            String adresseMada, String email, Integer idSituationFamiliale, Integer idNationalite) {
        this.idDemandeur = idDemandeur;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.adresseMada = adresseMada;
        this.email = email;
        this.idSituationFamiliale = idSituationFamiliale;
        this.idNationalite = idNationalite;
    }

    public Integer getIdDemandeur() {
        return idDemandeur;
    }

    public void setIdDemandeur(Integer idDemandeur) {
        this.idDemandeur = idDemandeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public void setLieuNaissance(String lieuNaissance) {
        this.lieuNaissance = lieuNaissance;
    }

    public String getName() {
        return getNom();
    }

    public void setName(String name) {
        setNom(name);
    }

    public String getLastName() {
        return getPrenom();
    }

    public void setLastName(String lastName) {
        setPrenom(lastName);
    }

    public LocalDate getBirthdate() {
        return getDateNaissance();
    }

    public void setBirthdate(LocalDate birthdate) {
        setDateNaissance(birthdate);
    }

    public String getLocationBirth() {
        return getLieuNaissance();
    }

    public void setLocationBirth(String locationBirth) {
        setLieuNaissance(locationBirth);
    }

    public String getAdresseMada() {
        return adresseMada;
    }

    public void setAdresseMada(String adresseMada) {
        this.adresseMada = adresseMada;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getIdSituationFamiliale() {
        return idSituationFamiliale;
    }

    public void setIdSituationFamiliale(Integer idSituationFamiliale) {
        this.idSituationFamiliale = idSituationFamiliale;
    }

    public Integer getIdNationalite() {
        return idNationalite;
    }

    public void setIdNationalite(Integer idNationalite) {
        this.idNationalite = idNationalite;
    }
}
