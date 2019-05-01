package org.openjfx;

import CustomerModell.Customer;
import FileManagement.CsvWriter;
import FileManagement.ObjectWriter;
import Insurances.House_Household_Insurance;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

        NumberValidator numvalidator = new NumberValidator();

        amountForConstruction.getValidators().add(numvalidator);
        yearConstruction.getValidators().add(numvalidator);
        nrSquareMeters.getValidators().add(numvalidator);
        amountForHousehold.getValidators().add(numvalidator);
        yearlyPremium.getValidators().add(numvalidator);
        InsuranceAmount.getValidators().add(numvalidator);


        numvalidator.setMessage("Only numbers are supported!");

        setInputValidaiton();


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
          conditions.getText(), Double.parseDouble(nrSquareMeters.getText()), Integer.parseInt(amountForConstruction.getText()), Integer.parseInt(amountForHousehold.getText()));

        CsvWriter.writeHouseInsuranceToCSV(h1, true);
        info.setText(h1.toString());
        clearInput();


    }

    public void setInputValidaiton(){
        amountForConstruction.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    amountForConstruction.validate();
                }
            }
        });

        yearConstruction.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    yearConstruction.validate();
                }
            }
        });

        nrSquareMeters.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    nrSquareMeters.validate();
                }
            }
        });

        amountForHousehold.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    amountForHousehold.validate();
                }
            }
        });

        yearlyPremium.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    yearlyPremium.validate();
                }
            }
        });

        InsuranceAmount.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    InsuranceAmount.validate();
                }
            }
        });
    }

    public void clearInput(){
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
