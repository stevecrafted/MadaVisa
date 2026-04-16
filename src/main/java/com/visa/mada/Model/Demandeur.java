package com.visa.mada.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
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

    @ManyToOne
    @JoinColumn(name = "id_situation_familiale")
    private SituationFamiliale situationFamiliale;

    @ManyToOne
    @JoinColumn(name = "id_nationalite")
    private Nationalite nationalite;

    public Demandeur() {
    }

    public Demandeur(Integer idDemandeur, String nom, String prenom, LocalDate dateNaissance, String lieuNaissance,
            String adresseMada, String email, SituationFamiliale situationFamiliale, Nationalite nationalite) {
        this.idDemandeur = idDemandeur;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.adresseMada = adresseMada;
        this.email = email;
        this.situationFamiliale = situationFamiliale;
        this.nationalite = nationalite;
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

    public SituationFamiliale getSituationFamiliale() {
        return situationFamiliale;
    }

    public void setSituationFamiliale(SituationFamiliale situationFamiliale) {
        this.situationFamiliale = situationFamiliale;
    }

    public Integer getIdNationalite() {
        return nationalite != null ? nationalite.getIdNationalite() : null;
    }

    public void setIdNationalite(Integer idNationalite) {
        if (this.nationalite == null) {
            this.nationalite = new Nationalite();
        }
        this.nationalite.setIdNationalite(idNationalite);
    }

    public Nationalite getNationalite() {
        return nationalite;
    }

    public void setNationalite(Nationalite nationalite) {
        this.nationalite = nationalite;
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
 
}
