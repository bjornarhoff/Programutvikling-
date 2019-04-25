package org.openjfx;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class HomeInsuranceController {

        HandlerFxml handlerFxml = new HandlerFxml();

        @FXML
        private BorderPane entireScreenInsurance;

        @FXML
        private GridPane pane_Insurance;

        @FXML
        private JFXButton button_Customer, btn_createInsurance1, btn_modfiInsurance1, btn_deleteInsurance1, btn_showInfoIns1;


        @FXML
        private void handleButtonActions(ActionEvent event) {
            if(event.getSource() == button_Customer){
                handlerFxml.navigate(entireScreenInsurance,"homeCustomer.fxml");
            }
            //if(event.getSource() == btn_createInsurance1){
              //  handlerFxml.navigate(entireScreenInsurance,"HouseholdInsurance.fxml");
            }

        //}

        @FXML
        private void addInsurancePressed(){
            handlerFxml.navigate(entireScreenInsurance, "HouseholdInsurance.fxml");
    }

}
