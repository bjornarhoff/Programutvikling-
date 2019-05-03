package org.openjfx;

import CustomerModell.Customer;
import Exceptions.ExceptionHandler;
import FileManagement.CsvWriter;
import Insurances.Boat_Insurance;
import Insurances.Household_Insurance;
import Insurances.Leisure_Insurance;
import Insurances.Travel_Insurance;
import FileManagement.DeleteFromCSV;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.util.StringConverter;

import java.io.FileNotFoundException;


public class ALLInsurancesController {

    /**
     * Method that converts String to Integer and from String to Integer and handles
     */
    private static StringConverter<Integer> converter = new StringConverter<>() {
        @Override
        public String toString(Integer object) throws NumberFormatException, NullPointerException {
            try {
                Integer.toString(object);
                return Integer.toString(object);
            } catch (NullPointerException e) {
                return null;
            }


        }

        @Override
        public Integer fromString(String string) throws NumberFormatException {
            try {
                Integer.parseInt(string);
                return Integer.parseInt(string);

            } catch (NumberFormatException e) {
                ExceptionHandler.alertBox("Wrong Input Provided", "Please provide only Numbers as input in this textfield", "Please change your input to a valid number");

            }
            return null;

        }
    };
    HandlerFxml handlerFxml = new HandlerFxml();
    Customer customerEditable = HomeInsuranceController.getCustomerSelected();
    @FXML
    private BorderPane allInsurancesScreen;
    @FXML
    private Label customerSelected;
    @FXML
    private JFXButton modifyHousehold, delHousehold, modifyTravel, delTravel, modifyLeisure, modifyBoat, delBoat, cancel,
            showHousehold, showTravel, showLeisure, showBoat, delLeisure;
    @FXML
    private JFXTextArea info;
    @FXML
    private TableView<Household_Insurance> tvHousehold;
    @FXML
    private TableView<Travel_Insurance> tvTravel;
    @FXML
    private TableView<Leisure_Insurance> tvLeisure;
    @FXML
    private TableView<Boat_Insurance> tvBoat;
    @FXML
    private TableColumn<Household_Insurance, String> HouseyearlyPremium, houseOwner, houseInsuranceConditions, houseConstMaterial, houseCondition;
    @FXML
    private TableColumn<Household_Insurance, Integer> houseInsAmount, amountHousehold;
    @FXML
    private TableColumn<Travel_Insurance, String> travelDate, travelInsConditions, travelInsArea, travelYearlyPremium;
    @FXML
    private TableColumn<Travel_Insurance, Integer> travelInsAmount;
    @FXML
    private TableColumn<Leisure_Insurance, String> leisureDate, conditions, leisureCondition, leisureConstrMaterial, leisureNrSquareMeters, yearlyPremium;
    @FXML
    private TableColumn<Leisure_Insurance, Integer> amountLeisure;
    @FXML
    private TableColumn<Boat_Insurance, String> boatDate, boatOwner, boatRegisterNr, boatTypeModel, boatLengthFoot, motorType;
    @FXML
    private TableColumn<Boat_Insurance, Integer> boatInsAmount;

    /**
     * Initialize Method that starts the page with Table view data and disables buttons before a Table view is marked
     */
    @FXML
    private void initialize() {
        customerSelected.setText(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));

        handlerFxml.setCellValueHousehold(HouseyearlyPremium, houseInsAmount, houseInsuranceConditions, houseOwner, houseConstMaterial, houseCondition, amountHousehold, tvHousehold);
        handlerFxml.setCellValueTravel(travelDate, travelInsAmount, travelYearlyPremium, travelInsConditions, travelInsArea, tvTravel);
        handlerFxml.setCellValueBoat(boatDate, boatInsAmount, boatOwner, boatRegisterNr, boatTypeModel, boatLengthFoot, motorType, tvBoat);
        handlerFxml.setCellValueLeisure(leisureDate, yearlyPremium, conditions, leisureConstrMaterial, leisureCondition, leisureNrSquareMeters, amountLeisure, tvLeisure);

        handlerFxml.enableWhenMarked(tvHousehold, modifyHousehold, delHousehold, showHousehold);
        handlerFxml.enableWhenMarked(tvLeisure, modifyLeisure, delLeisure, showLeisure);
        handlerFxml.enableWhenMarked(tvTravel, modifyTravel, delTravel, showTravel);
        handlerFxml.enableWhenMarked(tvBoat, modifyBoat, delBoat, showBoat);

    }

    /**
     * Method to hadndle button events like Delete Insurances, show full info and Modify Insurances
     *
     * @param event
     */
    @FXML
    public void handleButtonEvents(javafx.event.ActionEvent event) {
        if (event.getSource() == cancel) {
            handlerFxml.navigate(allInsurancesScreen, "homeInsurance.fxml");
        }
        if (event.getSource() == delHousehold) {
            String selectHouse = tvHousehold.getSelectionModel().getSelectedItem().getDateOfCreatedInsurance();
            DeleteFromCSV.deleteHouseholdFromCsv(String.valueOf(selectHouse));
            handlerFxml.setCellValueHousehold(HouseyearlyPremium, houseInsAmount, houseInsuranceConditions, houseOwner, houseConstMaterial, houseCondition, amountHousehold, tvHousehold);
            Customer.customerInsuranceCounterDeacrease(customerEditable);

        }
        if (event.getSource() == delBoat) {
            String selectBoat = tvBoat.getSelectionModel().getSelectedItem().getDateOfCreatedInsurance();
            DeleteFromCSV.deleteBoatFromCsv(String.valueOf(selectBoat));
            handlerFxml.setCellValueBoat(boatDate, boatInsAmount, boatOwner, boatRegisterNr, boatTypeModel, boatLengthFoot, motorType, tvBoat);
            Customer.customerInsuranceCounterDeacrease(customerEditable);


        }
        if (event.getSource() == delTravel) {
            String selectedTravel = tvTravel.getSelectionModel().getSelectedItem().getDateOfCreatedInsurance();
            DeleteFromCSV.deleteTravelFromCsv(String.valueOf(selectedTravel));
            handlerFxml.setCellValueTravel(travelDate, travelInsAmount, travelYearlyPremium, travelInsConditions, travelInsArea, tvTravel);
            Customer.customerInsuranceCounterDeacrease(customerEditable);


        }
        if (event.getSource() == delLeisure) {
            String selectLeisure = tvLeisure.getSelectionModel().getSelectedItem().getAddress_Not_Billing();
            DeleteFromCSV.deleteLeisureFromCsv(String.valueOf(selectLeisure));
            handlerFxml.setCellValueLeisure(leisureDate, yearlyPremium, conditions, leisureConstrMaterial, leisureCondition, leisureNrSquareMeters, amountLeisure, tvLeisure);
            Customer.customerInsuranceCounterDeacrease(customerEditable);
        }

        if (event.getSource() == showBoat) {
            String boat = tvBoat.getSelectionModel().getSelectedItem().toString();
            info.setText(boat);
        }
        if (event.getSource() == showHousehold) {
            String house = tvHousehold.getSelectionModel().getSelectedItem().toString();
            info.setText(house);
        }
        if (event.getSource() == showLeisure) {
            String leisure = tvLeisure.getSelectionModel().getSelectedItem().toString();
            info.setText(leisure);
        }
        if (event.getSource() == showTravel) {
            String travel = tvTravel.getSelectionModel().getSelectedItem().toString();
            info.setText(travel);
        }


        if (event.getSource() == modifyHousehold) {
            tvHousehold.setEditable(true);
            HouseyearlyPremium.setCellFactory(TextFieldTableCell.forTableColumn());
            houseInsAmount.setCellFactory(TextFieldTableCell.forTableColumn(converter));
            houseInsuranceConditions.setCellFactory(TextFieldTableCell.forTableColumn());
            houseOwner.setCellFactory(TextFieldTableCell.forTableColumn());
            houseConstMaterial.setCellFactory(TextFieldTableCell.forTableColumn());
            houseCondition.setCellFactory(TextFieldTableCell.forTableColumn());
            amountHousehold.setCellFactory(TextFieldTableCell.forTableColumn(converter));
            ExceptionHandler.modifyAlertbox("Modify Household Insurance");
        }

        if (event.getSource() == modifyTravel) {
            tvTravel.setEditable(true);
            travelInsAmount.setCellFactory(TextFieldTableCell.forTableColumn(converter));
            travelYearlyPremium.setCellFactory(TextFieldTableCell.forTableColumn());
            travelInsConditions.setCellFactory(TextFieldTableCell.forTableColumn());
            travelInsArea.setCellFactory(TextFieldTableCell.forTableColumn());
            ExceptionHandler.modifyAlertbox("Modify Travel Insurance");

        }

        if (event.getSource() == modifyLeisure) {
            tvLeisure.setEditable(true);
            leisureDate.setCellFactory(TextFieldTableCell.forTableColumn());
            yearlyPremium.setCellFactory(TextFieldTableCell.forTableColumn());
            conditions.setCellFactory(TextFieldTableCell.forTableColumn());
            leisureConstrMaterial.setCellFactory(TextFieldTableCell.forTableColumn());
            leisureCondition.setCellFactory(TextFieldTableCell.forTableColumn());
            amountLeisure.setCellFactory(TextFieldTableCell.forTableColumn(converter));
            ExceptionHandler.modifyAlertbox("Modify Leisure Insurance");

        }
        if (event.getSource() == modifyBoat) {
            tvBoat.setEditable(true);
            boatDate.setCellFactory(TextFieldTableCell.forTableColumn());
            boatInsAmount.setCellFactory(TextFieldTableCell.forTableColumn(converter));
            boatOwner.setCellFactory(TextFieldTableCell.forTableColumn());
            boatTypeModel.setCellFactory(TextFieldTableCell.forTableColumn());
            motorType.setCellFactory(TextFieldTableCell.forTableColumn());
            ExceptionHandler.modifyAlertbox("Modify Boat Insurance");

        }
    }

    /**
     * Method that edits Yearly premium in the Household table and replaces the edited term in the csv file
     *
     * @param CellEditEvent
     */
    public void editYearlyPremium(TableColumn.CellEditEvent<Household_Insurance, String> CellEditEvent) throws FileNotFoundException {
        Household_Insurance householdIns = tvHousehold.getSelectionModel().getSelectedItem();

        DeleteFromCSV.deleteHouseholdFromCsv(String.valueOf(householdIns.getDateOfCreatedInsurance()));
        householdIns.setYearlyInsurancePremium(CellEditEvent.getNewValue());
        CsvWriter.writeHouseInsuranceToCSV(householdIns, false);
        tvHousehold.setEditable(false);

    }

    /**
     * Method that edits Insurance Amount in the Household table and replaces the edited term in the csv file
     *
     * @param CellEditEvent
     */
    public void editInsurnaceAmount(TableColumn.CellEditEvent<Household_Insurance, Integer> CellEditEvent) throws FileNotFoundException {
        Household_Insurance householdIns = tvHousehold.getSelectionModel().getSelectedItem();
        DeleteFromCSV.deleteHouseholdFromCsv(String.valueOf(householdIns.getDateOfCreatedInsurance()));
        householdIns.setInsuranceAmount(CellEditEvent.getNewValue() == null ? CellEditEvent.getOldValue() : CellEditEvent.getNewValue());
        CsvWriter.writeHouseInsuranceToCSV(householdIns, false);
        tvHousehold.setEditable(false);
        handlerFxml.setCellValueHousehold(HouseyearlyPremium, houseInsAmount, houseInsuranceConditions, houseOwner, houseConstMaterial, houseCondition, amountHousehold, tvHousehold);


    }

    /**
     * Method that edits Insurance conditions in the Household table and replaces the edited term in the csv file
     *
     * @param CellEditEvent
     */
    public void editConditions(TableColumn.CellEditEvent<Household_Insurance, String> CellEditEvent) throws FileNotFoundException {
        Household_Insurance householdIns = tvHousehold.getSelectionModel().getSelectedItem();

        DeleteFromCSV.deleteHouseholdFromCsv(String.valueOf(householdIns.getDateOfCreatedInsurance()));
        householdIns.setInsuranceConditions(CellEditEvent.getNewValue());
        CsvWriter.writeHouseInsuranceToCSV(householdIns, false);
        tvHousehold.setEditable(false);

    }

    /**
     * Method that edits Property Owner in the Household table and replaces the edited term in the csv file
     *
     * @param CellEditEvent
     */
    public void editOwner(TableColumn.CellEditEvent<Household_Insurance, String> CellEditEvent) throws FileNotFoundException {
        Household_Insurance householdIns = tvHousehold.getSelectionModel().getSelectedItem();

        DeleteFromCSV.deleteHouseholdFromCsv(String.valueOf(householdIns.getDateOfCreatedInsurance()));
        householdIns.setPropertyOwner(CellEditEvent.getNewValue());
        CsvWriter.writeHouseInsuranceToCSV(householdIns, false);
        tvHousehold.setEditable(false);

    }

    /**
     * Method that edits Construction Material in the Household table and replaces the edited term in the csv file
     *
     * @param CellEditEvent
     */
    public void editConstructionMaterial(TableColumn.CellEditEvent<Household_Insurance, String> CellEditEvent) throws FileNotFoundException {
        Household_Insurance householdIns = tvHousehold.getSelectionModel().getSelectedItem();

        DeleteFromCSV.deleteHouseholdFromCsv(String.valueOf(householdIns.getDateOfCreatedInsurance()));
        householdIns.setConstructionMaterial(CellEditEvent.getNewValue());
        CsvWriter.writeHouseInsuranceToCSV(householdIns, false);
        tvHousehold.setEditable(false);

    }

    /**
     * Method that edits the House Condition in the Household table and replaces the edited term in the csv file
     *
     * @param CellEditEvent
     */
    public void editHouseCondition(TableColumn.CellEditEvent<Household_Insurance, String> CellEditEvent) throws FileNotFoundException {
        Household_Insurance householdIns = tvHousehold.getSelectionModel().getSelectedItem();

        DeleteFromCSV.deleteHouseholdFromCsv(String.valueOf(householdIns.getDateOfCreatedInsurance()));
        householdIns.setCondition(CellEditEvent.getNewValue());
        CsvWriter.writeHouseInsuranceToCSV(householdIns, false);
        tvHousehold.setEditable(false);

    }

    /**
     * Method that edits Household Amount in the Household table and replaces the edited term in the csv file
     *
     * @param CellEditEvent
     */
    public void editAmountHousehold(TableColumn.CellEditEvent<Household_Insurance, Integer> CellEditEvent) throws FileNotFoundException {
        Household_Insurance householdIns = tvHousehold.getSelectionModel().getSelectedItem();

        DeleteFromCSV.deleteHouseholdFromCsv(String.valueOf(householdIns.getDateOfCreatedInsurance()));
        householdIns.setInsuranceAmountForHousehold(CellEditEvent.getNewValue() == null ? CellEditEvent.getOldValue() : CellEditEvent.getNewValue());
        CsvWriter.writeHouseInsuranceToCSV(householdIns, false);
        tvHousehold.setEditable(false);
        handlerFxml.setCellValueHousehold(HouseyearlyPremium, houseInsAmount, houseInsuranceConditions, houseOwner, houseConstMaterial, houseCondition, amountHousehold, tvHousehold);


    }

    /**
     * Method that edits Insurance Area in the Travel table and replaces the edited term in the csv file
     *
     * @param editEvent
     */
    public void InsurnaceArea(TableColumn.CellEditEvent<Travel_Insurance, String> editEvent) throws FileNotFoundException {
        Travel_Insurance travelInsurance = tvTravel.getSelectionModel().getSelectedItem();

        DeleteFromCSV.deleteTravelFromCsv(String.valueOf(travelInsurance.getDateOfCreatedInsurance()));
        travelInsurance.setInsuranceArea(editEvent.getNewValue());
        CsvWriter.writeTravelInsjurance(travelInsurance, false);
        tvTravel.setEditable(false);

    }

    /**
     * Method that edits Insurance Amount in the Travel table and replaces the edited term in the csv file
     *
     * @param editEvent
     */
    public void editInsuranceAmountTravel(TableColumn.CellEditEvent<Travel_Insurance, Integer> editEvent) throws FileNotFoundException {
        Travel_Insurance travelInsurance = tvTravel.getSelectionModel().getSelectedItem();

        DeleteFromCSV.deleteTravelFromCsv(String.valueOf(travelInsurance.getDateOfCreatedInsurance()));
        travelInsurance.setInsuranceAmount(editEvent.getNewValue() == null ? editEvent.getOldValue() : editEvent.getNewValue());
        CsvWriter.writeTravelInsjurance(travelInsurance, false);
        tvTravel.setEditable(false);
        handlerFxml.setCellValueTravel(travelDate, travelInsAmount, travelYearlyPremium, travelInsConditions, travelInsArea, tvTravel);


    }

    /**
     * Method that edits Insurance Conditions in the Travel table and replaces the edited term in the csv file
     *
     * @param editEvent
     */
    public void editInsuranceConditions(TableColumn.CellEditEvent<Travel_Insurance, String> editEvent) throws FileNotFoundException {
        Travel_Insurance travelInsurance = tvTravel.getSelectionModel().getSelectedItem();

        DeleteFromCSV.deleteTravelFromCsv(String.valueOf(travelInsurance.getDateOfCreatedInsurance()));
        travelInsurance.setInsuranceConditions(editEvent.getNewValue());
        CsvWriter.writeTravelInsjurance(travelInsurance, false);
        tvTravel.setEditable(false);

    }

    /**
     * Method that edits Yearly Premium in the Travel table and replaces the edited term in the csv file
     *
     * @param editEvent
     */
    public void editYearlyPremiumTravel(TableColumn.CellEditEvent<Travel_Insurance, Integer> editEvent) throws FileNotFoundException {
        Travel_Insurance travelInsurance = tvTravel.getSelectionModel().getSelectedItem();

        DeleteFromCSV.deleteTravelFromCsv(String.valueOf(travelInsurance.getDateOfCreatedInsurance()));
        travelInsurance.setYearlyInsurancePremium(String.valueOf(editEvent.getNewValue()));
        CsvWriter.writeTravelInsjurance(travelInsurance, false);
        tvTravel.setEditable(false);


    }

    /**
     * Method that edits Yearly Premium in the Leisure table and replaces the edited term in the csv file
     *
     * @param cellEditEvent
     */
    public void editYearlyPremiumLeisure(TableColumn.CellEditEvent<Leisure_Insurance, String> cellEditEvent) throws FileNotFoundException {
        Leisure_Insurance leisureIns = tvLeisure.getSelectionModel().getSelectedItem();

        DeleteFromCSV.deleteLeisureFromCsv(String.valueOf(leisureIns.getAddress_Not_Billing()));
        leisureIns.setInsuranceConditions(cellEditEvent.getNewValue());
        CsvWriter.writeLeisureInsurance(leisureIns, false);
        tvLeisure.setEditable(false);

    }

    /**
     * Method that edits Insurance Condition in the Leisure table and replaces the edited term in the csv file
     *
     * @param cellEditEvent
     */
    public void editInsuranceConditionsLeisure(TableColumn.CellEditEvent<Leisure_Insurance, String> cellEditEvent) throws FileNotFoundException {
        Leisure_Insurance leisureIns = tvLeisure.getSelectionModel().getSelectedItem();

        DeleteFromCSV.deleteLeisureFromCsv(String.valueOf(leisureIns.getAddress_Not_Billing()));
        leisureIns.setInsuranceConditions(cellEditEvent.getNewValue());
        CsvWriter.writeLeisureInsurance(leisureIns, false);
        tvLeisure.setEditable(false);


    }

    /**
     * Method that edits Construction Material in the Leisure table and replaces the edited term in the csv file
     *
     * @param cellEditEvent
     */
    public void editConstructionMaterialLeisure(TableColumn.CellEditEvent<Leisure_Insurance, String> cellEditEvent) throws FileNotFoundException {
        Leisure_Insurance leisureIns = tvLeisure.getSelectionModel().getSelectedItem();

        DeleteFromCSV.deleteLeisureFromCsv(String.valueOf(leisureIns.getAddress_Not_Billing()));
        leisureIns.setConstructionMaterial(cellEditEvent.getNewValue());
        CsvWriter.writeLeisureInsurance(leisureIns, false);
        tvLeisure.setEditable(false);

    }

    /**
     * Method that edits Insurance Condition in the Leisure table and replaces the edited term in the csv file
     *
     * @param cellEditEvent
     */
    public void editLeisureConditions(TableColumn.CellEditEvent<Leisure_Insurance, String> cellEditEvent) throws FileNotFoundException {
        Leisure_Insurance leisureIns = tvLeisure.getSelectionModel().getSelectedItem();

        DeleteFromCSV.deleteLeisureFromCsv(String.valueOf(leisureIns.getAddress_Not_Billing()));
        leisureIns.setCondition(cellEditEvent.getNewValue());
        CsvWriter.writeLeisureInsurance(leisureIns, false);
        tvLeisure.setEditable(false);

    }

    /**
     * Method that edits Insurance Amount in the Leisure table and replaces the edited term in the csv file
     *
     * @param cellEditEvent
     */
    public void editLeisure(TableColumn.CellEditEvent<Leisure_Insurance, Integer> cellEditEvent) throws FileNotFoundException {
        Leisure_Insurance leisureIns = tvLeisure.getSelectionModel().getSelectedItem();

        DeleteFromCSV.deleteLeisureFromCsv(String.valueOf(leisureIns.getAddress_Not_Billing()));
        leisureIns.setAmountForHousehold(cellEditEvent.getNewValue() == null ? cellEditEvent.getOldValue() : cellEditEvent.getNewValue());
        CsvWriter.writeLeisureInsurance(leisureIns, false);
        tvLeisure.setEditable(false);
        handlerFxml.setCellValueLeisure(leisureDate, yearlyPremium, conditions, leisureConstrMaterial, leisureCondition, leisureNrSquareMeters, amountLeisure, tvLeisure);


    }

    /**
     * Method that edits Insurance Amount in the Boat table and replaces the edited term in the csv file
     *
     * @param cellEditEvent
     */
    public void editInsuranceAmountBoat(TableColumn.CellEditEvent<Boat_Insurance, Integer> cellEditEvent) throws FileNotFoundException {
        Boat_Insurance boatIns = tvBoat.getSelectionModel().getSelectedItem();

        DeleteFromCSV.deleteBoatFromCsv(String.valueOf(boatIns.getDateOfCreatedInsurance()));
        boatIns.setInsuranceAmount(cellEditEvent.getNewValue() == null ? cellEditEvent.getOldValue() : cellEditEvent.getNewValue());
        CsvWriter.writeBoatInsuranceToCSV(boatIns, false);
        tvBoat.setEditable(false);
        handlerFxml.setCellValueBoat(boatDate, boatInsAmount, boatOwner, boatRegisterNr, boatTypeModel, boatLengthFoot, motorType, tvBoat);


    }

    /**
     * Method that edits Insurance Owner in the Boat table and replaces the edited term in the csv file
     *
     * @param cellEditEvent
     */
    public void editOwnerBoat(TableColumn.CellEditEvent<Boat_Insurance, String> cellEditEvent) throws FileNotFoundException {
        Boat_Insurance boatIns = tvBoat.getSelectionModel().getSelectedItem();

        DeleteFromCSV.deleteBoatFromCsv(String.valueOf(boatIns.getDateOfCreatedInsurance()));
        boatIns.setOwner(cellEditEvent.getNewValue());
        CsvWriter.writeBoatInsuranceToCSV(boatIns, false);
        tvBoat.setEditable(false);

    }

    /**
     * Method that edits Boat Motor in the Boat table and replaces the edited term in the csv file
     *
     * @param cellEditEvent
     */
    public void editMotor(TableColumn.CellEditEvent<Boat_Insurance, String> cellEditEvent) throws FileNotFoundException {
        Boat_Insurance boatIns = tvBoat.getSelectionModel().getSelectedItem();

        DeleteFromCSV.deleteBoatFromCsv(String.valueOf(boatIns.getDateOfCreatedInsurance()));
        boatIns.setMotorTypeAndMotorPower(cellEditEvent.getNewValue());
        CsvWriter.writeBoatInsuranceToCSV(boatIns, false);
        tvBoat.setEditable(false);

    }


}