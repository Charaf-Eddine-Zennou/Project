package com.example.demo.controller;
import java.io.IOException;


import com.example.demo.util.DatabaseConnection;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.sql.Connection;

public class MainController {

    @FXML
    private Button loginButton;

    @FXML
    private Button appointmentsButton;

    @FXML
    private void goToLoginPage(ActionEvent event) {
        try {
            Parent loginPageParent = FXMLLoader.load(getClass().getResource("/com/example/demo/LoginPage.fxml"));
            Scene loginPageScene = new Scene(loginPageParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(loginPageScene);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void navigateTo(ActionEvent event, String fxmlPath) {
        try {
            Parent targetPage = FXMLLoader.load(getClass().getResource(fxmlPath));
            Scene targetScene = new Scene(targetPage);

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(targetScene);
            window.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private void goToAppointmentsPage() {
        System.out.println("Navigating to Appointments Page");
        // Add your navigation logic here
    }

    @FXML
    private void goToLoginPageAdmi(ActionEvent event) {
        try {
            Parent loginPageParent = FXMLLoader.load(getClass().getResource("/com/example/demo/Logadmin.fxml"));
            Scene loginPageScene = new Scene(loginPageParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(loginPageScene);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML
    public void goToLoginPageAdmin(ActionEvent event) {
        try {
            Parent loginPageParent = FXMLLoader.load(getClass().getResource("/com/example/demo/LoginPage.fxml"));
            Scene loginPageScene = new Scene(loginPageParent);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(loginPageScene);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testDatabaseConnection() {
        try (Connection connection = DatabaseConnection.getConnection()) {
            System.out.println("Connexion réussie !");
        } catch (Exception e) {
            System.err.println("Erreur de connexion : " + e.getMessage());
        }
    }

    // Ajoutez ceci pour appeler la méthode au démarrage
    public MainController() {
        testDatabaseConnection();
    }
}