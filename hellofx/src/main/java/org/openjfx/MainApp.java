package org.openjfx;

import CustomerModell.Customer;
import FileManagement.CsvReader;
import FileManagement.CsvWriter;
import FileManagement.ObjectWriter;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.application.Platform;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


public class MainApp extends Application {
    
    @Override
    public void start(Stage stage) {

        ObservableList<Customer> minListe = CsvReader.read();
        for (Customer customer : minListe){
            System.out.println(customer);
        }

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



    }


}
