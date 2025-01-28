package com.example.demo.controller;
import com.example.demo.controller.MainController;


import javafx.event.ActionEvent;

public class AppointmentsPageController {

    public void handleAddAppointment(ActionEvent event) {
        // Code to add an appointment
        System.out.println("Add Appointment Clicked");
    }

    public void handleDeleteAppointment(ActionEvent event) {
        // Code to delete an appointment
        System.out.println("Delete Appointment Clicked");
    }

    public void handleBackToMenu(ActionEvent event) {
        // Code to navigate back to the menu
        MainController mainController = new MainController();
        mainController.navigateTo(event, "/com/example/demo/adminconsole.fxml");
    }
}
