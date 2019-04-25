package org.openjfx;

import CustomerModell.Customer;
import FileManagement.ObjectWriter;
import Insurances.House_Household_Insurance;
import Insurances.Travel_Insurance;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;

import java.awt.*;
import java.util.Date;

public class TravelInsurnaceController {

    private HandlerFxml handlerFxml = new HandlerFxml();

    @FXML
    private Pane entireScreenTravel;

    @FXML
    private JFXTextField insuranceArea, insuranceSum, YearlyInsurance, date, InsuranceAmount, InsuranceConditions;

    @FXML
    private JFXTextArea info;

    @FXML
    private JFXButton btn_household, btn_leisure, btn_boat, btn_travel, btn_cancel, btn_apply, btn_ok;

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


    @FXML
    public void cancel() {
        handlerFxml.navigate(entireScreenTravel, "homeInsurance.fxml");
    }


    @FXML
    public void apply(){


        Customer sven =  new Customer("1235", "sven", "234", "svenemail", "today", "hometown");

        Travel_Insurance t1 = new Travel_Insurance(sven, YearlyInsurance.getText(), String.valueOf(new Date()), Integer.parseInt(InsuranceAmount.getText()), InsuranceConditions.getText(),
        insuranceArea.getText(), Integer.parseInt(insuranceSum.getText()));
        ObjectWriter.WriteObjectToFile(t1);
        info.setText(t1.toString());



        insuranceArea.setText("");
        insuranceSum.setText("");
        YearlyInsurance.setText("");
        date.setText("");
        InsuranceAmount.setText("");
        InsuranceConditions.setText("");

    }

}
