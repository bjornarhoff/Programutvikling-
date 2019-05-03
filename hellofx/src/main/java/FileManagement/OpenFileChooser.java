package FileManagement;

import CustomerModell.Customer;
import Exceptions.ExceptionHandler;
import Insurances.Boat_Insurance;
import Insurances.House_Household_Insurance;
import Insurances.Leisure_Insurance;
import Insurances.Travel_Insurance;
import Serialisering.Serialization;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.openjfx.HandlerFxml;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.util.ArrayList;
import java.util.List;

public class OpenFileChooser {
    private FileChooser chooser = new FileChooser();
    private HandlerFxml handlerFxml = new HandlerFxml();


    public void fileChooser(String title) {
        chooser.setTitle(title);
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv"),
                new FileChooser.ExtensionFilter("jObject file (*.jobj)", "*.jobj"));

        String directory = System.getProperty("user.home");

        File userDirectory = new File(directory);

        if (!userDirectory.canRead()) {
            userDirectory = new File("c:/");
        }
        chooser.setInitialDirectory(userDirectory);
    }

    public void fileChooserImport(BorderPane borderPane) {
        fileChooser("Import file");
        Stage stage = (Stage) borderPane.getScene().getWindow();
        // Choose file
        List<File> files = chooser.showOpenMultipleDialog(stage);

        for (File file : files) {

            if (file.getName().equals("customer2.csv") ||
                            file.getName().equals("boatInsurance.csv") ||
                            file.getName().equals("travelInsurance.csv") ||
                            file.getName().equals("houseInsurance.csv") ||
                            file.getName().equals("LeisureInsurnace.csv")) {
                ExceptionHandler.alertBox("Error", "File already loaded", "Please choose a file " +
                        "with a different name, or rename your file");
                break;
            }

            if (file != null) {
                CsvReader.read(file);
                CsvReader.readAllBoat();
                handlerFxml.navigate(borderPane, "homeCustomer.fxml");
                }

        }
    }


    public void fileChooserExport(BorderPane borderPane) {
        fileChooser("Export file");
        Stage stage = (Stage) borderPane.getScene().getWindow();
        // Choose file
        File file = chooser.showSaveDialog(stage);

        String s = file.getName().split("\\.")[1];
        ObservableList<Customer> customers = CsvReader.read();
        ArrayList<String> damage_reports = CsvReader.readAllDamageReports();
        ArrayList<String> boat_insurances = CsvReader.readAllBoat();
        ArrayList<String> house_household_insurances = CsvReader.readAllHouse();
        ArrayList<String> leisure_insurances = CsvReader.readAllLeisure();
        ArrayList<String> travel_insurances = CsvReader.readAllTravel();

        File directory = new File (file.getPath().split("\\.")[0]);
        if (!directory.exists()) {
            directory.mkdir();
        }
        if (s.equals("csv")) {
            String path = file.getPath().split("\\.")[0];
            for (Customer customer : customers) {
                CsvWriter.writeFileToCsvCustomer(path + "/Customer.csv", customer);
            }
            for (String boat_insurance : boat_insurances) {
                CsvWriter.writeFileToCsv(path + "/Boat.csv", boat_insurance);
            }
            for (String house_household_insurance : house_household_insurances) {
                CsvWriter.writeFileToCsv(path + "/House.csv", house_household_insurance);
            }
            for (String leisure_insurance : leisure_insurances) {
                CsvWriter.writeFileToCsv(path + "/Leisure.csv", leisure_insurance);
            }
            for (String travel_insurance : travel_insurances) {
                CsvWriter.writeFileToCsv(path + "/Travel.csv", travel_insurance);
            }
            for (String damage_report : damage_reports) {
                CsvWriter.writeFileToCsv(path + "/Damage.csv", damage_report);
            }
        }
        if (s.equals("jobj")) {
            System.out.println("Fuck off");
        }
    }
}
