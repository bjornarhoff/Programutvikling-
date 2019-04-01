package Insurances;

import Customer_Controller.Customer;

import java.util.Date;

public class Boat_Insurance extends Data_for_overall_Insurances {


    private String Owner;
    private String RegisterNr;
    private String BoatTypeAndMOdel;
    private double LengthInFoot;
    private int Year;
    private String MotorTypeAndMotorPower;
    private Customer Customer;


    public Boat_Insurance(String yearlyInsurancePremium, Date dateOfCreatedInsurance, int insuranceAmount,
                          String insuranceConditions, String owner, String registerNr, String boatTypeAndMOdel,
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

    @Override
    public String toString() {
        return "\nBoat_Insurance{" +
                "Owner='" + Owner + '\'' +
                ", RegisterNr=" + RegisterNr +
                ", BoatTypeAndMOdel='" + BoatTypeAndMOdel + '\'' +
                ", LengthInFoot=" + LengthInFoot +
                ", Year=" + Year +
                ", MotorTypeAndMotorPower='" + MotorTypeAndMotorPower + '\'' +
                ", Customer=" + Customer +
                "} " + super.toString();
    }

    public void setOwner(String owner) {
        this.Owner = owner;
    }

    public String getOwner() {
        return this.Owner;
    }


    public void setRegisterNr(String registerNr) {
        this.RegisterNr = registerNr;
    }

    public String getRegisterNr() {
        return this.RegisterNr;
    }


    public void setBoatTypeAndMOdel(String boatTypeAndMOdel) {
        this.BoatTypeAndMOdel = boatTypeAndMOdel;
    }

    public String getBoatTypeAndMOdel() {
        return this.BoatTypeAndMOdel;
    }


    public void setLengthInFoot(double lengthInFoot) {
        this.LengthInFoot = lengthInFoot;
    }

    public double getLengthInFoot() {
        return this.LengthInFoot;
    }


    public void setYear(int year) {
        this.Year = year;
    }

    public int getYear() {
        return this.Year;
    }


    public void setMotorTypeAndMotorPower(String motorTypeAndMotorPower) {
        this.MotorTypeAndMotorPower = motorTypeAndMotorPower;
    }

    public String getMotorTypeAndMotorPower() {
        return this.MotorTypeAndMotorPower;
    }

    public Customer getCustomer() {
        return this.Customer;
    }

    public void setCustomer(Customer customer) {
        this.Customer = customer;
    }
}
