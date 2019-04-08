package org.openjfx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;


import java.io.IOException;

public class FXMLController {


    @FXML
    private Button create;

    
    @FXML
    private void handleButtonActions(ActionEvent event) {
        System.out.println("Steroids!");
        label.setText("!");


    }

    @FXML
    private void createInsuranceNr (ActionEvent event) {
        System.out.println("Forsikringsnummer generert");
        forsikringsNr.setText("Forsikringsnummer er: ");

    }

    @FXML
    private void homeScreen (ActionEvent event) {
        System.out.println("Tilbake");
        newCustomer.setVisible(false);
        home.setVisible(true);
    }



    public void initialize() {
        // TODO
    }
}
