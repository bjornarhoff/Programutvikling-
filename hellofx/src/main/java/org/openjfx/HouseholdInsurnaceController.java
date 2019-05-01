package org.openjfx;

import CustomerModell.Customer;
import FileManagement.CsvWriter;
import Insurances.House_Household_Insurance;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.AnimationTimer;
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
            conditions, amountForHousehold, yearlyPremium, date, insuranceAmount, insuranceConditions;

    @FXML
    private JFXTextArea info;

    @FXML
    private void initialize() {
        customerLabel.setText(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));

        new AnimationTimer() {
            @Override
            public void handle(long l) {
                boolean allFilled = handlerFxml.enableButton(btn_apply,propertyOwner, yearConstruction, constMaterial, residentialType, amountForConstruction, nrSquareMeters,
                        conditions, amountForHousehold, yearlyPremium, date, insuranceAmount, insuranceConditions);
                if (allFilled){
                    btn_apply.setDisable(false);
                }else{
                    btn_apply.setDisable(true);
                }
            }
        }.start();

        handlerFxml.setInputValidation(amountForConstruction);
        handlerFxml.setInputValidation(yearConstruction);
        handlerFxml.setInputValidation(nrSquareMeters);
        handlerFxml.setInputValidation(amountForHousehold);
        handlerFxml.setInputValidation(yearlyPremium);
        handlerFxml.setInputValidation(amountForConstruction);
        handlerFxml.setInputValidation(insuranceAmount);


    }


    @FXML
    private void handleButtonActions(ActionEvent event) {

        if (event.getSource() == btn_household) {
            handlerFxml.navigate(entireScreenHousehold, "householdInsurance.fxml");
        } else if (event.getSource() == btn_leisure) {
            handlerFxml.navigate(entireScreenHousehold, "LeisureInsurance.fxml");
        } else if (event.getSource() == btn_travel) {
            handlerFxml.navigate(entireScreenHousehold, "TravelInsurance.fxml");
        } else if (event.getSource() == btn_boat) {
            handlerFxml.navigate(entireScreenHousehold, "BoatInsurance.fxml");
        }
    }

    @FXML
    public void cancel() {
        handlerFxml.navigate(entireScreenHousehold, "homeInsurance.fxml");
    }

    @FXML
    public void apply() {

        Customer customer = HomeInsuranceController.getCustomerSelected();

        House_Household_Insurance h1 = new House_Household_Insurance(customer, yearlyPremium.getText(), String.valueOf(new Date()), Integer.parseInt(insuranceAmount.getText()),
                insuranceConditions.getText(), propertyOwner.getText(), Integer.parseInt(yearConstruction.getText()), residentialType.getText(), constMaterial.getText(),
                conditions.getText(), Double.parseDouble(nrSquareMeters.getText()), Integer.parseInt(amountForConstruction.getText()), Integer.parseInt(amountForHousehold.getText()));

        CsvWriter.writeHouseInsuranceToCSV(h1);
        info.setText(h1.toString());

        // Clear input
        handlerFxml.clearInput(propertyOwner, yearConstruction, constMaterial, residentialType, amountForConstruction, nrSquareMeters,
        conditions, amountForHousehold, yearlyPremium, date, insuranceAmount, insuranceConditions);

    }

    /*public void setInputValidaiton(){
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

        insuranceAmount.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    insuranceAmount.validate();
                }
            }
        });
    }

    public void clearInput(JFXTextField ... fields) {

        for (JFXTextField field : fields) {
            field.setText("");
        }
    }


    public void setInputValidation(JFXTextField textField) {
        textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    textField.validate();
                }
            }
        });
    } */
}
