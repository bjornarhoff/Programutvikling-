package Insurances;

import CustomerModell.Customer;

import java.util.Date;

public class House_Household_Insurance extends Insurance {

    private String propertyOwner;
    private int yearOfConstruction;
    private String residentialType;
    private String constructionMaterial;
    private String condition;
    private double numberOfSquareMeters;
    private int insuranceAmountForConstruction;
    private int insuranceAmountForHousehold;


    /**
     * Default Constructor for Household Object
     *
     * @param customer
     * @param yearlyInsurancePremium
     * @param dateOfCreatedInsurance
     * @param insuranceAmount
     * @param insuranceConditions
     * @param propertyOwner
     * @param yearOfConstruction
     * @param residentialType
     * @param constructionMaterial
     * @param condition
     * @param numberOfSquareMeters
     * @param insuranceAmountForConstruction
     * @param insuranceAmountForHousehold
     */
    public House_Household_Insurance(Customer customer, String yearlyInsurancePremium, String dateOfCreatedInsurance, int insuranceAmount,
                                     String insuranceConditions, String propertyOwner, int yearOfConstruction,
                                     String residentialType, String constructionMaterial, String condition,
                                     double numberOfSquareMeters, int insuranceAmountForConstruction,
                                     int insuranceAmountForHousehold) {

        super(customer, yearlyInsurancePremium, dateOfCreatedInsurance, insuranceAmount, insuranceConditions);
        this.propertyOwner = propertyOwner;
        this.yearOfConstruction = yearOfConstruction;
        this.residentialType = residentialType;
        this.constructionMaterial = constructionMaterial;
        this.condition = condition;
        this.numberOfSquareMeters = numberOfSquareMeters;
        this.insuranceAmountForConstruction = insuranceAmountForConstruction;
        this.insuranceAmountForHousehold = insuranceAmountForHousehold;
        customer.customerInsuranceCounter(customer);

    }

    /**
     * @return Household object in String format
     */
    @Override
    public String toString() {
        return "\nHOUSEHOLD INSURANCE" +
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

    /**
     * @return Household object in csv String format
     */
    public String toCSVStringHousehold() {
        return super.toCSVStringInsurnce() + "," +
                propertyOwner + "," +
                String.valueOf(yearOfConstruction) + "," +
                residentialType + "," +
                constructionMaterial + "," +
                condition + "," +
                String.valueOf(numberOfSquareMeters) + "," +
                String.valueOf(insuranceAmountForConstruction) + "," +
                String.valueOf(insuranceAmountForHousehold);
    }

    /**
     * @return propertyOwner
     */
    public String getPropertyOwner() {
        return this.propertyOwner;
    }

    /**
     * @param propertyOwner
     */
    public void setPropertyOwner(String propertyOwner) {
        this.propertyOwner = propertyOwner;
    }

    /**
     * @return yearOfConstruction
     */
    public int getYearOfConstruction() {
        return this.yearOfConstruction;
    }

    /**
     * @param yearOfConstruction
     */
    public void setYearOfConstruction(int yearOfConstruction) {
        this.yearOfConstruction = yearOfConstruction;
    }

    /**
     * @return residentialType
     */
    public String getResidentialType() {
        return this.residentialType;
    }

    /**
     * @param residentialType
     */
    public void setResidentialType(String residentialType) {
        this.residentialType = residentialType;
    }

    /**
     * @return constructionMaterial
     */
    public String getConstructionMaterial() {
        return this.constructionMaterial;
    }

    /**
     * @param constructionMaterial
     */
    public void setConstructionMaterial(String constructionMaterial) {
        this.constructionMaterial = constructionMaterial;
    }

    /**
     * @return condition
     */
    public String getCondition() {
        return this.condition;
    }

    /**
     * @param condition
     */
    public void setCondition(String condition) {
        this.condition = condition;
    }

    /**
     * @return numberOfSquareMeters
     */
    public double getNumberOfSquareMeters() {
        return this.numberOfSquareMeters;
    }

    /**
     * @param numberOfSquareMeters
     */
    public void setNumberOfSquareMeters(double numberOfSquareMeters) {
        this.numberOfSquareMeters = numberOfSquareMeters;
    }

    /**
     * @return insuranceAmountForConstruction
     */
    public int getInsuranceAmountForConstruction() {
        return this.insuranceAmountForConstruction;
    }

    /**
     * @param insuranceAmountForConstruction
     */
    public void setInsuranceAmountForConstruction(int insuranceAmountForConstruction) {
        this.insuranceAmountForConstruction = insuranceAmountForConstruction;
    }

    /**
     * @return insuranceAmountForHousehold
     */
    public int getInsuranceAmountForHousehold() {
        return this.insuranceAmountForHousehold;
    }

    /**
     * @param insuranceAmountForHousehold
     */
    public void setInsuranceAmountForHousehold(int insuranceAmountForHousehold) {
        this.insuranceAmountForHousehold = insuranceAmountForHousehold;
    }

}
