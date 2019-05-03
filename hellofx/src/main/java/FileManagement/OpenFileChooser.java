package FileManagement;

import CustomerModell.Customer;
import Damages.Damage_Report;
import Exceptions.ExceptionHandler;
import Insurances.Boat_Insurance;
import Insurances.Household_Insurance;
import Insurances.Leisure_Insurance;
import Insurances.Travel_Insurance;
import Serialisering.Serialization;
import javafx.collections.ObservableList;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.openjfx.DamageReportController;
import org.openjfx.HandlerFxml;

import java.io.*;
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
            String line;
            String[] header = new String[0];
            if (file != null) {
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                    while ((line = br.readLine()) != null) {
                        header = line.split(",");
                        break;
                    }
                    if (header[2].equals("Name")) {
                        CsvReader.readAllCustomers(file);
                        handlerFxml.navigate(borderPane, "homeCustomer.fxml");
                    } else if (header[2].equals("DamageNr")) {
                        CsvReader.readAllDamagereportImport(file);
                    } else if (header[5].equals("insuranceArea")) {
                        CsvReader.readAllTravelImport(file);
                    } else if (header[7].equals("Boat type")) {
                        CsvReader.readAllBoatImport(file);
                    } else if (header[7].equals("residentalType")) {
                        CsvReader.readAllLeisureImport(file);
                    } else if (header[7].equals("ResidentialType")) {
                        CsvReader.readAllHouseImport(file);
                    }

                } catch (FileNotFoundException e) {
                    System.out.println("File is not yet created, just registrer anything");
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (IndexOutOfBoundsException ie) {
                    ie.printStackTrace();
                }

            }
        }
    }


    public void fileChooserExport (BorderPane borderPane) throws IOException {
        fileChooser("Export file");
        Stage stage = (Stage) borderPane.getScene().getWindow();
        // Choose file
        File file = chooser.showSaveDialog(stage);

        String s = file.getName().split("\\.")[1];
        ObservableList<Customer> customers = CsvReader.readAllCustomers();
        File directory = new File (file.getPath().split("\\.")[0]);

        if (!directory.exists()) {
            directory.mkdir();
        }
        if (s.equals("csv")) {
            ArrayList<String> damage_reports = CsvReader.readAllDamageReports();
            ArrayList<String> boat_insurances = CsvReader.readAllBoat();
            ArrayList<String> household_insurances = CsvReader.readAllHouse();
            ArrayList<String> leisure_insurances = CsvReader.readAllLeisure();
            ArrayList<String> travel_insurances = CsvReader.readAllTravel();

            String path = file.getPath().split("\\.")[0];
            for (Customer customer : customers) {
                CsvWriter.writeFileToCsvCustomer(path + "/Customer.csv", customer);
            }
            for (String boat_insurance : boat_insurances) {
                CsvWriter.writeFileToCsv(path + "/Boat.csv", boat_insurance);
            }
            for (String household_insurance : household_insurances) {
                CsvWriter.writeFileToCsv(path + "/House.csv", household_insurance);
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
            String path = file.getPath().split("\\.")[0];
            ObservableList<Boat_Insurance> boat = CsvReader.readBoatInsuranceToJobj();
            ObservableList<Household_Insurance> house = CsvReader.readHouseHoldInsuranceToJobj();
            ObservableList<Leisure_Insurance> leisure = CsvReader.readLeisureInsuranceToJobj();
            ObservableList<Travel_Insurance> travel = CsvReader.readTravelInsuranceToJobj();
            ObservableList<Damage_Report> damage_reports = CsvReader.readDamageReportToObj();

            for (Customer customer : customers) {
                Serialization.serialiseCustomer(customer,path +"/customers.jobj");
            }
            for (Household_Insurance houseIn : house) {
                Serialization.serialiseInsurance(houseIn,path + "/house.jobj");
            }
            for (Leisure_Insurance leisureIn : leisure) {
                Serialization.serialiseInsurance(leisureIn,path + "/leisure.jobj");
            }
            for (Travel_Insurance travelIn : travel) {
                Serialization.serialiseInsurance(travelIn,path + "/travel.jobj");
            }
            for (Boat_Insurance boatIn : boat) {
                Serialization.serialiseInsurance(boatIn,path + "/boat.jobj");
            }
            for (Damage_Report damage_report : damage_reports) {
                Serialization.serialiseDamageReport(damage_report, path + "/damage.jobj");
            }
        }
    }
}
