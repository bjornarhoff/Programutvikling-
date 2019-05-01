package FileManagement;

import CustomerModell.Customer;
import Insurances.House_Household_Insurance;
import Insurances.Insurance;
import Serialisering.Serialization;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.openjfx.HandlerFxml;
import org.openjfx.HomeCustomerController;

import java.io.File;
import java.io.Serializable;

public class OpenFileChooser {
    FileChooser chooser = new FileChooser();
    HandlerFxml handlerFxml = new HandlerFxml();


    public void fileChooser (String title) {
        chooser.setTitle(title);
        chooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv"),
                new FileChooser.ExtensionFilter("jObject file (*.ser)", "*.ser"));

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

        //Make sure a file was selected, if not return default
        if(file != null) {
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
        ObservableList<House_Household_Insurance> house_household_insurances = CsvReader.readHousehold();

        if (s.equals("csv")) {
            for (Customer customer : customers) {
                CsvWriter.writeFileToCsv(file.getPath(),customer);
            }
        }
        if (s.equals("ser")) {

            }
        }
    
}
