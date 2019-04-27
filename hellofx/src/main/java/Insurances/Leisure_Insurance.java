package Insurances;

import CustomerModell.Customer;

import java.util.Date;

public class Leisure_Insurance extends Insurance {

    private String address_Not_Billing;
    private int constructionYear;
    private String residentalType;
    private String constructionMaterial;
    private String condition;
    private double amountSquareMeters;
    private int amountforConstruction;
    private int amountForHousehold;


    // Default Constructor for Leisure Insurance
    public Leisure_Insurance(Customer customer, String yearlyInsurancePremium, String dateOfCreatedInsurance, int insuranceAmount,
                             String insuranceConditions, String address_Not_Billing, int constructionYear,
                             String residentalType, String constructionMaterial, String condition,
                             double amountSquareMeters, int amountforConstruction, int amountForHousehold) {

        super(customer, yearlyInsurancePremium, dateOfCreatedInsurance, insuranceAmount, insuranceConditions);
        this.address_Not_Billing = address_Not_Billing;
        this.constructionYear = constructionYear;
        this.residentalType = residentalType;
        this.constructionMaterial = constructionMaterial;
        this.condition = condition;
        this.amountSquareMeters = amountSquareMeters;
        this.amountforConstruction = amountforConstruction;
        this.amountForHousehold = amountForHousehold;
        customer.customerInsuranceCounter(customer);
    }

    @Override
    public String toString() {
        return  "\nLEISURE INSURANCE" +
                "\nAddress_Not_Billing: " + address_Not_Billing +
                "\nConstructionYear: " + constructionYear +
                "\nResidentalType: " + residentalType +
                "\nConstructionMaterial: " + constructionMaterial +
                "\nCondition: " + condition +
                "\nAmountSquareMeters: " + amountSquareMeters +
                "\nAmountforConstruction: " + amountforConstruction +
                "\nAmountForHousehold: " + amountForHousehold +
                "\n\nOVERALL FOR LEISRUE INSURANCE" + super.toString();
    }

    public String toCSVStringLeisure() {
        return super.toCSVStringInsurnce() + "," +
                address_Not_Billing + "," +
                String.valueOf(constructionYear) + "," +
                residentalType + "," +
                constructionMaterial + "," +
                condition + "," +
                String.valueOf(amountSquareMeters) + "," +
                String.valueOf(amountforConstruction) +  "," +
                String.valueOf(amountForHousehold);
    }

    public void setAddress_Not_Billing(String address_Not_Billing) {
        this.address_Not_Billing = address_Not_Billing;
    }

    public String getAddress_Not_Billing() {
        return this.address_Not_Billing;
    }


    public void setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
    }

    public int getConstructionYear() {
        return this.constructionYear;
    }


    public void setResidentalType(String residentalType) {
        this.residentalType = residentalType;
    }

    public String getResidentalType() {
        return this.residentalType;
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


    public void setAmountSquareMeters(double amountSquareMeters) {
        this.amountSquareMeters = amountSquareMeters;
    }

    public double getAmountSquareMeters() {
        return this.amountSquareMeters;
    }

    public void setAmountforConstruction(int amountforConstruction) {
        this.amountforConstruction = amountforConstruction;
    }

    public int getAmountforConstruction() {
        return this.amountforConstruction;
    }


    public void setAmountForHousehold(int amountForHousehold) {
        this.amountForHousehold = amountForHousehold;
    }

    public int getAmountForHousehold() {
        return this.amountForHousehold;
    }

}
