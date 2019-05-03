package Exceptions;

import CustomerModell.Customer;
import FileManagement.CsvReader;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExceptionHandler {

    /**
     * Method for creating an Alertbox
     *
     * @param title  user input for title
     * @param header user input for header
     * @param contet user input for content
     */
    public static void alertBox(String title, String header, String contet) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(contet);
        alert.showAndWait();
    }


    /**
     * Method for Alertbox when modifying a table view
     *
     * @param title user input for title
     */
    public static void modifyAlertbox(String title) {
        ExceptionHandler.alertBox(title, "You are now able to modify text in the table view", "There are specific Items that" +
                " you can now edit by double clicking the desired box. Not all Items are editable");
    }

    /**
     * Method for personalID verification validation
     *
     * @param ID textfield
     * @return false if length is not equal to 11 digits or if a customer already has this personalId and true if correct
     * @throws FileNotFoundException
     */
    public static boolean personalIDValidator(JFXTextField ID) throws FileNotFoundException {
        String personalID = ID.getText();
        if (CsvReader.findCustomer(personalID) != null || personalID.length() != 11) {
            alertBox("Error", "Error in personalID", "A customer with this personal id " +
                    "already exists, or the submitted personalID is not 11 digits long.");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Method for phone verification validation
     *
     * @param phoneNumber textfield for phone number
     * @return false if length is not equal to 8 digits or if a customer already has this phone number and true if correct
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static boolean phoneValidator(JFXTextField phoneNumber) throws IOException, FileNotFoundException {
        String phone = phoneNumber.getText();
        ObservableList<Customer> customers = CsvReader.readAllCustomers();
        for (Customer customer : customers) {
            if (customer.getPhoneNumber().equals(phone) || phone.length() != 8) {
                alertBox("Error", "Error in phonenumber", "A customer with this phonenumber " +
                        "already exists, or the submitted phonenumber is not 8 digits long.");
                return false;
            }
        }
        return true;
    }

    /**
     * Method for email verification validation
     *
     * @param email textfield for phone number
     * @return false if input is not valid or email is already registered and true if correct
     * @throws IOException
     * @throws FileNotFoundException
     */
    public static boolean emailValidator(JFXTextField email) throws IOException, FileNotFoundException {
        String mail = email.getText();
        Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(mail);
        ObservableList<Customer> customers = CsvReader.readAllCustomers();
        for (Customer customer : customers) {
            if (customer.getEmail().equals(mail) || !matcher.matches()) {
                alertBox("Error", "Error in email", "A customer with this email already exists," +
                        "or the submitted email is not valid");
                return false;
            }
        }
        return true;
    }
}
