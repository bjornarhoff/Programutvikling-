package FileManagement;

import Customer_Controller.Customer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;



public class CsvWriter {

    // Parameters used in CSV file
    private static final String COMMA = ",";
    private static final String HEADER = "InsuranceNumber,PersonalId,Name,Phonenumber,Email,Date,Adress,Unpaid";
    private static final String NEW_LINE = "\n";
    private static ArrayList<Customer> customers = new ArrayList<>();




    // Method for create CSV file -> return file
    public static File createFileCSV(){
        File file = new File(System.getProperty("user.home")+"/customer2.csv");

        // Checks whether the file exists or not
        try {
            if (file.createNewFile()){
                System.out.println("File created!");
            } else {
                System.out.println("File already exists");
            }
        }catch (IOException e){
            System.err.println("Something wrong!!");
        }
        return file;
    }

    // Method for write customer object to CSV file
    public static void writeObjectToCSV (Customer aCustomer) {
        FileWriter fileWriter = null;
        customers.add(aCustomer);

        try {
            fileWriter = new FileWriter(createFileCSV());
            // Write to header
            fileWriter.append(HEADER);
            // New line after header
            fileWriter.append(NEW_LINE);

            // Loops over arraylist -> Retrieving parameters
            for (Customer customer : customers){
            fileWriter.append(String.valueOf(customer.getInsuranceNr()));
            fileWriter.append(COMMA);
            fileWriter.append(customer.getPersonalID());
            fileWriter.append(COMMA);
            fileWriter.append(customer.getName());
            fileWriter.append(COMMA);
            fileWriter.append(customer.getPhoneNumber());
            fileWriter.append(COMMA);
            fileWriter.append(customer.getEmail());
            fileWriter.append(COMMA);
            fileWriter.append(String.valueOf(new Date()));
            fileWriter.append(COMMA);
            fileWriter.append(customer.getBillingAddress());
            fileWriter.append(COMMA);
            fileWriter.append(String.valueOf(customer.getUnpaidReplacements()));
            fileWriter.append(NEW_LINE);
            }
            // If something went wrong while creating file
        } catch (IOException e) {
            System.out.println("csv file create error");
            e.printStackTrace();
        }
        // finally code -> always executes when the try block exits
        finally {

            try {
                if (fileWriter != null) {
                    // Closes the stream, flushing it first.
                    fileWriter.flush();
                    fileWriter.close();
                }
                // Prints out arraylist
                System.out.println(customers.toString());

            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter");
                e.printStackTrace();
            }
        }
    }
}
