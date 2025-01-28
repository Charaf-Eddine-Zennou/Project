package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class Patient {
    private int id;
    private String nom;
    private String prenom;
    private String adresse;
    private String telephone;
    private String gender;
    private String dateOfBirth;

    // List to store medical records specific to this patient
    private List<FicheMedicale> fichesMedicales = new ArrayList<>();

    // Constructor
    public Patient(int id, String nom, String prenom, String adresse, String telephone, String gender, String dateOfBirth) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.adresse = adresse;
        this.telephone = telephone;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    // Default Constructor
    public Patient() {}

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public List<FicheMedicale> getFichesMedicales() {
        return fichesMedicales;
    }

    public void addFicheMedicale(FicheMedicale ficheMedicale) {
        this.fichesMedicales.add(ficheMedicale);
    }

    public void removeFicheMedicale(FicheMedicale ficheMedicale) {
        this.fichesMedicales.remove(ficheMedicale);
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adresse='" + adresse + '\'' +
                ", telephone='" + telephone + '\'' +
                ", gender='" + gender + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", fichesMedicales=" + fichesMedicales +
                '}';
    }
}
