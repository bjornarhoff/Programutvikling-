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
    }


    /**
     * Handles our button interactions
     * @param event
     */
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

    /**
     * go back to Insurance page
     */
    @FXML
    public void cancel() {
        handlerFxml.navigate(entireScreenBoat, "homeInsurance.fxml");
    }

    /**
     * Adds Boat object to selected Customer and clears text fields
     */
    @FXML
    public void apply(){

        Customer customer = HomeInsuranceController.getCustomerSelected();


        Boat_Insurance b1 = new Boat_Insurance(customer, yearlyPremium.getText(), String.valueOf(new Date()), Integer.parseInt(insuranceAmount.getText()),
                InsuranceConditions.getText(), Owner.getText(), registerNr.getText(), boatTypeModel.getText(), Double.parseDouble(length.getText()),
                Integer.parseInt(year.getText()), motorTypePower.getText());

        CsvWriter.writeBoatInsuranceToCSV(b1, true);

        info.setText(b1.toString());

        handlerFxml.clearInput(Owner, registerNr, length, boatTypeModel, motorTypePower, year, yearlyPremium, date, insuranceAmount, InsuranceConditions);

    }
}
