package FileManagement;

import CustomerModell.Customer;
import Damages.Damage_Report;
import Insurances.*;
import Serialisering.SearchAndReadFromCSV;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class CsvWriter {

    // Parameters used in CSV file
    private static final String CUSTOMERHEADER = "PersonalId,InsuranceNumber,Name,Phonenumber,Email,Date,Adress,Unpaid,Total";
    private static final String BOATINSURNACEHEADER = "PersonalId,yearlyInsurancePremium,dateofCreatedInsurance,insuranceAmount,insurnaceConditions,Owner,Register Nr,Boat type,Boat Length,Year,Motortype";
    private static final String HOUSEINSURANCEHEADER = "PersonalId,yearlyInsurancePremium,dateofCreatedInsurance,insuranceAmount,insurnaceConditions,Owner,Year,ResidentialType,ConstructionMaterial,Condition,NumberOfSquareMeters,AmountForConstruction,AmountForHousehold";
    private static final String LEISUREINSURANCE = "PersonalId,yearlyInsurancePremium,dateofCreatedInsurance,insuranceAmount,insuranceConditions,address_Not_Billing,constructionYear,residentalType,constructionMaterial,condition,amountSquareMeters,amountforConstruction,amountForHousehold";
    private static final String TRAVELINSURANCE = "PersonalId,yearlyInsurancePremium,dateofCreatedInsurance,insuranceAmount,insuranceConditions,insuranceArea,insurnaceSum";
    private static final String DAMAGEREPORT = "PersonalID,DateofDamage,DamageNr,DamageType,DamageDescription,ContactOfWitnesses,TaxOfDamage,UnpaidReplacements";
    private static final String NEW_LINE = "\n";
    public static FileWriter fileWriter = null;
    private static boolean fileExists = false;

    // Method for finally block
    public static void finallyBlock(FileWriter fw) {

        // finally code -> always executes when the try block exits
        try {
            if (fw != null) {
                // Closes the stream, flushing it first.
                fw.flush();
                fw.close();
            }
        } catch (IOException e) {
            System.out.println("Error while flushing/closing fileWriter");
            e.printStackTrace();
        }
    }

    public static void makeHeader(String header) {
        try {
            if (!fileExists) {
                // Write to header
                fileWriter.append(header);

                // New line after header
                fileWriter.append(NEW_LINE);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * method for creating a CSV file
     *
     * @param path
     * @return a file
     */
    public static File createFileCSV(String path) {
        File file = new File(path);

        // Checks whether the file exists or not
        try {
            if (file.createNewFile()) {
                fileExists = false;
                System.out.println("File created!");
            } else {
                fileExists = true;
                System.out.println("File already exists");
            }
        } catch (IOException e) {
            System.err.println("Something wrong!!");
        }
        return file;
    }

    public static void writeFileToCsv(String path, String values) {

        try {
            fileWriter = new FileWriter(createFileCSV(path), true);
            fileWriter.append(values);
            fileWriter.append(NEW_LINE);
        } catch (IOException e) {
            e.printStackTrace();
        }
        finallyBlock(fileWriter);
    }

    public static void writeFileToCsvCustomer(String path, Customer customer) {

        try {
            fileWriter = new FileWriter(createFileCSV(path), true);
            makeHeader(CUSTOMERHEADER);
            fileWriter.append(customer.toCSVString());
            fileWriter.append(NEW_LINE);


            // If something went wrong while creating file
        } catch (IOException e) {
            System.out.println("csv file create error");
            e.printStackTrace();
        }

        finallyBlock(fileWriter);
    }


    // Method for write customer object to CSV file
    public static void writeCustomerToCSV(Customer aCustomer) {

        try {
            fileWriter = new FileWriter(createFileCSV(System.getProperty("user.home") + "/customer2.csv"), true);
            makeHeader(CUSTOMERHEADER);
            fileWriter.append(aCustomer.toCSVString());
            fileWriter.append(NEW_LINE);

            // If something went wrong while creating file
        } catch (IOException e) {
            System.out.println("csv file create error");
            e.printStackTrace();
        }

        finallyBlock(fileWriter);
    }

    /**
     * a method which updates and sets all the customer Insurances
     *
     * @param insurance
     */
    public static void updateAllInsurances(Insurance insurance) {
        Customer customer = insurance.getCustomer();
        String personID = customer.getPersonalID();
        int allCustomerInsurance = customer.getAllCustomerInsurance();

        Customer existing = CsvReader.findCustomer(personID);
        SearchAndReadFromCSV.deleteCustomerFromCsv(existing.getPersonalID());

        existing.setAllCustomerInsurance(allCustomerInsurance);
        CsvWriter.writeCustomerToCSV(existing);
    }


    public static void writeBoatInsuranceToCSV(Boat_Insurance boatInsurance, boolean createInsurance) {
        /**
         * a method which writes a boat object object to a csv file
         * @param boatInsurance
         */

        if (createInsurance) {
            updateAllInsurances(boatInsurance);
        }

        try {
            fileWriter = new FileWriter(createFileCSV(System.getProperty("user.home") + "/boatInsurance.csv"), true);
            makeHeader(BOATINSURNACEHEADER);


            fileWriter.append(boatInsurance.toCSVStringBoat());
            fileWriter.append(NEW_LINE);

            // If something went wrong while creating file
        } catch (IOException e) {
            System.out.println("csv file create error");
            e.printStackTrace();
        }
        finallyBlock(fileWriter);
    }


    public static void writeHouseInsuranceToCSV(Household_Insurance houseInsurance, boolean createInsurance) {
        /**
         * a method which writes a House object to a csv file
         * @param houseInsurance
         */

        if (createInsurance == true) {
            updateAllInsurances(houseInsurance);
        }

        try {
            fileWriter = new FileWriter(createFileCSV(System.getProperty("user.home") + "/houseInsurance.csv"), true);
            makeHeader(HOUSEINSURANCEHEADER);
            fileWriter.append(houseInsurance.toCSVStringHousehold());
            fileWriter.append(NEW_LINE);

            // If something went wrong while creating file
        } catch (IOException e) {
            System.out.println("csv file create error");
            e.printStackTrace();
        }
        finallyBlock(fileWriter);
    }


    /**
     * a method which writes a Travel object to a csv file
     *
     * @param travelInsurance
     */
    public static void writeTravelInsjurance(Travel_Insurance travelInsurance, boolean createInsurnace) {

        if (createInsurnace == true) {
            updateAllInsurances(travelInsurance);
        }

        try {
            fileWriter = new FileWriter(createFileCSV(System.getProperty("user.home") + "/travelInsurnace.csv"), true);
            makeHeader(TRAVELINSURANCE);
            fileWriter.append(travelInsurance.toCSVStringTravel());
            fileWriter.append(NEW_LINE);


            // If something went wrong while creating file
        } catch (IOException e) {
            System.out.println("csv file create error");
            e.printStackTrace();
        }


        finallyBlock(fileWriter);
    }

    /**
     * a method which writes a Leisure object to a csv file
     *
     * @param leisureInsurnace
     */
    public static void writeLeisureInsurance(Leisure_Insurance leisureInsurnace, boolean createInsurnace) {


        if (createInsurnace == true) {
            updateAllInsurances(leisureInsurnace);
        }

        try {
            fileWriter = new FileWriter(createFileCSV(System.getProperty("user.home") + "/LeisureInsurnace.csv"), true);
            makeHeader(LEISUREINSURANCE);
            fileWriter.append(leisureInsurnace.toCSVStringLeisure());
            fileWriter.append(NEW_LINE);
            // If something went wrong while creating file
        } catch (IOException e) {
            System.out.println("csv file create error");
            e.printStackTrace();
        }
        finallyBlock(fileWriter);
    }


    /**
     * e method which write a damage report to a csv file
     *
     * @param damage_report
     */
    public static void writeDamageReport(Damage_Report damage_report) {
        try {
            fileWriter = new FileWriter(createFileCSV(System.getProperty("user.home") + "/damageReport.csv"), true);
            makeHeader(DAMAGEREPORT);
            fileWriter.append(damage_report.toCSVStringDamageReport());
            fileWriter.append(NEW_LINE);
            // If something went wrong while creating file
        } catch (IOException e) {
            System.out.println("csv file create error");
            e.printStackTrace();
        }
        finallyBlock(fileWriter);
    }


}
