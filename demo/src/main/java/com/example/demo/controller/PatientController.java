package com.example.demo.controller;

import com.example.demo.model.Patient;
import com.example.demo.util.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class PatientController {

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField adresseField;

    @FXML
    private TextField telephoneField;

    @FXML
    private DatePicker dateNaissancePicker;

    /** ✅ Ajouter un patient */
    @FXML
    private void ajouterPatient(ActionEvent event) {
        String nom = nomField.getText().trim();
        String prenom = prenomField.getText().trim();
        String adresse = adresseField.getText().trim();
        String telephone = telephoneField.getText().trim();
        String dateNaissance = dateNaissancePicker.getValue() != null ? dateNaissancePicker.getValue().toString() : "";

        if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || telephone.isEmpty() || dateNaissance.isEmpty()) {
            showAlert("Erreur", "Veuillez remplir tous les champs.");
            return;
        }

        String sql = "INSERT INTO patients (nom, prenom, adresse, telephone, date_naissance) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, nom);
            pstmt.setString(2, prenom);
            pstmt.setString(3, adresse);
            pstmt.setString(4, telephone);
            pstmt.setString(5, dateNaissance);

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                showAlert("Succès", "Patient ajouté avec succès !");
            }
        } catch (SQLException e) {
            showAlert("Erreur", "Problème lors de l'ajout du patient.");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /** ✅ Supprimer un patient avec ses rendez-vous associés */
    @FXML
    private void supprimerPatient(ActionEvent event) {
        String nom = nomField.getText().trim();
        String prenom = prenomField.getText().trim();

        if (nom.isEmpty() || prenom.isEmpty()) {
            showAlert("Erreur", "Veuillez entrer le nom et prénom du patient à supprimer.");
            return;
        }

        Connection conn = null;
        PreparedStatement deleteRendezVousStmt = null;
        PreparedStatement deletePatientStmt = null;

        try {
            conn = DatabaseConnection.getConnection();

            // Étape 1 : Récupérer l'ID du patient
            String getPatientIdQuery = "SELECT id FROM patients WHERE nom = ? AND prenom = ?";
            try (PreparedStatement getPatientIdStmt = conn.prepareStatement(getPatientIdQuery)) {
                getPatientIdStmt.setString(1, nom);
                getPatientIdStmt.setString(2, prenom);

                ResultSet rs = getPatientIdStmt.executeQuery();
                if (rs.next()) {
                    int patientId = rs.getInt("id");

                    // Étape 2 : Supprimer les rendez-vous associés au patient
                    String deleteRendezVousQuery = "DELETE FROM rendezvous WHERE patient_id = ?";
                    deleteRendezVousStmt = conn.prepareStatement(deleteRendezVousQuery);
                    deleteRendezVousStmt.setInt(1, patientId);
                    deleteRendezVousStmt.executeUpdate();

                    // Étape 3 : Supprimer le patient
                    String deletePatientQuery = "DELETE FROM patients WHERE id = ?";
                    deletePatientStmt = conn.prepareStatement(deletePatientQuery);
                    deletePatientStmt.setInt(1, patientId);

                    int rowsDeleted = deletePatientStmt.executeUpdate();
                    if (rowsDeleted > 0) {
                        showAlert("Succès", "Patient et ses rendez-vous associés supprimés avec succès !");
                    } else {
                        showAlert("Erreur", "Le patient n'a pas pu être supprimé.");
                    }
                } else {
                    showAlert("Erreur", "Aucun patient trouvé avec ces informations.");
                }
            }
        } catch (SQLException e) {
            showAlert("Erreur", "Problème lors de la suppression du patient et de ses rendez-vous.");
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            // Fermer les ressources
            try {
                if (deleteRendezVousStmt != null) deleteRendezVousStmt.close();
                if (deletePatientStmt != null) deletePatientStmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
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
    public void retournerInterfacePrecedente(ActionEvent event) {
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
    }

