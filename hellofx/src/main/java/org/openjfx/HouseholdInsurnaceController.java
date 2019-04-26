package org.openjfx;

import CustomerModell.Customer;
import FileManagement.CsvWriter;
import FileManagement.ObjectWriter;
import Insurances.House_Household_Insurance;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import java.util.Date;

public class HouseholdInsurnaceController {

    private HandlerFxml handlerFxml = new HandlerFxml();

    @FXML
    private Pane entireScreenHousehold;

    @FXML
    private Label customerLabel;

    @FXML
    private JFXButton btn_household, btn_leisure, btn_boat, btn_travel, btn_cancel, btn_apply, btn_ok;

    @FXML
    private JFXTextField propertyOwner, yearConstruction, constMaterial, residentialType, amountForConstruction, nrSquareMeters,
                        conditions, amountForHousehold, yearlyPremium, date, InsuranceAmount, InsuranceConditions;

    @FXML
    private JFXTextArea info;

    @FXML
    private void initialize(){
        customerLabel.setText(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
    }


    @FXML
    private void handleButtonActions(ActionEvent event) {

        if(event.getSource() == btn_household){
            handlerFxml.navigate(entireScreenHousehold,"householdInsurance.fxml");
        }
        else if(event.getSource() == btn_leisure){
            handlerFxml.navigate(entireScreenHousehold,"LeisureInsurance.fxml");
        }
        else if(event.getSource() == btn_travel){
            handlerFxml.navigate(entireScreenHousehold,"TravelInsurance.fxml");
        }
        else if(event.getSource() == btn_boat){
            handlerFxml.navigate(entireScreenHousehold,"BoatInsurance.fxml");
        }
    }

    @FXML
    public void cancel() {
        handlerFxml.navigate(entireScreenHousehold, "homeInsurance.fxml");
    }

    @FXML
    public void apply(){

        Customer customer = HomeInsuranceController.getCustomerSelected();

        House_Household_Insurance h1 = new House_Household_Insurance(customer, yearlyPremium.getText(), String.valueOf(new Date()), Integer.parseInt(InsuranceAmount.getText()),
         InsuranceConditions.getText(), propertyOwner.getText(), Integer.parseInt(yearConstruction.getText()), residentialType.getText(), constMaterial.getText(),
          conditions.getText(), Double.parseDouble(nrSquareMeters.getText()), Integer.parseInt(amountForConstruction.getText()), Integer.parseInt(InsuranceConditions.getText()));

        CsvWriter.writeHouseInsuranceToCSV(h1);
        info.setText(h1.toString());



        propertyOwner.setText("");
        yearConstruction.setText("");
        constMaterial.setText("");
        residentialType.setText("");
        amountForConstruction.setText("");
        nrSquareMeters.setText("");
        conditions.setText("");
        amountForHousehold.setText("");
        yearlyPremium.setText("");
        date.setText("");
        InsuranceAmount.setText("");
        InsuranceConditions.setText("");
    }
}
