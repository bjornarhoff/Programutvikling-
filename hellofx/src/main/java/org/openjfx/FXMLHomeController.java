package org.openjfx;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.Pane;

public class FXMLHomeController {


    @FXML
    private Pane pane_Customer, pane_Insurance;

    @FXML
    private JFXButton button_Customer, button_Insurance, btn_addCustomer, btn_editCustomer, btn_deleteCustomer,
            tn_showDamageReport, btn_showInfoCust, btn_createInsurance, btn_modfiInsurance, btn_showInfoIns ;

    @FXML
    private TreeTableView ttv_custView;

    @FXML
    private TreeTableColumn ttc_cName, ttc_cPersonalID, ttc_cInsruanceID, ttc__cNrInsurnaces;

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
