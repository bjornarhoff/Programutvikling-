package Insurances;

import CustomerModell.Customer;

import java.util.Date;

public class Boat_Insurance extends Insurance {


    private String owner;
    private String registerNr;
    private String boatTypeAndModel;
    private double lengthInFoot;
    private int year;
    private String motorTypeAndMotorPower;


    public Boat_Insurance(Customer customer, String yearlyInsurancePremium, String dateOfCreatedInsurance, int insuranceAmount,
                          String insuranceConditions, String owner, String registerNr, String boatTypeAndModel,
                          double lengthInFoot, int year, String motorTypeAndMotorPower) {

        super(customer, yearlyInsurancePremium, dateOfCreatedInsurance, insuranceAmount, insuranceConditions);
        this.owner = owner;
        this.registerNr = registerNr;
        this.boatTypeAndModel = boatTypeAndModel;
        this.lengthInFoot = lengthInFoot;
        this.year = year;
        this.motorTypeAndMotorPower = motorTypeAndMotorPower;
        customer.customerInsuranceCounter(customer);
    }

    @Override
    public String toString() {
        return  "\nBOAT INSURANCE" +
                "\nOwner: " + owner +
                "\nRegisterNr: " + registerNr +
                "\nBoatTypeAndMOdel: " + boatTypeAndModel +
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


    public void setBoatTypeAndModel(String boatTypeAndModel) {
        this.boatTypeAndModel = boatTypeAndModel;
    }

    public String getBoatTypeAndModel() {
        return this.boatTypeAndModel;
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

}
