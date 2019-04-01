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
        Address_Not_Billing = address_Not_Billing;
    }

    public String getAddress_Not_Billing() {
        return Address_Not_Billing;
    }


    public void setConstructionYear(int constructionYear) {
        ConstructionYear = constructionYear;
    }

    public int getConstructionYear() {
        return ConstructionYear;
    }


    public void setResidentalType(String residentalType) {
        ResidentalType = residentalType;
    }

    public String getResidentalType() {
        return ResidentalType;
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


    public void setAmountSquareMeters(double amountSquareMeters) {
        AmountSquareMeters = amountSquareMeters;
    }

    public double getAmountSquareMeters() {
        return AmountSquareMeters;
    }


    public void setAmountforConstruction(int amountforConstruction) {
        AmountforConstruction = amountforConstruction;
    }

    public int getAmountforConstruction() {
        return AmountforConstruction;
    }


    public void setAmountForHousehold(int amountForHousehold) {
        AmountForHousehold = amountForHousehold;
    }

    public int getAmountForHousehold() {
        return AmountForHousehold;
    }

    public Customer getCustomer() {
        return Customer;
    }

    public void setCustomer(Customer customer) {
        Customer = customer;
    }
}
