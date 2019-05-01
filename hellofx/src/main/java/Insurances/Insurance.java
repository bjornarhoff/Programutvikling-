package Insurances;

import CustomerModell.Customer;

import java.io.Serializable;

public abstract class Insurance implements Serializable {


    private static final long serialVersionUID = 2;
    private Customer customer;
    private String yearlyInsurancePremium;
    private String dateOfCreatedInsurance;
    private int insuranceAmount;
    private String insuranceConditions;


    /**
     * Default abstract Constructor for Insurances
     * @param customer
     * @param yearlyInsurancePremium
     * @param dateOfCreatedInsurance
     * @param insuranceAmount
     * @param insuranceConditions
     */
    public Insurance(Customer customer, String yearlyInsurancePremium, String dateOfCreatedInsurance, int insuranceAmount,
                     String insuranceConditions) {
        this.customer = customer;
        this.yearlyInsurancePremium = yearlyInsurancePremium;
        this.dateOfCreatedInsurance = dateOfCreatedInsurance;
        this.insuranceAmount = insuranceAmount;
        this.insuranceConditions = insuranceConditions;
    }

    /**
     * @return Insurance to String format
     */
    @Override
    public String toString() {
        return  "\nYearlyInsurancePremium: " + yearlyInsurancePremium +
                "\nDateOfCreatedInsurance: " + dateOfCreatedInsurance +
                "\ninsuranceAmount: " + insuranceAmount +
                "\nInsuranceConditions: " + insuranceConditions;
    }

    /**
     * @return Insurance object to csv String format
     */
    public String toCSVStringInsurnce() {
        return customer.getPersonalID() + "," +
                yearlyInsurancePremium + "," +
                dateOfCreatedInsurance + "," +
                String.valueOf(insuranceAmount) + "," +
                insuranceConditions;
    }

    /**
     * @param yearlyInsurancePremium
     */
    public void setYearlyInsurancePremium(String yearlyInsurancePremium) {
        this.yearlyInsurancePremium = yearlyInsurancePremium;
    }

    /**
     * @return yearlyInsurancePremium
     */
    public String getYearlyInsurancePremium() {
        return this.yearlyInsurancePremium;
    }

    /**
     * @param dateOfCreatedInsurance
     */
    public void setDateOfCreatedInsurance(String dateOfCreatedInsurance) {
        this.dateOfCreatedInsurance = dateOfCreatedInsurance;
    }

    /**
     * @return dateOfCreatedInsurance
     */
    public String getDateOfCreatedInsurance() {
        return this.dateOfCreatedInsurance;
    }

    /**
     * @param insuranceAmount
     */
    public void setInsuranceAmount(int insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    /**
     * @return insuranceAmount
     */
    public int getInsuranceAmount() {
        return this.insuranceAmount;
    }

    /**
     * @param insuranceConditions
     */
    public void setInsuranceConditions(String insuranceConditions) {
        this.insuranceConditions = insuranceConditions;
    }

    /**
     * @return insuranceConditions
     */
    public String getInsuranceConditions() {
        return this.insuranceConditions;
    }

    /**
     * @return customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
