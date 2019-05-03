package Serialisering;

import CustomerModell.Customer;
import Damages.Damage_Report;
import Insurances.Insurance;

import java.io.*;

public class Serialization {


    public static void serialiseCustomer(Customer customer, String filepath) {
        try (
                FileOutputStream fos = new FileOutputStream(filepath);
                ObjectOutputStream out = new ObjectOutputStream(fos);
        ) {
            out.writeObject(customer);
            out.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void serialiseInsurance(Insurance insurance, String filepath) {

        try (
                FileOutputStream fos = new FileOutputStream(filepath);
                ObjectOutputStream out = new ObjectOutputStream(fos)
        ) {
            out.writeObject(insurance);
            out.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void serialiseDamageReport(Damage_Report damage_report, String filepath) {

        try (
                FileOutputStream fos = new FileOutputStream(filepath);
                ObjectOutputStream out = new ObjectOutputStream(fos)
        ) {
            out.writeObject(damage_report);
            out.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void writeToFileCustomer(Customer customer, String filepath) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath));
        oos.writeObject(customer);
        oos.flush();
        oos.close();
    }

    public static void writeToFileInsurnace(Insurance insurance, String filepath) throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filepath));
        oos.writeObject(insurance);
        oos.flush();
        oos.close();
    }

    public static void readFile(Customer acustomer ,String filepath) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath));

        acustomer = (Customer) ois.readObject();
        System.out.println(acustomer);
    }

    public static void readFileInsurance(Insurance insurnace, String filepath) throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filepath));

        insurnace = (Insurance) ois.readObject();
        System.out.println(insurnace);
    }
}
