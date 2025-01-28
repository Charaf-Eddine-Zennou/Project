package com.example.demo.model;

public class Salle {
    private int id;
    private String nom;
    private String type; // E.g., "Consultation", "Examen", etc.
    private int capacite;

    // Constructor
    public Salle(int id, String nom, String type, int capacite) {
        this.id = id;
        this.nom = nom;
        this.type = type;
        this.capacite = capacite;
    }

    // Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public int getCapacite() { return capacite; }
    public void setCapacite(int capacite) { this.capacite = capacite; }
}
