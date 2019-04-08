package FileManagement;

import Customer_Controller.Customer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CsvWriter {

    // Used in CSV file
    private static final String COMMA = ",";
    private static final String HEADER = "Id,InsuranceNumber,Name,Phonenumber,Email,Date,Adress,Unpaid";
    private static final String NEW_LINE = "\n";




    public static void writeCsv (String fileName) {
        Customer cato = new Customer("112121","Cato Akay","123455","catoboy@oslomet.no", new Date(),"Dal",22222);
        Customer cato2 = new Customer("112121","Cato Akay","123455","catoboy@oslomet.no", new Date(),"Dal",22222);
        Customer cato3 = new Customer("112121","Cato Akay","123455","catoboy@oslomet.no", new Date(),"Dal",22222);

        ArrayList<Customer> customerList = new ArrayList();
        customerList.add(cato);
        customerList.add(cato2);
        customerList.add(cato3);

        // Creates File Writer
        FileWriter fileWriter = null;


        try {
            fileWriter = new FileWriter(fileName);
            // Write to header
            fileWriter.append(HEADER.toString());
            // New line after header
            fileWriter.append(NEW_LINE);



            for(Customer customer : customerList) {
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

            System.out.println("CSV files created");


        } catch (IOException e) {
            System.out.println("csv file create error");
            e.printStackTrace();
        }

        finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter");
                e.printStackTrace();
            }
        }
    }
}
