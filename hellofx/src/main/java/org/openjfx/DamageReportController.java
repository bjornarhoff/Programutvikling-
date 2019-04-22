package org.openjfx;


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
    private Label customerName;

    @FXML
    private JFXButton btn_create, btn_edit, btn_showDescription, btn_delete, btn_goBack;

    @FXML
    private TreeTableView ttv_table;

    @FXML
    private TreeTableColumn ttc_damageNr,ttc_dateDamage, ttc_unpaid, ttc_taxAmount;

    @FXML
    private TextArea desciption;


    @FXML
    private void createDamageReport(ActionEvent event){
        handlerFxml.navigate(damageReport, "createDamageReport.fxml");
    }

    @FXML
    private void goBackPressed(){
        handlerFxml.navigate(damageReport, "homeCustomer.fxml");
    }
}
