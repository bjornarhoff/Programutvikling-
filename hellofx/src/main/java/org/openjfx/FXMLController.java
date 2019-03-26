package org.openjfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class FXMLController {

    @FXML
    private Label label;

    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("Steroids!");
        label.setText("Trykk her for å se Cato!");
    }

    public void initialize() {
        // TODO
    }
}
