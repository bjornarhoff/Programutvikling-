package Insurances;

import Customer_Controller.Customer;

import java.util.Date;

public class Boat_Insurance extends Data_for_overall_Insurances {


    private String Owner;
    private int RegisterNr;
    private String BoatTypeAndMOdel;
    private double LengthInFoot;
    private int Year;
    private String MotorTypeAndMotorPower;
    private Customer Customer;


    public Boat_Insurance(String yearlyInsurancePremium, Date dateOfCreatedInsurance, int insuranceAmount,
                          String insuranceConditions, String owner, int registerNr, String boatTypeAndMOdel,
                          double lengthInFoot, int year, String motorTypeAndMotorPower,
                          Customer_Controller.Customer customer) {

        super(yearlyInsurancePremium, dateOfCreatedInsurance, insuranceAmount, insuranceConditions);
        this.Owner = owner;
        this.RegisterNr = registerNr;
        this.BoatTypeAndMOdel = boatTypeAndMOdel;
        this.LengthInFoot = lengthInFoot;
        this.Year = year;
        this.MotorTypeAndMotorPower = motorTypeAndMotorPower;
        this.Customer = customer;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getOwner() {
        return Owner;
    }


    public void setRegisterNr(int registerNr) {
        RegisterNr = registerNr;
    }

    public int getRegisterNr() {
        return RegisterNr;
    }


    public void setBoatTypeAndMOdel(String boatTypeAndMOdel) {
        BoatTypeAndMOdel = boatTypeAndMOdel;
    }

    public String getBoatTypeAndMOdel() {
        return BoatTypeAndMOdel;
    }


    public void setLengthInFoot(double lengthInFoot) {
        LengthInFoot = lengthInFoot;
    }

    public double getLengthInFoot() {
        return LengthInFoot;
    }


    public void setYear(int year) {
        Year = year;
    }

    public int getYear() {
        return Year;
    }


    public void setMotorTypeAndMotorPower(String motorTypeAndMotorPower) {
        MotorTypeAndMotorPower = motorTypeAndMotorPower;
    }

    public String getMotorTypeAndMotorPower() {
        return MotorTypeAndMotorPower;
    }

    public Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(Customer customer) {
        Customer = customer;
    }
}
