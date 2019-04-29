package org.openjfx;

import CustomerModell.Customer;
import FileManagement.CsvReader;
import Serialisering.SearchAndReadFromCSV;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TreeItemPropertyValueFactory;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import org.w3c.dom.Text;


import javax.swing.*;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Predicate;

import static org.openjfx.HomeInsuranceController.customerSelected;

public class HomeCustomerController {

    private HandlerFxml handlerFxml = new HandlerFxml();



    @FXML
    private BorderPane entireScreenCustomer;

    @FXML
    private TextField searching;

    @FXML
    private JFXButton button_Customer, button_Insurance, btn_addCustomer, btn_editCustomer, btn_deleteCustomer,
            tn_showDamageReport, btn_showInfoCust, refresh;

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



    ObservableList<Customer> customers;
    @FXML
    private void initialize(){
        handlerFxml.setCellValue(personalID, insuranceNr, name, phone, email, date, billing, customerTable);
        entireScreenCustomer.toFront();

    }

    @FXML
    private void handleButtonActions(ActionEvent event) {
        if(event.getSource() == button_Insurance){
            handlerFxml.navigate(entireScreenCustomer,"homeInsurance.fxml");
        }

        if (event.getSource() == btn_deleteCustomer) {
            String customerSelected = customerTable.getSelectionModel().getSelectedItem().getPersonalID();
            SearchAndReadFromCSV.deleteCustomerFromCsv(customerSelected);
            SearchAndReadFromCSV.deleteTravelFromCsv(customerSelected);
            SearchAndReadFromCSV.deleteHouseholdFromCsv(customerSelected);
            SearchAndReadFromCSV.deleteBoatFromCsv(customerSelected);
            SearchAndReadFromCSV.deleteLeisureFromCsv(customerSelected);

            handlerFxml.setCellValue(personalID, insuranceNr, name, phone, email, date, billing, customerTable);


        }
    }

    public static Customer getCustomerSelected() {
        return customerSelected;
    }


    @FXML
    public void delete(ActionEvent event) {

    }




    @FXML
    private void damageReportPressed(){

        customerTable.getItems();
        customerSelected = customerTable.getSelectionModel().getSelectedItem();
        handlerFxml.navigate(entireScreenCustomer, "damageReport.fxml");
       // System.out.println(customerSelected.getPersonalID());


    }

    @FXML
    private void addCustomerPressed(){
        handlerFxml.navigate(entireScreenCustomer, "createCustomer.fxml");
    }

    public TableView getCustomerTable() {
        return this.customerTable;
    }


    public void search(KeyEvent keyEvent) {
        FilteredList<Customer> filteredData = new FilteredList<>(customers, e -> true);

        searching.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate((Predicate<? super Customer>) customer -> {

                String lowerCaseFilter = newValue.toLowerCase();

                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                if(customer.getPersonalID().contains(lowerCaseFilter)){
                    return true;
                }

                else if(customer.getName().toLowerCase().contains(lowerCaseFilter)){
                    return true;
                }

                return false;

            });

        });

        SortedList<Customer> sortedData = new SortedList<>(filteredData);
        sortedData.comparatorProperty().bind(customerTable.comparatorProperty());
        customerTable.setItems(sortedData);
    }
}
