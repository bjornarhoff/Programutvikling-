package org.openjfx;

import CustomerModell.Customer;
import Exceptions.ExceptionHandler;
import FileManagement.CsvWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.util.Date;

public class CreateCustomerController {
    @FXML
    public TextArea info;
    @FXML
    public JFXTextField personalID, name, billing, phone, email;
    @FXML
    public JFXButton cancel, apply;
    HandlerFxml handlerFxml = new HandlerFxml();
    @FXML
    private BorderPane popUpCreate;


    /**
     * Method for creating a Customer and clearing text fields
     */
    @FXML
    public void apply() throws IOException {
        /*
        Skriv lagret data til fil. Så må dette leses inn igjen slik at tableview på forsiden bli oppdatert.
         */
        if (ExceptionHandler.personalIDValidator(personalID) && ExceptionHandler.phoneValidator(phone) && ExceptionHandler.emailValidator(email)) {
            Customer aCustomer = new Customer(personalID.getText(), name.getText(), phone.getText(), email.getText(), String.valueOf(new Date()), billing.getText());
            aCustomer.generateInsuranceNr();
            CsvWriter.writeCustomerToCSV(aCustomer);
            info.setText(aCustomer.toString());
            handlerFxml.clearInput(personalID, name, billing, phone, email);
        }
    }


    /**
     * method to get back to home Customer page
     */
    @FXML
    public void cancel() {
        handlerFxml.navigate(popUpCreate, "homeCustomer.fxml");
    }

    /**
     * Method were everything for the page is being initialize
     */
    @FXML
    public void initialize() {
        handlerFxml.restrictionId(personalID);
        handlerFxml.setInputValidation(personalID);

        handlerFxml.restrictionPhone(phone);
        // Enabling button only if all of the textfields have text, using animationTimer
        new AnimationTimer() {
            @Override
            public void handle(long l) {
                boolean allFilled = handlerFxml.enableButton(apply, name, personalID, phone, email, billing);
                if (allFilled) {
                    apply.setDisable(false);
                } else {
                    apply.setDisable(true);
                }
                // Sets restriction for personal ID and phone number, 0-11 characters & 0-8 characters
            }
        }.start();

    }
}
