package FileManagement;


import CustomerModell.Customer;
import Damages.Damage_Report;
import Insurances.Boat_Insurance;
import Insurances.Household_Insurance;
import Insurances.Leisure_Insurance;
import Insurances.Travel_Insurance;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.openjfx.HomeCustomerController;
import org.openjfx.HomeInsuranceController;

import java.io.*;
import java.util.ArrayList;


public class CsvReader {


    /**
     * a method which reads all the customers from the csv file
     *
     * @return an ObservableList containing all the customers in the csv file
     */
    public static ObservableList<Customer> readAllCustomers() throws IOException, FileNotFoundException {

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
        } catch (FileNotFoundException e) {
            System.out.println("File is not yet created, just registrer anything");
        }
        return customersFromCsv;
    }

    /**
     * Method that reads all the customer from a chosen File
     *
     * @param file input file
     * @return an Observable list containing all the customers from the file
     */
    public static ObservableList<Customer> readAllCustomers(File file) {

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
            System.out.println("File is not yet created, just registrer anything");
        }
        return customer;
    }

    /**
     * @param searchterm to specify what to search for in the Customer csv file in this case PersonalId
     * @return an ObservableList which contains all the items which matched the searchtearm
     */
    public static ObservableList<Damage_Report> findDamageReport(String searchterm) throws IOException, FileNotFoundException {
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
        } catch (FileNotFoundException e) {
        }
        return damageReports;
    }


    /**
     * a method which reads a damageReport csv file
     *
     * @return an ObservableList which contains Damage Report
     */
    public static ObservableList<Damage_Report> readDamageReport() throws IOException, FileNotFoundException {
        ObservableList<Damage_Report> damageReports;
        Customer customer = CsvReader.findCustomer(String.valueOf(HomeCustomerController.getCustomerSelected().getPersonalID()));
        damageReports = findDamageReport(customer.getPersonalID());
        return damageReports;
    }

    /**
     * Method that reads all the Damage Reports
     *
     * @return An ArrayList with each index containing a damage report
     */
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

    public static void readAllDamagereportImport(File file) {
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
                Damage_Report damage = new Damage_Report(values[1], Integer.parseInt(values[2]), values[3], values[4],
                        values[5], Double.parseDouble(values[6]), Integer.parseInt(values[7]), CsvReader.findCustomer(values[0]));
                damage_reports.add(damage);
            }
            for (Damage_Report damage_report : damage_reports) {
                CsvWriter.writeDamageReport(damage_report);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * @param searchterm to specify what to search for in the Customer csv file in this case PersonalID
     * @return an ObservableList with all the matching House Insurances
     */

    public static ObservableList<Household_Insurance> findHouseInsurnace(String searchterm) throws IOException, FileNotFoundException {
        Customer customer = null;
        Household_Insurance household = null;
        ObservableList<Household_Insurance> households = FXCollections.observableArrayList();
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

                    household = new Household_Insurance(customer, values[1], values[2], Integer.parseInt(values[3]), values[4], values[5],
                            Integer.parseInt(values[6]), values[7], values[8], values[9], Double.parseDouble(values[10]), Integer.parseInt(values[11]), Integer.parseInt(values[12]));
                    households.add(household);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File is not yet created, just registrer anything");
        }
        return households;
    }

    /**
     * Method that reads all the Household objects with the matching customers
     *
     * @return An ObservableList with the containing Household Insurances and customers
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static ObservableList<Household_Insurance> readHouseholdWithCustomer() throws IOException, FileNotFoundException {
        ObservableList<Household_Insurance> household;
        Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
        household = findHouseInsurnace(customer.getPersonalID());
        return household;
    }

    /**
     * Method that reads all the Household Insurances with customers
     *
     * @return An ArrayList with all the containing Household Insurances and customers
     */
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

    public static void readAllHouseImport(File file) {
        String line;
        ObservableList<Household_Insurance> house = FXCollections.observableArrayList();
        int iteration = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            while ((line = br.readLine()) != null) {
                if (iteration == 0) {
                    iteration++;
                    continue;
                }
                String[] values = line.split(",");
                Household_Insurance household = new Household_Insurance(CsvReader.findCustomer(values[0]), values[1], values[2], Integer.parseInt(values[3]),
                        values[4], values[5], Integer.parseInt(values[6]), values[7], values[8], values[9], Double.parseDouble(values[10]), Integer.parseInt(values[11]), Integer.parseInt(values[12]));
                house.add(household);
            }
            for (Household_Insurance households : house) {
                CsvWriter.writeHouseInsuranceToCSV(households, false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method for exporting the Household Insurnace for jobj file
     *
     * @return An ObservableList with all the conataining data required
     * @throws IOException
     */
    public static ObservableList<Household_Insurance> readHouseHoldInsuranceToJobj() throws IOException {
        ObservableList<Customer> customers = readAllCustomers();
        ObservableList<Household_Insurance> HouseholdInsurances = null;
        for (Customer customer : customers) {
            Customer aCustomer = findCustomer(customer.getPersonalID());
            HouseholdInsurances = findHouseInsurnace(aCustomer.getPersonalID());
        }
        return HouseholdInsurances;
    }

    /**
     * @param searchterm to specify what to search for in the Customer csv file in this case PersonalID
     * @return an ObservableList with all the matching Travel Insurances
     */
    public static ObservableList<Travel_Insurance> findTravelInsurnace(String searchterm) throws IOException, FileNotFoundException {
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
            System.out.println("File is not yet created, just registrer anything");
        }
        return travelInsurnaces;
    }

    /**
     * Method that reads Travel Insurance with matching customer
     *
     * @return an ObservableList that containing all the data
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static ObservableList<Travel_Insurance> readTravelWithCustomer() throws IOException, FileNotFoundException {
        ObservableList<Travel_Insurance> travelInsurnces;
        Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
        travelInsurnces = findTravelInsurnace(customer.getPersonalID());
        return travelInsurnces;
    }

    /**
     * Method that reads all the Travel Insurances in the file with customers
     *
     * @return An ArrayList containing all the data
     */
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

    public static void readAllTravelImport(File file) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method that reads all the Travel Insurances and matching customers used when export to jobj file
     *
     * @return An ObservableList containing all the Travel Insurances with matching customers
     * @throws IOException
     */
    public static ObservableList<Travel_Insurance> readTravelInsuranceToJobj() throws IOException {
        ObservableList<Customer> customers = readAllCustomers();
        ObservableList<Travel_Insurance> travelInsurances = null;
        for (Customer customer : customers) {
            Customer aCustomer = findCustomer(customer.getPersonalID());
            travelInsurances = findTravelInsurnace(aCustomer.getPersonalID());
        }
        return travelInsurances;
    }

    /**
     * @param searchterm to specify what to search for in Boat csv file
     * @return a ObservableList with all the found Boat Insurances to the search
     */
    public static ObservableList<Boat_Insurance> findBoatInsurnace(String searchterm) throws IOException, FileNotFoundException {
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
            System.out.println("File is not yet created, just registrer anything");
        }
        return boatInsurnaces;
    }

    /**
     * Method for reading Boat Insurances with matching customers
     *
     * @return An ObservableList containing all the data
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static ObservableList<Boat_Insurance> readBoatWithCustomer() throws IOException, FileNotFoundException {
        ObservableList<Boat_Insurance> boatInsurnace;
        Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
        boatInsurnace = findBoatInsurnace(customer.getPersonalID());
        return boatInsurnace;
    }

    /**
     * Method for reading all the Boat Insurances with the matching customer
     *
     * @return An ArrayList containing all the data
     * @throws IOException
     */
    public static ArrayList<String> readAllBoat() throws IOException {
        String line;
        ArrayList<String> values = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.home") + "/boatInsurance.csv"))) {
            while ((line = br.readLine()) != null) {
                values.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File is not yet created, just registrer anything");
        }
        return values;
    }

    public static void readAllBoatImport(File file) {
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
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method for reading all the Boat Insurances for export to jobj file
     *
     * @return An ObservableList containing all the data
     * @throws IOException
     */
    public static ObservableList<Boat_Insurance> readBoatInsuranceToJobj() throws IOException {
        ObservableList<Customer> customers = readAllCustomers();
        ObservableList<Boat_Insurance> boat_insurances = null;
        for (Customer customer : customers) {
            Customer aCustomer = findCustomer(customer.getPersonalID());
            boat_insurances = findBoatInsurnace(aCustomer.getPersonalID());

        }
        return boat_insurances;
    }

    public static ObservableList<Damage_Report> readDamageReportToObj() throws IOException {
        ObservableList<Customer> customers = readAllCustomers();
        ObservableList<Damage_Report> damage_reports = null;
        for (Customer customer : customers) {
            Customer aCustomer = findCustomer(customer.getPersonalID());
            damage_reports = findDamageReport(aCustomer.getPersonalID());
        }
        return damage_reports;
    }


    /**
     * @param searchterm to specify what to search for in leisure csv file
     * @return a ObservableList with all the found Leisure Insurances to the search
     */
    public static ObservableList<Leisure_Insurance> findLeisureInsurnace(String searchterm) throws IOException, FileNotFoundException {
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

    /**
     * Method for reading Leisure Insurances with matching customer
     *
     * @return An ObservableList containing all the data
     * @throws FileNotFoundException
     * @throws IOException
     */
    public static ObservableList<Leisure_Insurance> readLeisureWithCustomer() throws FileNotFoundException, IOException {
        ObservableList<Leisure_Insurance> leisureInsurnces;
        Customer customer = CsvReader.findCustomer(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
        leisureInsurnces = findLeisureInsurnace(customer.getPersonalID());
        return leisureInsurnces;
    }

    /**
     * Method for reading all the Leisure Insurances with matching customer
     *
     * @return An ArrayList containing all the data
     */
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

    public static void readAllLeisureImport(File file) {
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
                        values[4], values[5], Integer.parseInt(values[6]), values[7], values[8], values[9], Double.parseDouble(values[10]), Integer.parseInt(values[11]), Integer.parseInt(values[12]));
                leisure.add(leisureInsurance);
            }
            for (Leisure_Insurance leisures : leisure) {
                CsvWriter.writeLeisureInsurance(leisures, false);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Method for reading all the Leisure Insurnace with matching customers for export to jobj file
     *
     * @return An ObservableList containing all the data
     * @throws IOException
     */
    public static ObservableList<Leisure_Insurance> readLeisureInsuranceToJobj() throws IOException {
        ObservableList<Customer> customers = readAllCustomers();
        ObservableList<Leisure_Insurance> leisure_insurances = null;
        for (Customer customer : customers) {
            Customer aCustomer = findCustomer(customer.getPersonalID());
            leisure_insurances = findLeisureInsurnace(aCustomer.getPersonalID());
        }
        return leisure_insurances;
    }
}