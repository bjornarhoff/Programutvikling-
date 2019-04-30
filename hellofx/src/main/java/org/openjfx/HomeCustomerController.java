package org.openjfx;

import CustomerModell.Customer;
import FileManagement.CsvReader;
import Serialisering.SearchAndReadFromCSV;
import Threads.Threads;
import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
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
            btn_showDamageReport, btn_showInfoCust, refresh;

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
        // Sets cell value to tableview
        handlerFxml.setCellValue(personalID, insuranceNr, name, phone, email, date, billing, customerTable);
        // Enables buttons when marked one customer
        handlerFxml.enableWhenMarked(customerTable, btn_deleteCustomer,btn_editCustomer,btn_showInfoCust,btn_showDamageReport);
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
    private void handleImportClicked(ActionEvent event) {

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Import file");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv"));
                new FileChooser.ExtensionFilter("J Object file (*.jobj", "*.jobj");
        String directory = System.getProperty("user.home");
        File userDirectory = new File(directory);

        if(!userDirectory.canRead()) {
            userDirectory = new File("c:/");
        }
        chooser.setInitialDirectory(userDirectory);

        // Choose file
        File file = chooser.showOpenDialog(null);

        //Make sure a file was selected, if not return default
        String path;
        if(file != null) {
            path = file.getPath();
            ObservableList<Customer> list = CsvReader.read(file);
            handlerFxml.setCellValue(customerTable, list, customerTable.getColumns());

        } else {
            //default return value
            path = null;
        }



    }

    @FXML
    private void handleExportClicked(ActionEvent event) {

        FileChooser chooser = new FileChooser();
        chooser.setTitle("Export file");
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV files", "*.csv"),
                new FileChooser.ExtensionFilter("jObj file ", "*.ser"));

        String directory = System.getProperty("user.home");
        File userDirectory = new File(directory);

        if(!userDirectory.canRead()) {
            userDirectory = new File("c:/");
        }
        chooser.setInitialDirectory(userDirectory);

        Stage stage = new Stage();

        File selectedFile = chooser.showSaveDialog(stage);

        if (selectedFile != null) {
            try {
               selectedFile.createNewFile();


            } catch (Exception e) {
                e.printStackTrace();
            }
        }
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
    }

    @FXML
    private void addCustomerPressed(){
        handlerFxml.navigate(entireScreenCustomer, "createCustomer.fxml");
    }

    public TableView getCustomerTable() {
        return this.customerTable;
    }

    /**
     * Search Method that filters through Customer Table view and matches search input
     * @param keyEvent
     */
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
