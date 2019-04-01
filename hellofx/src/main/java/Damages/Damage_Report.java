package Damages;

import java.util.Date;

public class Damage_Report {

    private Date DateOfDamage;
    private int DamageNr;
    private String DamageType;
    private String DamageDescription;
    private String ContactOfPotentialWitnesses;
    private double TaxationAmountOfDamage;
    private int UnpaidReplacementAmount; // can be lower than taxed amount


    public void setDateOfDamage(Date dateOfDamage) {
        DateOfDamage = dateOfDamage;
    }

    public Date getDateOfDamage() {
        return DateOfDamage;
    }


    public void setDamageNr(int damageNr) {
        DamageNr = damageNr;
    }

    public int getDamageNr() {
        return DamageNr;
    }


    public void setDamageType(String damageType) {
        DamageType = damageType;
    }

    public String getDamageType() {
        return DamageType;
    }


    public void setDamageDescription(String damageDescription) {
        DamageDescription = damageDescription;
    }

    public String getDamageDescription() {
        return DamageDescription;
    }


    public void setContactOfPotentialWitnesses(String contactOfPotentialWitnesses) {
        ContactOfPotentialWitnesses = contactOfPotentialWitnesses;
    }

    public String getContactOfPotentialWitnesses() {
        return ContactOfPotentialWitnesses;
    }


    public void setTaxationAmountOfDamage(double taxationAmountOfDamage) {
        TaxationAmountOfDamage = taxationAmountOfDamage;
    }

    public double getTaxationAmountOfDamage() {
        return TaxationAmountOfDamage;
    }


    public void setUnpaidReplacementAmount(int unpaidReplacementAmount) {
        UnpaidReplacementAmount = unpaidReplacementAmount;
    }

    public int getUnpaidReplacementAmount() {
        return UnpaidReplacementAmount;
    }
}
