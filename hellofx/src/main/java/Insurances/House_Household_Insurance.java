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
        PropertyOwner = propertyOwner;
    }

    public String getPropertyOwner() {
        return PropertyOwner;
    }


    public void setYearOfConstruction(int yearOfConstruction) {
        YearOfConstruction = yearOfConstruction;
    }

    public int getYearOfConstruction() {
        return YearOfConstruction;
    }


    public void setResidentialType(String residentialType) {
        ResidentialType = residentialType;
    }

    public String getResidentialType() {
        return ResidentialType;
    }


    public void setConstructionMaterial(String constructionMaterial) {
        ConstructionMaterial = constructionMaterial;
    }

    public String getConstructionMaterial() {
        return ConstructionMaterial;
    }


    public void setCondition(String condition) {
        Condition = condition;
    }

    public String getCondition() {
        return Condition;
    }


    public void setNumberOfSquareMeters(double numberOfSquareMeters) {
        NumberOfSquareMeters = numberOfSquareMeters;
    }

    public double getNumberOfSquareMeters() {
        return NumberOfSquareMeters;
    }


    public void setInsuranceAmountForConstruction(int insuranceAmountForConstruction) {
        InsuranceAmountForConstruction = insuranceAmountForConstruction;
    }

    public int getInsuranceAmountForConstruction() {
        return InsuranceAmountForConstruction;
    }


    public void setInsuranceAmountForHousehold(int insuranceAmountForHousehold) {
        InsuranceAmountForHousehold = insuranceAmountForHousehold;
    }

    public int getInsuranceAmountForHousehold() {
        return InsuranceAmountForHousehold;
    }

    public Customer getCustomer() {
        return this.Customer;
    }

    public void setCustomer(Customer customer) {
        this.Customer = customer;
    }
}
