package org.openjfx;

import Customer_Controller.Customer;
import FileManagement.CsvReader;
import FileManagement.CsvWriter;
import FileManagement.ObjectWriter;
import FileManagement.OpenFileChooser;
import Customer_Controller.Customer;
import Damages.Damage_Report;
import Insurances.Boat_Insurance;
import Insurances.House_Household_Insurance;
import Insurances.Insurance;
import Serialisering.Serialization;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.application.Platform;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Date;


public class MainApp extends Application {
    
    @Override
    public void start(Stage stage) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("homeCustomer.fxml"));

            stage.setOnCloseRequest(event -> {
                Platform.exit();
                System.exit(0);
            });

            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());

            stage.setTitle("JavaFX and Maven");
            stage.setScene(scene);
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);

        //String fileName = System.getProperty("user.home")+"/customer.csv";

       // Write CSV file

        //CsvWriter.writeCsv(fileName);
        Customer cato = new Customer("1","Cato Akay1","123455","catoboy@oslomet.no", new Date(),"Dal");
        Customer cato1 = new Customer("2","Cato Akay2","123455","catoboy@oslomet.no", new Date(),"Dal");

        CsvWriter.writeObjectToCSV(cato);
        CsvWriter.writeObjectToCSV(cato1);
        CsvReader.read();


        // Write object to file
        ObjectWriter ow = new ObjectWriter();
        Customer cato4 = new Customer("160895","Cato Akay2","123455","catoboy@oslomet.no", new Date(),"Dal");
        ow.WriteObjectToFile(cato4);






    }


}
