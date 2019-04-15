package org.openjfx;


import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.layout.AnchorPane;


public class DamageReportController {

    //DamageReport
    @FXML
    private AnchorPane anchorPane;

    @FXML
    private TextArea text_area;

    @FXML
    private TextField txt_Customername;

    @FXML
    private TreeTableColumn ttc_damageNr,ttc_dateDamage, ttc_unpaid, ttc_taxAmount;

    @FXML
    private TreeTableView ttv_table;

    @FXML
    private JFXButton btn_create, btn_edit, btn_showDescription, btn_delete, btn_goBack;




    // CreateDamageReport
    @FXML
    private TextArea txta_info, txta_DaDescription, txta_potWitnesses;

    @FXML
    private TextField txt_date, txt_damageType, txt_customerName;

    @FXML
    private JFXButton btn_cancel, btn_apply, btn_ok;


    @FXML
    private void handleButtonActions(ActionEvent event){


    }

    @FXML
    private void goBackPressed(){
            HandlerFxml handlerFxml = new HandlerFxml();
            handlerFxml.toHome(anchorPane);
    }
}
