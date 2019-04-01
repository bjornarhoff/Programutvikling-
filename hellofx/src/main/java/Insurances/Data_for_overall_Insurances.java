package Insurances;

import java.util.Date;

public abstract class Data_for_overall_Insurances {

    private String YearlyInsurancePremium;
    private Date DateOfCreatedInsurance;
    private int InsuranceAmount;
    private String InsuranceConditions;


    // Default Constructor for Overall Insurances
    public Data_for_overall_Insurances(String yearlyInsurancePremium, Date dateOfCreatedInsurance, int insuranceAmount,
                                       String insuranceConditions) {

        this.YearlyInsurancePremium = yearlyInsurancePremium;
        this.DateOfCreatedInsurance = dateOfCreatedInsurance;
        this.InsuranceAmount = insuranceAmount;
        this.InsuranceConditions = insuranceConditions;
    }


    public void setYearlyInsurancePremium(String yearlyInsurancePremium) {
        this.YearlyInsurancePremium = yearlyInsurancePremium;
    }

    public String getYearlyInsurancePremium() {
        return this.YearlyInsurancePremium;
    }


    public void setDateOfCreatedInsurance(Date dateOfCreatedInsurance) {
        this.DateOfCreatedInsurance = dateOfCreatedInsurance;
    }

    public Date getDateOfCreatedInsurance() {
        return this.DateOfCreatedInsurance;
    }


    public void setInsuranceAmount(int insuranceAmount) {
        this.InsuranceAmount = insuranceAmount;
    }

    public int getInsuranceAmount() {
        return this.InsuranceAmount;
    }


    public void setInsuranceConditions(String insuranceConditions) {
        this.InsuranceConditions = insuranceConditions;
    }

    public String getInsuranceConditions() {
        return this.InsuranceConditions;
    }



}
