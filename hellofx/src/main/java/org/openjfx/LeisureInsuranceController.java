package org.openjfx;

import CustomerModell.Customer;
import Exceptions.ExceptionHandler;
import FileManagement.CsvWriter;
import Insurances.Leisure_Insurance;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeisureInsuranceController {

    private HandlerFxml handlerFxml = new HandlerFxml();


    @FXML
    private Pane entireScreenLeisure;

    @FXML
    public JFXButton btn_household, btn_leisure, btn_boat, btn_travel, btn_cancel, btn_apply, btn_ok;

    @FXML
    private JFXTextField address, yearConstruction, constructionMaterial, residentialType, amountConstruction, nrSquareMeters,
                        condition, amountHousehold, InsuranceConditions, yearlyPremium, InsuranceAmount;

    @FXML
    public JFXTextArea info;

    @FXML
    private Label customerLabel;


    /**
     * Method that validates input for text fields so a user has to enter a Integer input
     * @return true if entered Integer and false if not
     */
    private boolean validateNumber(){
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(amountConstruction.getText());
        Matcher m2 = p.matcher(nrSquareMeters.getText());
        Matcher m3 = p.matcher(InsuranceAmount.getText());
        Matcher m4 = p.matcher(amountHousehold.getText());

        if(m.find() && m.group().equals(amountConstruction.getText()) && m2.find() && m2.group().equals(nrSquareMeters.getText()) && m4.find() &&
                m4.group().equals(amountHousehold.getText()) && m3.find() && m3.group().equals(InsuranceAmount.getText())){
            return true;
        }else{
            ExceptionHandler.alertBox("Wrong Input Data Type", "Check red highleted boxes", "Convert Leters into numbers");
            return false;
        }
    }

    /**
     * Initialize Method that sets show buttons and input validations
     */
    @FXML
    private void initialize(){
        customerLabel.setText(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));

        new AnimationTimer() {
            @Override
            public void handle(long l) {
                boolean allFilled = handlerFxml.enableButton(btn_apply,address, yearConstruction, constructionMaterial, residentialType, amountConstruction, nrSquareMeters,
                        condition, amountHousehold, InsuranceConditions, yearlyPremium, InsuranceAmount);
                if (allFilled){
                    btn_apply.setDisable(false);
                }else{
                    btn_apply.setDisable(true);
                }
            }
        }.start();

        NumberValidator numvalidator = new NumberValidator();

        yearConstruction.getValidators().add(numvalidator);
        amountConstruction.getValidators().add(numvalidator);
        nrSquareMeters.getValidators().add(numvalidator);
        amountHousehold.getValidators().add(numvalidator);
        InsuranceAmount.getValidators().add(numvalidator);

        numvalidator.setMessage("Only numbers are supported!");

        setValidationInput();
    }


    /**
     * Method that handles button events for switching between Insurance screens
     * @param event
     */
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

    /**
     * Method that takes you back to the home Insurance screen
     */
    @FXML
    public void cancel() {
        handlerFxml.navigate(entireScreenLeisure, "homeInsurance.fxml");
    }

    /**
     * Method that checks for valid input and if true creates a new Leisure Insurance
     */
    @FXML
    public void apply(){


        Customer customer = HomeInsuranceController.getCustomerSelected();
        if(validateNumber())
        try {

            Leisure_Insurance l1 = new Leisure_Insurance(customer, yearlyPremium.getText(), String.valueOf(new Date()), Integer.parseInt(InsuranceAmount.getText()),
                    InsuranceConditions.getText(), address.getText(), Integer.parseInt(yearConstruction.getText()), residentialType.getText(), constructionMaterial.getText(),
                    condition.getText(), Double.parseDouble(nrSquareMeters.getText()), Integer.parseInt(amountConstruction.getText()), Integer.parseInt(amountHousehold.getText()));


            CsvWriter.writeLeisureInsurance(l1, true);
            info.setText(l1.toString());

            setText();
        }catch(Exception e){
            System.out.println("wrong data type");
        }

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
