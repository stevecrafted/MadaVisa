package com.visa.mada.DTO;

import com.visa.mada.Model.Demandeur;
import com.visa.mada.Model.Nationalite;
import com.visa.mada.Model.SituationFamiliale;
import com.visa.mada.Model.VisaTransformable;
import com.visa.mada.Model.Passport;

public class DemandeWrapper {
    private Demandeur demandeur = new Demandeur();
    private Passport passport = new Passport();
    private VisaTransformable visaTransformable = new VisaTransformable();

    public DemandeWrapper() {
        this.demandeur.setSituationFamiliale(new SituationFamiliale());
        this.demandeur.setNationalite(new Nationalite());
    }


    // Getters et Setters (obligatoires)
    public VisaTransformable getVisaTransformable() { return visaTransformable; }
    public void setVisaTransformable(VisaTransformable VisaTransformable) { this.visaTransformable = VisaTransformable; }
    public Demandeur getDemandeur() { return demandeur; }
    public void setDemandeur(Demandeur demandeur) { this.demandeur = demandeur; }
    public Passport getPassport() { return passport; }
    public void setPassport(Passport passport) { this.passport = passport; }
}
