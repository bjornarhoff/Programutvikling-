package Customer_Controller;

import java.util.Date;


public class Customer {

    /**
     * Instance variables for the Customer class
     */
    private String personalID;
    private int insuranceNr;
    private String name;
    private Date date;
    private String billingAddress;
    private String allCustomerInsurance;
    private String injuryReport;
    private double unpaidReplacements;

    /**
     * Default constructor for Customer class
     * @param PersonalID
     * @param InsuranceNr
     * @param Name
     * @param Date
     * @param BillingAddress
     * @param AllCustomerInsurance
     * @param InjuryReport
     * @param UnpaidReplacements
     */

    public Customer(String PersonalID, int InsuranceNr, String Name, Date Date, String BillingAddress,
                    String AllCustomerInsurance, String InjuryReport, double UnpaidReplacements){

        this.personalID = PersonalID;
        this.insuranceNr = InsuranceNr;
        this.name = Name;
        this.date = Date;
        this.billingAddress = BillingAddress;
        this.allCustomerInsurance = AllCustomerInsurance;
        this.injuryReport = InjuryReport;
        this.unpaidReplacements = UnpaidReplacements;

    }

    /**
     * @return a string that contains all data in the instance variables for class Customer
     */
    @Override
    public String toString() {
        return  "\nCUSTOMER" +
                "\nPersonalID: " + personalID +
                "\nInsuranceNr: " + insuranceNr +
                "\nName: " + name +
                "\nDate: " + date +
                "\nBillingAddress: " + billingAddress +
                "\nAllCustomerInsurance: " + allCustomerInsurance +
                "\nInjuryReport: " + injuryReport +
                "\nUnpaidReplacements: " + unpaidReplacements;
    }

    /**
     * @param PersonalID
     */
    public void setPersonalID(String PersonalID) {
        this.personalID = PersonalID;
    }

    /**
     * @return pernalID
     */
    public String getPersonalID() {
        return this.personalID;
    }

    /**
     * @param date
     */
    public void setDate(java.util.Date date) {
        this.date = date;
    }

    /**
     * @return date
     */
    public java.util.Date getDate() {
        return this.date;
    }


    /**
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * @param billingAddress
     */
    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    /**
     * @return billingAddress
     */
    public String getBillingAddress() {
        return this.billingAddress;
    }


    /**
     * @param insuranceNr
     */
    public void setInsuranceNr(int insuranceNr) {
        this.insuranceNr = insuranceNr;
    }

    /**
     * @return insuranceNr
     */
    public int getInsuranceNr() {
        return this.insuranceNr;
    }


    /**
     * @param allCustomerInsurance
     */
    public void setAllCustomerInsurance(String allCustomerInsurance) {
        this.allCustomerInsurance = allCustomerInsurance;
    }

    /**
     * @return allCustomerInsurance
     */
    public String getAllCustomerInsurance() {
        return this.allCustomerInsurance;
    }

    /**
     * @param injuryReport
     */
    public void setInjuryReport(String injuryReport) {
        this.injuryReport = injuryReport;
    }

    /**
     * @return injuryReport
     */
    public String getInjuryReport() {
        return this.injuryReport;
    }


    /**
     * @param unpaidReplacements
     */
    public void setUnpaidReplacements(double unpaidReplacements) {
        this.unpaidReplacements = unpaidReplacements;
    }

    /**
     * @return unpaidReplacements
     */
    public double getUnpaidReplacements() {
        return this.unpaidReplacements;
    }

}
