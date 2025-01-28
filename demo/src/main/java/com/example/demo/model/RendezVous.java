package com.example.demo.model;

import java.util.Date;

public class RendezVous {
    private int id;
    private int patientId;
    private Date date;
    private String heure;
    private String statut;

    // Constructor
    public RendezVous(int id, int patientId, Date date, String heure, String statut) {
        this.id = id;
        this.patientId = patientId;
        this.date = date;
        this.heure = heure;
        this.statut = statut;
    }

    // Getters et Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getHeure() {
        return heure;
    }

    public void setHeure(String heure) {
        this.heure = heure;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "RendezVous{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", date=" + date +
                ", heure='" + heure + '\'' +
                ", statut='" + statut + '\'' +
                '}';
    }
}
