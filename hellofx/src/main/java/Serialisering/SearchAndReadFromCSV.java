package Serialisering;
import CustomerModell.Customer;
import Damages.Damage_Report;

import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.util.Date;
import java.util.Scanner;



public class SearchAndReadFromCSV {

    // Customer
    static String personalID = "";
    static String insuranceNr = "";

    static String name = "";
    static String age = "";
    static String phoneNumber = "";
    static String email = "";
    static String date = "";
    static String billingAddress = "";
    static String allCustomerInsurance = "";
    static String unpaidReplacements = "";


    // DamageReport
    static String DateofDamage = "";
    static String DamageNr = "";
    static String DamageType = "";

    static String DamageDescription = "";
    static String ContactOfWitnesses = "";
    static String TaxOfDamage = "";
    static String unpaid = "";

    // Overall Insurance
    static String yearlyInsurnacePremium = "";
    static String dateOfCreatedInsurnace = "";
    static String insurnaceAmount = "";
    static String insurnaceConditions = "";


    // Travel Insurance
    static String insurnaceArea = "";
    static String insurnceSum = "";

    // Household Insurance
    static String propertyOwner = "";
    static String yearOfConstruction = "";
    static String residentialType = "";
    static String constructionMaterial = "";
    static String condition = "";
    static String numberOfSquareMeters = "";
    static String insurnceAmountForConstruction = "";
    static String insurnaceAmountForHousehold = "";

    // Boat Insurnace
    static String owner = "";
    static String registerNr = "";
    static String boatTypeAndModel = "";
    static String lengthInFoot = "";
    static String year = "";
    static String motorTypeAndMotorPower = "";

    // Leisure Insurance
    static String address_Not_Billing = "";
    static String constructionYear = "";
    //static String residentialType = "";
    //static String constructionMaterial = "";
    //static String condition = "";
    static String amountSquareMeters = "";
    static String amountforConstruction = "";
    static String amountForHousehold = "";

    private static Scanner x;
    private static BufferedReader y;


   /* public static void main(String[] args) {
        String filepath = "trying.txt";
        String searchTerm = "4444";

        readRecord(searchTerm, filepath);
    }*/




    public static void readRecordCustomer(String searchTerm, String filepath) {

        boolean found = false;


        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext() && !found) {
                personalID = x.next();
                name = x.next();
                age = x.next();
                phoneNumber = x.next();
                email = x.next();
                date = x.next();
                billingAddress = x.next();
                allCustomerInsurance = x.next();
                unpaidReplacements = x.next();

                if (personalID.equals(searchTerm) || name.equals(searchTerm) || age.equals(searchTerm)
                        || phoneNumber.equals(searchTerm) || email.equals(searchTerm) || date.equals(searchTerm) || billingAddress.equals(searchTerm)
                        || allCustomerInsurance.equals(searchTerm) || unpaidReplacements.equals(searchTerm)) {
                    found = true;
                }
            }

            if (found) {
                System.out.println("PersonalID: " + personalID + "Name: " + name + "Age: " + age + "PhoneNumber: " + phoneNumber +
                        "Email: " + email + "Date: " + date + "BillingAddress: " + billingAddress + "AllCustomerInsurances: "
                        + allCustomerInsurance + "UnpaidReplacements: " + unpaidReplacements);
            } else {
                System.out.println("Search term not found!");
            }
        } catch (Exception e) {

        }

    }

    public static void deleteCustomerFromCsv(String searchterm) {


        String filepath = System.getProperty("user.home") + "/customer2.csv";

        String tempfile = "temp.txt";
        File oldFile = new File(filepath);
        File newfile = new File(tempfile);

        boolean found = false;


        try {
            FileWriter fw = new FileWriter(tempfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            x = new Scanner(new File(filepath));

            while (x.hasNextLine()) {
                String[] customer = x.nextLine().split(",");
                if (!customer[0].equals(searchterm)) {
                    pw.println(customer[0] + "," + customer[1] + "," + customer[2] + "," + customer[3] + "," + customer[4] + "," + customer[5] + "," +
                            customer[6] + "," + customer[7] + "," + customer[8]);
                }
            }

            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newfile.renameTo(dump);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    public static void deleteDamageReportFromCsv(String searchterm) {


        String filepath = System.getProperty("user.home") + "/damageReport.csv";

        String tempfile = "temp.txt";
        File oldFile = new File(filepath);
        File newfile = new File(tempfile);

        boolean found = false;


        try {
            FileWriter fw = new FileWriter(tempfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext()) {
                personalID = x.next();
                DateofDamage = x.next();
                DamageNr = x.next();
                DamageType = x.next();
                DamageDescription = x.next();
                ContactOfWitnesses = x.next();
                TaxOfDamage = x.next();
                unpaid = x.next();


                if (!DateofDamage.equals(searchterm)) {
                    pw.println(personalID + "," + DateofDamage + "," + DamageNr + "," + DamageType + "," + DamageDescription + "," + ContactOfWitnesses + "," +
                            TaxOfDamage + "," + unpaid);
                }

            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newfile.renameTo(dump);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error");
        }

    }


    public static void deleteLeisureFromCsv(String searchterm) {


        String filepath = System.getProperty("user.home") + "/LeisureInsurnace.csv";

        String tempfile = "temp.txt";
        File oldFile = new File(filepath);
        File newfile = new File(tempfile);

        boolean found = false;


        try {
            FileWriter fw = new FileWriter(tempfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext()) {
                personalID = x.next();
                yearlyInsurnacePremium = x.next();
                dateOfCreatedInsurnace = x.next();
                insurnaceAmount = x.next();
                insurnaceConditions = x.next();
                address_Not_Billing = x.next();
                constructionYear = x.next();
                residentialType = x.next();
                constructionMaterial = x.next();
                condition = x.next();
                amountSquareMeters = x.next();
                amountforConstruction = x.next();
                amountForHousehold = x.next();


                if (!address_Not_Billing.equals(searchterm)) {
                    pw.println(personalID + "," + yearlyInsurnacePremium + "," + dateOfCreatedInsurnace + "," + insurnaceAmount + "," + insurnaceConditions + "," + address_Not_Billing + "," +
                            constructionYear + "," + residentialType + "," + constructionMaterial + "," + condition + "," + amountSquareMeters + "," + amountforConstruction
                            + "," + amountForHousehold);
                }

            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newfile.renameTo(dump);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    public static void deleteBoatFromCsv(String searchterm) {


        String filepath = System.getProperty("user.home") + "/boatInsurance.csv";

        String tempfile = "temp.txt";
        File oldFile = new File(filepath);
        File newfile = new File(tempfile);

        boolean found = false;


        try {
            FileWriter fw = new FileWriter(tempfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext()) {
                personalID = x.next();
                yearlyInsurnacePremium = x.next();
                dateOfCreatedInsurnace = x.next();
                insurnaceAmount = x.next();
                insurnaceConditions = x.next();
                owner = x.next();
                registerNr = x.next();
                boatTypeAndModel = x.next();
                lengthInFoot = x.next();
                year = x.next();
                motorTypeAndMotorPower = x.next();


                if (!dateOfCreatedInsurnace.equals(searchterm)) {
                    pw.println(personalID + "," + yearlyInsurnacePremium + "," + dateOfCreatedInsurnace + "," + insurnaceAmount + "," + insurnaceConditions + "," + owner + "," +
                            registerNr + "," + boatTypeAndModel + "," + lengthInFoot + "," + year + "," + motorTypeAndMotorPower);
                }

            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newfile.renameTo(dump);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error");
        }

    }

    public static void deleteTravelFromCsv(String searchterm) {


        String filepath = System.getProperty("user.home") + "/travelInsurnace.csv";

        String tempfile = "temp.txt";
        File oldFile = new File(filepath);
        File newfile = new File(tempfile);

        boolean found = false;


        try {
            FileWriter fw = new FileWriter(tempfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext()) {
                personalID = x.next();
                yearlyInsurnacePremium = x.next();
                dateOfCreatedInsurnace = x.next();
                insurnaceAmount = x.next();
                insurnaceConditions = x.next();
                insurnaceArea = x.next();
                insurnceSum = x.next();



                if (!dateOfCreatedInsurnace.equals(searchterm)) {
                    pw.println(personalID + "," + yearlyInsurnacePremium + "," + dateOfCreatedInsurnace + "," + insurnaceAmount + "," + insurnaceConditions + "," + insurnaceArea + "," +
                            insurnceSum);
                }

            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newfile.renameTo(dump);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error");
        }

    }


    public static void deleteHouseholdFromCsv(String searchterm) {


        String filepath = System.getProperty("user.home") + "/houseInsurance.csv";

        String tempfile = "temp.txt";
        File oldFile = new File(filepath);
        File newfile = new File(tempfile);

        boolean found = false;


        try {
            FileWriter fw = new FileWriter(tempfile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext()) {
                personalID = x.next();
                yearlyInsurnacePremium = x.next();
                dateOfCreatedInsurnace = x.next();
                insurnaceAmount = x.next();
                insurnaceConditions = x.next();
                propertyOwner = x.next();
                yearOfConstruction = x.next();
                residentialType = x.next();
                constructionMaterial = x.next();
                condition = x.next();
                numberOfSquareMeters = x.next();
                insurnceAmountForConstruction = x.next();
                insurnaceAmountForHousehold = x.next();


                if (!dateOfCreatedInsurnace.equals(searchterm)) {
                    pw.println(personalID + "," + yearlyInsurnacePremium + "," + dateOfCreatedInsurnace + "," + insurnaceAmount + "," + insurnaceConditions + "," + propertyOwner + "," +
                            yearOfConstruction + "," + residentialType + "," + constructionMaterial + "," + condition + "," + numberOfSquareMeters + "," + insurnceAmountForConstruction + "," + insurnaceAmountForHousehold);
                }

            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newfile.renameTo(dump);

        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Error");
        }

    }



}
