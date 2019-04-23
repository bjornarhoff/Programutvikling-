package Insurances;

import CustomerModell.Customer;

import java.io.Serializable;
import java.util.Date;

public abstract class Insurance implements Serializable {


    private static final long serialVersionUID = 2;
    private Customer customer;
    private String yearlyInsurancePremium;
    private Date dateOfCreatedInsurance;
    private int insuranceAmount;
    private String insuranceConditions;



    // Default Constructor for Overall Insurances
    public Insurance(Customer customer, String yearlyInsurancePremium, Date dateOfCreatedInsurance, int insuranceAmount,
                     String insuranceConditions) {
        this.customer = customer;
        this.yearlyInsurancePremium = yearlyInsurancePremium;
        this.dateOfCreatedInsurance = dateOfCreatedInsurance;
        this.insuranceAmount = insuranceAmount;
        this.insuranceConditions = insuranceConditions;
    }

    @Override
    public String toString() {
        return  "\nYearlyInsurancePremium: " + yearlyInsurancePremium +
                "\nDateOfCreatedInsurance: " + dateOfCreatedInsurance +
                "\nInsuranceAmount: " + insuranceAmount +
                "\nInsuranceConditions: " + insuranceConditions;
    }

    public void setYearlyInsurancePremium(String yearlyInsurancePremium) {
        this.yearlyInsurancePremium = yearlyInsurancePremium;
    }

    public String getYearlyInsurancePremium() {
        return this.yearlyInsurancePremium;
    }


    public void setDateOfCreatedInsurance(Date dateOfCreatedInsurance) {
        this.dateOfCreatedInsurance = dateOfCreatedInsurance;
    }

    public Date getDateOfCreatedInsurance() {
        return this.dateOfCreatedInsurance;
    }


    public void setInsuranceAmount(int insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public int getInsuranceAmount() {
        return this.insuranceAmount;
    }


    public void setInsuranceConditions(String insuranceConditions) {
        this.insuranceConditions = insuranceConditions;
    }

    public String getInsuranceConditions() {
        return this.insuranceConditions;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
