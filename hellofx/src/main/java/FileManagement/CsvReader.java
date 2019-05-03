package FileManagement;


import CustomerModell.Customer;
import Damages.Damage_Report;
import Insurances.*;
import Damages.Damage_Report;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.HomeCustomerController;
import org.openjfx.HomeInsuranceController;

import java.io.*;
import java.util.ArrayList;


public class CsvReader {


    /**
     * a method which reads the customer csv file
     * @return an ObservableList containing all the customers in the csv file
     */
    public static ObservableList<Customer> read () throws IOException, FileNotFoundException {

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
        }
        catch (FileNotFoundException e){
            System.out.println("file");
        }
        return customersFromCsv;
    }



    /**
     *
     * @param searchterm to specify what to search for in Customer csv file in this case PersonalId
     * @return the specific searched customer
     */
    public static Customer findCustomer(String searchterm) {
       Customer customer = null;
       String line;
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

    /**
     *
     * @param searchterm to specify what to search for in the Customer csv file in this case PersonalId
     * @return an ObservableList which contains all the items which matched the searchtearm
     */
    public static ObservableList<Damage_Report> findDamageReport(String searchterm) throws IOException, FileNotFoundException {
       Customer customer;
       Damage_Report damageReport;
       String line;
       ObservableList<Damage_Report> damageReports = FXCollections.observableArrayList();
       int iteration = 0;

       try(BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home")+ "/damageReport.csv"))){
           while ((line = br.readLine()) != null) {
               if (iteration == 0) {
                   iteration ++;
                   continue;
               }


               String[] values = line.split(",");

               if(searchterm.equals(values[0])){

                   customer = findCustomer(values[0]);
                   damageReport = new Damage_Report(values[1], Integer.parseInt(values[2]), values[3],
                           values[4], values[5], Double.parseDouble(values[6]), Integer.parseInt(values[7]), customer);

                   damageReports.add(damageReport);
               }
           }
       } catch (FileNotFoundException e) {
       }
       return damageReports;
    }


    /**
     * a method which reads a damageReport csv file
     * @return an ObservableList which contains Damage Report
     */
    public static ObservableList<Damage_Report> readDamageReport () throws IOException, FileNotFoundException {
        ObservableList<Damage_Report> damageReports;
        Customer customer = CsvReader.findCustomer(String.valueOf(HomeCustomerController.getCustomerSelected().getPersonalID()));
        damageReports = findDamageReport(customer.getPersonalID());
        return damageReports;
    }

    /**
     *
     * @param file
     * @return
     */
    public static ObservableList<Customer> read (File file) {

        String line;
        ObservableList<Customer> customersFromCsv = FXCollections.observableArrayList();
        int iteration = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
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
                CsvWriter.writeCustomerToCSV(aCustomer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customersFromCsv;
    }
    public static ArrayList<String> readAllLeisure2(File file) {
        String line;
        ArrayList<String> values = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                values.add(line);
                //CsvWriter.writeHouseInsuranceToCSV();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return values;
    }

    /**
     *
     * @param searchterm to specify what to search for in the Customer csv file in this case PersonalID
     * @return an ObservableList with all the matching House Insurances
     */

        public static ObservableList<House_Household_Insurance> findHouseInsurnace (String searchterm) throws IOException, FileNotFoundException{
            Customer customer = null;
            House_Household_Insurance household = null;
            ObservableList<House_Household_Insurance> households = FXCollections.observableArrayList();
            String line;
            int iteration = 0;

            try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/houseInsurance.csv"))) {
                while ((line = br.readLine()) != null) {
                    if (iteration == 0) {
                        iteration++;
                        continue;
                    }
                    String[] values = line.split(",");
                    if (searchterm.equals(values[0])) {

                        customer = findCustomer(values[0]);
                        household = new House_Household_Insurance(customer, values[1], values[2], Integer.parseInt(values[3]), values[4], values[5],
                                Integer.parseInt(values[6]), values[7], values[8], values[9], Double.parseDouble(values[10]), Integer.parseInt(values[11]), Integer.parseInt(values[12]));
                        households.add(household);
                    }
                }
            } catch (FileNotFoundException e) {
            }

            return households;
        }

        public static ObservableList<House_Household_Insurance> readHousehold () throws IOException, FileNotFoundException {
            ObservableList<House_Household_Insurance> household;
            Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
            household = findHouseInsurnace(customer.getPersonalID());
            return household;
        }

    /**
     *
     * @param searchterm to specify what to search for in the Customer csv file in this case PersonalID
     * @return an ObservableList with all the matching Travel Insurances
     */
    public static ObservableList<Travel_Insurance> findTravelInsurnace (String searchterm) throws IOException, FileNotFoundException{
            Customer customer = null;
            ObservableList<Travel_Insurance> travelInsurnaces = FXCollections.observableArrayList();
            Travel_Insurance travelInsurance = null;
            String line;
            int iteration = 0;

            try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/travelInsurnace.csv"))) {
                while ((line = br.readLine()) != null) {
                    if (iteration == 0) {
                        iteration++;
                        continue;
                    }
                    String[] values = line.split(",");
                    if (searchterm.equals(values[0])) {
                        customer = findCustomer(values[0]);
                        travelInsurance = new Travel_Insurance(customer, values[1], values[2], Integer.parseInt(values[3]), values[4], values[5], Integer.parseInt(values[6]));
                        travelInsurnaces.add(travelInsurance);
                    }
                }
            } catch (FileNotFoundException e) {
            }
            return travelInsurnaces;
        }


        public static ObservableList<Travel_Insurance> readTravel () throws IOException, FileNotFoundException {
            ObservableList<Travel_Insurance> travelInsurnces ;
            Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
            travelInsurnces = findTravelInsurnace(customer.getPersonalID());
            return travelInsurnces;
        }

    /**
     *
     * @param searchterm to specify what to search for in Boat csv file
     * @return a ObservableList with all the found Boat Insurances to the search
     */
    public static ObservableList<Boat_Insurance> findBoatInsurnace (String searchterm) throws IOException, FileNotFoundException{
            Customer customer = null;
            Boat_Insurance boatInsurnace = null;
            ObservableList<Boat_Insurance> boatInsurnaces = FXCollections.observableArrayList();
            String line;
            int iteration = 0;

            try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/boatInsurance.csv"))) {
                while ((line = br.readLine()) != null) {
                    if (iteration == 0) {
                        iteration++;
                        continue;
                    }

                    String[] values = line.split(",");

                    if (searchterm.equals(values[0])) {

                        customer = findCustomer(values[0]);
                        boatInsurnace = new Boat_Insurance(customer, values[1], values[2], Integer.parseInt(values[3]), values[4], values[5], values[6], values[7], Double.parseDouble(values[8]), Integer.parseInt(values[9]), values[10]);
                        boatInsurnaces.add(boatInsurnace);

                    }

                }

            } catch (FileNotFoundException e) {
            }
            return boatInsurnaces;
        }

        public static ObservableList<Boat_Insurance> readBoat () throws IOException, FileNotFoundException {
            ObservableList<Boat_Insurance> boatInsurnace;
            Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
            boatInsurnace = findBoatInsurnace(customer.getPersonalID());
            return boatInsurnace;
        }


    /**
     *
     * @param searchterm to specify what to search for in leisure csv file
     * @return a ObservableList with all the found Leisure Insurances to the search
     */
    public static ObservableList<Leisure_Insurance> findLeisureInsurnace (String searchterm) throws IOException, FileNotFoundException{
            Customer customer = null;
            Leisure_Insurance leisureInsurnace = null;
            ObservableList<Leisure_Insurance> leisureInsurnaces = FXCollections.observableArrayList();
            String line;
            int iteration = 0;

            try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/LeisureInsurnace.csv"))) {
                while ((line = br.readLine()) != null) {
                    if (iteration == 0) {
                        iteration++;
                        continue;
                    }

                    String[] values = line.split(",");

                    if (searchterm.equals(values[0])) {

                        customer = findCustomer(values[0]);
                        leisureInsurnace = new Leisure_Insurance(customer, values[1], values[2], Integer.parseInt(values[3]), values[4], values[5], Integer.parseInt(values[6]), values[7], values[8], values[9], Double.parseDouble(values[10]), Integer.parseInt(values[11]), Integer.parseInt(values[12]));
                        leisureInsurnaces.add(leisureInsurnace);
                    }

                }

            } catch (FileNotFoundException e) {
            }
            return leisureInsurnaces;
        }

        public static ObservableList<Leisure_Insurance> readLeisure () throws FileNotFoundException, IOException {
        ObservableList<Leisure_Insurance> leisureInsurnces;
        Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
        leisureInsurnces = findLeisureInsurnace(customer.getPersonalID());
        return leisureInsurnces;
        }
}