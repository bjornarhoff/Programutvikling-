package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public class FXMLController {


    @FXML
    private Button create;

    @FXML
    private Label kunde;

    @FXML
    private Label forsikringsNr;

    @FXML
    private Button generateF;

    @FXML
    private Pane home;

    @FXML
    private AnchorPane newCustomer;


    @FXML
    private void createCustomer (ActionEvent event) {
        System.out.println("Kunde opprettet!");
        kunde.setText("Ny kunde lagt til");


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
