package Serialisering;

import javax.swing.*;
import java.io.*;
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

    String filepath = "customer2.csv";


    public static void checknextCustomer() {
        personalID = x.next();
        name = x.next();
        phoneNumber = x.next();
        email = x.next();
        date = x.next();
        billingAddress = x.next();
        allCustomerInsurance = x.next();
        unpaidReplacements = x.next();
    }

    public static void editCustomerRecord(String filepath, String editTerm, String newPersonalID, String newName, String newAge, String newPhone, String newEmail,
                                          String newDate, String newBilling, String newAllInsurance, String newUnpaid) {
        String tempFile = "temp.txt";
        File oldFile = new File(filepath);
        File newFile = new File(tempFile);

        try {
            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while (x.hasNext()) {
                checknextCustomer();

                if (personalID.equals(editTerm)) {
                    pw.println(newPersonalID + ", " + newName + ", " + newAge + "," + newPhone +
                            "," + newEmail + "," + newDate + "," + newBilling + ","
                            + newAllInsurance + "," + newUnpaid);
                } else {
                    pw.println(personalID + ", " + name + ", " + age + "," + phoneNumber +
                            "," + email + "," + date + "," + billingAddress + ","
                            + allCustomerInsurance + "," + unpaidReplacements);
                }
            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newFile.renameTo(dump);

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

    /**
     * Method that deletes the Damage Report from the csv file with the matching searchterm
     *
     * @param searchterm
     */
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

            System.err.println("customer without insurance ");
        }

    }

    /**
     * Method that deltes the Leisure object from the csv file with the matching searchterm
     *
     * @param searchterm
     */
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

            System.err.println("customer without insurance ");
        }

    }

    /**
     * Method that deletes the Boat object from the csv file with the matching searchterm
     *
     * @param searchterm
     */
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

            System.err.println("customer without insurance ");
        }

    }

    /**
     * Method that deletes the Travel object from the csv with the matching searchterm
     *
     * @param searchterm
     */
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
            System.err.println("customer without insurance ");
        }

    }


    /**
     * Method that deletes a Household object from the csv file with the matching searchterm
     *
     * @param searchterm
     */
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

            System.err.println("customer without insurance ");
        }

    }
}
