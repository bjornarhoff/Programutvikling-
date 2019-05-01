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

    public static ObservableList<Damage_Report> findDamageReport(String searchterm) {
       Customer customer = null;
       Damage_Report damageReport = null;
       String line;
       ObservableList<Damage_Report> damageReports = FXCollections.observableArrayList();
       int iteration = 0;

       try(BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home")+ "/damageReport.csv"))){
           while ((line = br.readLine()) != null) {
               if (iteration ==0) {
                   iteration ++;
                   continue;
               }


               String[] values = line.split(",");

               if(searchterm.equals(values[0])){

                   customer = findCustomer(values[0]);
                   damageReport = new Damage_Report(values[1], Integer.parseInt(values[2]), values[3],
                           values[4], values[5], Double.parseDouble(values[6]), Integer.parseInt(values[7]), customer);

                   damageReports.add(damageReport);
                   //System.out.println(customer);
                  // System.out.println(damageReport);
               }
           }
       } catch (IOException e) {
           e.printStackTrace();
       }
       return damageReports;
    }


    public static ObservableList<Damage_Report> readDamageReport () {

        String line;
        ObservableList<Damage_Report> damageReports = null;
        int iteration = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home")+"/damageReport.csv"))) {
            while ((line = br.readLine()) != null) {
                if (iteration == 0){
                    iteration ++;
                    continue;
                }
                String[] values = line.split(",");

                Customer customer = CsvReader.findCustomer(String.valueOf(HomeCustomerController.getCustomerSelected().getPersonalID()));
                damageReports = findDamageReport(customer.getPersonalID());

                //damageReports.add(damageReport);
                //System.out.println(damageReports);

               /* Damage_Report damagereport = new Damage_Report(values[1],Integer.parseInt(values[2]), values[3], values[4], values[5], Double.parseDouble(values[6]), Integer.parseInt(values[7]), customer);
                damageReports.add(damagereport);
                */

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return damageReports;
    }

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

        public static ObservableList<House_Household_Insurance> findHouseInsurnace (String searchterm){
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

            } catch (IOException e) {
                e.printStackTrace();
            }
            return households;
        }

        public static ObservableList<House_Household_Insurance> readHousehold () {

            String line;
            ObservableList<House_Household_Insurance> household = null;
            int iteration = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/houseInsurance.csv"))) {
                while ((line = br.readLine()) != null) {
                    if (iteration == 0) {
                        iteration++;
                        continue;
                    }
                    String[] values = line.split(",");

                    Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));


                    household = findHouseInsurnace(customer.getPersonalID());

                    //householdFromCsv.add(household);

                /*House_Household_Insurance household = new House_Household_Insurance(customer,values[1], values[2], Integer.parseInt(values[3]), values[4], values[5],
                        Integer.parseInt(values[6]), values[7], values[8], values[9], Double.parseDouble(values[10]), Integer.parseInt(values[11]), Integer.parseInt(values[12]));
                householdFromCsv.add(household);

                 */
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return household;
        }

        public static ObservableList<Travel_Insurance> findTravelInsurnace (String searchterm){
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

            } catch (IOException e) {
                e.printStackTrace();
            }
            return travelInsurnaces;
        }


        public static ObservableList<Travel_Insurance> readTravel () {

            String line;
            ObservableList<Travel_Insurance> travelInsurnces = null;
            int iteration = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/travelInsurnace.csv"))) {
                while ((line = br.readLine()) != null) {
                    if (iteration == 0) {
                        iteration++;
                        continue;
                    }
                    String[] values = line.split(",");

                    Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
                    travelInsurnces = findTravelInsurnace(customer.getPersonalID());

                /*
                Travel_Insurance travel = new Travel_Insurance(customer,values[1], values[2], Integer.parseInt(values[3]), values[4], values[5], Integer.parseInt(values[6]));
                travelFromCsv.add(travel);

                 */
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return travelInsurnces;
        }

        public static ObservableList<Boat_Insurance> findBoatInsurnace (String searchterm){
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

            } catch (IOException e) {
                e.printStackTrace();
            }
            return boatInsurnaces;
        }

        public static ObservableList<Boat_Insurance> readBoat () {

            String line;
            ObservableList<Boat_Insurance> boatInsurnace = null;
            int iteration = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/boatInsurance.csv"))) {
                while ((line = br.readLine()) != null) {
                    if (iteration == 0) {
                        iteration++;
                        continue;
                    }
                    String[] values = line.split(",");
                    Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));

                    boatInsurnace = findBoatInsurnace(customer.getPersonalID());

                /*
                Boat_Insurance boat = new Boat_Insurance(customer, values[1], values[2], Integer.parseInt(values[3]), values[4], values[5], values[6], values[7], Double.parseDouble(values[8]), Integer.parseInt(values[9]), values[10]);
                boatFromCsv.add(boat);

                 */
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return boatInsurnace;
        }


        public static ObservableList<Leisure_Insurance> findLeisureInsurnace (String searchterm){
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

            } catch (IOException e) {
                e.printStackTrace();
            }
            return leisureInsurnaces;
        }

        public static ObservableList<Leisure_Insurance> readLeisure () {

            String line;
            ObservableList<Leisure_Insurance> leisureInsurnces = null;
            int iteration = 0;
            try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/LeisureInsurnace.csv"))) {
                while ((line = br.readLine()) != null) {
                    if (iteration == 0) {
                        iteration++;
                        continue;
                    }
                    String[] values = line.split(",");
                    Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));

                    leisureInsurnces = findLeisureInsurnace(customer.getPersonalID());

                /*
                Leisure_Insurance leisure = new Leisure_Insurance(customer, values[1], values[2], Integer.parseInt(values[3]), values[4], values[5], Integer.parseInt(values[6]), values[7], values[8], values[9], Double.parseDouble(values[10]), Integer.parseInt(values[11]), Integer.parseInt(values[12]));
                int allCustomerInsurance = customer.getAllCustomerInsurance();
                //updateAllInsurances(allCustomerInsurance);
                LeisureFromCsv.add(leisure);
                 */
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return leisureInsurnces;
        }
}