package FileManagement;

import CustomerModell.Customer;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;



public class CsvWriter {

    // Parameters used in CSV file
    private static final String COMMA = ",";
    private static final String HEADER = "PersonalId,InsuranceNumber,Name,Phonenumber,Email,Date,Adress,AllCustomerInsurance,DamageReport,UnpaidReplacements";
    private static final String NEW_LINE = "\n";
    private static boolean fileExists = false;


    // Method for create CSV file -> return file
    public static File createFileCSV(){
        File file = new File(System.getProperty("user.home")+"/customer2.csv");

        // Checks whether the file exists or not
        try {
            if (file.createNewFile()){
                fileExists = false;
                System.out.println("File created!");
            } else {
                fileExists = true;
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

        try {
            fileWriter = new FileWriter(createFileCSV(), true);
            if (!fileExists){
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
            fileWriter.append(COMMA);
            fileWriter.append(String.valueOf(aCustomer.getAllCustomerInsurance()));
            fileWriter.append(COMMA);
            fileWriter.append(String.valueOf(aCustomer.getDamageReport()));
            fileWriter.append(COMMA);
            fileWriter.append(String.valueOf(aCustomer.getUnpaidReplacements()));
            fileWriter.append(NEW_LINE);

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
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter");
                e.printStackTrace();
            }
        }
    }
}
