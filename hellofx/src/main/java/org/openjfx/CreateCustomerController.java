package org.openjfx;

import CustomerModell.Customer;
import FileManagement.CsvWriter;
import com.jfoenix.controls.JFXButton;
import javafx.beans.binding.BooleanBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class CreateCustomerController implements Initializable{

    HandlerFxml handlerFxml = new HandlerFxml();
    HomeCustomerController homeCustomerController = new HomeCustomerController();

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
    public JFXButton apply;

    @FXML
    private void handleButtonAction(ActionEvent event) {


    }


    @FXML
    public void apply() {
        /*
        Skriv lagret data til fil. Så må dette leses inn igjen slik at tableview på forsiden bli oppdatert.
         */
        Customer aCustomer = new Customer(personalID.getText(), name.getText(), phone.getText(), email.getText(), String.valueOf(new Date()), billing.getText());
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

        // Enabling button only if all of the textfields have text
        BooleanBinding boolBind = personalID.textProperty().isEmpty()
                .or(name.textProperty().isEmpty())
                .or(billing.textProperty().isEmpty())
                        .or(phone.textProperty().isEmpty())
                                .or(email.textProperty().isEmpty());

        apply.disableProperty().bind(boolBind);

    }

}
