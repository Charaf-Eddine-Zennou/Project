package com.example.demo.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Paiement {
    private int id;
    private int patientId;
    private double montant;
    private LocalDate datePaiement;
    private String methodePaiement; // Example: "Carte bancaire", "Espèces", "Chèque"

    // Static list to store all payments
    private static List<Paiement> paiementList = new ArrayList<>();

    // Constructor
    public Paiement(int id, int patientId, double montant, LocalDate datePaiement, String methodePaiement) {
        this.id = id;
        this.patientId = patientId;
        this.montant = montant;
        this.datePaiement = datePaiement;
        this.methodePaiement = methodePaiement;
    }

    // Default Constructor
    public Paiement() {}

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

    public double getMontant() {
        return montant;
    }

    public void setMontant(double montant) {
        this.montant = montant;
    }

    public LocalDate getDatePaiement() {
        return datePaiement;
    }

    public void setDatePaiement(LocalDate datePaiement) {
        this.datePaiement = datePaiement;
    }

    public String getMethodePaiement() {
        return methodePaiement;
    }

    public void setMethodePaiement(String methodePaiement) {
        this.methodePaiement = methodePaiement;
    }

    // Static Methods for Payment Management
    public static void addPaiement(Paiement paiement) {
        paiementList.add(paiement);
    }

    public static void removePaiement(Paiement paiement) {
        paiementList.remove(paiement);
    }

    public static List<Paiement> getPaiementList() {
        return paiementList;
    }

    @Override
    public String toString() {
        return "Paiement{" +
                "id=" + id +
                ", patientId=" + patientId +
                ", montant=" + montant +
                ", datePaiement=" + datePaiement +
                ", methodePaiement='" + methodePaiement + '\'' +
                '}';
    }
}
