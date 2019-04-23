package org.openjfx;

import Customer_Controller.Customer;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import org.w3c.dom.Text;


import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class HomeCustomerController {

    HandlerFxml handlerFxml = new HandlerFxml();


    @FXML
    private BorderPane entireScreenCustomer;

    @FXML
    private TextField searching;

    @FXML
    private JFXButton button_Customer, button_Insurance, btn_addCustomer, btn_editCustomer, btn_deleteCustomer,
            tn_showDamageReport, btn_showInfoCust;

    @FXML
    private TableView<Customer> customerTable;

    @FXML
    private TableColumn<Customer, String> personalID;

    @FXML
    private TableColumn<Customer, String> name;

    @FXML
    private TableColumn<Customer, String> phone;

    @FXML
    private TableColumn<Customer, String> email;

    @FXML
    private TableColumn <Customer, Date> date;

    @FXML
    private TableColumn<Customer, String> billing;

    @FXML
    private TableColumn<Customer, Double> unpaidReplacements;

    @FXML
    public void initialize(){

        personalID.setCellValueFactory(new PropertyValueFactory<>("personalID"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        email.setCellValueFactory(new PropertyValueFactory<>("email"));
       // date.setCellValueFactory(new PropertyValueFactory<>(date));
        billing.setCellValueFactory(new PropertyValueFactory<>("billingAddress"));
        unpaidReplacements.setCellValueFactory(new PropertyValueFactory<>("unpaidReplacements"));

        entireScreenCustomer.toFront();
        customerTable.setItems(observableList);




    }

    ObservableList<Customer> observableList = FXCollections.observableArrayList(
            new Customer("123", "Cato", "11", "fda", new Date(), "fasdf"),
            new Customer("43", "sven", "143", "asddddlf", new Date(), "fasdf"),
            new Customer("66", "bjornar", "99", "ahjnbsdlf", new Date(), "fasdf"),
            new Customer("88", "tree", "87", "nh", new Date(), "fasdf")

    );


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

    }
}
