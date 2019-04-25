package org.openjfx;

import CustomerModell.Customer;
import FileManagement.CsvReader;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import org.w3c.dom.Text;


import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.function.Predicate;

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

        entireScreenCustomer.toFront();

    }



/*
    @FXML
    private void search(KeyEvent ke){
        FilteredList filteredData = new FilteredList(observableList, e -> true);

        searching.textProperty().addListener((observableValue, oldValue, newValue) -> {
            filteredData.setPredicate((Predicate<? super Customer >) (Customer customer)->{

                String lowerCaseFilter = newValue.toLowerCase();

                if(newValue == null || newValue.isEmpty()){
                    return true;
                }
                if(customer.getPersonalID().contains(newValue)){
                    return true;
                }

                else if(customer.getName().toLowerCase().contains(newValue)){
                    return true;
                }

                return false;

            });

        });

        SortedList sortedData = new SortedList(filteredData);
        sortedData.comparatorProperty().bind(customerTable.comparatorProperty());
        customerTable.setItems(sortedData);

    }*/

    @FXML
    private void delete(ActionEvent event){
       /* ObservableList<Customer> customerSelected, allCustomers;
        allCustomers = customerTable.getItems();
        customerSelected = customerTable.getSelectionModel().getSelectedItems();

        customerSelected.forEach(allCustomers::remove); */

        customers.remove(customerTable.getSelectionModel().getSelectedItem());


    }

    @FXML
    private void refresh(ActionEvent event){
        customers = CsvReader.read();
        personalID.setCellValueFactory(new PropertyValueFactory<>("personalID"));
        insuranceNr.setCellValueFactory(new PropertyValueFactory<>("insuranceNr"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
        date.setCellValueFactory(new PropertyValueFactory<>("date"));
        billing.setCellValueFactory(new PropertyValueFactory<>("billingAddress"));
        customerTable.setItems(customers);
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



    public void search(javafx.scene.input.KeyEvent keyEvent) {
        FilteredList<Customer> filteredData = new FilteredList<>(customers, e -> true);

        searching.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(customer -> {

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
