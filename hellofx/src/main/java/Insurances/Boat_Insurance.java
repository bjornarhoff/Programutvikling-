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


    /**
     * Default Constructor for Boat Object
     * @param customer
     * @param yearlyInsurancePremium
     * @param dateOfCreatedInsurance
     * @param insuranceAmount
     * @param insuranceConditions
     * @param owner
     * @param registerNr
     * @param boatTypeAndModel
     * @param lengthInFoot
     * @param year
     * @param motorTypeAndMotorPower
     */
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

    /**
     * @return Boat object in String
     */
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

    /**
     * toString method for csv file
     * @return Boat object
     */
    public String toCSVStringBoat(){
        return super.toCSVStringInsurnce() + "," +
                owner + "," +
                String.valueOf(registerNr) + "," +
                boatTypeAndModel + "," +
                lengthInFoot + "," +
                String.valueOf(year) + "," +
                motorTypeAndMotorPower;

    }

    /**
     * @param owner
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }

    /**
     *
     * @return owner
     */
    public String getOwner() {
        return this.owner;
    }

    /**
     * @param registerNr
     */
    public void setRegisterNr(String registerNr) {
        this.registerNr = registerNr;
    }

    /**
     * @return registerNr
     */
    public String getRegisterNr() {
        return this.registerNr;
    }

    /**
     * @param boatTypeAndModel
     */
    public void setBoatTypeAndModel(String boatTypeAndModel) {
        this.boatTypeAndModel = boatTypeAndModel;
    }

    /**
     * @return boatTypeAndModel
     */
    public String getBoatTypeAndModel() {
        return this.boatTypeAndModel;
    }

    /**
     * @param lengthInFoot
     */
    public void setLengthInFoot(double lengthInFoot) {
        this.lengthInFoot = lengthInFoot;
    }

    /**
     * @return lengthInFoot
     */
    public double getLengthInFoot() {
        return this.lengthInFoot;
    }

    /**
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return year
     */
    public int getYear() {
        return this.year;
    }

    /**
     * @param motorTypeAndMotorPower
     */
    public void setMotorTypeAndMotorPower(String motorTypeAndMotorPower) {
        this.motorTypeAndMotorPower = motorTypeAndMotorPower;
    }

    /**
     * @return motorTypeAndPower
     */
    public String getMotorTypeAndMotorPower() {
        return this.motorTypeAndMotorPower;
    }

}
