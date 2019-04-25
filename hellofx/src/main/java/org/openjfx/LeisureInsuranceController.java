package org.openjfx;

import CustomerModell.Customer;
import FileManagement.ObjectWriter;
import Insurances.Leisure_Insurance;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private void handleButtonActions(ActionEvent event) {
        if(event.getSource() == btn_household){
            handlerFxml.navigate(entireScreenLeisure,"HouseholdInsurance.fxml");
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
        /*
        Customer sven =  new Customer("1235", "sven", "234", "svenemail", "today", "hometown");

        Leisure_Insurance l1 = new Leisure_Insurance(sven, yearlyPremium.getText(), new Date(), Integer.parseInt(InsuranceAmount.getText()),
         InsuranceConditions.getText(), address.getText(), Integer.parseInt(yearConstruction.getText()), residentialType.getText(), constructionMaterial.getText(),
          condition.getText(), Double.parseDouble(nrSquareMeters.getText()), Integer.parseInt(amountConstruction.getText()), Integer.parseInt(amountHousehold.getText()));

        ObjectWriter.WriteObjectToFile(l1);
        info.setText(l1.toString());

         */


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
}
