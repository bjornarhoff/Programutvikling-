package Insurances;

import Customer_Controller.Customer;

import java.util.Date;

public class Boat_Insurance extends Data_for_overall_Insurances {


    private String owner;
    private String registerNr;
    private String boatTypeAndMOdel;
    private double lengthInFoot;
    private int year;
    private String motorTypeAndMotorPower;
    private Customer customer;


    public Boat_Insurance(String yearlyInsurancePremium, Date dateOfCreatedInsurance, int insuranceAmount,
                          String insuranceConditions, String owner, String registerNr, String boatTypeAndMOdel,
                          double lengthInFoot, int year, String motorTypeAndMotorPower,
                          Customer_Controller.Customer customer) {

        super(yearlyInsurancePremium, dateOfCreatedInsurance, insuranceAmount, insuranceConditions);
        this.owner = owner;
        this.registerNr = registerNr;
        this.boatTypeAndMOdel = boatTypeAndMOdel;
        this.lengthInFoot = lengthInFoot;
        this.year = year;
        this.motorTypeAndMotorPower = motorTypeAndMotorPower;
        this.customer = customer;
    }

    @Override
    public String toString() {
        return  "\nBOAT INSURANCE" +
                "\nOwner: " + owner +
                "\nRegisterNr: " + registerNr +
                "\nBoatTypeAndMOdel: " + boatTypeAndMOdel +
                "\nLengthInFoot: " + lengthInFoot +
                "\nYear: " + year +
                "\nMotorTypeAndMotorPower: " + motorTypeAndMotorPower +
                "\n\nOVERALL FOR BOAT INSURANCE" + super.toString();
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return this.owner;
    }


    public void setRegisterNr(String registerNr) {
        this.registerNr = registerNr;
    }

    public String getRegisterNr() {
        return this.registerNr;
    }


    public void setBoatTypeAndMOdel(String boatTypeAndMOdel) {
        this.boatTypeAndMOdel = boatTypeAndMOdel;
    }

    public String getBoatTypeAndMOdel() {
        return this.boatTypeAndMOdel;
    }


    public void setLengthInFoot(double lengthInFoot) {
        this.lengthInFoot = lengthInFoot;
    }

    public double getLengthInFoot() {
        return this.lengthInFoot;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getYear() {
        return this.year;
    }


    public void setMotorTypeAndMotorPower(String motorTypeAndMotorPower) {
        this.motorTypeAndMotorPower = motorTypeAndMotorPower;
    }

    public String getMotorTypeAndMotorPower() {
        return this.motorTypeAndMotorPower;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
