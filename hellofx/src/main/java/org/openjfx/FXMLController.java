package org.openjfx;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;


import java.io.IOException;

public class FXMLController {

    @FXML
    private Label label;

    
    @FXML
    private void handleButtonActions(ActionEvent event) {
        System.out.println("Steroids!");
        label.setText("!");


    }

    public void initialize() {
        // TODO
    }
}
