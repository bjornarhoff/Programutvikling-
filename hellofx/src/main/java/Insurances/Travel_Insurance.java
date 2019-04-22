package Insurances;

import Customer_Controller.Customer;

import java.util.Date;

public class Travel_Insurance extends Insurance {


    private String insuranceArea; // where insurance is valid
    private int insuranceSum;
    private Customer customer;


    // Default Constructor for Travel Insurance.
    public Travel_Insurance(String yearlyInsurancePremium, Date dateOfCreatedInsurance, int insuranceAmount,
                            String insuranceConditions, String insuranceArea, int insuranceSum,
                            Customer_Controller.Customer customer) {

        super(yearlyInsurancePremium, dateOfCreatedInsurance, insuranceAmount, insuranceConditions);
        this.insuranceArea = insuranceArea;
        this.insuranceSum = insuranceSum;
        this.customer = customer;
        customer.customerInsuranceCounter(customer);
    }

    @Override
    public String toString() {
        return  "\nTRAVEL INSURANCE" +
                "\nInsuranceArea: " + insuranceArea +
                "\nInsuranceSum: " + insuranceSum +
                "\n\nOVERALL FOR TRAVEL INSURANCE" + super.toString();
    }

    public void setInsuranceArea(String insuranceArea) {
        this.insuranceArea = insuranceArea;
    }

    public String getInsuranceArea() {
        return this.insuranceArea;
    }


    public void setInsuranceSum(int insuranceSum) {
        this.insuranceSum = insuranceSum;
    }

    public int getInsuranceSum() {
        return this.insuranceSum;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
