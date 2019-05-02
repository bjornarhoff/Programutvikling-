package Serialisering;

import CustomerModell.Customer;
import Insurances.Insurance;

import java.io.*;

public class Serialization {


    public static void serialiseCustomer(Customer customer, String filepath) {
        try (
                FileOutputStream fos = new FileOutputStream(filepath);
                ObjectOutputStream out = new ObjectOutputStream(fos);
        ) {
            out.writeObject(customer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void serialiseInsurance(Insurance insurance, String filepath) {

        try (
                FileOutputStream fos = new FileOutputStream(filepath);
                ObjectOutputStream out = new ObjectOutputStream(fos)
        ) {
            out.writeObject(insurance);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(Customer customer, String filepath) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath + ".jobj"));

        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void readFile(Insurance insurance, String filepath) throws IOException, ClassNotFoundException {
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath + ".jobj"));

            insurance = (Insurance) ois.readObject();
            System.out.println(insurance);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public static void readFileInsurance(Insurance insurnace, String filepath) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath));

        insurnace = (Insurance) ois.readObject();
        System.out.println(insurnace);
    }
}
