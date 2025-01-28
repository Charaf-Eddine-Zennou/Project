package com.example.demo.controller;

import javafx.event.ActionEvent;

public class MedicalRecordPageController {

    public void handleViewMedicalRecord(ActionEvent event) {
        // Code to view a medical record
        System.out.println("View Medical Record Clicked");
    }

    public void handleUpdateMedicalRecord(ActionEvent event) {
        // Code to update a medical record
        System.out.println("Update Medical Record Clicked");
    }

    public void handleBackToMenu(ActionEvent event) {
        // Code to navigate back to the menu
        MainController mainController = new MainController();
        mainController.navigateTo(event, "/com/example/demo/adminconsole.fxml");
    }
}
