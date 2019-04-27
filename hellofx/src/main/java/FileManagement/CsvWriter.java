package FileManagement;

import CustomerModell.Customer;
import Insurances.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class CsvWriter {

    // Parameters used in CSV file
    private static final String COMMA = ",";
    private static final String CUSTOMERHEADER = "InsuranceNumber,PersonalId,Name,Phonenumber,Email,Date,Adress,Unpaid";
    private static final String BOATINSURNACEHEADER = "PersonalId,yearlyInsurancePremium,dateofCreatedInsurance,insuranceAmount,insurnaceConditions,Owner,Register Nr,Boat type,Boat Length,Year,Motortype";
    private static final String HOUSEINSURANCEHEADER = "PersonalId,yearlyInsurancePremium,dateofCreatedInsurance,insuranceAmount,insurnaceConditions,Owner,Year,ResidentialType,ConstructionMaterial,Condition,NumberOfSquareMeters,AmountForConstruction,AmountForHousehold";
    private static final String LEISUREINSURANCE = "PersonalId,yearlyInsurancePremium,dateofCreatedInsurance,insuranceAmount,insuranceConditions,address_Not_Billing,constructionYear,residentalType,constructionMaterial,condition,amountSquareMeters,amountforConstruction,amountForHousehold";
    private static final String TRAVELINSURANCE = "PersonalId,yearlyInsurancePremium,dateofCreatedInsurance,insuranceAmount,insuranceConditions,insuranceArea,insurnaceSum";


    private static final String NEW_LINE = "\n";
    private static boolean fileExists = false;


    public static FileWriter fileWriter = null;



    // Method for finally block
    public static void finallyBlock(FileWriter fw) {

        // finally code -> always executes when the try block exits
        try {
            if (fileWriter != null) {
                // Closes the stream, flushing it first.
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (IOException e) {
            System.out.println("Error while flushing/closing fileWriter");
            e.printStackTrace();
        }
    }


    // Method for create CSV file -> return file
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

    // Method for write customer object to CSV file
    public static void writeObjectToCSV(Customer aCustomer) {

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


    public static void writeBoatInsuranceToCSV(Boat_Insurance boatInsurance) {

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



    public static void writeHouseInsuranceToCSV(House_Household_Insurance houseInsurance) {
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


    public static void writeTravelInsjurance(Travel_Insurance travelInsurance) {
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

    public static void writeLeisureInsurance(Leisure_Insurance LeisureInsurnace) {
        try {
            fileWriter = new FileWriter(createFileCSV(System.getProperty("user.home") + "/LeisureInsurnace.csv"), true);
            if (!fileExists) {
                // Write to header
                fileWriter.append(LEISUREINSURANCE);

                // New line after header
                fileWriter.append(NEW_LINE);
            }

            fileWriter.append(LeisureInsurnace.toCSVStringLeisure());
            fileWriter.append(NEW_LINE);



            // If something went wrong while creating file
        } catch (IOException e) {
            System.out.println("csv file create error");
            e.printStackTrace();
        }


        finallyBlock(fileWriter);
    }

    
}
