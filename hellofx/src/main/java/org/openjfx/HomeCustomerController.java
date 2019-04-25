package org.openjfx;

import CustomerModell.Customer;
import FileManagement.CsvReader;
import Threads.Thread;
import Threads.Threads;
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
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HomeCustomerController {

    private HandlerFxml handlerFxml = new HandlerFxml();
    private Threads thread = new Threads();




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
        //handlerFxml.loadFileThread();
        //thread.run();
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

    }

    @FXML
    private void handleButtonActions(ActionEvent event) {
        if(event.getSource() == button_Insurance){
            handlerFxml.navigate(entireScreenCustomer,"homeInsurance.fxml");
        }
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
