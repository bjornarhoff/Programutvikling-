package org.openjfx;

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
import javafx.scene.layout.BorderPane;



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
    private TableColumn<House_Household_Insurance, String> houseDate, houseInsAmount, houseOwner, houseResidentialType, houseConstMaterial,
    houseNrSquareMeters;

    @FXML
    private TableColumn<Travel_Insurance, String> travelDate, travelInsAmount, travelYearlyPremium, travelInsConditions, travelInsArea;

    @FXML
    private TableColumn<Leisure_Insurance, String> leisureDate, leisureInsAmount, leisureConstructionYear, leisureResidentialType, leisureConstrMaterial, leisureNrSquareMeters;

    @FXML
    private TableColumn<Boat_Insurance, String> boatDate, boatInsAmount, boatOwner, boatRegisterNr, boatTypeModel, boatLengthFoot;




    @FXML
    private void initialize(){
       customerSelected.setText(String.valueOf(HomeInsuranceController.getCustomerSelected().getPersonalID()));

       handlerFxml.setCellValueHousehold(houseDate, houseInsAmount, houseOwner, houseResidentialType, houseConstMaterial, houseNrSquareMeters, tvHousehold);
       handlerFxml.setCellValueTravel(travelDate, travelInsAmount, travelYearlyPremium, travelInsConditions, travelInsArea,tvTravel);
       handlerFxml.setCellValueBoat(boatDate, boatInsAmount, boatOwner, boatRegisterNr, boatTypeModel,boatLengthFoot, tvBoat);
       handlerFxml.setCellValueLeisure(leisureDate, leisureInsAmount, leisureConstructionYear, leisureResidentialType, leisureConstrMaterial,leisureNrSquareMeters, tvLeisure);



    }

    @FXML
    public void handleButtonEvents(javafx.event.ActionEvent event) {
        if(event.getSource() == cancel){
            handlerFxml.navigate(allInsurancesScreen, "homeInsurance.fxml");
        }
        if(event.getSource() == delHousehold){
            String selectHouse = tvHousehold.getSelectionModel().getSelectedItem().getDateOfCreatedInsurance();
            SearchAndReadFromCSV.deleteHouseholdFromCsv(String.valueOf(selectHouse));
            handlerFxml.setCellValueHousehold(houseDate, houseInsAmount, houseOwner, houseResidentialType, houseConstMaterial, houseNrSquareMeters, tvHousehold);

        }
        if(event.getSource() == delBoat){
            String selectBoat = tvBoat.getSelectionModel().getSelectedItem().getDateOfCreatedInsurance();
            SearchAndReadFromCSV.deleteBoatFromCsv(String.valueOf(selectBoat));
            handlerFxml.setCellValueBoat(boatDate, boatInsAmount, boatOwner, boatRegisterNr, boatTypeModel,boatLengthFoot, tvBoat);

        }
        if(event.getSource() == delTravel){
            String selectedTravel = tvTravel.getSelectionModel().getSelectedItem().getDateOfCreatedInsurance();
            SearchAndReadFromCSV.deleteTravelFromCsv(String.valueOf(selectedTravel));
            handlerFxml.setCellValueTravel(travelDate, travelInsAmount, travelYearlyPremium, travelInsConditions, travelInsArea,tvTravel);

        }
        if(event.getSource() == delLeisure){
            String selectLeisure = tvLeisure.getSelectionModel().getSelectedItem().getAddress_Not_Billing();
            SearchAndReadFromCSV.deleteLeisureFromCsv(String.valueOf(selectLeisure));
            handlerFxml.setCellValueLeisure(leisureDate, leisureInsAmount, leisureConstructionYear, leisureResidentialType, leisureConstrMaterial,leisureNrSquareMeters, tvLeisure);


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
    }
}


