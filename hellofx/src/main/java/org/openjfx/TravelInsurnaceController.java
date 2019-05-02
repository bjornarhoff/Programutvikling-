package org.openjfx;

import CustomerModell.Customer;
import Exceptions.ExceptionHandler;
import FileManagement.CsvWriter;
import Insurances.Travel_Insurance;
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

public class TravelInsurnaceController {

    private HandlerFxml handlerFxml = new HandlerFxml();

    @FXML
    private Pane entireScreenTravel;

    @FXML
    private JFXTextField insuranceArea, insuranceSum, YearlyInsurance, InsuranceAmount, InsuranceConditions;

    @FXML
    private JFXTextArea info;

    @FXML
    private JFXButton btn_household, btn_leisure, btn_boat, btn_travel, btn_cancel, btn_apply, btn_ok;

    @FXML
    private Label customerLabel;

    /**
     * Method that validates number input and matches it with the user input
     * @return true if matching and false with alert box if not matching
     */
    private boolean validateNumber(){
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(insuranceSum.getText());
        Matcher m2 = p.matcher(InsuranceAmount.getText());

        if(m.find() && m.group().equals(insuranceSum.getText()) && m2.find() && m2.group().equals(InsuranceAmount.getText())){
            return true;
        }
        else{
            ExceptionHandler.alertBox("Wrong Input Data Type", "Check red highleted boxes", "Convert Leters into numbers");
            return false;
        }
    }


    /**
     * Initialize Method that starts Animation timer and sets number validation
     */
    @FXML
    private void initialize(){
        customerLabel.setText(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
        handlerFxml.setInputValidation(insuranceSum);
        handlerFxml.setInputValidation(InsuranceAmount);

        new AnimationTimer() {
            @Override
            public void handle(long l) {
                boolean allFilled = handlerFxml.enableButton(btn_apply,insuranceArea, insuranceSum, YearlyInsurance, InsuranceAmount, InsuranceConditions);
                if (allFilled){
                    btn_apply.setDisable(false);
                }else{
                    btn_apply.setDisable(true);
                }
            }
        }.start();


        //setInputValidation();
    }

    /**
     * Method that handles button events for switching between Insurnace screens
     * @param event
     */
    @FXML
    private void handleButtonActions(ActionEvent event) {
        if(event.getSource() == btn_household){
            handlerFxml.navigate(entireScreenTravel,"householdInsurance.fxml");
        }
        else if(event.getSource() == btn_leisure){
            handlerFxml.navigate(entireScreenTravel,"LeisureInsurance.fxml");
        }
        else if(event.getSource() == btn_boat){
            handlerFxml.navigate(entireScreenTravel,"BoatInsurance.fxml");
        }
        else if(event.getSource() == btn_travel){
            handlerFxml.navigate(entireScreenTravel,"TravelInsurance.fxml");
        }
    }


    /**
     * Method that takes you back to home Insurance screen
     */
    @FXML
    public void cancel() {
        handlerFxml.navigate(entireScreenTravel, "homeInsurance.fxml");
    }


    /**
     * Method that checks for correct input and if true creates a Travel Insurance
     */
    @FXML
    public void apply(){

        Customer customer = HomeInsuranceController.getCustomerSelected();

        if(validateNumber())
        try {
            Travel_Insurance t1 = new Travel_Insurance(customer, YearlyInsurance.getText(), String.valueOf(new Date()), Integer.parseInt(InsuranceAmount.getText()), InsuranceConditions.getText(),
                    insuranceArea.getText(), Integer.parseInt(insuranceSum.getText()));
            CsvWriter.writeTravelInsjurance(t1, true);
            info.setText(t1.toString());

            clearInput();
        }catch(Exception e){
            System.out.println("wrong data type");
        }

    }

    /**
     * Method that clears input
     */
    public void clearInput(){
        insuranceArea.setText("");
        insuranceSum.setText("");
        YearlyInsurance.setText("");
        InsuranceAmount.setText("");
        InsuranceConditions.setText("");
    }
  /*
    public void setInputValidation(){
        insuranceSum.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    insuranceSum.validate();
                }
            }
        });

        YearlyInsurance.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    YearlyInsurance.validate();
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
    }*/

}
