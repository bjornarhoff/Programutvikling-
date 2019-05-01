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
    private static boolean fileExists = false;


    public static FileWriter fileWriter = null;



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


    /**
     * method for creating a CSV file
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

    public static void writeFileToCsvCustomer(String path, Customer customer){

        try {
            fileWriter = new FileWriter(createFileCSV(path), true);
            if (!fileExists) {
                // Write to header
                fileWriter.append(CUSTOMERHEADER);

                // New line after header
                fileWriter.append(NEW_LINE);
            }
            fileWriter.append(customer.toCSVString());
            fileWriter.append(NEW_LINE);


            // If something went wrong while creating file
        } catch (IOException e) {
            System.out.println("csv file create error");
            e.printStackTrace();
        }

        finallyBlock(fileWriter);
    }

    public static void writeFileToCsvInsurance(String path, Insurance insurance){

        try {
            fileWriter = new FileWriter(createFileCSV(path), true);
            if (insurance.getClass() == Boat_Insurance.class){
                fileWriter.append(BOATINSURNACEHEADER);
                fileWriter.append(NEW_LINE);
                fileWriter.append(insurance.toCSVStringInsurnce());
                fileWriter.append(NEW_LINE);
            }else if (insurance.getClass() == House_Household_Insurance.class){
                fileWriter.append(HOUSEINSURANCEHEADER);
                fileWriter.append(NEW_LINE);
                fileWriter.append(insurance.toCSVStringInsurnce());
                fileWriter.append(NEW_LINE);
            }else if (insurance.getClass() == Leisure_Insurance.class){
                fileWriter.append(LEISUREINSURANCE);
                fileWriter.append(NEW_LINE);
                fileWriter.append(insurance.toCSVStringInsurnce());
                fileWriter.append(NEW_LINE);
            }else if (insurance.getClass() == Travel_Insurance.class){
                fileWriter.append(TRAVELINSURANCE);
                fileWriter.append(NEW_LINE);
                fileWriter.append(insurance.toCSVStringInsurnce());
                fileWriter.append(NEW_LINE);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        finallyBlock(fileWriter);
    }


    // Method for write customer object to CSV file
    public static void writeCustomerToCSV(Customer aCustomer) {

        try {
            fileWriter = new FileWriter(createFileCSV(System.getProperty("user.home") + "/customer2.csv"), true);
            if (!fileExists) {
                // Write to header
                fileWriter.append(CUSTOMERHEADER);

                // New line after header
                fileWriter.append(NEW_LINE);
            }

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
     * @param insurance
     */
    public static void updateAllInsurances(Insurance insurance){
        Customer customer = insurance.getCustomer();
        String personID = customer.getPersonalID();
        int allCustomerInsurance = customer.getAllCustomerInsurance();

        Customer existing = CsvReader.findCustomer(personID);
        SearchAndReadFromCSV.deleteCustomerFromCsv(existing.getPersonalID());

        existing.setAllCustomerInsurance(allCustomerInsurance);
        CsvWriter.writeCustomerToCSV(existing);
    }


    /**
     * a method which writes a boat object object to a csv file
     * @param boatInsurance
     */
    public static void writeBoatInsuranceToCSV(Boat_Insurance boatInsurance) {

        updateAllInsurances(boatInsurance);

        try {
            fileWriter = new FileWriter(createFileCSV(System.getProperty("user.home") + "/boatInsurance.csv"), true);
            if (!fileExists) {
                // Write to header
                fileWriter.append(BOATINSURNACEHEADER);

                // New line after header
                fileWriter.append(NEW_LINE);
            }

            fileWriter.append(boatInsurance.toCSVStringBoat());
            fileWriter.append(NEW_LINE);

            // If something went wrong while creating file
        } catch (IOException e) {
            System.out.println("csv file create error");
            e.printStackTrace();
        }


        finallyBlock(fileWriter);
    }


    /**
     * a method which writes a House object to a csv file
     * @param houseInsurance
     */
    public static void writeHouseInsuranceToCSV(House_Household_Insurance houseInsurance) {

        updateAllInsurances(houseInsurance);

        try {
            fileWriter = new FileWriter(createFileCSV(System.getProperty("user.home") + "/houseInsurance.csv"), true);
            if (!fileExists) {
                // Write to header
                fileWriter.append(HOUSEINSURANCEHEADER);

                // New line after header
                fileWriter.append(NEW_LINE);
            }

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
     * @param travelInsurance
     */
    public static void writeTravelInsjurance(Travel_Insurance travelInsurance) {

        updateAllInsurances(travelInsurance);

        try {
            fileWriter = new FileWriter(createFileCSV(System.getProperty("user.home") + "/travelInsurnace.csv"), true);
            if (!fileExists) {
                // Write to header
                fileWriter.append(TRAVELINSURANCE);

                // New line after header
                fileWriter.append(NEW_LINE);
            }

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
     * @param leisureInsurnace
     */
    public static void writeLeisureInsurance(Leisure_Insurance leisureInsurnace) {

        updateAllInsurances(leisureInsurnace);


        try {
            fileWriter = new FileWriter(createFileCSV(System.getProperty("user.home") + "/LeisureInsurnace.csv"), true);
            if (!fileExists) {
                // Write to header
                fileWriter.append(LEISUREINSURANCE);

                // New line after header
                fileWriter.append(NEW_LINE);
            }

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
     * @param damage_report
     */
    public static void writeDamageReport(Damage_Report damage_report) {

        Customer aCustomer = damage_report.getCustomer();
        String personID = aCustomer.getPersonalID();
        int totalt = aCustomer.getAllCustomerInsurance();

        Customer registrert = CsvReader.findCustomer(personID);

        //CsvWriter.delete(registrert);

        try {
            fileWriter = new FileWriter(createFileCSV(System.getProperty("user.home") + "/damageReport.csv"), true);
            if (!fileExists) {
                // Write to header
                fileWriter.append(DAMAGEREPORT);

                // New line after header
                fileWriter.append(NEW_LINE);
            }

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
