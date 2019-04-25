package org.openjfx;

import CustomerModell.Customer;
import Insurances.Boat_Insurance;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private void handleButtonActions(ActionEvent event) {

        if(event.getSource() == btn_Household){
            handlerFxml.navigate(entireScreenBoat,"HouseholdInsurance.fxml");
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

        Customer sven =  new Customer("1235", "sven", "234", "svenemail", "today", "hometown");

        Boat_Insurance b1 = new Boat_Insurance(sven, yearlyPremium.getText(), new Date(), Integer.parseInt(InsuranceAmount.getText()),
                InsuranceConditions.getText(), Owner.getText(), registerNr.getText(), boatTypeModel.getText(), Double.parseDouble(length.getText()),
                Integer.parseInt(year.getText()), motorTypePower.getText());

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

        //info.setText((b1.toString()));

    }
}
