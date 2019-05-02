package org.openjfx;

import CustomerModell.Customer;
import Exceptions.ExceptionHandler;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    /**
     * Method that validates input for text fields so a user has to enter a Integer input
     * @return true if entered Integer and false if not
     */
    private boolean validateNumber(){
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(length.getText());
        Matcher m2 = p.matcher(year.getText());
        Matcher m3 = p.matcher(insuranceAmount.getText());

        if(m.find() && m.group().equals(length.getText()) && m2.find() && m2.group().equals(year.getText()) && m3.find() &&
                m3.group().equals(insuranceAmount.getText())){
            return true;
        }else{
            ExceptionHandler.alertBox("Wrong Input Data Type", "Check red highleted boxes", "Convert Leters into numbers");
            return false;
        }
    }

    /**
     * Initialize Method where load page and set Animation Timer and Input validation
     */
    @FXML
    private void initialize(){
        customerLabel.setText(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));


        handlerFxml.setInputValidation(registerNr);
        handlerFxml.setInputValidation(length);
        handlerFxml.setInputValidation(year);
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

        if(validateNumber())
        try {

            Boat_Insurance b1 = new Boat_Insurance(customer, yearlyPremium.getText(), String.valueOf(new Date()), Integer.parseInt(insuranceAmount.getText()),
                    InsuranceConditions.getText(), Owner.getText(), registerNr.getText(), boatTypeModel.getText(), Double.parseDouble(length.getText()),
                    Integer.parseInt(year.getText()), motorTypePower.getText());

            CsvWriter.writeBoatInsuranceToCSV(b1, true);

            info.setText(b1.toString());

            handlerFxml.clearInput(Owner, registerNr, length, boatTypeModel, motorTypePower, year, yearlyPremium, date, insuranceAmount, InsuranceConditions);
        }catch(Exception e){
            System.out.println("wrong data type");
        }
    }
}
