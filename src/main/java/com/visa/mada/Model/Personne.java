package com.visa.mada.Model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="personne")
public class Personne {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "nom")
    @NotBlank(message = "Le nom est obligatoire")
    @Size(max = 250, message = "Le nom ne peut pas depasser 250 caracteres")
    private String name;

    @Column(name = "prenom")
    @NotBlank(message = "Le prenom est obligatoire")
    @Size(max = 250, message = "Le prenom ne peut pas depasser 250 caracteres")
    private String last_name;

    @Column(name = "date_naissance")
    @NotNull(message = "La date de naissance est obligatoire")
    @Past(message = "La date de naissance doit etre dans le passe")
    private LocalDate birthdate;

    @Column(name = "lieu_naissance")
    @NotBlank(message = "Le lieu de naissance est obligatoire")
    @Size(max = 250, message = "Le lieu de naissance ne peut pas depasser 250 caracteres")
    private String location_birth;

    @Column(name = "situation_familiale")
    @NotBlank(message = "La situation familiale est obligatoire")
    @Size(max = 50, message = "La situation familiale ne peut pas depasser 50 caracteres")
    private String family_situation;

    @Column(name = "ancienne_adresse")
    @Size(max = 250, message = "L'ancienne adresse ne peut pas depasser 250 caracteres")
    private String old_address;

    @Column(name = "adresse_actuelle")
    @NotBlank(message = "L'adresse actuelle est obligatoire")
    @Size(max = 250, message = "L'adresse actuelle ne peut pas depasser 250 caracteres")
    private String actual_address;

    @Column(name = "nationalite")
    @NotBlank(message = "La nationalite est obligatoire")
    @Size(max = 50, message = "La nationalite ne peut pas depasser 50 caracteres")
    private String nationalite;

    @Column(name = "profession")
    @NotBlank(message = "La profession est obligatoire")
    @Size(max = 50, message = "La profession ne peut pas depasser 50 caracteres")
    private String profession;

    public Personne() {
    }

    public Personne(int id, String name, String last_name, LocalDate birthDate, String location_birth,
            String family_situation, String old_address, String actual_address, String nationalite, String profession) {
        this.id = id;
        this.name = name;
        this.last_name = last_name;
        this.birthdate = birthDate;
        this.location_birth = location_birth;
        this.family_situation = family_situation;
        this.old_address = old_address;
        this.actual_address = actual_address;
        this.nationalite = nationalite;
        this.profession = profession;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getLocation_birth() {
        return location_birth;
    }

    public void setLocation_birth(String location_birth) {
        this.location_birth = location_birth;
    }

    public String getFamily_situation() {
        return family_situation;
    }

    public void setFamily_situation(String family_situation) {
        this.family_situation = family_situation;
    }

    public String getOld_address() {
        return old_address;
    }

    public void setOld_address(String old_address) {
        this.old_address = old_address;
    }

    public String getActual_address() {
        return actual_address;
    }

    public void setActual_address(String actual_address) {
        this.actual_address = actual_address;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

}
