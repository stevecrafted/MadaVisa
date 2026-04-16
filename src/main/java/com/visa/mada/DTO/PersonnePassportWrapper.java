package com.visa.mada.DTO;

import com.visa.mada.Model.Personne;
import com.visa.mada.Model.Passport;

public class PersonnePassportWrapper {
    private Personne personne = new Personne();
    private Passport passport = new Passport();

    // Getters et Setters (obligatoires)
    public Personne getPersonne() { return personne; }
    public void setPersonne(Personne personne) { this.personne = personne; }
    public Passport getPassport() { return passport; }
    public void setPassport(Passport passport) { this.passport = passport; }
}
