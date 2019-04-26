package FileManagement;

import CustomerModell.Customer;
import Insurances.*;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;



public class CsvWriter {

    // Parameters used in CSV file
    private static final String COMMA = ",";
    private static final String HEADER = "InsuranceNumber,PersonalId,Name,Phonenumber,Email,Date,Adress,Unpaid";
    private static final String insuranceHeader = "Customer,Insurance Premium ,Date,Amount,Condition";
    private static final String boatInsuranceHeader = "Owner,Register Nr,Boat type,Boat Length,Year,Motortype";
    private static final String houseInsuranceHeader = "Owner,Year,ResidentialType,ConstructionMaterial,Condition,NumberOfSquareMeters,AmountForConstruction, AmountForHousehold";


    private static final String NEW_LINE = "\n";
    private static boolean fileExists = false;


    // Method for finally block
    public static void finallyBlock(FileWriter fw) {
        FileWriter fileWriter = null;
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

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(createFileCSV(System.getProperty("user.home") + "/customer2.csv"), true);
            if (!fileExists) {
                // Write to header
                fileWriter.append(HEADER);

                // New line after header
                fileWriter.append(NEW_LINE);
            }

            fileWriter.append(aCustomer.getPersonalID());
            fileWriter.append(COMMA);
            fileWriter.append(String.valueOf(aCustomer.getInsuranceNr()));
            fileWriter.append(COMMA);
            fileWriter.append(aCustomer.getName());
            fileWriter.append(COMMA);
            fileWriter.append(aCustomer.getPhoneNumber());
            fileWriter.append(COMMA);
            fileWriter.append(aCustomer.getEmail());
            fileWriter.append(COMMA);
            fileWriter.append(aCustomer.getDate());
            fileWriter.append(COMMA);
            fileWriter.append(aCustomer.getBillingAddress());
            fileWriter.append(NEW_LINE);

            // If something went wrong while creating file
        } catch (IOException e) {
            System.out.println("csv file create error");
            e.printStackTrace();
        }


        finallyBlock(fileWriter);
    }


    public static void writeInsuranceToCSV(Insurance insurance) {

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(createFileCSV(System.getProperty("user.home") + "/insurance.csv"), true);
            if (!fileExists) {
                // Write to header
                fileWriter.append(insuranceHeader);

                // New line after header
                fileWriter.append(NEW_LINE);
            }

            fileWriter.append(String.valueOf(insurance.getCustomer()));
            fileWriter.append(COMMA);
            fileWriter.append(insurance.getYearlyInsurancePremium());
            fileWriter.append(COMMA);
            fileWriter.append(insurance.getDateOfCreatedInsurance());
            fileWriter.append(COMMA);
            fileWriter.append(String.valueOf(insurance.getInsuranceAmount()));
            fileWriter.append(COMMA);
            fileWriter.append(insurance.getInsuranceConditions());
            fileWriter.append(NEW_LINE);


            // If something went wrong while creating file
        } catch (IOException e) {
            System.out.println("csv file create error");
            e.printStackTrace();
        }
        finallyBlock(fileWriter);
    }


    public static void writeBoatInsuranceToCSV(Boat_Insurance boatInsurance) {

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(createFileCSV(System.getProperty("user.home") + "/boatInsurance.csv"), true);
            if (!fileExists) {
                // Write to header
                fileWriter.append(boatInsuranceHeader);

                // New line after header
                fileWriter.append(NEW_LINE);
            }
            fileWriter.append(boatInsurance.getOwner());
            fileWriter.append(COMMA);
            fileWriter.append(boatInsurance.getRegisterNr());
            fileWriter.append(COMMA);
            fileWriter.append(String.valueOf(boatInsurance.getLengthInFoot()));
            fileWriter.append(COMMA);
            fileWriter.append(String.valueOf(boatInsurance.getYear()));
            fileWriter.append(COMMA);
            fileWriter.append(boatInsurance.getMotorTypeAndMotorPower());
            fileWriter.append(NEW_LINE);

            // If something went wrong while creating file
        } catch (IOException e) {
            System.out.println("csv file create error");
            e.printStackTrace();
        }


        finallyBlock(fileWriter);
    }



    public static void writeHouseInsuranceToCSV(House_Household_Insurance houseInsurance) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(createFileCSV(System.getProperty("user.home") + "/houseInsurance.csv"), true);
            if (!fileExists) {
                // Write to header
                fileWriter.append(houseInsuranceHeader);

                // New line after header
                fileWriter.append(NEW_LINE);
            }
            fileWriter.append(houseInsurance.getPropertyOwner());
            fileWriter.append(COMMA);
            fileWriter.append(String.valueOf(houseInsurance.getYearOfConstruction()));
            fileWriter.append(COMMA);
            fileWriter.append(houseInsurance.getResidentialType());
            fileWriter.append(COMMA);
            fileWriter.append(houseInsurance.getConstructionMaterial());
            fileWriter.append(COMMA);
            fileWriter.append(houseInsurance.getCondition());
            fileWriter.append(COMMA);
            fileWriter.append(String.valueOf(houseInsurance.getNumberOfSquareMeters()));
            fileWriter.append(COMMA);
            fileWriter.append(String.valueOf(houseInsurance.getInsuranceAmountForConstruction()));
            fileWriter.append(COMMA);
            fileWriter.append(String.valueOf(houseInsurance.getInsuranceAmountForHousehold()));
            fileWriter.append(NEW_LINE);

            // If something went wrong while creating file
        } catch (IOException e) {
            System.out.println("csv file create error");
            e.printStackTrace();
        }


        finallyBlock(fileWriter);
    }


    public static void writeTravelInsjurance(Travel_Insurance travelInsurance) {
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(createFileCSV(System.getProperty("user.home") + "/houseInsurance.csv"), true);
            if (!fileExists) {
                // Write to header
                fileWriter.append(houseInsuranceHeader);

                // New line after header
                fileWriter.append(NEW_LINE);
            }

            fileWriter.append(String.valueOf(travelInsurance.getCustomer()));
            fileWriter.append(COMMA);
            fileWriter.append(travelInsurance.getYearlyInsurancePremium());
            fileWriter.append(COMMA);
            fileWriter.append(travelInsurance.getDateOfCreatedInsurance());
            fileWriter.append(COMMA);
            fileWriter.append(String.valueOf(travelInsurance.getInsuranceAmount()));
            fileWriter.append(COMMA);
            fileWriter.append(travelInsurance.getInsuranceConditions());

            fileWriter.append(travelInsurance.getInsuranceArea());
            fileWriter.append(COMMA);
            fileWriter.append(String.valueOf(travelInsurance.getInsuranceSum()));
            fileWriter.append(COMMA);
            fileWriter.append(NEW_LINE);



            // If something went wrong while creating file
        } catch (IOException e) {
            System.out.println("csv file create error");
            e.printStackTrace();
        }


        finallyBlock(fileWriter);
    }

    
}
