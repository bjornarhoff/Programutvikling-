package org.openjfx;

import CustomerModell.Customer;
import FileManagement.CsvReader;
import javafx.collections.ObservableList;
import CustomerModell.Customer;
import FileManagement.CsvReader;
import FileManagement.CsvWriter;
import com.jfoenix.controls.JFXButton;
import javafx.beans.binding.BooleanBinding;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
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

    public void setCellValue(TableColumn<Customer,String> t1, TableColumn<Customer,String> t2,
                             TableColumn<Customer,String> t3, TableColumn<Customer,String> t4,
                             TableColumn<Customer,String> t5, TableColumn<Customer,String> t6,
                             TableColumn<Customer,String> t7, TableView<Customer> table){
        ObservableList<Customer> customers = CsvReader.read();
        t1.setCellValueFactory(new PropertyValueFactory<>("personalID"));
        t2.setCellValueFactory(new PropertyValueFactory<>("insuranceNr"));
        t3.setCellValueFactory(new PropertyValueFactory<>("name"));
        t4.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        t5.setCellValueFactory(new PropertyValueFactory<>("email"));
        t6.setCellValueFactory(new PropertyValueFactory<>("date"));
        t7.setCellValueFactory(new PropertyValueFactory<>("billingAddress"));
        table.setItems(customers);
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


    public void loadFileThread () {
        Task task = new Task<Void>() {
            @Override
            public Void call() {
                int max = 1000000;
                for (int i = 1; i <= max; i = i + 10) {
                    if (isCancelled()) {
                        break;
                    }
                    updateProgress(i, max);
                    CsvReader.read();
                }
                return null;
            }
        };
        new Thread(task).start();
    }



}