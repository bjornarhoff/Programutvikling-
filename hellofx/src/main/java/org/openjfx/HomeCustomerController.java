package org.openjfx;

import CustomerModell.Customer;
import Exceptions.ExceptionHandler;
import FileManagement.CsvReader;
import FileManagement.CsvWriter;
import FileManagement.OpenFileChooser;
import Serialisering.SearchAndReadFromCSV;
import Threads.Threads;
import com.jfoenix.controls.JFXButton;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.io.IOException;
import java.util.function.Predicate;

import static org.openjfx.HomeInsuranceController.customerSelected;

public class HomeCustomerController {

    FileChooser chooser = new FileChooser();
    ObservableList<Customer> customers;
    private HandlerFxml handlerFxml = new HandlerFxml();
    private OpenFileChooser openFileChooser = new OpenFileChooser();
    private FileChooser fc = new FileChooser();
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
    private TableColumn<Customer, String> personalID;
    @FXML
    private TableColumn<Customer, String> insuranceNr;
    @FXML
    private TableColumn<Customer, String> name;
    @FXML
    private TableColumn<Customer, String> phone;
    @FXML
    private TableColumn<Customer, String> email;
    @FXML
    private TableColumn<Customer, String> date;
    @FXML
    private TableColumn<Customer, String> billing;

    public static Customer getCustomerSelected() {
        return customerSelected;
    }

    private void setEditable(TableColumn... tablecolum) {
        for (TableColumn colum : tablecolum) {
            colum.setCellFactory(TextFieldTableCell.forTableColumn());
        }
    }

    @FXML
    private void initialize() throws IOException {
        customers = CsvReader.read();
        handlerFxml.setCellValue(personalID, insuranceNr, name, phone, email, date, billing, customerTable);
        // Enables buttons when marked one customer
        handlerFxml.enableWhenMarked(customerTable, btn_deleteCustomer, btn_editCustomer, btn_showDamageReport);
        entireScreenCustomer.toFront();


    }

    @FXML
    private void handleButtonActions(ActionEvent event) throws IOException {
        if(event.getSource() == button_Insurance){
            handlerFxml.navigate(entireScreenCustomer,"homeInsurance.fxml");
        }

        if (event.getSource() == btn_deleteCustomer) {
            String customerSelected = String.valueOf(customerTable.getSelectionModel().getSelectedItem().getPersonalID());
            SearchAndReadFromCSV.deleteCustomerFromCsv(customerSelected);
            SearchAndReadFromCSV.deleteTravelFromCsv(customerSelected);
            SearchAndReadFromCSV.deleteHouseholdFromCsv(customerSelected);
            SearchAndReadFromCSV.deleteBoatFromCsv(customerSelected);
            SearchAndReadFromCSV.deleteLeisureFromCsv(customerSelected);
            SearchAndReadFromCSV.deleteDamageReportFromCsv(customerSelected);

            handlerFxml.setCellValueCustomers(personalID, insuranceNr, name, phone, email, date, billing, customerTable);
        }
    }

    @FXML
    private void handleImportClicked(ActionEvent event) {

        openFileChooser.fileChooserImport(entireScreenCustomer);


    }

    @FXML
    private void handleExportClicked(ActionEvent event) throws IOException {

        openFileChooser.fileChooserExport(entireScreenCustomer);


    }

    @FXML
    private void handleCloseClicked(ActionEvent event) {

        System.exit(1);
    }

    @FXML
    private void damageReportPressed() {
        customerTable.getItems();
        customerSelected = customerTable.getSelectionModel().getSelectedItem();
        handlerFxml.navigate(entireScreenCustomer, "damageReport.fxml");
    }

    @FXML
    private void addCustomerPressed() {
        handlerFxml.navigate(entireScreenCustomer, "createCustomer.fxml");
    }

    public TableView getCustomerTable() {
        return this.customerTable;
    }

    /**
     * Search Method that filters through Customer Table view and matches search input
     */


    public void filter(KeyEvent keyEvent) {
        ObservableList<Customer> data = CsvReader.readAllCustomers();
        searching.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (oldValue != null && (newValue.length() < oldValue.length())) {
                customerTable.setItems(data);
            }
            String value = newValue.toLowerCase();
            ObservableList<Customer> subentries = FXCollections.observableArrayList();

            long count = customerTable.getColumns().stream().count();



    public void filter(KeyEvent keyEvent) throws IOException {
        ObservableList<Customer> data=CsvReader.read();
        searching.textProperty().addListener((ObservableValue<?extends String> observable,String oldValue,String newValue)->{
        if(oldValue!=null&&(newValue.length()<oldValue.length())){
        customerTable.setItems(data);
        }
        String value=newValue.toLowerCase();
        ObservableList<Customer> subentries=FXCollections.observableArrayList();

                }
            }
            customerTable.setItems(subentries);
        });


         /*

        ObservableList<Customer> data =  customerTable.getItems();

        searching.textProperty().addListener(new InvalidationListener() {

            @Override
            public void invalidated(Observable observable) {
                if(searching.textProperty().get().isEmpty()) {
                    customerTable.setItems(data);
                    return;
                }
                ObservableList<Customer> tableItems = FXCollections.observableArrayList();
                ObservableList<TableColumn<Customer, ?>> cols = customerTable.getColumns();
                for(int i=0; i<data.size(); i++) {

                    for(int j=0; j<cols.size(); j++) {
                        TableColumn col = cols.get(j);
                        String cellValue = col.getCellData(data.get(i)).toString();
                        cellValue = cellValue.toLowerCase();
                        if(cellValue.contains(searching.textProperty().get().toLowerCase())) {
                            tableItems.add(data.get(i));
                            break;
                        }
                    }
                }
                customerTable.setItems(tableItems);

            }
        });

         */

    }


    /**
     * Method that edits name from customer table view
     *
     * @param customerStringCellEditEvent
     */
    public void onEdit(TableColumn.CellEditEvent<Customer, String> customerStringCellEditEvent) {
        Customer customerModifiable = customerTable.getSelectionModel().getSelectedItem();


        SearchAndReadFromCSV.deleteCustomerFromCsv(String.valueOf(customerModifiable.getPersonalID()));
        customerModifiable.setName(customerStringCellEditEvent.getNewValue());
        CsvWriter.writeCustomerToCSV(customerModifiable);

    }

    /**
     * Method that edits phone number for the customer in the table view
     *
     * @param customerStringCellEditEvent
     */
    public void onEditPhone(TableColumn.CellEditEvent<Customer, String> customerStringCellEditEvent) {
        Customer customerModifiable = customerTable.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteCustomerFromCsv(String.valueOf(customerModifiable.getPersonalID()));
        customerModifiable.setPhoneNumber(customerStringCellEditEvent.getNewValue());
        CsvWriter.writeCustomerToCSV(customerModifiable);
    }

    /**
     * Method that edits email for the customer in the table view
     *
     * @param customerStringCellEditEvent
     */
    public void onEditEmail(TableColumn.CellEditEvent<Customer, String> customerStringCellEditEvent) {
        Customer customerModifiable = customerTable.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteCustomerFromCsv(String.valueOf(customerModifiable.getPersonalID()));
        customerModifiable.setEmail(customerStringCellEditEvent.getNewValue());
        CsvWriter.writeCustomerToCSV(customerModifiable);

    }


    /**
     * Method that edits billing address for the customer in the Table view
     *
     * @param customerStringCellEditEvent
     */
    public void onEditBilling(TableColumn.CellEditEvent<Customer, String> customerStringCellEditEvent) {
        Customer customerModifiable = customerTable.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteCustomerFromCsv(String.valueOf(customerModifiable.getPersonalID()));
        customerModifiable.setBillingAddress(customerStringCellEditEvent.getNewValue());
        CsvWriter.writeCustomerToCSV(customerModifiable);
    }

    public void editCustomer(ActionEvent event) {
        customerTable.setEditable(true);
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        phone.setCellFactory(TextFieldTableCell.forTableColumn());
        email.setCellFactory(TextFieldTableCell.forTableColumn());
        billing.setCellFactory(TextFieldTableCell.forTableColumn());
        ExceptionHandler.modifyAlertbox("Modify Customers");
    }

    /*
    public void setTerm(TableColumn.CellEditEvent<Customer, String> customerStringCellEditEvent ){
        SearchAndReadFromCSV.deleteCustomerFromCsv(String.valueOf(customer.getPersonalID()));
        customer.(customerStringCellEditEvent.getNewValue());
        CsvWriter.writeCustomerToCSV(customer);
    }

     */
}

