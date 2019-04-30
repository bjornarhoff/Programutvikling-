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


    /**
     * Default Constructor for Leisure object
     * @param customer
     * @param yearlyInsurancePremium
     * @param dateOfCreatedInsurance
     * @param insuranceAmount
     * @param insuranceConditions
     * @param address_Not_Billing
     * @param constructionYear
     * @param residentalType
     * @param constructionMaterial
     * @param condition
     * @param amountSquareMeters
     * @param amountforConstruction
     * @param amountForHousehold
     */
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

    /**
     * @return Leisure object to a String format
     */
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

    /**
     * @return Leisure object to a csv String format
     */
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

    /**
     * @param address_Not_Billing
     */
    public void setAddress_Not_Billing(String address_Not_Billing) {
        this.address_Not_Billing = address_Not_Billing;
    }

    /**

     * @return address_Not_Billing
     */
    public String getAddress_Not_Billing() {
        return this.address_Not_Billing;
    }

    /**
     * @param constructionYear
     */
    public void setConstructionYear(int constructionYear) {
        this.constructionYear = constructionYear;
    }

    /**
     * @return constructionYear
     */
    public int getConstructionYear() {
        return this.constructionYear;
    }

    /**
     * @param residentalType
     */
    public void setResidentalType(String residentalType) {
        this.residentalType = residentalType;
    }

    /**
     * @return residentalType
     */
    public String getResidentalType() {
        return this.residentalType;
    }

    /**
     * @param constructionMaterial
     */
    public void setConstructionMaterial(String constructionMaterial) {
        this.constructionMaterial = constructionMaterial;
    }

    /**
     * @return constructionMaterial
     */
    public String getConstructionMaterial() {
        return this.constructionMaterial;
    }

    /**
     * @param condition
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * @return condition
     */
    public String getCondition() {
        return this.condition;
    }

    /**
     * @param amountSquareMeters
     */
    public void setAmountSquareMeters(double amountSquareMeters) {
        this.amountSquareMeters = amountSquareMeters;
    }

    /**
     * @return amountSquareMeters
     */
    public double getAmountSquareMeters() {
        return this.amountSquareMeters;
    }

    /**
     * @param amountforConstruction
     */
    public void setAmountforConstruction(int amountforConstruction) {
        this.amountforConstruction = amountforConstruction;
    }

    /**
     * @return amountforConstruction
     */
    public int getAmountforConstruction() {
        return this.amountforConstruction;
    }

    /**
     * @param amountForHousehold
     */
    public void setAmountForHousehold(int amountForHousehold) {
        this.amountForHousehold = amountForHousehold;
    }

    /**
     * @return amountForHousehold
     */
    public int getAmountForHousehold() {
        return this.amountForHousehold;
    }

}
