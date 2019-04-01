package Test;

import Customer_Controller.Customer;
import Insurances.Boat_Insurance;

import java.util.Date;

public class Test {

    public static void main(String[] args) {

        Customer customer = new Customer("07029633996", 2, "Cato Akay", new Date(),
                "Goteborggata 26", "2", "Testing", 3900);
        Boat_Insurance boat_insurance = new Boat_Insurance("10%", new Date(), 4500,
                "Husk betaling!", "Sven", "CV45784", "BMW 44",
        2423.2, 2012, "V8 200HP", customer);

        System.out.println(boat_insurance.toString());

    }

}
