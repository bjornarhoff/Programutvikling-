package Test;

import Customer_Controller.Customer;
import Insurances.Boat_Insurance;
import Insurances.House_Household_Insurance;
import Insurances.Leisure_Insurance;
import Insurances.Travel_Insurance;

import java.util.Date;

public class Test {

    public static void main(String[] args) {

        Customer customer = new Customer("07029633996", 2, "Cato Akay", new Date(),
                "Goteborggata 26", "2", "Testing", 3900);

        Boat_Insurance boat_insurance = new Boat_Insurance("10%", new Date(), 4500,
                "Husk betaling!", "Sven", "CV45784", "BMW 44",
        2423.2, 2012, "V8 200HP", customer);

        House_Household_Insurance house_household_insurance = new House_Household_Insurance("25%",
                new Date(), 3, "Betal", "Bjornar", 3,
                "Innbo", "Tre", "Bra", 25.5,
                2500, 3000, customer);
        Leisure_Insurance leisure_insurance = new Leisure_Insurance("30%", new Date(),
                7, "Betal mer!", "Sersjant Dohlies Veg 17 ",
                2020, "Hus", "Tre og mur", "Best",
                200, 10000, 4000, customer);
        Travel_Insurance travel_insurance = new Travel_Insurance("60%", new Date(),
                120, "Bare betal", "EU", 350, customer);

        System.out.println(customer.toString());
        System.out.println(boat_insurance.toString());
        System.out.println(house_household_insurance.toString());
        System.out.println(leisure_insurance.toString());
        System.out.println(travel_insurance.toString());
    }
}
