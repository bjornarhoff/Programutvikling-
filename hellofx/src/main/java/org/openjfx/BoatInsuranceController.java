package org.openjfx;

import CustomerModell.Customer;
import Insurances.Boat_Insurance;
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

public class BoatInsuranceController {

    private HandlerFxml handlerFxml = new HandlerFxml();

    @FXML
    private Pane entireScreenBoat;

    @FXML
    private JFXButton btn_Household, btn_Leisure, btn_Boat, btn_Travel, btn_cancel, btn_apply, btn_ok;

    @FXML
    public JFXTextField Owner, registerNr, length, boatTypeModel, motorTypePower, year, yearlyPremium, date, InsuranceAmount, InsuranceConditions;

    @FXML
    private JFXTextArea info;

    @FXML
    private Label customerLabel;



    @FXML
    private void initialize(){
        customerLabel.setText(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));

        NumberValidator numvalidator = new NumberValidator();

        registerNr.getValidators().add(numvalidator);
        length.getValidators().add(numvalidator);
        year.getValidators().add(numvalidator);
        yearlyPremium.getValidators().add(numvalidator);
        InsuranceAmount.getValidators().add(numvalidator);


        numvalidator.setMessage("Only numbers are supported!");

        setInputValidation();

    }


    @FXML
    private void handleButtonActions(ActionEvent event) {

        if(event.getSource() == btn_Household){
            handlerFxml.navigate(entireScreenBoat,"householdInsurance.fxml");
        }
        else if(event.getSource() == btn_Leisure){
            handlerFxml.navigate(entireScreenBoat,"LeisureInsurance.fxml");
        }
        else if(event.getSource() == btn_Travel){
            handlerFxml.navigate(entireScreenBoat,"TravelInsurance.fxml");
        }
        else if(event.getSource() == btn_Boat){
            handlerFxml.navigate(entireScreenBoat,"BoatInsurance.fxml");
        }
    }

    @FXML
    public void cancel() {
        handlerFxml.navigate(entireScreenBoat, "homeInsurance.fxml");
    }

    @FXML
    public void apply(){

        Customer customer = HomeInsuranceController.getCustomerSelected();


        Boat_Insurance b1 = new Boat_Insurance(customer, yearlyPremium.getText(), String.valueOf(new Date()), Integer.parseInt(InsuranceAmount.getText()),
                InsuranceConditions.getText(), Owner.getText(), registerNr.getText(), boatTypeModel.getText(), Double.parseDouble(length.getText()),
                Integer.parseInt(year.getText()), motorTypePower.getText());

        info.setText(b1.toString());

        clearInput();

    }

    public void clearInput(){
        Owner.setText("");
        registerNr.setText("");
        length.setText("");
        boatTypeModel.setText("");
        motorTypePower.setText("");
        year.setText("");
        yearlyPremium.setText("");
        date.setText("");
        InsuranceAmount.setText("");
        InsuranceConditions.setText("");
    }


    public void setInputValidation(){
        registerNr.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    registerNr.validate();
                }
            }
        });

        length.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    length.validate();
                }
            }
        });

        year.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    year.validate();
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
