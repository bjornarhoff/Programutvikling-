package org.openjfx;

import Customer_Controller.Customer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class ForsikringFXMLController implements Initializable {

    @FXML
    public TextArea info;

    @FXML
    public void registrer() {
        Customer customer = new Customer("07029633996", 2, "Cato Akay", new Date(),
                "Goteborggata 26", "2", "Testing", 3900);
        String out = customer.toString();
        info.setText(out);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
