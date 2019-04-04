package Insurances;
import Customer_Controller.Customer;

import java.util.Date;

public class House_Household_Insurance extends Data_for_overall_Insurances {

    private String propertyOwner;
    private int yearOfConstruction;
    private String residentialType;
    private String constructionMaterial;
    private String condition;
    private double numberOfSquareMeters;
    private int insuranceAmountForConstruction;
    private int insuranceAmountForHousehold;
    private Customer customer;



    // Default Constructor for House Hold Insurances.
    public House_Household_Insurance(String yearlyInsurancePremium, Date dateOfCreatedInsurance, int insuranceAmount,
                                     String insuranceConditions, String propertyOwner, int yearOfConstruction,
                                     String residentialType, String constructionMaterial, String condition,
                                     double numberOfSquareMeters, int insuranceAmountForConstruction,
                                     int insuranceAmountForHousehold, Customer_Controller.Customer customer) {

        super(yearlyInsurancePremium, dateOfCreatedInsurance, insuranceAmount, insuranceConditions);
        this.propertyOwner = propertyOwner;
        this.yearOfConstruction = yearOfConstruction;
        this.residentialType = residentialType;
        this.constructionMaterial = constructionMaterial;
        this.condition = condition;
        this.numberOfSquareMeters = numberOfSquareMeters;
        this.insuranceAmountForConstruction = insuranceAmountForConstruction;
        this.insuranceAmountForHousehold = insuranceAmountForHousehold;
        this.customer = customer;
        customer.CustomerInsuranceCounter(customer);

    }

    @Override
    public String toString() {
        return  "\nHOUSEHOLD INSURANCE" +
                "\nPropertyOwner: " + propertyOwner +
                "\nYearOfConstruction: " + yearOfConstruction +
                "\nResidentialType: " + residentialType +
                "\nConstructionMaterial: " + constructionMaterial +
                "\nCondition: " + condition +
                "\nNumberOfSquareMeters: " + numberOfSquareMeters +
                "\nInsuranceAmountForConstruction: " + insuranceAmountForConstruction +
                "\nInsuranceAmountForHousehold: " + insuranceAmountForHousehold +
                "\n\nOverall for Household Insurance " + super.toString();
    }

    public void setPropertyOwner(String propertyOwner) {
        this.propertyOwner = propertyOwner;
    }

    public String getPropertyOwner() {
        return this.propertyOwner;
    }


    public void setYearOfConstruction(int yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    public int getYearOfConstruction() {
        return this.yearOfConstruction;
    }


    public void setResidentialType(String residentialType) {
        this.residentialType = residentialType;
    }

    public String getResidentialType() {
        return this.residentialType;
    }


    public void setConstructionMaterial(String constructionMaterial) {
        this.constructionMaterial = constructionMaterial;
    }

    public String getConstructionMaterial() {
        return this.constructionMaterial;
    }


    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getCondition() {
        return this.condition;
    }


    public void setNumberOfSquareMeters(double numberOfSquareMeters) {
        this.numberOfSquareMeters = numberOfSquareMeters;
    }

    public double getNumberOfSquareMeters() {
        return this.numberOfSquareMeters;
    }


    public void setInsuranceAmountForConstruction(int insuranceAmountForConstruction) {
        this.insuranceAmountForConstruction = insuranceAmountForConstruction;
    }

    public int getInsuranceAmountForConstruction() {
        return this.insuranceAmountForConstruction;
    }


    public void setInsuranceAmountForHousehold(int insuranceAmountForHousehold) {
        this.insuranceAmountForHousehold = insuranceAmountForHousehold;
    }

    public int getInsuranceAmountForHousehold() {
        return this.insuranceAmountForHousehold;
    }

    public Customer getCustomer() {
        return this.customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
