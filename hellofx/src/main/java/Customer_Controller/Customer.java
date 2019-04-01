package Customer_Controller;

import Insurances.Boat_Insurance;
import Insurances.House_Household_Insurance;
import Insurances.Leisure_Insurance;
import Insurances.Travel_Insurance;

import java.util.Date;


public class Customer {



    private long PersonalID;
    private int InsuranceNr;
    private String Name;
    private Date Date;
    private String BillingAddress;
    private String AllCustomerInsurance;
    private String InjuryReport;
    private double UnpaidReplacements;
    private House_Household_Insurance HHI;
    private Leisure_Insurance LeiI;
    private Travel_Insurance TraI;
    private Boat_Insurance BoaI;



    // Default Constructor for Customer
    public Customer(long PersonalID, int InsuranceNr, String Name, Date Date, String BillingAddress,
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



    public void setPersonalID(long PersonalID) {
        PersonalID = PersonalID;
    }

    public Number getPersonalID() {
        return PersonalID;
    }

    public void setDate(java.util.Date date) {
        Date = date;
    }

    public java.util.Date getDate() {
        return Date;
    }


    public void setName(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }


    public void setBillingAddress(String billingAddress) {
        BillingAddress = billingAddress;
    }

    public String getBillingAddress() {
        return BillingAddress;
    }


    public void setInsuranceNr(int insuranceNr) {
        InsuranceNr = insuranceNr;
    }

    public int getInsuranceNr() {
        return InsuranceNr;
    }


    public void setAllCustomerInsurance(String allCustomerInsurance) {
        AllCustomerInsurance = allCustomerInsurance;
    }

    public String getAllCustomerInsurance() {
        return AllCustomerInsurance;
    }


    public void setInjuryReport(String injuryReport) {
        InjuryReport = injuryReport;
    }

    public String getInjuryReport() {
        return InjuryReport;
    }


    public void setUnpaidReplacements(double unpaidReplacements) {
        UnpaidReplacements = unpaidReplacements;
    }

    public double getUnpaidReplacements() {
        return UnpaidReplacements;
    }



    public void setHHI(House_Household_Insurance HHI) {
        this.HHI = HHI;
    }

    public House_Household_Insurance getHHI() {
        return HHI;
    }


    public void setLeiI(Leisure_Insurance leiI) {
        LeiI = leiI;
    }

    public Leisure_Insurance getLeiI() {
        return LeiI;
    }


    public void setTraI(Travel_Insurance traI) {
        TraI = traI;
    }

    public Travel_Insurance getTraI() {
        return TraI;
    }


    public void setBoaI(Boat_Insurance boaI) {
        BoaI = boaI;
    }

    public Boat_Insurance getBoaI() {
        return BoaI;
    }

}
