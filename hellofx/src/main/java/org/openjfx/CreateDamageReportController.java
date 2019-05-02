package org.openjfx;

import CustomerModell.Customer;
import Damages.Damage_Report;
import Exceptions.ExceptionHandler;
import FileManagement.CsvWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.AnimationTimer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;

import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CreateDamageReportController {

    HandlerFxml handlerFxml = new HandlerFxml();

    @FXML
    private BorderPane createDamageReport;

    @FXML
    private Label customerLabel;

    @FXML
    private JFXTextField txt_damageType, damageNr, taxAmount, unpaidReplacements;

    @FXML
    private TextArea txta_DaDescription, txta_potWitnesses, txta_info;

    @FXML
    private JFXButton btn_cancel, btn_apply, btn_ok;

    private boolean validateNumber() {
        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(damageNr.getText());
        Matcher m2 = p.matcher(taxAmount.getText());
        Matcher m3 = p.matcher(unpaidReplacements.getText());

        if (m.find() && m.group().equals(damageNr.getText()) && m2.find() && m2.group().equals(taxAmount.getText()) && m3.find() &&
                m3.group().equals(unpaidReplacements.getText())) {
            return true;
        } else {
            ExceptionHandler.alertBox("Wrong Input Data Type", "Check red highleted boxes", "Convert Leters into numbers");
            return false;
        }
    }

    /**
     * Initialize Method that gets Customer selected PersonalID
     */
    @FXML
    private void initialize() {
        customerLabel.setText(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
        handlerFxml.setInputValidation(damageNr);
        handlerFxml.setInputValidation(taxAmount);
        handlerFxml.setInputValidation(unpaidReplacements);

        new AnimationTimer() {
            @Override
            public void handle(long l) {
                boolean allFilled = handlerFxml.enableButton(btn_apply, txt_damageType, damageNr, taxAmount, unpaidReplacements);
                if (allFilled) {
                    btn_apply.setDisable(false);
                } else {
                    btn_apply.setDisable(true);
                }
            }
        }.start();
    }

    /**
     * Method that returns to the Damage Report page
     *
     * @param event
     */
    @FXML
    private void cancel(ActionEvent event) {
        handlerFxml.navigate(createDamageReport, "damageReport.fxml");
    }

    /**
     * Method where a Damage Report is created for the selected Customer and text fields are reset
     *
     * @param event
     */
    @FXML
    private void apply(ActionEvent event) {

        Customer customer = HomeInsuranceController.getCustomerSelected();
        if (validateNumber())
            try {

                Damage_Report damage_report = new Damage_Report(String.valueOf(new Date()), Integer.parseInt(damageNr.getText()), txt_damageType.getText(), txta_DaDescription.getText(), txta_potWitnesses.getText(),
                        Double.parseDouble(taxAmount.getText()), Integer.parseInt(unpaidReplacements.getText()), customer);

                CsvWriter.writeDamageReport(damage_report);
                txta_info.setText(damage_report.toString());

                handlerFxml.clearInput();
            } catch (Exception e) {
                System.out.println("wrong input provided");
            }

    }


}
