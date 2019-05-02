package org.openjfx;

import Damages.Damage_Report;
import Exceptions.ExceptionHandler;
import FileManagement.CsvWriter;
import Serialisering.SearchAndReadFromCSV;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.util.StringConverter;


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
    private TableColumn<Damage_Report, String> dmgType, dmgDescription, potentialWitnesses, unpaid;

    @FXML
    private TableColumn<Damage_Report, Integer> dmgNr;

    @FXML
    private TextArea desciption;

    private static StringConverter<Integer> converter = new StringConverter<>() {
        @Override
        public String toString(Integer object) {
            return Integer.toString(object);
        }

        @Override
        public Integer fromString(String string) {
            return Integer.parseInt(string);
        }
    };


    /**
     * Initialize Method where we set Table View values and get Customer selected PersonalID
     */
    @FXML
    private void initialize(){
        customerLabel.setText(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));
        handlerFxml.setCellValueDamageReport(dmgType, dmgDescription, dmgNr, potentialWitnesses, unpaid,damageTableView);

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

            handlerFxml.setCellValueDamageReport(dmgType, dmgDescription, dmgNr, potentialWitnesses, unpaid,damageTableView);

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


    /**
     * @return Damage Report selcted
     */
    public static Damage_Report getDamageReport() {
        return damageReportSelected;
    }


    /**
     * Method that edits the Damage Type in the table view
     * @param damage_reportStringCellEditEvent
     */
    public void onEditDamageType(TableColumn.CellEditEvent<Damage_Report, String> damage_reportStringCellEditEvent) {
        Damage_Report damageModifiable = damageTableView.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteDamageReportFromCsv(String.valueOf(damageModifiable.getDateOfDamage()));
        damageModifiable.setDamageType(damage_reportStringCellEditEvent.getNewValue());
        CsvWriter.writeDamageReport(damageModifiable);
        damageTableView.setEditable(false);

    }

    /**
     * Method that edits the Damage Description in the table view
     * @param damage_reportStringCellEditEvent
     */
    public void onEditDamageDesc(TableColumn.CellEditEvent<Damage_Report, String> damage_reportStringCellEditEvent) {
        Damage_Report damageModifiable = damageTableView.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteDamageReportFromCsv(String.valueOf(damageModifiable.getDateOfDamage()));
        damageModifiable.setDamageDescription(damage_reportStringCellEditEvent.getNewValue());
        CsvWriter.writeDamageReport(damageModifiable);
        damageTableView.setEditable(false);
    }


    /**
     * Method that edits the Damage number in the table view
     * @param damage_reportStringCellEditEvent
     */
    /*
    public void onEditDamageNr(TableColumn.CellEditEvent<Damage_Report, Integer> damage_reportStringCellEditEvent) {
        Damage_Report damageModifiable = damageTableView.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteDamageReportFromCsv(String.valueOf(damageModifiable.getDateOfDamage()));
        damageModifiable.setDamageNr(damage_reportStringCellEditEvent.getNewValue());
        CsvWriter.writeDamageReport(damageModifiable);
        damageTableView.setEditable(false);
    }

     */

    /**
     * Method that edits the potential Witnesses in the table view
     * @param damage_reportStringCellEditEvent
     */
    public void onEditWitnesses(TableColumn.CellEditEvent<Damage_Report, String> damage_reportStringCellEditEvent) {
        Damage_Report damageModifiable = damageTableView.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteDamageReportFromCsv(String.valueOf(damageModifiable.getDateOfDamage()));
        damageModifiable.setContactOfPotentialWitnesses(damage_reportStringCellEditEvent.getNewValue());
        CsvWriter.writeDamageReport(damageModifiable);
        damageTableView.setEditable(false);
    }

    /**
     * Method that enables editing in the table view
     * @param event
     */
    public void editReport(ActionEvent event) {
        damageTableView.setEditable(true);
        dmgType.setCellFactory(TextFieldTableCell.forTableColumn());
        dmgDescription.setCellFactory(TextFieldTableCell.forTableColumn());
        potentialWitnesses.setCellFactory(TextFieldTableCell.forTableColumn());
        ExceptionHandler.modifyAlertbox("Modify Damage Report");
    }
}
