package Damages;

import java.util.Date;

public class Damage_Report {

    /**
     * Instance variables for the Damage_Report class
     */

    private Date dateOfDamage;
    private int damageNr;
    private String damageType;
    private String damageDescription;
    private String contactOfPotentialWitnesses;
    private double taxationAmountOfDamage;
    private int unpaidReplacementAmount; // can be lower than taxed amount

    /**
     * Default constructor for Damage_report class
     * @param dateOfDamage
     * @param damageNr
     * @param damageType
     * @param damageDescription
     * @param contactOfPotentialWitnesses
     * @param taxationAmountOfDamage
     * @param unpaidReplacementAmount
     */
    public Damage_Report(Date dateOfDamage, int damageNr, String damageType, String damageDescription,
                         String contactOfPotentialWitnesses, double taxationAmountOfDamage, int unpaidReplacementAmount) {
        this.dateOfDamage = dateOfDamage;
        this.damageNr = damageNr;
        this.damageType = damageType;
        this.damageDescription = damageDescription;
        this.contactOfPotentialWitnesses = contactOfPotentialWitnesses;
        this.taxationAmountOfDamage = taxationAmountOfDamage;
        this.unpaidReplacementAmount = unpaidReplacementAmount;
    }

    /**
     * @param dateOfDamage
     */
    public void setDateOfDamage(Date dateOfDamage) {
        this.dateOfDamage = dateOfDamage;
    }

    /**
     * @return dateOfDamage
     */
    public Date getDateOfDamage() {
        return dateOfDamage;
    }


    /**
     * @param damageNr
     */
    public void setDamageNr(int damageNr) {
        this.damageNr = damageNr;
    }

    /**
     * @return damageNr
     */
    public int getDamageNr() {
        return damageNr;
    }


    /**
     * @param damageType
     */
    public void setDamageType(String damageType) {
        this.damageType = damageType;
    }

    /**
     * @return damageType
     */
    public String getDamageType() {
        return damageType;
    }


    /**
     * @param damageDescription
     */
    public void setDamageDescription(String damageDescription) {
        this.damageDescription = damageDescription;
    }

    /**
     * @return damageDescription
     */
    public String getDamageDescription() {
        return damageDescription;
    }


    /**
     * @param contactOfPotentialWitnesses
     */
    public void setContactOfPotentialWitnesses(String contactOfPotentialWitnesses) {
        this.contactOfPotentialWitnesses = contactOfPotentialWitnesses;
    }

    /**
     * @return contactOfPotentialWitnesses
     */
    public String getContactOfPotentialWitnesses() {
        return contactOfPotentialWitnesses;
    }


    /**
     * @param taxationAmountOfDamage
     */
    public void setTaxationAmountOfDamage(double taxationAmountOfDamage) {
        this.taxationAmountOfDamage = taxationAmountOfDamage;
    }

    /**
     * @return taxationAmountOfDamage
     */
    public double getTaxationAmountOfDamage() {
        return taxationAmountOfDamage;
    }


    /**
     * @param unpaidReplacementAmount
     */
    public void setUnpaidReplacementAmount(int unpaidReplacementAmount) {
        this.unpaidReplacementAmount = unpaidReplacementAmount;
    }

    /**
     * @return unpaidReplacementAmount
     */
    public int getUnpaidReplacementAmount() {
        return unpaidReplacementAmount;
    }
}
