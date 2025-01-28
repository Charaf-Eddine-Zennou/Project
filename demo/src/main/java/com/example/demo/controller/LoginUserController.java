package com.example.demo.controller;

import com.example.demo.util.DatabaseConnection;
import javafx.event.ActionEvent;
import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Objects;

public class LoginUserController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorMessage;

    /**
     * Event handler for the Login button.
     */
    @FXML
    private void handleLogin(ActionEvent event) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        // Simple login validation (for demonstration purposes)
        try {
            System.out.println("Back button clicked!");

            // Load the MainPage.fxml file
            Parent mainPageParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/SecriteControle.fxml")));

            // Create a new scene with the loaded layout
            Scene mainPageScene = new Scene(mainPageParent);

            // Get the current stage (window) from the event source
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            // Set the new scene to the current stage
            window.setScene(mainPageScene);

            // Show the updated stage
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Validates user credentials.
     *
     * @param username the entered username
     * @param password the entered password
     * @return true if credentials are valid, false otherwise
     */
    private boolean isValidCredentials(String username, String password) {
        // For demonstration, using hardcoded credentials
        return "admin".equals(username) && "password".equals(password);
    }

    /**
     * Navigates back to the main page.
     *
     * @param actionEvent the action event triggered by the button
     */
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
    public void handleLoginadmi(ActionEvent actionEvent) {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            errorMessage.setText("Veuillez remplir tous les champs !");
            return;
        }

        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM utilisateurs WHERE login = ? AND mot_de_passe = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Credentials are correct
                errorMessage.setText("Connexion réussie !");

                // Load the SecriteControle.fxml page
                Parent secriteControleParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/demo/SecriteControle.fxml")));

                // Create a new scene with the loaded layout
                Scene secriteControleScene = new Scene(secriteControleParent);

                // Get the current stage (window) from the event source
                Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

                // Set the new scene to the current stage
                window.setScene(secriteControleScene);

                // Show the updated stage
                window.show();
            } else {
                // Credentials are incorrect
                errorMessage.setText("Nom d'utilisateur ou mot de passe incorrect !");
            }
        } catch (Exception e) {
            errorMessage.setText("Erreur de connexion : " + e.getMessage());
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




}



