package Customer_Controller;

import Damages.Damage_Report;
import Insurances.Insurance;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Random;


public class Customer implements Serializable {

    /**
     * Instance variables for the Customer class
     */
    private static final long serialVersionUID = 1;
    private String personalID;
    private int insuranceNr;
    private String name;
    private transient String phoneNumber;
    private transient String email;
    private Date date;
    private String billingAddress;
    private transient int allCustomerInsurance;
    private Damage_Report damageReport;
    private transient double unpaidReplacements;


    // A constructor that dosent require a damageReport (Default constructor)
    public Customer(String PersonalID, String Name, String phoneNumber, String email, Date Date, String BillingAddress){

        this.personalID = PersonalID;
        this.insuranceNr = generateInsuranceNr();
        this.name = Name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.date = Date;
        this.billingAddress = BillingAddress;
    }

    /**
     * Constructor for Customer class with Damage_Report
     * @param PersonalID
     * @param InsuranceNr
     * @param Name
     * @param Date
     * @param BillingAddress
     * @param AllCustomerInsurance
     * @param damageReport
     * @param UnpaidReplacements
     */


    /**
     * @return a string that contains all data in the instance variables for class Customer
     */
    @Override
    public String toString() {
        return  "\nPersonalID: " + personalID +
                "\nInsuranceNr: " + insuranceNr +
                "\nName: " + name +
                "\nPhone: " + phoneNumber +
                "\nEmail: " + email +
                "\nDate: " + date +
                "\nBillingAddress: " + billingAddress +
                "\nAllCustomerInsurance: " + allCustomerInsurance;
    }

    /**
     * @param
     * @return insuranceNr we define a range for our InsuranceNr and then generate a random Number between our range and then
     * return the generated Number
     */
    public static int generateInsuranceNr() {
        int min = 100000;
        int max = 999999;

        Random r = new Random();
        return r.nextInt((max - min) + 1);
    }

    /**
     * We first get all the excisitng Insurances the customer has and then increase the number of Insurnaces
     * then we set the existing number of Insurances to the customer.
     * @param customer object
     *
     */
    public void customerInsuranceCounter(Customer customer) {
        int existingInsurances = customer.getAllCustomerInsurance();
        existingInsurances++;

        customer.setAllCustomerInsurance(existingInsurances);
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


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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
    public void setAllCustomerInsurance(int allCustomerInsurance) {
        this.allCustomerInsurance = allCustomerInsurance;
    }

    /**
     * @return allCustomerInsurance
     */
    public int getAllCustomerInsurance() {
        return this.allCustomerInsurance;
    }

    /**
     * @param damageReport
     */
    public void setDamageReport(Damage_Report damageReport) {
        this.damageReport = damageReport;
    }

    /**
     * @return damageReport
     */
    public Damage_Report getDamageReport() {
        return this.damageReport;
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
