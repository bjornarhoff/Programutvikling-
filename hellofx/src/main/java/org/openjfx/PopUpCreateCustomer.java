package org.openjfx;

import Customer_Controller.Customer;
import Damages.Damage_Report;
import FileManagement.CsvWriter;
import FileManagement.OpenFileChooser;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;


public class PopUpCreateCustomer implements Initializable {

    @FXML
    private AnchorPane anchorPane;

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
    public JFXButton goback;

    @FXML
    public JFXButton ok;


    final FileChooser fileChooser = new FileChooser();
    OpenFileChooser ofc = new OpenFileChooser();
    public String out;

    @FXML
    private void handleButtonAction(ActionEvent event) {

    }


    @FXML
    public void Apply() {
        Damage_Report damage_report = new Damage_Report(new Date(), 3, "A crash",
                "The window borke", "Bjornar", 3000,
                100);

        Customer customer = new Customer(personalID.getText(), name.getText(), phone.getText(),
                email.getText(), new Date(), billing.getText(), 3900);

        out = customer.toString();
        info.setText(out);

        CsvWriter.writeObjectToCSV(customer);
        ok.setVisible(true);

    }


    @FXML
    public void cancelPressed() {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
            anchorPane.getChildren().setAll(root);
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    @FXML
    public void okPressed(ActionEvent e) {
        

    }
}