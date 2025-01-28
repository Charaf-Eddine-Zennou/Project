package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class FicheMedicale {
    private int id;
    private int patientId;
    private String description;

    // Static list to hold all medical records
    private static List<FicheMedicale> ficheMedicaleList = new ArrayList<>();

    // Constructor
    public FicheMedicale(int id, int patientId, String description) {
        this.id = id;
        this.patientId = patientId;
        this.description = description;
    }

    // Methods to manage the list of medical records
    public static void addFicheMedicale(FicheMedicale ficheMedicale) {
        ficheMedicaleList.add(ficheMedicale);
    }

    public static void removeFicheMedicale(FicheMedicale ficheMedicale) {
        ficheMedicaleList.remove(ficheMedicale);
    }

    public static List<FicheMedicale> getFicheMedicaleList() {
        return ficheMedicaleList;
    }

    // Getters and Setters
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "FicheMedicale{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", description='" + description + '\'' +
                '}';
    }
}
