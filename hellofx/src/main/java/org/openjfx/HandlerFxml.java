package org.openjfx;

import CustomerModell.Customer;
import Damages.Damage_Report;
import FileManagement.CsvReader;
import FileManagement.CsvWriter;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import com.jfoenix.controls.JFXButton;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Insurances.Leisure_Insurance;
import Insurances.House_Household_Insurance;
import Insurances.Travel_Insurance;
import Insurances.Boat_Insurance;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
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

    public void setCellValue( TableView<Customer> table,
                              ObservableList<Customer> customers,
                              ObservableList<TableColumn<Customer,?>> columns){
        columns.get(0).setCellValueFactory(new PropertyValueFactory<>("personalID"));
        columns.get(1).setCellValueFactory(new PropertyValueFactory<>("insuranceNr"));
        columns.get(2).setCellValueFactory(new PropertyValueFactory<>("name"));
        columns.get(3).setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        columns.get(4).setCellValueFactory(new PropertyValueFactory<>("email"));
        columns.get(5).setCellValueFactory(new PropertyValueFactory<>("date"));
        columns.get(6).setCellValueFactory(new PropertyValueFactory<>("billingAddress"));
        table.setItems(customers);
    }

    public void setCellValueDamageReport(TableColumn<Damage_Report,String> t1, TableColumn<Damage_Report,String> t2,
                                         TableColumn<Damage_Report,String> t3, TableColumn<Damage_Report,String> t4,
                                         TableColumn<Damage_Report,String> t5, TableView<Damage_Report> table) {
        ObservableList<Damage_Report> damageReport = CsvReader.readDamageReport();
        t1.setCellValueFactory(new PropertyValueFactory<>("damageType"));
        t2.setCellValueFactory(new PropertyValueFactory<>("damageNr"));
        t3.setCellValueFactory(new PropertyValueFactory<>("dateOfDamage"));
        t4.setCellValueFactory(new PropertyValueFactory<>("taxationAmountOfDamage"));
        t5.setCellValueFactory(new PropertyValueFactory<>("unpaidReplacementAmount"));
        table.setItems(damageReport);
    }


     public void restrictionId (TextField textField) {
         // Sets pattern to texfield, 0 - 8 characters allowed
         Pattern pattern = Pattern.compile(".{0,11}");
         TextFormatter formatter = new TextFormatter
                 ((UnaryOperator<TextFormatter.Change>) change -> {
                     return pattern.matcher(change.getControlNewText()).matches() ? change : null;
                 });
         textField.setTextFormatter(formatter);
     }

    public void restrictionPhone (TextField textField) {
        // Sets pattern to texfield, 0 - 8 characters allowed
        Pattern pattern = Pattern.compile(".{0,8}");
        TextFormatter formatter = new TextFormatter
                ((UnaryOperator<TextFormatter.Change>) change -> {
                    return pattern.matcher(change.getControlNewText()).matches() ? change : null;
                });
        textField.setTextFormatter(formatter);
    }

    // Enabling button only if all of the textfields have text
    /**public void enableButton (JFXButton apply, TextField personalID, TextField name, TextField billing, TextField phone, TextField email) {
        BooleanBinding boolBind = personalID.textProperty().isEmpty()
                .or(name.textProperty().isEmpty())
                .or(billing.textProperty().isEmpty())
                .or(phone.textProperty().isEmpty())
                .or(email.textProperty().isEmpty());

        apply.disableProperty().bind(boolBind);
    } */

    // Enabling a disabled button when TableView row selected
    public void enableWhenMarked (TableView tableView, JFXButton ... button) {
        for (JFXButton buttons : button) {
            buttons.disableProperty().bind(Bindings.isEmpty(tableView.getSelectionModel().getSelectedItems()));
        }
    }

     // Enabling button only if all of the textfields have text
    public boolean enableButton(JFXButton apply, JFXTextField... textFields) {
        /*BooleanBinding boolBind;
        for (JFXTextField field : textFields) {
            boolBind = field.textProperty().isEmpty();
            if (boolBind.getValue()) {
                apply.disableProperty().bind(boolBind);
            }
            System.out.println(boolBind);

        }*/

        boolean filled = true;
        for (JFXTextField field : textFields) {
            if (field.textProperty().isEmpty().get()){
                filled = false;
            }
        }
        return filled;

    }
/**
    // Loop over textfield, find empty fields
    public boolean fieldsEmpty (JFXTextField ... textFields) {
        for (JFXTextField field : textFields) {
            if(!field.getText().isEmpty()) {
                return false;
            }
        } return true;
    } */

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




    public void clearInput(JFXTextField... fields) {

        for (JFXTextField field : fields) {
            field.setText("");
        }
    }


    public void setInputValidation(JFXTextField textField) {
        textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    textField.validate();
                }
            }
        });
    }


    public void getValidators (JFXTextField textField) {
        NumberValidator numvalidator = new NumberValidator();

        textField.getValidators().add(numvalidator);
        numvalidator.setMessage("Only numbers are supported!");
    }



        public void setCellValueHousehold(TableColumn<House_Household_Insurance,String> t1, TableColumn<House_Household_Insurance,String> t2,
                                         TableColumn<House_Household_Insurance,String> t3, TableColumn<House_Household_Insurance,String> t4,
                                         TableColumn<House_Household_Insurance,String> t5, TableColumn<House_Household_Insurance,String> t6, TableView<House_Household_Insurance> table) {
            ObservableList<House_Household_Insurance> householdInsurnace = CsvReader.readHousehold();
            t1.setCellValueFactory(new PropertyValueFactory<>("dateOfCreatedInsurance"));
            t2.setCellValueFactory(new PropertyValueFactory<>("insuranceAmount"));
            t3.setCellValueFactory(new PropertyValueFactory<>("propertyOwner"));
            t4.setCellValueFactory(new PropertyValueFactory<>("residentialType"));
            t5.setCellValueFactory(new PropertyValueFactory<>("constructionMaterial"));
            t6.setCellValueFactory(new PropertyValueFactory<>("numberOfSquareMeters"));
            table.setItems(householdInsurnace);

        }
        public void setCellValueTravel(TableColumn<Travel_Insurance,String> t1, TableColumn<Travel_Insurance,String> t2,
                                         TableColumn<Travel_Insurance,String> t3, TableColumn<Travel_Insurance,String> t4,
                                         TableColumn<Travel_Insurance,String> t5, TableView<Travel_Insurance> table){
        ObservableList<Travel_Insurance> travelInsurnce = CsvReader.readTravel();
        t1.setCellValueFactory(new PropertyValueFactory<>("dateOfCreatedInsurance"));
        t2.setCellValueFactory(new PropertyValueFactory<>("insuranceAmount"));
        t3.setCellValueFactory(new PropertyValueFactory<>("yearlyInsurancePremium"));
        t4.setCellValueFactory(new PropertyValueFactory<>("insuranceConditions"));
        t5.setCellValueFactory(new PropertyValueFactory<>("insuranceArea"));
        table.setItems(travelInsurnce);


    }

    public void setCellValueLeisure(TableColumn<Leisure_Insurance,String> t1, TableColumn<Leisure_Insurance,String> t2,
                                         TableColumn<Leisure_Insurance,String> t3, TableColumn<Leisure_Insurance,String> t4,
                                         TableColumn<Leisure_Insurance,String> t5, TableColumn<Leisure_Insurance,String> t6, TableView<Leisure_Insurance> table){
        ObservableList<Leisure_Insurance> leisureInsurnace = CsvReader.readLeisure();
        t1.setCellValueFactory(new PropertyValueFactory<>("dateOfCreatedInsurance"));
        t2.setCellValueFactory(new PropertyValueFactory<>("insuranceAmount"));
        t3.setCellValueFactory(new PropertyValueFactory<>("constructionYear"));
        t4.setCellValueFactory(new PropertyValueFactory<>("residentalType"));
        t5.setCellValueFactory(new PropertyValueFactory<>("constructionMaterial"));
        t6.setCellValueFactory(new PropertyValueFactory<>("amountSquareMeters"));

        table.setItems(leisureInsurnace);


    }

    public void setCellValueBoat(TableColumn<Boat_Insurance,String> t1, TableColumn<Boat_Insurance,String> t2,
                                         TableColumn<Boat_Insurance,String> t3, TableColumn<Boat_Insurance,String> t4,
                                         TableColumn<Boat_Insurance,String> t5, TableColumn<Boat_Insurance,String> t6,TableView<Boat_Insurance> table){
        ObservableList<Boat_Insurance> boatInsurance = CsvReader.readBoat();
        t1.setCellValueFactory(new PropertyValueFactory<>("dateOfCreatedInsurance"));
        t2.setCellValueFactory(new PropertyValueFactory<>("insuranceAmount"));
        t3.setCellValueFactory(new PropertyValueFactory<>("owner"));
        t4.setCellValueFactory(new PropertyValueFactory<>("registerNr"));
        t5.setCellValueFactory(new PropertyValueFactory<>("boatTypeAndModel"));
        t6.setCellValueFactory(new PropertyValueFactory<>("lengthInFoot"));

        table.setItems(boatInsurance);


    }
}