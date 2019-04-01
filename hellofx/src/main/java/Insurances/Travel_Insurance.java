package Insurances;

import Customer_Controller.Customer;

import java.util.Date;

public class Travel_Insurance extends Data_for_overall_Insurances {


    private String InsuranceArea; // where insurance is valid
    private int InsuranceSum;
    private Customer Customer;


    // Default Constructor for Travel Insurance.
    public Travel_Insurance(String yearlyInsurancePremium, Date dateOfCreatedInsurance, int insuranceAmount,
                            String insuranceConditions, String insuranceArea, int insuranceSum,
                            Customer_Controller.Customer customer) {

        super(yearlyInsurancePremium, dateOfCreatedInsurance, insuranceAmount, insuranceConditions);
        this.InsuranceArea = insuranceArea;
        this.InsuranceSum = insuranceSum;
        this.Customer = customer;
    }

    public void setInsuranceArea(String insuranceArea) {
        InsuranceArea = insuranceArea;
    }

    public String getInsuranceArea() {
        return InsuranceArea;
    }


    public void setInsuranceSum(int insuranceSum) {
        InsuranceSum = insuranceSum;
    }

    public int getInsuranceSum() {
        return InsuranceSum;
    }

    public Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(Customer customer) {
        Customer = customer;
    }
}
