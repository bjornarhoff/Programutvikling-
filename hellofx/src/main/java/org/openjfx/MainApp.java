package org.openjfx;

import Customer_Controller.Customer;
import FileManagement.CsvReader;
import FileManagement.CsvWriter;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.Date;


public class MainApp extends Application {
    
    @Override
    public void start(Stage stage) {

        try {
            Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));

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
        Customer cato = new Customer("1","Cato Akay1","123455","catoboy@oslomet.no", new Date(),"Dal",22222);
        Customer cato1 = new Customer("2","Cato Akay2","123455","catoboy@oslomet.no", new Date(),"Dal",22222);
        Customer cato2 = new Customer("3","Cato Akay3","123455","catoboy@oslomet.no", new Date(),"Dal",22222);

        CsvWriter.writeObjectToCSV(cato);
        CsvWriter.writeObjectToCSV(cato1);
        CsvWriter.writeObjectToCSV(cato2);

        //CsvReader.readFromCsv();

        //CsvWriter.createFileCSV();



    }


}
