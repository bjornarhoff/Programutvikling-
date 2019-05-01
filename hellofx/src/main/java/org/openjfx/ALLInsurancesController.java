package org.openjfx;

import Damages.Damage_Report;
import FileManagement.CsvWriter;
import Serialisering.SearchAndReadFromCSV;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import Insurances.Leisure_Insurance;
import Insurances.House_Household_Insurance;
import Insurances.Travel_Insurance;
import Insurances.Boat_Insurance;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.util.StringConverter;


public class ALLInsurancesController {

    HandlerFxml handlerFxml = new HandlerFxml();

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
    private TableView<House_Household_Insurance> tvHousehold;

    @FXML
    private TableView<Travel_Insurance> tvTravel;

    @FXML
    private TableView<Leisure_Insurance> tvLeisure;

    @FXML
    private TableView<Boat_Insurance> tvBoat;

    @FXML
    private TableColumn<House_Household_Insurance, String> HouseyearlyPremium, houseOwner, houseInsuranceConditions, houseConstMaterial, houseCondition;

    @FXML
    private TableColumn<House_Household_Insurance, Integer>  houseInsAmount, amountHousehold;

    @FXML
    private TableColumn<Travel_Insurance, String> travelDate, travelInsConditions, travelInsArea, travelYearlyPremium;

    @FXML
    private TableColumn<Travel_Insurance, Integer> travelInsAmount;

    @FXML
    private TableColumn<Leisure_Insurance, String> leisureDate, conditions, leisureCondition, leisureConstrMaterial, leisureNrSquareMeters, yearlyPremium ;

    @FXML
    private TableColumn<Leisure_Insurance, Integer> amountLeisure;

    @FXML
    private TableColumn<Boat_Insurance, String> boatDate, boatOwner, boatRegisterNr, boatTypeModel, boatLengthFoot, motorType;

    @FXML
    private TableColumn<Boat_Insurance, Integer> boatInsAmount;


    private static StringConverter<Integer> converter = new StringConverter<Integer>() {
        @Override
        public String toString(Integer object) {
            return Integer.toString(object);
        }

        @Override
        public Integer fromString(String string) {
            return Integer.parseInt(string);
        }
    };


    @FXML
    private void initialize(){
       customerSelected.setText(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));

       handlerFxml.setCellValueHousehold(HouseyearlyPremium, houseInsAmount, houseInsuranceConditions, houseOwner, houseConstMaterial, houseCondition, amountHousehold, tvHousehold);
       handlerFxml.setCellValueTravel(travelDate, travelInsAmount, travelYearlyPremium, travelInsConditions, travelInsArea,tvTravel);
       handlerFxml.setCellValueBoat(boatDate, boatInsAmount, boatOwner, boatRegisterNr, boatTypeModel,boatLengthFoot, motorType, tvBoat);
       handlerFxml.setCellValueLeisure(leisureDate, yearlyPremium, conditions, leisureConstrMaterial, leisureCondition,leisureNrSquareMeters, amountLeisure, tvLeisure);

       handlerFxml.enableWhenMarked(tvHousehold, modifyHousehold, delHousehold, showHousehold);
       handlerFxml.enableWhenMarked(tvLeisure, modifyLeisure, delLeisure, showLeisure);
       handlerFxml.enableWhenMarked(tvTravel, modifyTravel, delTravel, showTravel);
       handlerFxml.enableWhenMarked(tvBoat, modifyBoat, delBoat, showBoat);

    }

    @FXML
    public void handleButtonEvents(javafx.event.ActionEvent event) {
        if(event.getSource() == cancel){
            handlerFxml.navigate(allInsurancesScreen, "homeInsurance.fxml");
        }
        if(event.getSource() == delHousehold){
            String selectHouse = tvHousehold.getSelectionModel().getSelectedItem().getDateOfCreatedInsurance();
            SearchAndReadFromCSV.deleteHouseholdFromCsv(String.valueOf(selectHouse));
            handlerFxml.setCellValueHousehold(HouseyearlyPremium, houseInsAmount, houseInsuranceConditions, houseOwner, houseConstMaterial, houseCondition, amountHousehold, tvHousehold);

        }
        if(event.getSource() == delBoat){
            String selectBoat = tvBoat.getSelectionModel().getSelectedItem().getDateOfCreatedInsurance();
            SearchAndReadFromCSV.deleteBoatFromCsv(String.valueOf(selectBoat));
            handlerFxml.setCellValueBoat(boatDate, boatInsAmount, boatOwner, boatRegisterNr, boatTypeModel,boatLengthFoot, motorType, tvBoat);

        }
        if(event.getSource() == delTravel){
            String selectedTravel = tvTravel.getSelectionModel().getSelectedItem().getDateOfCreatedInsurance();
            SearchAndReadFromCSV.deleteTravelFromCsv(String.valueOf(selectedTravel));
            handlerFxml.setCellValueTravel(travelDate, travelInsAmount, travelYearlyPremium, travelInsConditions, travelInsArea,tvTravel);

        }
        if(event.getSource() == delLeisure){
            String selectLeisure = tvLeisure.getSelectionModel().getSelectedItem().getAddress_Not_Billing();
            SearchAndReadFromCSV.deleteLeisureFromCsv(String.valueOf(selectLeisure));
            handlerFxml.setCellValueLeisure(leisureDate, yearlyPremium, conditions, leisureConstrMaterial, leisureCondition,leisureNrSquareMeters, amountLeisure, tvLeisure);


        }
        if(event.getSource() == showBoat){
            String boat = tvBoat.getSelectionModel().getSelectedItem().toString();
            info.setText(boat);
        }
        if(event.getSource() == showHousehold){
            String house = tvHousehold.getSelectionModel().getSelectedItem().toString();
            info.setText(house);
        }
        if(event.getSource() == showLeisure){
            String leisure = tvLeisure.getSelectionModel().getSelectedItem().toString();
            info.setText(leisure);
        }
        if(event.getSource() == showTravel){
            String travel = tvTravel.getSelectionModel().getSelectedItem().toString();
            info.setText(travel);
        }


        if(event.getSource() == modifyHousehold){
            tvHousehold.setEditable(true);
            HouseyearlyPremium.setCellFactory(TextFieldTableCell.forTableColumn());
            houseInsAmount.setCellFactory(TextFieldTableCell.forTableColumn(converter));
            houseInsuranceConditions.setCellFactory(TextFieldTableCell.forTableColumn());
            houseOwner.setCellFactory(TextFieldTableCell.forTableColumn());
            houseConstMaterial.setCellFactory(TextFieldTableCell.forTableColumn());
            houseCondition.setCellFactory(TextFieldTableCell.forTableColumn());
            amountHousehold.setCellFactory(TextFieldTableCell.forTableColumn(converter));
        }

        if(event.getSource() == modifyTravel){
            tvTravel.setEditable(true);
            travelInsAmount.setCellFactory(TextFieldTableCell.forTableColumn(converter));
            travelYearlyPremium.setCellFactory(TextFieldTableCell.forTableColumn());
            travelInsConditions.setCellFactory(TextFieldTableCell.forTableColumn());
            travelInsArea.setCellFactory(TextFieldTableCell.forTableColumn());
        }

        if(event.getSource() == modifyLeisure){
            tvLeisure.setEditable(true);
            leisureDate.setCellFactory(TextFieldTableCell.forTableColumn());
            yearlyPremium.setCellFactory(TextFieldTableCell.forTableColumn());
            conditions.setCellFactory(TextFieldTableCell.forTableColumn());
            leisureConstrMaterial.setCellFactory(TextFieldTableCell.forTableColumn());
            leisureCondition.setCellFactory(TextFieldTableCell.forTableColumn());
            amountLeisure.setCellFactory(TextFieldTableCell.forTableColumn(converter));
        }
        if(event.getSource() == modifyBoat){
            tvBoat.setEditable(true);
            boatDate.setCellFactory(TextFieldTableCell.forTableColumn());
            boatInsAmount.setCellFactory(TextFieldTableCell.forTableColumn(converter));
            boatOwner.setCellFactory(TextFieldTableCell.forTableColumn());
            boatTypeModel.setCellFactory(TextFieldTableCell.forTableColumn());
            motorType.setCellFactory(TextFieldTableCell.forTableColumn());
        }
    }

    /**
     * Method that edits Yearly premium in the Household table and replaces the edited term in the csv file
     * @param house_household_insuranceStringCellEditEvent
     */
    public void editYearlyPremium(TableColumn.CellEditEvent<House_Household_Insurance, String> house_household_insuranceStringCellEditEvent) {
        House_Household_Insurance householdIns = tvHousehold.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteHouseholdFromCsv(String.valueOf(householdIns.getDateOfCreatedInsurance()));
        householdIns.setYearlyInsurancePremium(house_household_insuranceStringCellEditEvent.getNewValue());
        CsvWriter.writeHouseInsuranceToCSV(householdIns, false);
        tvHousehold.setEditable(false);

    }

    /**
     * Method that edits Insurance Amount in the Household table and replaces the edited term in the csv file
     * @param house_household_insuranceStringCellEditEvent
     */
    public void editInsurnaceAmount(TableColumn.CellEditEvent<House_Household_Insurance, Integer> house_household_insuranceStringCellEditEvent) {
        House_Household_Insurance householdIns = tvHousehold.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteHouseholdFromCsv(String.valueOf(householdIns.getDateOfCreatedInsurance()));
        householdIns.setInsuranceAmount(house_household_insuranceStringCellEditEvent.getNewValue());
        CsvWriter.writeHouseInsuranceToCSV(householdIns, false);
        tvHousehold.setEditable(false);

    }

    /**
     * Method that edits Insurance conditions in the Household table and replaces the edited term in the csv file
     * @param house_household_insuranceStringCellEditEvent
     */
    public void editConditions(TableColumn.CellEditEvent<House_Household_Insurance, String> house_household_insuranceStringCellEditEvent) {
        House_Household_Insurance householdIns = tvHousehold.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteHouseholdFromCsv(String.valueOf(householdIns.getDateOfCreatedInsurance()));
        householdIns.setInsuranceConditions(house_household_insuranceStringCellEditEvent.getNewValue());
        CsvWriter.writeHouseInsuranceToCSV(householdIns, false);
        tvHousehold.setEditable(false);

    }

    /**
     * Method that edits Property Owner in the Household table and replaces the edited term in the csv file
     * @param house_household_insuranceStringCellEditEvent
     */
    public void editOwner(TableColumn.CellEditEvent<House_Household_Insurance, String> house_household_insuranceStringCellEditEvent) {
        House_Household_Insurance householdIns = tvHousehold.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteHouseholdFromCsv(String.valueOf(householdIns.getDateOfCreatedInsurance()));
        householdIns.setPropertyOwner(house_household_insuranceStringCellEditEvent.getNewValue());
        CsvWriter.writeHouseInsuranceToCSV(householdIns, false);
        tvHousehold.setEditable(false);

    }

    /**
     * Method that edits Construction Material in the Household table and replaces the edited term in the csv file
     * @param house_household_insuranceStringCellEditEvent
     */
    public void editConstructionMaterial(TableColumn.CellEditEvent<House_Household_Insurance, String> house_household_insuranceStringCellEditEvent) {
        House_Household_Insurance householdIns = tvHousehold.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteHouseholdFromCsv(String.valueOf(householdIns.getDateOfCreatedInsurance()));
        householdIns.setConstructionMaterial(house_household_insuranceStringCellEditEvent.getNewValue());
        CsvWriter.writeHouseInsuranceToCSV(householdIns, false);
        tvHousehold.setEditable(false);

    }

    /**
     * Method that edits the House Condition in the Household table and replaces the edited term in the csv file
     * @param house_household_insuranceStringCellEditEvent
     */
    public void editHouseCondition(TableColumn.CellEditEvent<House_Household_Insurance, String> house_household_insuranceStringCellEditEvent) {
        House_Household_Insurance householdIns = tvHousehold.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteHouseholdFromCsv(String.valueOf(householdIns.getDateOfCreatedInsurance()));
        householdIns.setCondition(house_household_insuranceStringCellEditEvent.getNewValue());
        CsvWriter.writeHouseInsuranceToCSV(householdIns, false);
        tvHousehold.setEditable(false);

    }

    /**
     * Method that edits Household Amount in the Household table and replaces the edited term in the csv file
     * @param house_household_insuranceStringCellEditEvent
     */
    public void editAmountHousehold(TableColumn.CellEditEvent<House_Household_Insurance, Integer> house_household_insuranceStringCellEditEvent) {
        House_Household_Insurance householdIns = tvHousehold.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteHouseholdFromCsv(String.valueOf(householdIns.getDateOfCreatedInsurance()));
        householdIns.setInsuranceAmountForHousehold(house_household_insuranceStringCellEditEvent.getNewValue());
        CsvWriter.writeHouseInsuranceToCSV(householdIns, false);
        tvHousehold.setEditable(false);


    }

    /**
     * Method that edits Insurance Area in the Travel table and replaces the edited term in the csv file
     * @param editEvent
     */
    public void InsurnaceArea(TableColumn.CellEditEvent<Travel_Insurance, String> editEvent) {
        Travel_Insurance travelInsurance = tvTravel.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteTravelFromCsv(String.valueOf(travelInsurance.getDateOfCreatedInsurance()));
        travelInsurance.setInsuranceArea(editEvent.getNewValue());
        CsvWriter.writeTravelInsjurance(travelInsurance, false);
        tvTravel.setEditable(false);

    }

    /**
     * Method that edits Insurance Amount in the Travel table and replaces the edited term in the csv file
     * @param editEvent
     */
    public void editInsuranceAmountTravel(TableColumn.CellEditEvent<Travel_Insurance, Integer> editEvent) {
        Travel_Insurance travelInsurance = tvTravel.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteTravelFromCsv(String.valueOf(travelInsurance.getDateOfCreatedInsurance()));
        travelInsurance.setInsuranceAmount(editEvent.getNewValue());
        CsvWriter.writeTravelInsjurance(travelInsurance, false);
        tvTravel.setEditable(false);

    }

    /**
     * Method that edits Insurance Conditions in the Travel table and replaces the edited term in the csv file
     * @param editEvent
     */
    public void editInsuranceConditions(TableColumn.CellEditEvent<Travel_Insurance, String> editEvent) {
        Travel_Insurance travelInsurance = tvTravel.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteTravelFromCsv(String.valueOf(travelInsurance.getDateOfCreatedInsurance()));
        travelInsurance.setInsuranceConditions(editEvent.getNewValue());
        CsvWriter.writeTravelInsjurance(travelInsurance, false);
        tvTravel.setEditable(false);

    }

    /**
     * Method that edits Yearly Premium in the Travel table and replaces the edited term in the csv file
     * @param editEvent
     */
    public void editYearlyPremiumTravel(TableColumn.CellEditEvent<Travel_Insurance, Integer> editEvent) {
        Travel_Insurance travelInsurance = tvTravel.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteTravelFromCsv(String.valueOf(travelInsurance.getDateOfCreatedInsurance()));
        travelInsurance.setYearlyInsurancePremium(String.valueOf(editEvent.getNewValue()));
        CsvWriter.writeTravelInsjurance(travelInsurance, false);
        tvTravel.setEditable(false);


    }

    /**
     * Method that edits Yearly Premium in the Leisure table and replaces the edited term in the csv file
     * @param cellEditEvent
     */
    public void editYearlyPremiumLeisure(TableColumn.CellEditEvent<Leisure_Insurance, String> cellEditEvent) {
        Leisure_Insurance leisureIns = tvLeisure.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteLeisureFromCsv(String.valueOf(leisureIns.getAddress_Not_Billing()));
        leisureIns.setInsuranceConditions(cellEditEvent.getNewValue());
        CsvWriter.writeLeisureInsurance(leisureIns,false);
        tvLeisure.setEditable(false);

    }

    /**
     * Method that edits Insurance Condition in the Leisure table and replaces the edited term in the csv file
     * @param cellEditEvent
     */
    public void editInsuranceConditionsLeisure(TableColumn.CellEditEvent<Leisure_Insurance, String> cellEditEvent) {
        Leisure_Insurance leisureIns = tvLeisure.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteLeisureFromCsv(String.valueOf(leisureIns.getAddress_Not_Billing()));
        leisureIns.setInsuranceConditions(cellEditEvent.getNewValue());
        CsvWriter.writeLeisureInsurance(leisureIns,false);
        tvLeisure.setEditable(false);


    }

    /**
     * Method that edits Construction Material in the Leisure table and replaces the edited term in the csv file
     * @param cellEditEvent
     */
    public void editConstructionMaterialLeisure(TableColumn.CellEditEvent<Leisure_Insurance, String> cellEditEvent) {
        Leisure_Insurance leisureIns = tvLeisure.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteLeisureFromCsv(String.valueOf(leisureIns.getAddress_Not_Billing()));
        leisureIns.setConstructionMaterial(cellEditEvent.getNewValue());
        CsvWriter.writeLeisureInsurance(leisureIns,false);
        tvLeisure.setEditable(false);

    }

    /**
     * Method that edits Insurance Condition in the Leisure table and replaces the edited term in the csv file
     * @param cellEditEvent
     */
    public void editLeisureConditions(TableColumn.CellEditEvent<Leisure_Insurance, String> cellEditEvent) {
        Leisure_Insurance leisureIns = tvLeisure.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteLeisureFromCsv(String.valueOf(leisureIns.getAddress_Not_Billing()));
        leisureIns.setCondition(cellEditEvent.getNewValue());
        CsvWriter.writeLeisureInsurance(leisureIns, false);
        tvLeisure.setEditable(false);

    }

    /**
     * Method that edits Insurance Amount in the Leisure table and replaces the edited term in the csv file
     * @param cellEditEvent
     */
    public void editLeisure(TableColumn.CellEditEvent<Leisure_Insurance, Integer> cellEditEvent) {
        Leisure_Insurance leisureIns = tvLeisure.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteLeisureFromCsv(String.valueOf(leisureIns.getAddress_Not_Billing()));
        leisureIns.setAmountForHousehold(cellEditEvent.getNewValue());
        CsvWriter.writeLeisureInsurance(leisureIns, false);
        tvLeisure.setEditable(false);

    }

    /**
     * Method that edits Insurance Amount in the Boat table and replaces the edited term in the csv file
     * @param cellEditEvent
     */
    public void editInsuranceAmountBoat(TableColumn.CellEditEvent<Boat_Insurance, Integer> cellEditEvent) {
        Boat_Insurance boatIns = tvBoat.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteBoatFromCsv(String.valueOf(boatIns.getDateOfCreatedInsurance()));
        boatIns.setInsuranceAmount(cellEditEvent.getNewValue());
        CsvWriter.writeBoatInsuranceToCSV(boatIns, false);
        tvBoat.setEditable(false);

    }

    /**
     * Method that edits Insurance Owner in the Boat table and replaces the edited term in the csv file
     * @param cellEditEvent
     */
    public void editOwnerBoat(TableColumn.CellEditEvent<Boat_Insurance, String> cellEditEvent) {
        Boat_Insurance boatIns = tvBoat.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteBoatFromCsv(String.valueOf(boatIns.getDateOfCreatedInsurance()));
        boatIns.setOwner(cellEditEvent.getNewValue());
        CsvWriter.writeBoatInsuranceToCSV(boatIns, false);
        tvBoat.setEditable(false);

    }

    /**
     * Method that edits Boat Motor in the Boat table and replaces the edited term in the csv file
     * @param cellEditEvent
     */
    public void editMotor(TableColumn.CellEditEvent<Boat_Insurance, String> cellEditEvent) {
        Boat_Insurance boatIns = tvBoat.getSelectionModel().getSelectedItem();

        SearchAndReadFromCSV.deleteBoatFromCsv(String.valueOf(boatIns.getDateOfCreatedInsurance()));
        boatIns.setMotorTypeAndMotorPower(cellEditEvent.getNewValue());
        CsvWriter.writeBoatInsuranceToCSV(boatIns, false);
        tvBoat.setEditable(false);

    }



}

