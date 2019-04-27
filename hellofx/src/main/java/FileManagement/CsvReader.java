package FileManagement;


import CustomerModell.Customer;
import Damages.Damage_Report;
import Insurances.*;
import Damages.Damage_Report;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.HomeInsuranceController;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;


public class CsvReader {

   public static ObservableList<Customer> read () {

       String line;
       ObservableList<Customer> customersFromCsv = FXCollections.observableArrayList();
       int iteration = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home")+"/customer2.csv"))) {
            while ((line = br.readLine()) != null) {
                if (iteration == 0){
                    iteration ++;
                    continue;
                }
                String[] values = line.split(",");
                Customer aCustomer = new Customer(values[0], values[2], values[3], values[4], values[5], values[6]);
                aCustomer.setInsuranceNr(Integer.parseInt(values[1]));
                aCustomer.setUnpaidReplacements(Double.parseDouble(values[7]));
                aCustomer.setAllCustomerInsurance(Integer.parseInt(values[8]));
                customersFromCsv.add(aCustomer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customersFromCsv;
    }

    public static Customer findCustomer(String searchterm) {
       Customer customer = null;
       String line;
       //ObservableList<Customer> customersFromCsv = FXCollections.observableArrayList();
       int iteration = 0;

       try(BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home")+ "/customer2.csv"))){
           while ((line = br.readLine()) != null) {
               if (iteration ==0) {
                   iteration ++;
                   continue;
               }

               String[] values = line.split(",");

               if(searchterm.equals(values[0])){
                   customer = new Customer(values[0], values[2], values[3], values[4], values[5], values[6]);
                   customer.setInsuranceNr(Integer.parseInt(values[1]));
                   customer.setUnpaidReplacements(Double.parseDouble(values[7]));
                   customer.setAllCustomerInsurance(Integer.parseInt(values[8]));

               }

           }

       } catch (IOException e) {
           e.printStackTrace();
       }
       return customer;
    }



    public static ObservableList<Insurance> readHousehold () {

       String line;
       ObservableList<Insurance> householdFromCsv = FXCollections.observableArrayList();
       int iteration = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home")+"/household.csv"))) {
            while ((line = br.readLine()) != null) {
                if (iteration == 0){
                    iteration ++;
                    continue;
                }
                String[] values = line.split(",");
                Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected()));
                House_Household_Insurance household = new House_Household_Insurance(customer,values[2], values[3], Integer.parseInt(values[4]), values[5], values[6],
                        Integer.parseInt(values[7]), values[8], values[9], values[10], Integer.parseInt(values[11]), Integer.parseInt(values[12]), Integer.parseInt(values[13]));
                householdFromCsv.add(household);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return householdFromCsv;
    }

    public static ObservableList<Insurance> readTravel () {

        String line;
        ObservableList<Insurance> travelFromCsv = FXCollections.observableArrayList();
        int iteration = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home")+"/household.csv"))) {
            while ((line = br.readLine()) != null) {
                if (iteration == 0){
                    iteration ++;
                    continue;
                }
                String[] values = line.split(",");
                Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected()));
                Travel_Insurance travel = new Travel_Insurance(customer,values[1], values[2], Integer.parseInt(values[3]), values[4], values[5], Integer.parseInt(values[6]));
                travelFromCsv.add(travel);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return travelFromCsv;
    }

    public static ObservableList<Insurance> readBoat () {

        String line;
        ObservableList<Insurance> boatFromCsv = FXCollections.observableArrayList();
        int iteration = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home")+"/household.csv"))) {
            while ((line = br.readLine()) != null) {
                if (iteration == 0){
                    iteration ++;
                    continue;
                }
                String[] values = line.split(",");
                Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected()));
                Boat_Insurance boat = new Boat_Insurance(customer, values[1], values[2], Integer.parseInt(values[3]), values[4], values[5], values[6], values[7], Double.parseDouble(values[8]), Integer.parseInt(values[9]), values[10]);
                boatFromCsv.add(boat);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return boatFromCsv;
    }


    public static ObservableList<Insurance> readLeisure () {

        String line;
        ObservableList<Insurance> LeisureFromCsv = FXCollections.observableArrayList();
        int iteration = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home")+"/household.csv"))) {
            while ((line = br.readLine()) != null) {
                if (iteration == 0){
                    iteration ++;
                    continue;
                }
                String[] values = line.split(",");
                Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected()));
                Leisure_Insurance leisure = new Leisure_Insurance(customer, values[1], values[2], Integer.parseInt(values[3]), values[4], values[5], Integer.parseInt(values[6]), values[7], values[8], values[9], Double.parseDouble(values[10]), Integer.parseInt(values[11]), Integer.parseInt(values[12]));
                int allCustomerInsurance = customer.getAllCustomerInsurance();
                //updateAllInsurances(allCustomerInsurance);


                LeisureFromCsv.add(leisure);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return LeisureFromCsv;
    }





}