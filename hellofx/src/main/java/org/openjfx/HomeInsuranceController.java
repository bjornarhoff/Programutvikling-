package org.openjfx;

import CustomerModell.Customer;
import FileManagement.OpenFileChooser;
import com.jfoenix.controls.JFXButton;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import FileManagement.CsvReader;

public class HomeInsuranceController {


    static Customer customerSelected;
    HandlerFxml handlerFxml = new HandlerFxml();
    private OpenFileChooser openFileChooser = new OpenFileChooser();

    @FXML
    private BorderPane entireScreenInsurance;

    @FXML
    private TableView<Customer> insuranceTable;

    @FXML
    private TableColumn<Customer, String> personalID, insuranceNr, name, phone, email, date, billing;

    @FXML
    private GridPane pane_Insurance;

    @FXML
    private TextField searching;

    @FXML
    private JFXButton button_Customer, btn_createInsurance1, btn_modfiInsurance1, btn_deleteInsurance1, btn_showInfoIns1;

    /**
     * @return customer selected
     */
    public static Customer getCustomerSelected() {
        return customerSelected;
    }

    /**
     * Initialize Method that sets the data for the table view and enables when marked buttons
     */
    @FXML
    private void initialize() {
        handlerFxml.setCellValueCustomers(personalID, insuranceNr, name, phone, email, date, billing, insuranceTable);
        handlerFxml.enableWhenMarked(insuranceTable, btn_createInsurance1, btn_modfiInsurance1);
        entireScreenInsurance.toFront();


    }

    /**
     * Method that handle button clicked events
     *
     * @param event
     */
    @FXML
    private void handleButtonActions(ActionEvent event) {
        if (event.getSource() == button_Customer) {
            handlerFxml.navigate(entireScreenInsurance, "homeCustomer.fxml");
        }

        if (event.getSource() == btn_createInsurance1) {
            insuranceTable.getItems();
            customerSelected = insuranceTable.getSelectionModel().getSelectedItem();
            handlerFxml.navigate(entireScreenInsurance, "householdInsurance.fxml");
        }
        if (event.getSource() == btn_modfiInsurance1) {
            insuranceTable.getItems();
            customerSelected = insuranceTable.getSelectionModel().getSelectedItem();
            handlerFxml.navigate(entireScreenInsurance, "Insurances.fxml");
        }
    }

    /**
     * Method that handle Import files
     *
     * @param event
     */
    @FXML
    private void handleImportClicked(ActionEvent event) {
        openFileChooser.fileChooserImport(entireScreenInsurance);
    }

    /**
     * Method that handles export files
     *
     * @param event
     */
    @FXML
    private void handleExportClicked(ActionEvent event) {
        openFileChooser.fileChooserExport(entireScreenInsurance);
    }

    /**
     * Method that handles exit window
     *
     * @param event
     */
    @FXML
    private void handleCloseClicked(ActionEvent event) {
        System.exit(1);
    }

    @FXML
    private void addInsurancePressed() {
        handlerFxml.navigate(entireScreenInsurance, "householdInsurance.fxml");
    }

    /**
     * Method that filters through the customer table view and shows the matching results
     *
     * @param keyEvent
     */
    public void search(KeyEvent keyEvent) {


        ObservableList<Customer> data = CsvReader.readAllCustomers();
        searching.textProperty().addListener((ObservableValue<? extends String> observable, String oldValue, String newValue) -> {
            if (oldValue != null && (newValue.length() < oldValue.length())) {
                insuranceTable.setItems(data);
            }
            String value = newValue.toLowerCase();
            ObservableList<Customer> subentries = FXCollections.observableArrayList();

            long count = insuranceTable.getColumns().stream().count();

            for (int i = 0; i < insuranceTable.getItems().size(); i++) {
                for (int j = 0; j < count; j++) {
                    String entry = "" + insuranceTable.getColumns().get(j).getCellData(i);
                    if (entry.toLowerCase().contains(value)) {
                        subentries.add(insuranceTable.getItems().get(i));
                        break;
                    }

                }
            }
            insuranceTable.setItems(subentries);
        });


    }

}
