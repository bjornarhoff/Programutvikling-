package Serialisering;

import CustomerModell.Customer;
import Insurances.Insurance;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialization {


    public static void serialiseCustomer(Customer customer){


        String filepath = "Customers.jobj";
        try (
                FileOutputStream fos = new FileOutputStream(filepath);
                ObjectOutputStream out = new ObjectOutputStream(fos);
        ) {
            out.writeObject(customer);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void serialiseInsurance(Insurance insurance){


        String filepath = "Insurances.jobj";
        try (
                FileOutputStream fos = new FileOutputStream(filepath);
                ObjectOutputStream out = new ObjectOutputStream(fos);
        ) {
            out.writeObject(insurance);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
