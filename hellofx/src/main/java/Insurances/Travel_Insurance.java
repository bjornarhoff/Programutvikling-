package Insurances;

import CustomerModell.Customer;

import java.util.Date;

public class Travel_Insurance extends Insurance {


    private String insuranceArea; // where insurance is valid
    private int insuranceSum;


    // Default Constructor for Travel Insurance.
    public Travel_Insurance(Customer customer, String yearlyInsurancePremium, Date dateOfCreatedInsurance, int insuranceAmount,
                            String insuranceConditions, String insuranceArea, int insuranceSum) {

        super(customer, yearlyInsurancePremium, dateOfCreatedInsurance, insuranceAmount, insuranceConditions);
        this.insuranceArea = insuranceArea;
        this.insuranceSum = insuranceSum;
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



}
