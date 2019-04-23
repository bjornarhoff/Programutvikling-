package org.openjfx;

import Customer_Controller.Customer;
import Damages.Damage_Report;
import com.jfoenix.controls.JFXButton;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
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
