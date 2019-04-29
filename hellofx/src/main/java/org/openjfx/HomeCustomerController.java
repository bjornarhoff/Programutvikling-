package org.openjfx;

import CustomerModell.Customer;
import FileManagement.CsvReader;
import Serialisering.SearchAndReadFromCSV;
import Threads.Thread;
import Threads.Threads;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.layout.GridPane;
import org.w3c.dom.Text;

import java.io.File;
import java.io.IOException;

import javax.swing.*;
import java.awt.event.KeyListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Date;
import java.util.function.Predicate;

import static org.openjfx.HomeInsuranceController.customerSelected;

public class HomeCustomerController {

    private HandlerFxml handlerFxml = new HandlerFxml();
    private Threads thread = new Threads();




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
        handlerFxml.enableWhenMarked(customerTable, btn_deleteCustomer,btn_editCustomer,btn_showInfoCust);
        entireScreenCustomer.toFront();

    }
    /*
    @FXML
    private void delete(ActionEvent event){
       /* ObservableList<Customer> customerSelected, allCustomers;
        allCustomers = customerTable.getItems();
        customerSelected = customerTable.getSelectionModel().getSelectedItems();

        customerSelected.forEach(allCustomers::remove);

        customers.remove(customerTable.getSelectionModel().getSelectedItem());
    }

    private void search(KeyEvent ke){
        FilteredList filteredData = new FilteredList(observableList, e -> true);

        searching.textProperty().addListener((observableValue, oldValue, newValue) -> {
            filteredData.setPredicate((Predicate<? super Customer >) (Customer customer)->{

                String lowerCaseFilter = newValue.toLowerCase();

                if(newValue == null || newValue.isEmpty()){
                }
                    return true;
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
    private void handleSaveClicked(ActionEvent event) {



    }

    @FXML
    private void handleLoadClicked(ActionEvent event) {

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Load file");
        chooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("CSV File", "*.csv"));
        File csvFile = new File(System.getProperty("user.home") + "/customer1.csv");

        if (!csvFile.exists()) {
            System.out.println("File exist");
        }

        chooser.setInitialDirectory(csvFile);

        File selectedFile = chooser.showOpenDialog(entireScreenCustomer.getScene().getWindow());

    }

    @FXML
    private void handleCloseClicked(ActionEvent event) {

        System.exit(1);
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
