package org.openjfx;


import Damages.Damage_Report;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;


public class DamageReportController {

    HandlerFxml handlerFxml = new HandlerFxml();

    @FXML
    private BorderPane damageReport;

    @FXML
    private Label customerLabel;

    @FXML
    private JFXButton btn_create, btn_edit, btn_showDescription, btn_delete, btn_goBack;

    @FXML
    private TableView<Damage_Report> damageTableView;

    @FXML
    private TableColumn<Damage_Report, String> dmgType,dmgNr, dmgDate, tax, unpaid;

    @FXML
    private TextArea desciption;



    @FXML
    private void initialize(){
        customerLabel.setText(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
        handlerFxml.setCellValueDamageReport(dmgType, dmgNr, dmgDate, tax, unpaid,damageTableView);

    }

    @FXML
    private void createDamageReport(ActionEvent event){
        handlerFxml.navigate(damageReport, "createDamageReport.fxml");
    }

    @FXML
    private void goBackPressed(){
        handlerFxml.navigate(damageReport, "homeCustomer.fxml");
    }
}
