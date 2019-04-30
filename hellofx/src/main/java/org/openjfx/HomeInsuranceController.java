package org.openjfx;

import CustomerModell.Customer;
import FileManagement.CsvReader;
import FileManagement.CsvWriter;
import com.jfoenix.controls.JFXButton;
import javafx.beans.binding.Bindings;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.awt.event.MouseEvent;
import java.io.File;

public class HomeInsuranceController {

        HandlerFxml handlerFxml = new HandlerFxml();
        static Customer customerSelected;

        @FXML
        private BorderPane entireScreenInsurance;

        @FXML
        private TableView<Customer> insuranceTable;

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
        private GridPane pane_Insurance;

        @FXML
        private JFXButton button_Customer, btn_createInsurance1, btn_modfiInsurance1, btn_deleteInsurance1, btn_showInfoIns1;


        @FXML
        private void initialize(){
            handlerFxml.setCellValue(personalID, insuranceNr, name, phone, email, date, billing, insuranceTable);
            handlerFxml.enableWhenMarked(insuranceTable,btn_createInsurance1,btn_modfiInsurance1,btn_deleteInsurance1,btn_showInfoIns1);
            entireScreenInsurance.toFront();


        }

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
            if(event.getSource() == btn_modfiInsurance1){
                insuranceTable.getItems();
                customerSelected = insuranceTable.getSelectionModel().getSelectedItem();
                handlerFxml.navigate(entireScreenInsurance, "Insurances.fxml");
            }
        }

        public static Customer getCustomerSelected() {
            return customerSelected;
        }

        @FXML
        private void addInsurancePressed(){
            handlerFxml.navigate(entireScreenInsurance, "householdInsurance.fxml");
    }

}
