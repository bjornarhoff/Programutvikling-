package FileManagement;

import CustomerModell.Customer;
import Damages.Damage_Report;
import Exceptions.ExceptionHandler;
import Insurances.*;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.openjfx.HandlerFxml;

import java.io.File;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;

public class OpenFileChooser {
    FileChooser chooser = new FileChooser();
    HandlerFxml handlerFxml = new HandlerFxml();


    public void fileChooser (String title) {
        chooser.setTitle(title);
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv"),
                new FileChooser.ExtensionFilter("jObject file (*.jobj)", "*.jobj"));

        String directory = System.getProperty("user.home");

        File userDirectory = new File(directory);

        if(!userDirectory.canRead()) {
            userDirectory = new File("c:/");
        }
        chooser.setInitialDirectory(userDirectory);
    }

    public void fileChooserImport(BorderPane borderPane) {
        fileChooser("Import file");
        Stage stage = (Stage) borderPane.getScene().getWindow();
        // Choose file
        File file = chooser.showOpenDialog(stage);
        if (file.getName().equals("customer2.csv")){
            ExceptionHandler.alertBox("Error", "File allready loaded", "Please choose a file " +
                                                            "with a different name, or rename your file");
        }else {
            CsvReader.read(file);
            handlerFxml.navigate(borderPane,"homeCustomer.fxml");
        }
    }


    public void fileChooserExport (BorderPane borderPane) {
        fileChooser("Export file");
        Stage stage = (Stage) borderPane.getScene().getWindow();
        // Choose file
        File file = chooser.showSaveDialog(stage);

        String s = file.getName().split("\\.")[1];
        ObservableList<Customer> customers = CsvReader.read();
        //ObservableList<Damage_Report> damage_reports = CsvReader.readDamageReport();
        ObservableList<Boat_Insurance> boat_insurances = CsvReader.readBoat();
        ObservableList<House_Household_Insurance> house_household_insurances = CsvReader.readHousehold();
        ObservableList<Leisure_Insurance> leisure_insurances = CsvReader.readLeisure();
        ObservableList<Travel_Insurance> travel_insurances  = CsvReader.readTravel();

        if (s.equals("csv")) {
            String path = file.getPath().split("\\.")[0];
            for (Customer customer : customers) {
                CsvWriter.writeFileToCsvCustomer(file.getPath(),customer);
            }
            for (Boat_Insurance boat_insurance : boat_insurances) {
                CsvWriter.writeFileToCsvInsurance(path + "Boat.csv", boat_insurance);
            }
            for (House_Household_Insurance house_household_insurance : house_household_insurances) {
                CsvWriter.writeFileToCsvInsurance(path + "House.csv",house_household_insurance);
            }
            for (Leisure_Insurance leisure_insurance : leisure_insurances) {
                CsvWriter.writeFileToCsvInsurance(path + "Leisure.csv",leisure_insurance);
            }
            for (Travel_Insurance travel_insurance : travel_insurances) {
                CsvWriter.writeFileToCsvInsurance(path + "Travel.csv", travel_insurance);
            }
        }
        if (s.equals("ser")) {
            System.out.println("Fuck off");
        }
    }

}
