package org.openjfx;

import CustomerModell.Customer;
import Damages.Damage_Report;
import FileManagement.CsvReader;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import com.jfoenix.controls.JFXButton;
import javafx.concurrent.Task;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import Insurances.Leisure_Insurance;
import Insurances.House_Household_Insurance;
import Insurances.Travel_Insurance;
import Insurances.Boat_Insurance;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.function.UnaryOperator;
import java.util.regex.Pattern;

public class HandlerFxml {


    /**
     * Method that navigates through fmxl files
     *
     * @param current
     * @param path
     */
    public void navigate(Pane current, String path) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(path));
            Stage stg = (Stage) current.getScene().getWindow();
            stg.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method that sets table view column values for customer object
     * @param t1
     * @param t2
     * @param t3
     * @param t4
     * @param t5
     * @param t6
     * @param t7
     * @param table
     */
    public void setCellValue(TableColumn<Customer,String> t1, TableColumn<Customer,String> t2,
                             TableColumn<Customer,String> t3, TableColumn<Customer,String> t4,
                             TableColumn<Customer,String> t5, TableColumn<Customer,String> t6,
                             TableColumn<Customer,String> t7, TableView<Customer> table){
        new Thread(() -> {

            ObservableList<Customer> customers = null;
            try {
                customers = CsvReader.read();
            } catch (IOException e) {
                e.printStackTrace();
            }
            t1.setCellValueFactory(new PropertyValueFactory<>("personalID"));
        t2.setCellValueFactory(new PropertyValueFactory<>("insuranceNr"));
        t3.setCellValueFactory(new PropertyValueFactory<>("name"));
        t4.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
        t5.setCellValueFactory(new PropertyValueFactory<>("email"));
        t6.setCellValueFactory(new PropertyValueFactory<>("date"));
        t7.setCellValueFactory(new PropertyValueFactory<>("billingAddress"));
        table.setItems(customers);
        }).start();


    }

    /**
     * Method that sets table view columns values for Damage Report object
     * @param t1
     * @param t2
     * @param t3
     * @param t4
     * @param t5
     * @param table
     */
    public void setCellValueDamageReport(TableColumn<Damage_Report,String> t1, TableColumn<Damage_Report,String> t2,
                                         TableColumn<Damage_Report,Integer> t3, TableColumn<Damage_Report,String> t4,
                                         TableColumn<Damage_Report,String> t5, TableView<Damage_Report> table) {
        new Thread(() -> {

            /*try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

             */
            ObservableList<Damage_Report> damageReport = null;
            try {
                damageReport = CsvReader.readDamageReport();
            } catch (IOException e) {
                e.printStackTrace();
            }
            t1.setCellValueFactory(new PropertyValueFactory<>("damageType"));
        t2.setCellValueFactory(new PropertyValueFactory<>("damageDescription"));
        t3.setCellValueFactory(new PropertyValueFactory<>("damageNr"));
        t4.setCellValueFactory(new PropertyValueFactory<>("contactOfPotentialWitnesses"));
        t5.setCellValueFactory(new PropertyValueFactory<>("unpaidReplacementAmount"));
        table.setItems(damageReport);
        }).start();
    }


    /**
     * Method that restricts a user to write a PersonalId longer than 8 digits
     *
     * @param textField
     */
    public void restrictionId(TextField textField) {
        // Sets pattern to texfield, 0 - 8 characters allowed
        Pattern pattern = Pattern.compile(".{0,11}");
        TextFormatter formatter = new TextFormatter
                ((UnaryOperator<TextFormatter.Change>) change -> {
                    return pattern.matcher(change.getControlNewText()).matches() ? change : null;
                });
        textField.setTextFormatter(formatter);
    }

    /**
     * Method that restricts a user to write the phone number longer than 8 digits
     *
     * @param textField
     */
    public void restrictionPhone(TextField textField) {
        // Sets pattern to texfield, 0 - 8 characters allowed
        Pattern pattern = Pattern.compile(".{0,8}");
        TextFormatter formatter = new TextFormatter
                ((UnaryOperator<TextFormatter.Change>) change -> {
                    return pattern.matcher(change.getControlNewText()).matches() ? change : null;
                });
        textField.setTextFormatter(formatter);
    }

    /**
     * Method that enables a button when a row in the table view is selected
     *
     * @param tableView
     * @param button
     */
    public void enableWhenMarked(TableView tableView, JFXButton... button) {
        for (JFXButton buttons : button) {
            buttons.disableProperty().bind(Bindings.isEmpty(tableView.getSelectionModel().getSelectedItems()));
        }
    }

    /**
     * Method that enables buttons only if all the textfields are filled out
     *
     * @param apply
     * @param textFields
     * @return
     */
    public boolean enableButton(JFXButton apply, JFXTextField... textFields) {

        boolean filled = true;
        for (JFXTextField field : textFields) {
            if (field.textProperty().isEmpty().get()) {
                filled = false;
            }
        }
        return filled;

    }

    public void loadFileThread() {
        Task task = new Task<Void>() {
            @Override
            public Void call() throws IOException {
                int max = 1000000;
                for (int i = 1; i <= max; i = i + 10) {
                    if (isCancelled()) {
                        break;
                    }
                    updateProgress(i, max);
                    CsvReader.read();
                }
                return null;
            }
        };
        new Thread(task).start();
    }


    /**
     * Method that clears input from textfields
     *
     * @param fields
     */
    public void clearInput(JFXTextField... fields) {

        for (JFXTextField field : fields) {
            field.setText("");
        }
    }


    /**
     * Method that sets input validation for a textfields
     *
     * @param textField
     */
    public void setInputValidation(JFXTextField textField) {
        textField.focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if (!newValue) {
                    textField.validate();
                }
            }
        });
        getValidators(textField);
    }


    /**
     * Method that gets input validation for the textfields
     *
     * @param textField
     */
    public void getValidators(JFXTextField textField) {
        NumberValidator numvalidator = new NumberValidator();

        textField.getValidators().add(numvalidator);
        numvalidator.setMessage("Only numbers are supported!");
    }

    /**
     * Method that sets table view column values for customer object
     *
     * @param t1
     * @param t2
     * @param t3
     * @param t4
     * @param t5
     * @param t6
     * @param t7
     * @param table
     */
    public void setCellValueCustomers(TableColumn<Customer, String> t1, TableColumn<Customer, String> t2,
                                      TableColumn<Customer, String> t3, TableColumn<Customer, String> t4,
                                      TableColumn<Customer, String> t5, TableColumn<Customer, String> t6,
                                      TableColumn<Customer, String> t7, TableView<Customer> table) {
        new Thread(() -> {

            ObservableList<Customer> customers = CsvReader.read();
            t1.setCellValueFactory(new PropertyValueFactory<>("personalID"));
            t2.setCellValueFactory(new PropertyValueFactory<>("insuranceNr"));
            t3.setCellValueFactory(new PropertyValueFactory<>("name"));
            t4.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));
            t5.setCellValueFactory(new PropertyValueFactory<>("email"));
            t6.setCellValueFactory(new PropertyValueFactory<>("date"));
            t7.setCellValueFactory(new PropertyValueFactory<>("billingAddress"));
            table.setItems(customers);
        }).start();


    }

    /**
     * Method that sets table view columns values for Damage Report object
     *
     * @param t1
     * @param t2
     * @param t3
     * @param t4
     * @param t5
     * @param table
     */
    public void setCellValueDamageReport(TableColumn<Damage_Report, String> t1, TableColumn<Damage_Report, String> t2,
                                         TableColumn<Damage_Report, Integer> t3, TableColumn<Damage_Report, String> t4,
                                         TableColumn<Damage_Report, String> t5, TableView<Damage_Report> table) {
        new Thread(() -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ObservableList<Damage_Report> damageReport = CsvReader.readDamageReport();
            t1.setCellValueFactory(new PropertyValueFactory<>("damageType"));
            t2.setCellValueFactory(new PropertyValueFactory<>("damageDescription"));
            t3.setCellValueFactory(new PropertyValueFactory<>("damageNr"));
            t4.setCellValueFactory(new PropertyValueFactory<>("contactOfPotentialWitnesses"));
            t5.setCellValueFactory(new PropertyValueFactory<>("unpaidReplacementAmount"));
            table.setItems(damageReport);
        }).start();
    }


    /**
     * Method that displays the information about the Household Insurance in the columns of the Household table view and does so in a thread
     *
     * @param t1
     * @param t2
     * @param t3
     * @param t4
     * @param t5
     * @param t6
     * @param t7
     * @param table
     */
    public void setCellValueHousehold(TableColumn<House_Household_Insurance, String> t1, TableColumn<House_Household_Insurance, Integer> t2,
                                      TableColumn<House_Household_Insurance, String> t3, TableColumn<House_Household_Insurance, String> t4,
                                      TableColumn<House_Household_Insurance, String> t5, TableColumn<House_Household_Insurance, String> t6,
                                      TableColumn<House_Household_Insurance, Integer> t7, TableView<House_Household_Insurance> table) {
        new Thread(() -> {
            /*try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

             */

            ObservableList<House_Household_Insurance> householdInsurnace = null;
            try {
                householdInsurnace = CsvReader.readHousehold();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            t1.setCellValueFactory(new PropertyValueFactory<>("yearlyInsurancePremium"));
            t2.setCellValueFactory(new PropertyValueFactory<>("insuranceAmount"));
            t3.setCellValueFactory(new PropertyValueFactory<>("insuranceConditions"));
            t4.setCellValueFactory(new PropertyValueFactory<>("propertyOwner"));
            t5.setCellValueFactory(new PropertyValueFactory<>("constructionMaterial"));
            t6.setCellValueFactory(new PropertyValueFactory<>("condition"));
            t7.setCellValueFactory(new PropertyValueFactory<>("insuranceAmountForHousehold"));
            table.setItems(householdInsurnace);
        }).start();

    }

    /**
     * Method that displays the information about the Travel Insurance in the columns of the Travel table view and does so in a thread
     *
     * @param t1
     * @param t2
     * @param t3
     * @param t4
     * @param t5
     * @param table
     */
    public void setCellValueTravel(TableColumn<Travel_Insurance, String> t1, TableColumn<Travel_Insurance, Integer> t2,
                                   TableColumn<Travel_Insurance, String> t3, TableColumn<Travel_Insurance, String> t4,
                                   TableColumn<Travel_Insurance, String> t5, TableView<Travel_Insurance> table) {
        new Thread(() -> {
            /*try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

             */


            ObservableList<Travel_Insurance> travelInsurnce = null;
            try {
                travelInsurnce = CsvReader.readTravel();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            t1.setCellValueFactory(new PropertyValueFactory<>("dateOfCreatedInsurance"));
        t2.setCellValueFactory(new PropertyValueFactory<>("insuranceAmount"));
        t3.setCellValueFactory(new PropertyValueFactory<>("yearlyInsurancePremium"));
        t4.setCellValueFactory(new PropertyValueFactory<>("insuranceConditions"));
        t5.setCellValueFactory(new PropertyValueFactory<>("insuranceArea"));
        table.setItems(travelInsurnce);
        }).start();


    }

    /**
     * Method that displays the information about the Leisure Insurance in the columns of the Leisure table view and does so in a thread
     *
     * @param t1
     * @param t2
     * @param t3
     * @param t4
     * @param t5
     * @param t6
     * @param t7
     * @param table
     */
    public void setCellValueLeisure(TableColumn<Leisure_Insurance, String> t1, TableColumn<Leisure_Insurance, String> t2,
                                    TableColumn<Leisure_Insurance, String> t3, TableColumn<Leisure_Insurance, String> t4,
                                    TableColumn<Leisure_Insurance, String> t5, TableColumn<Leisure_Insurance, String> t6, TableColumn<Leisure_Insurance, Integer> t7, TableView<Leisure_Insurance> table) {
        new Thread(() -> {
            /*try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

             */

            ObservableList<Leisure_Insurance> leisureInsurnace = null;
            try {
                leisureInsurnace = CsvReader.readLeisure();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            t1.setCellValueFactory(new PropertyValueFactory<>("dateOfCreatedInsurance"));
        t2.setCellValueFactory(new PropertyValueFactory<>("yearlyInsurancePremium"));
        t3.setCellValueFactory(new PropertyValueFactory<>("insuranceConditions"));
        t4.setCellValueFactory(new PropertyValueFactory<>("constructionMaterial"));
        t5.setCellValueFactory(new PropertyValueFactory<>("condition"));
        t6.setCellValueFactory(new PropertyValueFactory<>("amountSquareMeters"));
        t7.setCellValueFactory(new PropertyValueFactory<>("amountForHousehold"));

            table.setItems(leisureInsurnace);
        }).start();


    }

    /**
     * Method that displays the information about the Boat Insurance in the columns of boat table view and does so in a thread
     *
     * @param t1
     * @param t2
     * @param t3
     * @param t4
     * @param t5
     * @param t6
     * @param t7
     * @param table
     */
    public void setCellValueBoat(TableColumn<Boat_Insurance, String> t1, TableColumn<Boat_Insurance, Integer> t2,
                                 TableColumn<Boat_Insurance, String> t3, TableColumn<Boat_Insurance, String> t4,
                                 TableColumn<Boat_Insurance, String> t5, TableColumn<Boat_Insurance, String> t6,
                                 TableColumn<Boat_Insurance, String> t7, TableView<Boat_Insurance> table) {
        new Thread(() -> {
            /*try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ObservableList<Boat_Insurance> boatInsurance = CsvReader.readBoatWithCustomer();
            t1.setCellValueFactory(new PropertyValueFactory<>("dateOfCreatedInsurance"));
            t2.setCellValueFactory(new PropertyValueFactory<>("insuranceAmount"));
            t3.setCellValueFactory(new PropertyValueFactory<>("owner"));
            t4.setCellValueFactory(new PropertyValueFactory<>("registerNr"));
            t5.setCellValueFactory(new PropertyValueFactory<>("boatTypeAndModel"));
            t6.setCellValueFactory(new PropertyValueFactory<>("lengthInFoot"));
            t7.setCellValueFactory(new PropertyValueFactory<>("motorTypeAndMotorPower"));

             */


            ObservableList<Boat_Insurance> boatInsurance = null;
            try {
                boatInsurance = CsvReader.readBoat();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            t1.setCellValueFactory(new PropertyValueFactory<>("dateOfCreatedInsurance"));
        t2.setCellValueFactory(new PropertyValueFactory<>("insuranceAmount"));
        t3.setCellValueFactory(new PropertyValueFactory<>("owner"));
        t4.setCellValueFactory(new PropertyValueFactory<>("registerNr"));
        t5.setCellValueFactory(new PropertyValueFactory<>("boatTypeAndModel"));
        t6.setCellValueFactory(new PropertyValueFactory<>("lengthInFoot"));
        t7.setCellValueFactory(new PropertyValueFactory<>("motorTypeAndMotorPower"));

        table.setItems(boatInsurance);
        }).start();


    }
}