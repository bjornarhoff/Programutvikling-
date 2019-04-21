package org.openjfx;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;


public class DamageReportController {

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
        try {
            Parent root = FXMLLoader.load(getClass().getResource("createDamageReport.fxml"));
            damageReport.getChildren().setAll(root);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void goBackPressed(){
            HandlerFxml handlerFxml = new HandlerFxml();
            handlerFxml.toHome(damageReport);
    }
}
