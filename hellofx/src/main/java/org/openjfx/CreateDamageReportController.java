package org.openjfx;

import CustomerModell.Customer;
import Damages.Damage_Report;
import FileManagement.CsvWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.NumberValidator;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class CreateDamageReportController {

    HandlerFxml handlerFxml = new HandlerFxml();

    @FXML
    private BorderPane createDamageReport;

    @FXML
    private Label customerLabel;

    @FXML
    private JFXTextField txt_date, txt_damageType, damageNr, taxAmount, unpaidReplacements;

    @FXML
    private TextArea txta_DaDescription, txta_potWitnesses, txta_info;

    @FXML
    private JFXButton btn_cancel, btn_apply, btn_ok;

    @FXML
    private void initialize(){
        customerLabel.setText(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
    }

    @FXML
    private void cancel(ActionEvent event){
        handlerFxml.navigate(createDamageReport, "damageReport.fxml");
    }

    @FXML
    private void apply(ActionEvent event){

        Customer customer = HomeInsuranceController.getCustomerSelected();

        Damage_Report damage_report = new Damage_Report(txt_date.getText(), Integer.parseInt(damageNr.getText()), txt_damageType.getText(), txta_DaDescription.getText(), txta_potWitnesses.getText(),
                Double.parseDouble(taxAmount.getText()), Integer.parseInt(unpaidReplacements.getText()), customer);

        CsvWriter.writeDamageReport(damage_report);
        txta_info.setText(damage_report.toString());

        handlerFxml.clearInput();

    }


}
