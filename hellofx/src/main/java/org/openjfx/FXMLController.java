package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

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
    private void createCustomer (ActionEvent event) {
        System.out.println("Kunde opprettet!");
        kunde.setText("Ny kunde lagt til");

    }

    @FXML
    private void createInsuranceNr (ActionEvent event) {
        System.out.println("Forsikringsnummer generert");
        forsikringsNr.setText("Forsikringsnummer er: ");

    }

    public void initialize() {
        // TODO
    }
}
