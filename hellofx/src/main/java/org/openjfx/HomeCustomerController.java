package org.openjfx;

import CustomerModell.Customer;
import FileManagement.CsvReader;
import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.util.ArrayList;

public class HomeCustomerController {

    private HandlerFxml handlerFxml = new HandlerFxml();
    FileChooser fileChooser = new FileChooser();




    @FXML
    private BorderPane entireScreenCustomer;

    @FXML
    private JFXButton button_Customer, button_Insurance, btn_addCustomer, btn_editCustomer, btn_deleteCustomer,
            tn_showDamageReport, btn_showInfoCust;

    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Customer,String> personalID;

    @FXML
    private TableColumn<Customer,String> insuranceNr;

    @FXML
    private TableColumn<Customer,String> name;

    @FXML
    private TableColumn<Customer,String> phone;

    @FXML
    private TableColumn<Customer,String> email;

    @FXML
    private TableColumn<Customer,String> date;

    @FXML
    private TableColumn<Customer,String> billing;

    @FXML
    private TableColumn<Customer,String> unpaidReplacements;


    @FXML
    private void initialize(){
        ObservableList<Customer> customers = CsvReader.read();
        personalID.setCellValueFactory(new PropertyValueFactory<>("personalID"));
        insuranceNr.setCellValueFactory(new PropertyValueFactory<>("insuranceNr"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        billing.setCellValueFactory(new PropertyValueFactory<>("billingAddress"));
        unpaidReplacements.setCellValueFactory(new PropertyValueFactory<>("unpaidReplacements"));
        customerTable.setItems(customers);

        entireScreenCustomer.toFront();
        fileChooser.setInitialDirectory(new File(System.getProperty("user.home")+"/customer2.csv"));

    }

    @FXML
    private void handleButtonActions(ActionEvent event) {
        if(event.getSource() == button_Insurance){
            handlerFxml.navigate(entireScreenCustomer,"homeInsurance.fxml");
        }
    }

    @FXML
    private void handleSaveClicked(ActionEvent event) {
        System.out.println("Save clicked");

    }

    @FXML
    private void handleLoadClicked(ActionEvent event) {

        System.out.println("Load clicked");
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
