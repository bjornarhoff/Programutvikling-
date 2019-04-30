package org.openjfx;

import Damages.Damage_Report;
import Serialisering.SearchAndReadFromCSV;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;


public class DamageReportController {

    HandlerFxml handlerFxml = new HandlerFxml();

    static Damage_Report damageReportSelected;

    @FXML
    private BorderPane damageReport;

    @FXML
    private Label customerLabel;

    @FXML
    private JFXButton btn_create, btn_edit, btn_showDescription, btn_delete, btn_goBack;

    @FXML
    private TableView<Damage_Report> damageTableView;

    @FXML
    private TableColumn<Damage_Report, String> dmgType,dmgNr, dmgDate, tax, unpaid;

    @FXML
    private TextArea desciption;

    /**
     * Initialize Method where we set Table View values and get Customer selected PersonalID
     */
    @FXML
    private void initialize(){
        customerLabel.setText(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
        handlerFxml.setCellValueDamageReport(dmgType, dmgNr, dmgDate, tax, unpaid,damageTableView);
    }

    /**
     * Method for switching to Create Damage Report page
     * @param event
     */
    @FXML
    private void createDamageReport(ActionEvent event){
        handlerFxml.navigate(damageReport, "createDamageReport.fxml");
    }

    /**
     * Method for getting back to the Customer home page
     */
    @FXML
    private void goBackPressed(){
        handlerFxml.navigate(damageReport, "homeCustomer.fxml");
    }

    /**
     * Method for deleting selected Damage Report
     * @param event
     */
    @FXML
    private void delete(ActionEvent event){
        if (event.getSource() == btn_delete){
            String customerSelected = damageTableView.getSelectionModel().getSelectedItem().getDateOfDamage();
            SearchAndReadFromCSV.deleteDamageReportFromCsv(customerSelected);

            handlerFxml.setCellValueDamageReport(dmgType, dmgNr, dmgDate, tax, unpaid,damageTableView);
        }
    }

    /**
     * Method for showing full info about a Damage Report object
     * @param event
     */
    @FXML
    private void show(ActionEvent event){
        if(event.getSource() == btn_showDescription){
            String damageReport = damageTableView.getSelectionModel().getSelectedItem().toString();

            desciption.setText(damageReport);
        }
    }


    public static Damage_Report getDamageReport() {
        return damageReportSelected;
    }
}
