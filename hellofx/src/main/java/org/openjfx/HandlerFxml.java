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
import Insurances.Leisure_Insurance;
import Insurances.House_Household_Insurance;
import Insurances.Travel_Insurance;
import Insurances.Boat_Insurance;

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
                                         TableColumn<Damage_Report,Integer> t3, TableColumn<Damage_Report,String> t4,
                                         TableColumn<Damage_Report,String> t5, TableView<Damage_Report> table) {
        ObservableList<Damage_Report> damageReport = CsvReader.readDamageReport();
        t1.setCellValueFactory(new PropertyValueFactory<>("damageType"));
        t2.setCellValueFactory(new PropertyValueFactory<>("damageDescription"));
        t3.setCellValueFactory(new PropertyValueFactory<>("damageNr"));
        t4.setCellValueFactory(new PropertyValueFactory<>("contactOfPotentialWitnesses"));
        t5.setCellValueFactory(new PropertyValueFactory<>("unpaidReplacementAmount"));
        table.setItems(damageReport);
    }

        public void setCellValueHousehold(TableColumn<House_Household_Insurance,String> t1, TableColumn<House_Household_Insurance,Integer> t2,
                                         TableColumn<House_Household_Insurance,String> t3, TableColumn<House_Household_Insurance,String> t4,
                                         TableColumn<House_Household_Insurance,String> t5, TableColumn<House_Household_Insurance,String> t6,
                                          TableColumn<House_Household_Insurance,Integer> t7, TableView<House_Household_Insurance> table) {
            ObservableList<House_Household_Insurance> householdInsurnace = CsvReader.readHousehold();
            t1.setCellValueFactory(new PropertyValueFactory<>("yearlyInsurancePremium"));
            t2.setCellValueFactory(new PropertyValueFactory<>("insuranceAmount"));
            t3.setCellValueFactory(new PropertyValueFactory<>("insuranceConditions"));
            t4.setCellValueFactory(new PropertyValueFactory<>("propertyOwner"));
            t5.setCellValueFactory(new PropertyValueFactory<>("constructionMaterial"));
            t6.setCellValueFactory(new PropertyValueFactory<>("condition"));
            t7.setCellValueFactory(new PropertyValueFactory<>("insuranceAmountForHousehold"));
            table.setItems(householdInsurnace);

        }
        public void setCellValueTravel(TableColumn<Travel_Insurance,String> t1, TableColumn<Travel_Insurance,Integer> t2,
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
                                         TableColumn<Leisure_Insurance,String> t5, TableColumn<Leisure_Insurance,String> t6,TableColumn<Leisure_Insurance,Integer> t7, TableView<Leisure_Insurance> table){
        ObservableList<Leisure_Insurance> leisureInsurnace = CsvReader.readLeisure();
        t1.setCellValueFactory(new PropertyValueFactory<>("dateOfCreatedInsurance"));
        t2.setCellValueFactory(new PropertyValueFactory<>("yearlyInsurancePremium"));
        t3.setCellValueFactory(new PropertyValueFactory<>("insuranceConditions"));
        t4.setCellValueFactory(new PropertyValueFactory<>("constructionMaterial"));
        t5.setCellValueFactory(new PropertyValueFactory<>("condition"));
        t6.setCellValueFactory(new PropertyValueFactory<>("amountSquareMeters"));
        t7.setCellValueFactory(new PropertyValueFactory<>("amountForHousehold"));

        table.setItems(leisureInsurnace);


    }

    public void setCellValueBoat(TableColumn<Boat_Insurance,String> t1, TableColumn<Boat_Insurance,Integer> t2,
                                         TableColumn<Boat_Insurance,String> t3, TableColumn<Boat_Insurance,String> t4,
                                         TableColumn<Boat_Insurance,String> t5, TableColumn<Boat_Insurance,String> t6,
                                 TableColumn<Boat_Insurance,String> t7,TableView<Boat_Insurance> table){
        ObservableList<Boat_Insurance> boatInsurance = CsvReader.readBoat();
        t1.setCellValueFactory(new PropertyValueFactory<>("dateOfCreatedInsurance"));
        t2.setCellValueFactory(new PropertyValueFactory<>("insuranceAmount"));
        t3.setCellValueFactory(new PropertyValueFactory<>("owner"));
        t4.setCellValueFactory(new PropertyValueFactory<>("registerNr"));
        t5.setCellValueFactory(new PropertyValueFactory<>("boatTypeAndModel"));
        t6.setCellValueFactory(new PropertyValueFactory<>("lengthInFoot"));
        t7.setCellValueFactory(new PropertyValueFactory<>("motorTypeAndMotorPower"));

        table.setItems(boatInsurance);


    }
}