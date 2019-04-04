package org.openjfx;

import Customer_Controller.Customer;
import Damages.Damage_Report;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ForsikringFXMLController implements Initializable {

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
    public void registrer() {
        Damage_Report damage_report = new Damage_Report(new Date(), 3, "A crash",
                "The window borke", "Bjornar", 3000,
                100);

        Customer customer = new Customer(personalID.getText(),  name.getText(), phone.getText(),
                email.getText(), new Date(), billing.getText(),  3900);

        String out = customer.toString();
        info.setText(out);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
