package Insurances;

import Customer_Controller.Customer;

import java.util.Date;

public class Leisure_Insurance extends Data_for_overall_Insurances {

    private String Address_Not_Billing;
    private int ConstructionYear;
    private String ResidentalType;
    private String ConstructionMaterial;
    private String Condition;
    private double AmountSquareMeters;
    private int AmountforConstruction;
    private int AmountForHousehold;
    private Customer Customer;


    // Default Constructor for Leisure Insurance
    public Leisure_Insurance(String yearlyInsurancePremium, Date dateOfCreatedInsurance, int insuranceAmount,
                             String insuranceConditions, String address_Not_Billing, int constructionYear,
                             String residentalType, String constructionMaterial, String condition,
                             double amountSquareMeters, int amountforConstruction, int amountForHousehold,
                             Customer_Controller.Customer customer) {

        super(yearlyInsurancePremium, dateOfCreatedInsurance, insuranceAmount, insuranceConditions);
        this.Address_Not_Billing = address_Not_Billing;
        this.ConstructionYear = constructionYear;
        this.ResidentalType = residentalType;
        this.ConstructionMaterial = constructionMaterial;
        this.Condition = condition;
        this.AmountSquareMeters = amountSquareMeters;
        this.AmountforConstruction = amountforConstruction;
        this.AmountForHousehold = amountForHousehold;
        this.Customer = customer;
    }

    public void setAddress_Not_Billing(String address_Not_Billing) {
        this.Address_Not_Billing = address_Not_Billing;
    }

    public String getAddress_Not_Billing() {
        return this.Address_Not_Billing;
    }


    public void setConstructionYear(int constructionYear) {
        this.ConstructionYear = constructionYear;
    }

    public int getConstructionYear() {
        return this.ConstructionYear;
    }


    public void setResidentalType(String residentalType) {
        this.ResidentalType = residentalType;
    }

    public String getResidentalType() {
        return this.ResidentalType;
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


    public void setAmountSquareMeters(double amountSquareMeters) {
        this.AmountSquareMeters = amountSquareMeters;
    }

    public double getAmountSquareMeters() {
        return this.AmountSquareMeters;
    }

    public void setAmountforConstruction(int amountforConstruction) {
        this.AmountforConstruction = amountforConstruction;
    }

    public int getAmountforConstruction() {
        return this.AmountforConstruction;
    }


    public void setAmountForHousehold(int amountForHousehold) {
        this.AmountForHousehold = amountForHousehold;
    }

    public int getAmountForHousehold() {
        return this.AmountForHousehold;
    }

    public Customer getCustomer() {
        return this.Customer;
    }

    public void setCustomer(Customer customer) {
        this.Customer = customer;
    }
}
