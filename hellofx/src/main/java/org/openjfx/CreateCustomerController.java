package org.openjfx;

import CustomerModell.Customer;
import FileManagement.CsvWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Date;

public class CreateCustomerController {
    HandlerFxml handlerFxml = new HandlerFxml();

    @FXML
    private BorderPane popUpCreate;

    @FXML
    public TextArea info;

    @FXML
    public JFXTextField personalID, name,billing,phone,email;

    @FXML
    public JFXButton cancel,apply;



    @FXML
    private void handleButtonAction(ActionEvent event) {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("FXMLHomeController"));
        try{
            loader.load();
        }
        catch (IOException e){
            System.out.println("error while loading");
        }

    }




    @FXML
    public void apply() {
        /*
        Skriv lagret data til fil. Så må dette leses inn igjen slik at tableview på forsiden bli oppdatert.
         */
        Customer aCustomer = new Customer(personalID.getText(), name.getText(), phone.getText(), email.getText(), String.valueOf(new Date()), billing.getText());
        aCustomer.generateInsuranceNr();
        CsvWriter.writeObjectToCSV(aCustomer);
        info.setText(aCustomer.toString());


        handlerFxml.clearInput(personalID, name,billing,phone,email);
    }


   @FXML
    public void cancel() {
        handlerFxml.navigate(popUpCreate, "homeCustomer.fxml");
   }

    @FXML
    public void initialize() {
        // Enabling button only if all of the textfields have text, using animationTimer
        new AnimationTimer() {
            @Override
            public void handle(long l) {
                boolean allFilled = handlerFxml.enableButton(apply, name,personalID,phone,email,billing);
                if (allFilled){
                    apply.setDisable(false);
                }else{
                    apply.setDisable(true);
                }
                // Sets restriction for personal ID and phone number, 0-11 characters & 0-8 characters
                handlerFxml.restrictionId(personalID);
                handlerFxml.restrictionPhone(phone);
            }
        }.start();

    }
}
