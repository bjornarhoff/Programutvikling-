package org.openjfx;

import CustomerModell.Customer;
import Damages.Damage_Report;
import FileManagement.CsvReader;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

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

    public void setCellValueDamageReport(TableColumn<Damage_Report,String> t1, TableColumn<Damage_Report,String> t2,
                                         TableColumn<Damage_Report,String> t3, TableColumn<Damage_Report,String> t4,
                                         TableColumn<Damage_Report,String> t5, TableView<Damage_Report> table){
        ObservableList<Damage_Report> damageReport = CsvReader.readDamageReport();
        t1.setCellValueFactory(new PropertyValueFactory<>("damageType"));
        t2.setCellValueFactory(new PropertyValueFactory<>("damageNr"));
        t3.setCellValueFactory(new PropertyValueFactory<>("dateOfDamage"));
        t4.setCellValueFactory(new PropertyValueFactory<>("taxationAmountOfDamage"));
        t5.setCellValueFactory(new PropertyValueFactory<>("unpaidReplacementAmount"));
        table.setItems(damageReport);
    }
}