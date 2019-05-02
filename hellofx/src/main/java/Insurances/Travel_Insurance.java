package Insurances;
import CustomerModell.Customer;

public class Travel_Insurance extends Insurance {


    private String insuranceArea; // where insurance is valid
    private int insuranceSum;


    /**
     * Default Constructor for Travel object
     * @param customer
     * @param yearlyInsurancePremium
     * @param dateOfCreatedInsurance
     * @param insuranceAmount
     * @param insuranceConditions
     * @param insuranceArea
     * @param insuranceSum
     */
    public Travel_Insurance(Customer customer, String yearlyInsurancePremium, String dateOfCreatedInsurance, int insuranceAmount,
                            String insuranceConditions, String insuranceArea, int insuranceSum) {

        super(customer, yearlyInsurancePremium, dateOfCreatedInsurance, insuranceAmount, insuranceConditions);
        this.insuranceArea = insuranceArea;
        this.insuranceSum = insuranceSum;
        customer.customerInsuranceCounter(customer);
    }

    /**
     * @return Travel object in String format
     */
    @Override
    public String toString() {
        return  "\nTRAVEL INSURANCE" +
                "\nInsuranceArea: " + insuranceArea +
                "\nInsuranceSum: " + insuranceSum +
                "\n\nOVERALL FOR TRAVEL INSURANCE" + super.toString();
    }

    /**
     * @return Travel object in csv String format
     */
    public String   toCSVStringTravel() {
        return super.toCSVStringInsurnce() + "," +
                insuranceArea + "," +
                String.valueOf(insuranceSum);
    }

    /**
     * @param insuranceArea
     */
    public void setInsuranceArea(String insuranceArea) {
        this.insuranceArea = insuranceArea;
    }

    /**
     * @return insuranceArea
     */
    public String getInsuranceArea() {
        return this.insuranceArea;
    }

    /**
     * @param insuranceSum
     */
    public void setInsuranceSum(int insuranceSum) {
        this.insuranceSum = insuranceSum;
    }

    /**
     * @return insuranceSum
     */
    public int getInsuranceSum() {
        return this.insuranceSum;
    }
}
