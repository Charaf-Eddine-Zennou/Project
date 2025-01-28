package com.example.demo.controller;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.Objects;

public class SecriteControle {
    public void handleRendezVous(ActionEvent actionEvent) {
        try {
            Parent rendezVousPage = FXMLLoader.load(getClass().getResource("/com/example/demo/RendezVousPage.fxml"));
            Scene rendezVousScene = new Scene(rendezVousPage);
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(rendezVousScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void goToMedicalRecordPage(ActionEvent actionEvent) {
    }
    @FXML
    public void goToPatientPage(ActionEvent actionEvent) {
        try {
            // Charger la page de gestion des patients
            Parent patientPage = FXMLLoader.load(getClass().getResource("/com/example/demo/PatientPage.fxml"));
            Scene patientScene = new Scene(patientPage);

            // Récupérer la fenêtre (stage) actuelle et changer la scène
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setScene(patientScene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to handle "Gérer Paiements"
    public void handlePaiements() {
        // Add your logic for managing payments
    }

    // Method to handle "Gérer Rapport"
    public void handleRapport() {
        // Add your logic for generating reports
    }

    // Method to handle "Créer Secrétaire"
    public void handleCreateSecretary() {
        // Add your logic for creating a new secretary
    }
    @FXML
    public void backMain(ActionEvent actionEvent) {
        try {
            System.out.println("Back button clicked!");
            // Load the MainPage.fxml file
            Parent mainPageParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/MainPage.fxml")));

            // Create a new scene with the loaded layout
            Scene mainPageScene = new Scene(mainPageParent);

            // Get the current stage (window) from the event source
            Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

            // Set the new scene to the current stage
            window.setScene(mainPageScene);

            // Show the updated stage
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}