package Customer_Controller;

import Insurances.Boat_Insurance;
import Insurances.House_Household_Insurance;
import Insurances.Leisure_Insurance;
import Insurances.Travel_Insurance;

import java.util.Date;


public class Customer {



    private String PersonalID;
    private int InsuranceNr;
    private String Name;
    private Date Date;
    private String BillingAddress;
    private String AllCustomerInsurance;
    private String InjuryReport;
    private double UnpaidReplacements;




    // Default Constructor for Customer
    public Customer(String PersonalID, int InsuranceNr, String Name, Date Date, String BillingAddress,
                    String AllCustomerInsurance, String InjuryReport, double UnpaidReplacements){

        this.PersonalID = PersonalID;
        this.InsuranceNr = InsuranceNr;
        this.Name = Name;
        this.Date = Date;
        this.BillingAddress = BillingAddress;
        this.AllCustomerInsurance = AllCustomerInsurance;
        this.InjuryReport = InjuryReport;
        this.UnpaidReplacements = UnpaidReplacements;

    }

    @Override
    public String toString() {
        return "\nCustomer{" +
                "PersonalID='" + PersonalID + '\'' +
                ", InsuranceNr=" + InsuranceNr +
                ", Name='" + Name + '\'' +
                ", Date=" + Date +
                ", BillingAddress='" + BillingAddress + '\'' +
                ", AllCustomerInsurance='" + AllCustomerInsurance + '\'' +
                ", InjuryReport='" + InjuryReport + '\'' +
                ", UnpaidReplacements=" + UnpaidReplacements +
                '}';
    }

    public void setPersonalID(String PersonalID) {
        this.PersonalID = PersonalID;
    }

    public String getPersonalID() {
        return this.PersonalID;
    }

    public void setDate(java.util.Date date) {
        this.Date = date;
    }

    public java.util.Date getDate() {
        return this.Date;
    }


    public void setName(String name) {
        this.Name = name;
    }

    public String getName() {
        return this.Name;
    }


    public void setBillingAddress(String billingAddress) {
        this.BillingAddress = billingAddress;
    }

    public String getBillingAddress() {
        return this.BillingAddress;
    }


    public void setInsuranceNr(int insuranceNr) {
        this.InsuranceNr = insuranceNr;
    }

    public int getInsuranceNr() {
        return this.InsuranceNr;
    }


    public void setAllCustomerInsurance(String allCustomerInsurance) {
        this.AllCustomerInsurance = allCustomerInsurance;
    }

    public String getAllCustomerInsurance() {
        return this.AllCustomerInsurance;
    }

    public void setInjuryReport(String injuryReport) {
        this.InjuryReport = injuryReport;
    }

    public String getInjuryReport() {
        return this.InjuryReport;
    }


    public void setUnpaidReplacements(double unpaidReplacements) {
        this.UnpaidReplacements = unpaidReplacements;
    }

    public double getUnpaidReplacements() {
        return this.UnpaidReplacements;
    }

}
