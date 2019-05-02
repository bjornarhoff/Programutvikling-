package Damages;

import CustomerModell.Customer;
import org.openjfx.HomeCustomerController;

import java.io.Serializable;

public class Damage_Report implements Serializable {


    /**
     * Instance variables for the Damage_Report class
     */
    private Customer customer;
    private String dateOfDamage;
    private int damageNr;
    private String damageType;
    private String damageDescription;
    private String contactOfPotentialWitnesses;
    private double taxationAmountOfDamage;
    private int unpaidReplacementAmount; // can be lower than taxed amount

    /**
     * Default constructor for Damage_report class
     *
     * @param dateOfDamage
     * @param damageNr
     * @param damageType
     * @param damageDescription
     * @param contactOfPotentialWitnesses
     * @param taxationAmountOfDamage
     * @param unpaidReplacementAmount
     * @param customer
     */
    public Damage_Report(String dateOfDamage, int damageNr, String damageType, String damageDescription,
                         String contactOfPotentialWitnesses, double taxationAmountOfDamage, int unpaidReplacementAmount, Customer customer) {
        this.customer = customer;
        this.dateOfDamage = dateOfDamage;
        this.damageNr = damageNr;
        this.damageType = damageType;
        this.damageDescription = damageDescription;
        this.contactOfPotentialWitnesses = contactOfPotentialWitnesses;
        this.taxationAmountOfDamage = taxationAmountOfDamage;
        this.unpaidReplacementAmount = unpaidReplacementAmount;
    }

    /**
     * Method to write Damage Report to String format
     *
     * @return Damage Report to String format
     */
    @Override
    public String toString() {
        return "DAMAGE REPORT" +
                "\nDateOfDamage: " + dateOfDamage +
                "\nDamageNr: " + damageNr +
                "\nDamageType: " + damageType +
                "\nDamageDescription: " + damageDescription +
                "\nContactOfPotentialWitnesses: " + contactOfPotentialWitnesses +
                "\nTaxationAmountOfDamage: " + taxationAmountOfDamage +
                "\nUnpaidReplacementAmount: " + unpaidReplacementAmount;
    }

    /**
     * Method to write Damage Report to csv String format
     *
     * @return Damage Report
     */
    public String toCSVStringDamageReport() {
        return
                customer.getPersonalID() + "," +
                        dateOfDamage + "," +
                        String.valueOf(damageNr) + "," +
                        damageType + "," +
                        damageDescription + "," +
                        contactOfPotentialWitnesses + "," +
                        String.valueOf(taxationAmountOfDamage) + "," +
                        String.valueOf(unpaidReplacementAmount);
    }

    /**
     * @return customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return dateOfDamage
     */
    public String getDateOfDamage() {
        return dateOfDamage;
    }

    /**
     * @param dateOfDamage
     */
    public void setDateOfDamage(String dateOfDamage) {
        this.dateOfDamage = dateOfDamage;
    }

    /**
     * @return damageNr
     */
    public int getDamageNr() {
        return damageNr;
    }

    /**
     * @param damageNr
     */
    public void setDamageNr(int damageNr) {
        this.damageNr = damageNr;
    }

    /**
     * @return damageType
     */
    public String getDamageType() {
        return damageType;
    }

    /**
     * @param damageType
     */
    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    /**
     * @return damageDescription
     */
    public String getDamageDescription() {
        return damageDescription;
    }

    /**
     * @param damageDescription
     */
    public void setDamageDescription(String damageDescription) {
        this.damageDescription = damageDescription;
    }

    /**
     * @return contactOfPotentialWitnesses
     */
    public String getContactOfPotentialWitnesses() {
        return contactOfPotentialWitnesses;
    }

    /**
     * @param contactOfPotentialWitnesses
     */
    public void setContactOfPotentialWitnesses(String contactOfPotentialWitnesses) {
        this.contactOfPotentialWitnesses = contactOfPotentialWitnesses;
    }

    /**
     * @return taxationAmountOfDamage
     */
    public double getTaxationAmountOfDamage() {
        return taxationAmountOfDamage;
    }

    /**
     * @param taxationAmountOfDamage
     */
    public void setTaxationAmountOfDamage(double taxationAmountOfDamage) {
        this.taxationAmountOfDamage = taxationAmountOfDamage;
    }

    /**
     * @return unpaidReplacementAmount
     */
    public int getUnpaidReplacementAmount() {
        return unpaidReplacementAmount;
    }

    /**
     * @param unpaidReplacementAmount
     */
    public void setUnpaidReplacementAmount(int unpaidReplacementAmount) {
        this.unpaidReplacementAmount = unpaidReplacementAmount;
    }
}


