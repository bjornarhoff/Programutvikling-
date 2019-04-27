package org.openjfx;

import CustomerModell.Customer;
import FileManagement.CsvWriter;
import FileManagement.ObjectWriter;
import Insurances.Leisure_Insurance;
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

import java.awt.*;
import java.util.Date;

public class LeisureInsuranceController {

    private HandlerFxml handlerFxml = new HandlerFxml();


    @FXML
    private Pane entireScreenLeisure;

    @FXML
    public JFXButton btn_household, btn_leisure, btn_boat, btn_travel, btn_cancel, btn_apply, btn_ok;

    @FXML
    private JFXTextField address, yearConstruction, constructionMaterial, residentialType, amountConstruction, nrSquareMeters,
                        condition, amountHousehold, date, InsuranceConditions, yearlyPremium, InsuranceAmount;

    @FXML
    public JFXTextArea info;

    @FXML
    private Label customerLabel;

    @FXML
    private void initialize(){
        customerLabel.setText(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));

        NumberValidator numvalidator = new NumberValidator();

        yearConstruction.getValidators().add(numvalidator);
        amountConstruction.getValidators().add(numvalidator);
        nrSquareMeters.getValidators().add(numvalidator);
        amountHousehold.getValidators().add(numvalidator);
        yearlyPremium.getValidators().add(numvalidator);
        InsuranceAmount.getValidators().add(numvalidator);


        numvalidator.setMessage("Only numbers are supported!");

        setValidationInput();
    }




    @FXML
    private void handleButtonActions(ActionEvent event) {
        if(event.getSource() == btn_household){
            handlerFxml.navigate(entireScreenLeisure,"householdInsurance.fxml");
        }
        if(event.getSource() == btn_leisure){
            handlerFxml.navigate(entireScreenLeisure,"LeisureInsurance.fxml");
        }
        if(event.getSource() == btn_travel){
            handlerFxml.navigate(entireScreenLeisure,"TravelInsurance.fxml");
        }
        if(event.getSource() == btn_boat){
            handlerFxml.navigate(entireScreenLeisure,"BoatInsurance.fxml");
        }
    }



    @FXML
    public void cancel() {
        handlerFxml.navigate(entireScreenLeisure, "homeInsurance.fxml");
    }

    @FXML
    public void apply(){


        Customer customer = HomeInsuranceController.getCustomerSelected();

        Leisure_Insurance l1 = new Leisure_Insurance(customer, yearlyPremium.getText(), String.valueOf(new Date()), Integer.parseInt(InsuranceAmount.getText()),
         InsuranceConditions.getText(), address.getText(), Integer.parseInt(yearConstruction.getText()), residentialType.getText(), constructionMaterial.getText(),
          condition.getText(), Double.parseDouble(nrSquareMeters.getText()), Integer.parseInt(amountConstruction.getText()), Integer.parseInt(amountHousehold.getText()));


        CsvWriter.writeLeisureInsurance(l1);
        info.setText(l1.toString());

        setText();

    }



    public void setText(){
        address.setText("");
        yearConstruction.setText("");
        constructionMaterial.setText("");
        residentialType.setText("");
        amountConstruction.setText("");
        nrSquareMeters.setText("");
        condition.setText("");
        amountHousehold.setText("");
        date.setText("");
        InsuranceConditions.setText("");
        yearlyPremium.setText("");
        InsuranceAmount.setText("");
    }

    public void setValidationInput(){
        yearConstruction.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    yearConstruction.validate();
                }
            }
        });

        amountConstruction.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    amountConstruction.validate();
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

        amountHousehold.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    amountHousehold.validate();
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
}
