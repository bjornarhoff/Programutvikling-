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
     *
     * @return an ObservableList containing all the customers in the csv file
     */
    public static ObservableList<Customer> read() {

        String line;
        ObservableList<Customer> customersFromCsv = FXCollections.observableArrayList();
        int iteration = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/customer2.csv"))) {
            while ((line = br.readLine()) != null) {
                if (iteration == 0) {
                    iteration++;
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

    /**
     * @param file
     * @return
     */
    public static ObservableList<Customer> read(File file) {

        String line;
        ObservableList<Customer> customersFromCsv = FXCollections.observableArrayList();
        int iteration = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                if (iteration == 0) {
                    iteration++;
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


    public static void readAllBoat(File file) {
        String line;
        ObservableList<Boat_Insurance> boatins = FXCollections.observableArrayList();
        int iteration = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                if (iteration == 0) {
                    iteration++;
                    continue;
                }
                String[] values = line.split(",");
                Boat_Insurance boatInsurance = new Boat_Insurance(CsvReader.findCustomer(values[0]), values[1], values[2], Integer.parseInt(values[3]),
                        values[4], values[5], values[6], values[7], Double.parseDouble(values[8]), Integer.parseInt(values[9]), values[10]);
                boatins.add(boatInsurance);
            }
            for (Boat_Insurance boatin : boatins) {
                CsvWriter.writeBoatInsuranceToCSV(boatin, false);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readAllLeisure(File file) {
        String line;
        ObservableList<Leisure_Insurance> leisure = FXCollections.observableArrayList();
        int iteration = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                if (iteration == 0) {
                    iteration++;
                    continue;
                }
                String[] values = line.split(",");
                Leisure_Insurance leisureInsurance = new Leisure_Insurance(CsvReader.findCustomer(values[0]), values[1], values[2], Integer.parseInt(values[3]),
                        values[4], values[5], Integer.parseInt(values[6]), values[7],values[8], values[9], Double.parseDouble(values[10]), Integer.parseInt(values[11]),Integer.parseInt(values[12]));
                leisure.add(leisureInsurance);
            }
            for (Leisure_Insurance leisures : leisure) {
                CsvWriter.writeLeisureInsurance(leisures, false);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readAllHousehold(File file) {
        String line;
        ObservableList<House_Household_Insurance> house = FXCollections.observableArrayList();
        int iteration = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                if (iteration == 0) {
                    iteration++;
                    continue;
                }
                String[] values = line.split(",");
                House_Household_Insurance household = new House_Household_Insurance(CsvReader.findCustomer(values[0]), values[1], values[2], Integer.parseInt(values[3]),
                        values[4], values[5], Integer.parseInt(values[6]), values[7],values[8], values[9], Double.parseDouble(values[10]), Integer.parseInt(values[11]),Integer.parseInt(values[12]));
                house.add(household);
            }
            for (House_Household_Insurance households : house) {
                CsvWriter.writeHouseInsuranceToCSV(households, false);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void readAllTravel(File file) {
        String line;
        ObservableList<Travel_Insurance> travel_insurances = FXCollections.observableArrayList();
        int iteration = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                if (iteration == 0) {
                    iteration++;
                    continue;
                }
                String[] values = line.split(",");
                Travel_Insurance travel = new Travel_Insurance(CsvReader.findCustomer(values[0]), values[1], values[2], Integer.parseInt(values[3]),
                        values[4], values[5], Integer.parseInt(values[6]));
                travel_insurances.add(travel);
            }
            for (Travel_Insurance travels : travel_insurances) {
                CsvWriter.writeTravelInsjurance(travels, false);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void readAllDamagereport(File file) {
        String line;
        ObservableList<Damage_Report> damage_reports = FXCollections.observableArrayList();
        int iteration = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                if (iteration == 0) {
                    iteration++;
                    continue;
                }
                String[] values = line.split(",");
                Damage_Report damage = new Damage_Report (values[1], Integer.parseInt(values[2]), values[3], values[4],
                        values[5], Double.parseDouble(values[6]), Integer.parseInt(values[7]),CsvReader.findCustomer(values[0]));
                damage_reports.add(damage);
            }
            for (Damage_Report damage_report : damage_reports) {
                CsvWriter.writeDamageReport(damage_report);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }

    }





    /**
     * @param searchterm to specify what to search for in Customer csv file in this case PersonalId
     * @return the specific searched customer
     */
    public static Customer findCustomer(String searchterm) {
        Customer customer = null;
        String line;
        int iteration = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/customer2.csv"))) {
            while ((line = br.readLine()) != null) {
                if (iteration == 0) {
                    iteration++;
                    continue;
                }

                String[] values = line.split(",");

                if (searchterm.equals(values[0])) {

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
     * @param searchterm to specify what to search for in the Customer csv file in this case PersonalId
     * @return an ObservableList which contains all the items which matched the searchtearm
     */
    public static ObservableList<Damage_Report> findDamageReport(String searchterm) {
        Customer customer;
        Damage_Report damageReport;
        String line;
        ObservableList<Damage_Report> damageReports = FXCollections.observableArrayList();
        int iteration = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/damageReport.csv"))) {
            while ((line = br.readLine()) != null) {
                if (iteration == 0) {
                    iteration++;
                    continue;
                }


                String[] values = line.split(",");

                if (searchterm.equals(values[0])) {

                    customer = findCustomer(values[0]);
                    damageReport = new Damage_Report(values[1], Integer.parseInt(values[2]), values[3],
                            values[4], values[5], Double.parseDouble(values[6]), Integer.parseInt(values[7]), customer);

                    damageReports.add(damageReport);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return damageReports;
    }


    /**
     * a method which reads a damageReport csv file
     *
     * @return an ObservableList which contains Damage Report
     */
    public static ObservableList<Damage_Report> readDamageReport() {
        ObservableList<Damage_Report> damageReports;
        Customer customer = CsvReader.findCustomer(String.valueOf(HomeCustomerController.getCustomerSelected().getPersonalID()));
        damageReports = findDamageReport(customer.getPersonalID());
        return damageReports;
    }

    public static ArrayList<String> readAllDamageReports() {
        String line;
        ArrayList<String> values = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/damageReport.csv"))) {
            while ((line = br.readLine()) != null) {
                values.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return values;
    }

    /**
     * @param searchterm to specify what to search for in the Customer csv file in this case PersonalID
     * @return an ObservableList with all the matching House Insurances
     */

    public static ObservableList<House_Household_Insurance> findHouseInsurnace(String searchterm) {
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

    public static ObservableList<House_Household_Insurance> readHouseholdWithCustomer() {
        ObservableList<House_Household_Insurance> household;
        Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
        household = findHouseInsurnace(customer.getPersonalID());
        return household;
    }

    public static ArrayList<String> readAllHouse() {
        String line;
        ArrayList<String> values = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/houseInsurance.csv"))) {
            while ((line = br.readLine()) != null) {
                values.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return values;
    }

    /**
     * @param searchterm to specify what to search for in the Customer csv file in this case PersonalID
     * @return an ObservableList with all the matching Travel Insurances
     */
    public static ObservableList<Travel_Insurance> findTravelInsurnace(String searchterm) {
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

    public static ObservableList<Travel_Insurance> readTravelWithCustomer() {
        ObservableList<Travel_Insurance> travelInsurnces;
        Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
        travelInsurnces = findTravelInsurnace(customer.getPersonalID());
        return travelInsurnces;
    }

    public static ArrayList<String> readAllTravel() {
        String line;
        ArrayList<String> values = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/travelInsurnace.csv"))) {
            while ((line = br.readLine()) != null) {
                values.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return values;
    }

    /**
     * @param searchterm to specify what to search for in Boat csv file
     * @return a ObservableList with all the found Boat Insurances to the search
     */
    public static ObservableList<Boat_Insurance> findBoatInsurnace(String searchterm) {
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

    public static ObservableList<Boat_Insurance> readBoatWithCustomer() {
        ObservableList<Boat_Insurance> boatInsurnace;
        Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
        boatInsurnace = findBoatInsurnace(customer.getPersonalID());
        return boatInsurnace;
    }

    public static ArrayList<String> readAllBoat() {
        String line;
        ArrayList<String> values = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/boatInsurance.csv"))) {
            while ((line = br.readLine()) != null) {
                values.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return values;
    }




    /**
     * @param searchterm to specify what to search for in leisure csv file
     * @return a ObservableList with all the found Leisure Insurances to the search
     */
    public static ObservableList<Leisure_Insurance> findLeisureInsurnace(String searchterm) {
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

    public static ObservableList<Leisure_Insurance> readLeisureWithCustomer() {
        ObservableList<Leisure_Insurance> leisureInsurnces;
        Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
        leisureInsurnces = findLeisureInsurnace(customer.getPersonalID());
        return leisureInsurnces;
    }

    public static ArrayList<String> readAllLeisure() {
        String line;
        ArrayList<String> values = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/LeisureInsurnace.csv"))) {
            while ((line = br.readLine()) != null) {
                values.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return values;
    }
/*
    public static ObservableList<Insurance> readInsurnaceJobj(ArrayList<String> insurances, String type){
        if (type.equals("boat")){
            ObservableList<Boat_Insurance> boat_insurances = FXCollections.observableArrayList();
            insurances = readAllBoat();
            for (String insurance : insurances) {
                boat_insurances.add(insurance);
            }
        }
    }

 */
}