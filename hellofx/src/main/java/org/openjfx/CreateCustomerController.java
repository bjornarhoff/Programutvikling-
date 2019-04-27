package org.openjfx;

import CustomerModell.Customer;
import FileManagement.CsvWriter;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class CreateCustomerController implements Initializable{

    HandlerFxml handlerFxml = new HandlerFxml();

    @FXML
    private BorderPane popUpCreate;

    @FXML
    public TextArea info;

    @FXML
    public TextField personalID;

    @FXML
    public TextField name;

    @FXML
    public TextField billing;

    @FXML
    public TextField phone;

    @FXML
    public TextField email;

    @FXML
    public JFXButton cancel;

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


        personalID.setText("");
        name.setText("");
        billing.setText("");
        phone.setText("");
        email.setText("");
    }


   @FXML
    public void cancel() {
        handlerFxml.navigate(popUpCreate, "homeCustomer.fxml");
   }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
