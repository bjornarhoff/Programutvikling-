package Insurances;
import Customer_Controller.Customer;

import java.util.Date;

public class House_Household_Insurance extends Data_for_overall_Insurances {

    private String PropertyOwner;
    private int YearOfConstruction;
    private String ResidentialType;
    private String ConstructionMaterial;
    private String Condition;
    private double NumberOfSquareMeters;
    private int InsuranceAmountForConstruction;
    private int InsuranceAmountForHousehold;
    private Customer Customer;



    // Default Constructor for House Hold Insurances.
    public House_Household_Insurance(String yearlyInsurancePremium, Date dateOfCreatedInsurance, int insuranceAmount,
                                     String insuranceConditions, String propertyOwner, int yearOfConstruction,
                                     String residentialType, String constructionMaterial, String condition,
                                     double numberOfSquareMeters, int insuranceAmountForConstruction,
                                     int insuranceAmountForHousehold, Customer_Controller.Customer customer) {

        super(yearlyInsurancePremium, dateOfCreatedInsurance, insuranceAmount, insuranceConditions);
        this.PropertyOwner = propertyOwner;
        this.YearOfConstruction = yearOfConstruction;
        this.ResidentialType = residentialType;
        this.ConstructionMaterial = constructionMaterial;
        this.Condition = condition;
        this.NumberOfSquareMeters = numberOfSquareMeters;
        this.InsuranceAmountForConstruction = insuranceAmountForConstruction;
        this.InsuranceAmountForHousehold = insuranceAmountForHousehold;
        this.Customer = customer;
    }

    public void setPropertyOwner(String propertyOwner) {
        this.PropertyOwner = propertyOwner;
    }

    public String getPropertyOwner() {
        return this.PropertyOwner;
    }


    public void setYearOfConstruction(int yearOfConstruction) {
        this.YearOfConstruction = yearOfConstruction;
    }

    public int getYearOfConstruction() {
        return this.YearOfConstruction;
    }


    public void setResidentialType(String residentialType) {
        this.ResidentialType = residentialType;
    }

    public String getResidentialType() {
        return this.ResidentialType;
    }


    public void setConstructionMaterial(String constructionMaterial) {
        this.ConstructionMaterial = constructionMaterial;
    }

    public String getConstructionMaterial() {
        return this.ConstructionMaterial;
    }


    public void setCondition(String condition) {
        this.Condition = condition;
    }

    public String getCondition() {
        return this.Condition;
    }


    public void setNumberOfSquareMeters(double numberOfSquareMeters) {
        this.NumberOfSquareMeters = numberOfSquareMeters;
    }

    public double getNumberOfSquareMeters() {
        return this.NumberOfSquareMeters;
    }


    public void setInsuranceAmountForConstruction(int insuranceAmountForConstruction) {
        this.InsuranceAmountForConstruction = insuranceAmountForConstruction;
    }

    public int getInsuranceAmountForConstruction() {
        return this.InsuranceAmountForConstruction;
    }


    public void setInsuranceAmountForHousehold(int insuranceAmountForHousehold) {
        this.InsuranceAmountForHousehold = insuranceAmountForHousehold;
    }

    public int getInsuranceAmountForHousehold() {
        return this.InsuranceAmountForHousehold;
    }

    public Customer getCustomer() {
        return this.Customer;
    }

    public void setCustomer(Customer customer) {
        this.Customer = customer;
    }
}
