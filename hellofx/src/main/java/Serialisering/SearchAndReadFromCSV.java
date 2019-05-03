package Serialisering;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class SearchAndReadFromCSV {

    // Customer
    private static String personalID = "";
    private static String insuranceNr = "";
    private static String name = "";
    private static String age = "";
    private static String phoneNumber = "";
    private static String email = "";
    private static String date = "";
    private static String billingAddress = "";
    private static String allCustomerInsurance = "";
    private static String unpaidReplacements = "";

    // DamageReport
    private static String DateofDamage = "";
    private static String DamageNr = "";
    private static String DamageType = "";

    private static String DamageDescription = "";
    private static String ContactOfWitnesses = "";
    private static String TaxOfDamage = "";
    private static String unpaid = "";

    // Overall Insurance
    private static String yearlyInsurnacePremium = "";
    private static String dateOfCreatedInsurnace = "";
    private static String insurnaceAmount = "";
    private static String insurnaceConditions = "";

    // Travel Insurance
    private static String insurnaceArea = "";
    private static String insurnceSum = "";

    // Household Insurance
    private static String propertyOwner = "";
    private static String yearOfConstruction = "";
    private static String residentialType = "";
    private static String constructionMaterial = "";
    private static String condition = "";
    private static String numberOfSquareMeters = "";
    private static String insurnceAmountForConstruction = "";
    private static String insurnaceAmountForHousehold = "";

    // Boat Insurnace
    private static String owner = "";
    private static String registerNr = "";
    private static String boatTypeAndModel = "";
    private static String lengthInFoot = "";
    private static String year = "";
    private static String motorTypeAndMotorPower = "";

    // Leisure Insurance
    private static String address_Not_Billing = "";
    private static String constructionYear = "";
    private static String amountSquareMeters = "";
    private static String amountforConstruction = "";
    private static String amountForHousehold = "";

    private static Scanner x;

    /**
     * Method that deletes the Customer object from the csv file
     * @param searchterm
     */
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
    public static void deleteDamageReportFromCsv(String searchterm) throws IOException {

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

            while (x.hasNextLine()) {
                String[] damage = x.nextLine().split(",");
                if (!damage[1].equals(searchterm)) {
                    pw.println(damage[0] + "," + damage[1] + "," + damage[2] + "," + damage[3] + "," + damage[4] + "," + damage[5] + "," +
                            damage[6] + "," + damage[7]);
                }
               /* if(!damage[0].equals(searchterm)) {
                    pw.println(damage[0] + "," + damage[1] + "," + damage[2] + "," + damage[3] + "," + damage[4] + "," + damage[5] + "," +
                            damage[6] + "," + damage[7]);}

                */
            }

            /*while (x.hasNext()) {


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

             */


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


            while (x.hasNextLine()) {
                String[] leisure = x.nextLine().split(",");
                if (!leisure[5].equals(searchterm)) {
                    pw.println(leisure[0] + "," + leisure[1] + "," + leisure[2] + "," + leisure[3] + "," + leisure[4] + "," + leisure[5] + "," +
                            leisure[6] + "," + leisure[7] + "," + leisure[8]+ "," + leisure[9]+ "," + leisure[10]+ "," + leisure[11]+ "," + leisure[12]);
                }
            }
            /*
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

             */


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

            while (x.hasNextLine()) {
                String[] boat = x.nextLine().split(",");
                if (!boat[2].equals(searchterm)) {
                    pw.println(boat[0] + "," + boat[1] + "," + boat[2] + "," + boat[3] + "," + boat[4] + "," + boat[5] + "," +
                            boat[6] + "," + boat[7] + "," + boat[8]+ "," + boat[9]+ "," + boat[10]);
                }
            }

           /* while (x.hasNext()) {
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

            */

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

            while (x.hasNextLine()) {
                String[] travel = x.nextLine().split(",");
                if (!travel[2].equals(searchterm)) {
                    pw.println(travel[0] + "," + travel[1] + "," + travel[2] + "," + travel[3] + "," + travel[4] + "," + travel[5]);
                }
            }

           /* while (x.hasNext()) {
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

            */
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


            while (x.hasNextLine()) {
                String[] house = x.nextLine().split(",");
                if (!house[2].equals(searchterm)) {
                    pw.println(house[0] + "," + house[1] + "," + house[2] + "," + house[3] + "," + house[4] + "," + house[5] + "," +
                            house[6] + "," + house[7] + "," + house[8]+ "," + house[9]+ "," + house[10]+ "," + house[11]+ "," + house[12]);
                }
            }

            /*while (x.hasNext()) {
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

             */
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
