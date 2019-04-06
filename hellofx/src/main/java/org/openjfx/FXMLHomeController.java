package org.openjfx;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class FXMLHomeController {


    @FXML
    private Pane pane_Customer, pane_Insurance;

    @FXML
    private JFXButton button_Customer, button_Insurance;

    @FXML
    private void handleButtonActions(ActionEvent event) {

        if(event.getSource() == button_Customer){
            pane_Customer.toFront();
        }
        else if(event.getSource() == button_Insurance){
            pane_Insurance.toFront();
        }
    }
}
