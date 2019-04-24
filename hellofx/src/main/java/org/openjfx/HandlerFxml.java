package org.openjfx;

import CustomerModell.Customer;
import FileManagement.CsvWriter;
import com.jfoenix.controls.JFXButton;
import javafx.beans.binding.BooleanBinding;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.io.IOException;
import java.util.Date;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class HandlerFxml {


    public void navigate(Pane current, String path){
       try{
           Parent root = FXMLLoader.load(getClass().getResource(path));
           Stage stg = (Stage)current.getScene().getWindow();
           stg.setScene(new Scene(root));
       }catch (IOException e){
           e.printStackTrace();
       }
    }


     public void restrictionId (TextField textField) {
         /** Funker, men ikke tatt fra hodet */
         // Sets pattern to texfield, 0 - 8 characters allowed
         Pattern pattern = Pattern.compile(".{0,11}");
         TextFormatter formatter = new TextFormatter
                 ((UnaryOperator<TextFormatter.Change>) change -> {
                     return pattern.matcher(change.getControlNewText()).matches() ? change : null;
                 });
         textField.setTextFormatter(formatter);
     }

    public void restrictionPhone (TextField textField) {
        /** Funker, men ikke tatt fra hodet */
        // Sets pattern to texfield, 0 - 8 characters allowed
        Pattern pattern = Pattern.compile(".{0,8}");
        TextFormatter formatter = new TextFormatter
                ((UnaryOperator<TextFormatter.Change>) change -> {
                    return pattern.matcher(change.getControlNewText()).matches() ? change : null;
                });
        textField.setTextFormatter(formatter);
    }

    public void enableButton (JFXButton apply, TextField personalID, TextField name, TextField billing, TextField phone, TextField email) {
        // Enabling button only if all of the textfields have text
        BooleanBinding boolBind = personalID.textProperty().isEmpty()
                .or(name.textProperty().isEmpty())
                .or(billing.textProperty().isEmpty())
                .or(phone.textProperty().isEmpty())
                .or(email.textProperty().isEmpty());

        apply.disableProperty().bind(boolBind);
    }


}