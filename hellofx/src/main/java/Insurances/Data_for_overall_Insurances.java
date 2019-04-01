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
        YearlyInsurancePremium = yearlyInsurancePremium;
    }

    public String getYearlyInsurancePremium() {
        return YearlyInsurancePremium;
    }


    public void setDateOfCreatedInsurance(Date dateOfCreatedInsurance) {
        DateOfCreatedInsurance = dateOfCreatedInsurance;
    }

    public Date getDateOfCreatedInsurance() {
        return DateOfCreatedInsurance;
    }


    public void setInsuranceAmount(int insuranceAmount) {
        InsuranceAmount = insuranceAmount;
    }

    public int getInsuranceAmount() {
        return InsuranceAmount;
    }


    public void setInsuranceConditions(String insuranceConditions) {
        InsuranceConditions = insuranceConditions;
    }

    public String getInsuranceConditions() {
        return InsuranceConditions;
    }



}
