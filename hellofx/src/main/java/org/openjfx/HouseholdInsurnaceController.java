package org.openjfx;

import CustomerModell.Customer;
import Exceptions.ExceptionHandler;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
            conditions, amountForHousehold, yearlyPremium, InsuranceAmount, InsuranceConditions;

    @FXML
    private JFXTextArea info;


    /**
     * Method that validates input for text fields so a user has to enter a Integer input
     *
     * @return true if entered Integer and false if not
     */
    private boolean validateNumber() {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(amountForConstruction.getText());
        Matcher m2 = p.matcher(amountForHousehold.getText());
        Matcher m3 = p.matcher(InsuranceAmount.getText());
        Matcher m4 = p.matcher(nrSquareMeters.getText());
        if (m.find() && m.group().equals(amountForConstruction.getText()) && m2.find() && m2.group().equals(amountForHousehold.getText()) && m3.find() &&
                m3.group().equals(InsuranceAmount.getText()) && m4.find() && m4.group().equals(nrSquareMeters.getText())) {
            return true;
        } else {
            ExceptionHandler.alertBox("Wrong Input Data Type", "Check red highleted boxes", "Convert Leters into numbers");
            return false;
        }
    }

    /**
     * Initialize Method
     */
    @FXML
    private void initialize() {
        customerLabel.setText(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
        handlerFxml.setInputValidation(amountForConstruction);
        handlerFxml.setInputValidation(yearConstruction);
        handlerFxml.setInputValidation(nrSquareMeters);
        handlerFxml.setInputValidation(amountForHousehold);
        handlerFxml.setInputValidation(amountForConstruction);
        handlerFxml.setInputValidation(InsuranceAmount);


        new AnimationTimer() {
            @Override
            public void handle(long l) {
                boolean filled = handlerFxml.enableButton(btn_apply, propertyOwner, yearConstruction, residentialType, constMaterial, conditions, amountForConstruction, nrSquareMeters,
                        amountForHousehold, yearlyPremium, InsuranceAmount, InsuranceConditions);
                if (filled) {
                    btn_apply.setDisable(false);
                } else {
                    btn_apply.setDisable(true);
                }
            }
        }.start();

    }


    /**
     * Method that hanldes button events for switching between Insurance screens
     *
     * @param event
     */
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

    /**
     * Method that takes you back to home Insurance screen
     */
    @FXML
    public void cancel() {
        handlerFxml.navigate(entireScreenHousehold, "homeInsurance.fxml");
    }

    /**
     * Method that checks if all input is valid and if true creates a new Household Insurance
     */
    @FXML
    public void apply() {
        Customer customer = HomeInsuranceController.getCustomerSelected();
        if (validateNumber()) {
            try {
                House_Household_Insurance h1 = new House_Household_Insurance(customer, yearlyPremium.getText(), String.valueOf(new Date()), Integer.parseInt(InsuranceAmount.getText()),
                        InsuranceConditions.getText(), propertyOwner.getText(), Integer.parseInt(yearConstruction.getText()), residentialType.getText(), constMaterial.getText(),
                        conditions.getText(), Double.parseDouble(nrSquareMeters.getText()), Integer.parseInt(amountForConstruction.getText()), Integer.parseInt(amountForHousehold.getText()));

                CsvWriter.writeHouseInsuranceToCSV(h1, true);
                info.setText(h1.toString());

                // Clear input
                handlerFxml.clearInput(propertyOwner, yearConstruction, constMaterial, residentialType, amountForConstruction, nrSquareMeters,
                        conditions, amountForHousehold, yearlyPremium, InsuranceAmount, InsuranceConditions);
            } catch (Exception e) {
                System.out.println("please enter right number");
            }
        }
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

        InsuranceAmount.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    InsuranceAmount.validate();
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
