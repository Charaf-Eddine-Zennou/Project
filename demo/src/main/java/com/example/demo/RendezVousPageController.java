package com.example.demo;

import com.example.demo.util.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import com.example.demo.model.Patient;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class RendezVousPageController {

    @FXML
    private TextField nameField;

    @FXML
    private DatePicker datePicker;


    @FXML
    private TextField timeField;

    @FXML
    private TextField nomPatient;

    @FXML
    private DatePicker dateRendezVous;

    @FXML
    private TextField heureRendezVous;

    /** ✅ Confirmer et enregistrer le rendez-vous */
    @FXML
    private void confirmerRendezVous(ActionEvent event) {
        // Vérification pour éviter NullPointerException
        String date = (dateRendezVous.getValue() != null) ? dateRendezVous.getValue().toString() : "";
        String heure = heureRendezVous.getText().trim();
        String nom = nomPatient.getText().trim();

        if (date.isEmpty() || heure.isEmpty() || nom.isEmpty()) {
            showAlert("Erreur", "Veuillez remplir tous les champs.");
            return;
        }

        // SQL insert statement
        String sql = "INSERT INTO rendezvous (patient_id, date, heure, statut) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Retrieve the patient_id based on the nom
            int patientId = getPatientIdByName(nom); // Get the patient ID by name

            String statut = "En attente"; // Default status if not provided

            pstmt.setInt(1, patientId);  // Set the patient_id
            pstmt.setString(2, date);    // Set the date
            pstmt.setString(3, heure);   // Set the heure
            pstmt.setString(4, statut);  // Set the statut (defaults to "En attente")

            // Execute the insert query
            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                showAlert("Succès", "Rendez-vous enregistré !");
            }

        } catch (SQLException e) {
            showAlert("Erreur", "Problème lors de l'enregistrement du rendez-vous.");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    private int getPatientIdByName(String nom) {
        String sql = "SELECT id FROM patients WHERE nom = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nom);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return rs.getInt("id"); // Return the ID if found
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return -1; // Return -1 if no patient is found
    }



    /** ✅ Méthode pour traiter la confirmation du rendez-vous */
    @FXML
    private void handleConfirm() {
        String name = nameField.getText();
        String date = datePicker.getValue() != null ? datePicker.getValue().toString() : "";
        String time = timeField.getText();

        System.out.println("Nom: " + name);
        System.out.println("Date: " + date);
        System.out.println("Heure: " + time);
    }

    /** ✅ Méthode pour retourner à la page de connexion */
    @FXML
    public void retournerALogin(ActionEvent event) {
        try {
            Parent loginPage = FXMLLoader.load(getClass().getResource("/com/example/demo/SecriteControle.fxml"));
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(loginPage));
            stage.show();
        } catch (IOException e) {
            showAlert("Erreur", "Impossible de charger la page de connexion.");
            e.printStackTrace();
        }
    }

    /** ✅ Méthode pour afficher les alertes */
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
