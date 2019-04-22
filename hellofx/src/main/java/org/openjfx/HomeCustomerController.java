package org.openjfx;

import Customer_Controller.Customer;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;
import java.util.Date;

public class HomeCustomerController {

    HandlerFxml handlerFxml = new HandlerFxml();


    @FXML
    private BorderPane entireScreenCustomer;

    @FXML
    private JFXButton button_Customer, button_Insurance, btn_addCustomer, btn_editCustomer, btn_deleteCustomer,
            tn_showDamageReport, btn_showInfoCust;

    @FXML
    private TableView customerTable;

    @FXML
    private TableColumn personalID;

    @FXML
    private TableColumn name;

    @FXML
    private TableColumn phone;

    @FXML
    private TableColumn email;

    @FXML
    private TableColumn date;

    @FXML
    private TableColumn billing;

    @FXML
    private TableColumn unpaidReplacements;

    @FXML
    private void initialize(){
        entireScreenCustomer.toFront();
    }

    @FXML
    private void handleButtonActions(ActionEvent event) {
        if(event.getSource() == button_Insurance){
            handlerFxml.navigate(entireScreenCustomer,"homeInsurance.fxml");
        }
    }

    @FXML
    private void damageReportPressed(){
        handlerFxml.navigate(entireScreenCustomer, "damageReport.fxml");
    }

    @FXML
    private void addCustomerPressed(){
        handlerFxml.navigate(entireScreenCustomer, "createCustomer.fxml");
    }

    public TableView getCustomerTable() {
        return this.customerTable;
    }
}
