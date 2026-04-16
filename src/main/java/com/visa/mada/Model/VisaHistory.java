package com.visa.mada.Model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "visa_historique_type")
public class VisaHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "visa_id", nullable = false)
    @NotNull(message = "Le visa est obligatoire")
    private Visa visa;

    @ManyToOne
    @JoinColumn(name = "ancien_type_id")
    private VisaType oldType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "nouveau_type_id", nullable = false)
    @NotNull(message = "Le nouveau type de visa est obligatoire")
    private VisaType newType;

    @Column(name = "date_changement", nullable = false)
    @NotNull(message = "La date de changement est obligatoire")
    private LocalDate changeDate;

    public VisaHistory() {
    }

    public VisaHistory(int id, Visa visa, VisaType oldType, VisaType newType, LocalDate changeDate) {
        this.id = id;
        this.visa = visa;
        this.oldType = oldType;
        this.newType = newType;
        this.changeDate = changeDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Visa getVisa() {
        return visa;
    }

    public void setVisa(Visa visa) {
        this.visa = visa;
    }

    public VisaType getOldType() {
        return oldType;
    }

    public void setOldType(VisaType oldType) {
        this.oldType = oldType;
    }

    public VisaType getNewType() {
        return newType;
    }

    public void setNewType(VisaType newType) {
        this.newType = newType;
    }

    public LocalDate getChangeDate() {
        return changeDate;
    }

    public void setChangeDate(LocalDate changeDate) {
        this.changeDate = changeDate;
    }
}