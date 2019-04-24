//package CustomerModell;
//
//import java.io.Serializable;
//
//public abstract class Person{
//
//    private String personalId;
//    private String name;
//    private String phoneNumber;
//    private String email;
//    private String billingAddress;
//
//
//
//    // Constructor
//    protected Person (String personalId, String name, String phoneNumber, String email, String billingAddress) {
//        this.personalId = personalId;
//        this.name = name;
//        this.phoneNumber = phoneNumber;
//        this.email = email;
//        this.billingAddress = billingAddress;
//    }
//
//
//
//
//    // Set-methods
//
//    public void setPersonalId (String personalId) {
//        this.personalId = personalId;
//    }
//    /**
//     * @param name
//     */
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setPhoneNumber(String phoneNumber) {
//        this.phoneNumber = phoneNumber;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    /**
//     * @param billingAddress
//     */
//    public void setBillingAddress(String billingAddress) {
//        this.billingAddress = billingAddress;
//    }
//
//
//
//
//
//
//    // Get-methods
//
//
//    /**
//     * @return pernalID
//     */
//    public String getPersonalID() {
//        return personalId;
//    }
//
//
//    public String getName() {
//        return this.name;
//    }
//
//    public String getPhoneNumber() {
//        return phoneNumber;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public String getBillingAddress() {
//        return this.billingAddress;
//    }
//
//
//
//    /**
//     * @return a string that contains all data in the instance variables for class Customer
//     */
//    @Override
//    public String toString() {
//        return  "\nPersonalID: " + personalId +
//                "\nName: " + name +
//                "\nPhone: " + phoneNumber +
//                "\nEmail: " + email +
//                "\nBillingAddress: " + billingAddress;
//
//    }
//}
