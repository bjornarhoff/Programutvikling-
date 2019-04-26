package Serialisering;
import CustomerModell.Customer;
import Damages.Damage_Report;

import javax.swing.*;
import java.io.*;
import java.nio.Buffer;
import java.util.Date;
import java.util.Scanner;

public class SearchAndReadFromCSV {

    private static Scanner x;
    private static BufferedReader y;


   /* public static void main(String[] args) {
        String filepath = "trying.txt";
        String searchTerm = "4444";

        readRecord(searchTerm, filepath);
    }*/


    public static void readRecordCustomer(String searchTerm, String filepath){

        boolean found = false;
        String personalID = "";
        String name = "";
        String age = "";
        String phoneNumber = "";
        String email = "";
        String date = "";
        String billingAddress = "";
        String allCustomerInsurance = "";
        String unpaidReplacements = "";

        try {
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while(x.hasNext() && !found){
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
                        || allCustomerInsurance.equals(searchTerm) || unpaidReplacements.equals(searchTerm)){
                    found = true;
                }
            }

            if (found){
                System.out.println("PersonalID: " + personalID + "Name: " + name + "Age: " + age + "PhoneNumber: " + phoneNumber +
                        "Email: "+ email  + "Date: " + date + "BillingAddress: " + billingAddress + "AllCustomerInsurances: "
                        + allCustomerInsurance + "UnpaidReplacements: " + unpaidReplacements);
            }
            else{
                System.out.println("Search term not found!");
            }
        }
        catch(Exception e){

        }

    }

    public static void deleteRecordFromCsv(String searchterm, String filepath){



        String tempfile = "temp.txt";
        File oldFile = new File(filepath);
        File newfile = new File(tempfile);

        boolean found = false;
        String personalID = "";
        String name = "";
        String age = "";
        String phoneNumber = "";
         String email = "";
        String date = "";
        String billingAddress = "";
        String allCustomerInsurance = "";
        String unpaidReplacements = "";

        try{
            FileWriter fw = new FileWriter(tempfile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");

            while(x.hasNext()){
                personalID = x.next();
                name = x.next();
                age = x.next();
                phoneNumber = x.next();
                email = x.next();
                date = x.next();
                billingAddress = x.next();
                allCustomerInsurance = x.next();
                unpaidReplacements = x.next();

                if(!personalID.equals(searchterm)) {
                    pw.println(personalID + ", " + name);
                }

            }
            x.close();
            pw.flush();
            pw.close();
            oldFile.delete();
            File dump = new File(filepath);
            newfile.renameTo(dump);


        }
        catch(Exception e ){

            JOptionPane.showMessageDialog(null, "Error");
        }

    }



}
