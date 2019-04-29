package org.openjfx;

import CustomerModell.Customer;
import FileManagement.CsvWriter;
import Insurances.Boat_Insurance;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.util.Date;

public class BoatInsuranceController {

    private HandlerFxml handlerFxml = new HandlerFxml();

    @FXML
    private Pane entireScreenBoat;

    @FXML
    private JFXButton btn_Household, btn_Leisure, btn_Boat, btn_Travel, btn_cancel, btn_apply, btn_ok;

    @FXML
    public JFXTextField Owner, registerNr, length, boatTypeModel, motorTypePower, year, yearlyPremium, date, insuranceAmount, InsuranceConditions;

    @FXML
    private JFXTextArea info;

    @FXML
    private Label customerLabel;



    @FXML
    private void initialize(){
        customerLabel.setText(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));

        /*NumberValidator numvalidator = new NumberValidator();

        registerNr.getValidators().add(numvalidator);
        length.getValidators().add(numvalidator);
        year.getValidators().add(numvalidator);
        yearlyPremium.getValidators().add(numvalidator);
        insuranceAmount.getValidators().add(numvalidator);


        numvalidator.setMessage("Only numbers are supported!");*/

        handlerFxml.getValidators(registerNr);
        handlerFxml.getValidators(length);
        handlerFxml.getValidators(year);
        handlerFxml.getValidators(yearlyPremium);
        handlerFxml.getValidators(insuranceAmount);

        handlerFxml.setInputValidation(registerNr);
        handlerFxml.setInputValidation(length);
        handlerFxml.setInputValidation(year);
        handlerFxml.setInputValidation(yearlyPremium);
        handlerFxml.setInputValidation(insuranceAmount);


        new AnimationTimer() {
            @Override
            public void handle(long l) {
                boolean allFilled = handlerFxml.enableButton(btn_apply, registerNr, length, boatTypeModel, motorTypePower, year, yearlyPremium, date, insuranceAmount, InsuranceConditions);
                if (allFilled){
                    btn_apply.setDisable(false);
                }else{
                    btn_apply.setDisable(true);
                }
            }
        }.start();
      //  handlerFxml.enableButton(btn_apply, Owner,registerNr,boatTypeModel,motorTypePower,year);
       //handlerFxml.enableButton(btn_apply, registerNr, length, boatTypeModel, motorTypePower, year, yearlyPremium, date, insuranceAmount, InsuranceConditions);





        //setInputValidation();

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


        Boat_Insurance b1 = new Boat_Insurance(customer, yearlyPremium.getText(), String.valueOf(new Date()), Integer.parseInt(insuranceAmount.getText()),
                InsuranceConditions.getText(), Owner.getText(), registerNr.getText(), boatTypeModel.getText(), Double.parseDouble(length.getText()),
                Integer.parseInt(year.getText()), motorTypePower.getText());

        CsvWriter.writeBoatInsuranceToCSV(b1);

        info.setText(b1.toString());

        handlerFxml.clearInput(Owner, registerNr, length, boatTypeModel, motorTypePower, year, yearlyPremium, date, insuranceAmount, InsuranceConditions);

    }

   /* public void clearInput(){
        Owner.setText("");
        registerNr.setText("");
        length.setText("");
        boatTypeModel.setText("");
        motorTypePower.setText("");
        year.setText("");
        yearlyPremium.setText("");
        date.setText("");
        insuranceAmount.setText("");
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

        insuranceAmount.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(!newValue){
                    insuranceAmount.validate();
                }
            }
        });
    } */
}
