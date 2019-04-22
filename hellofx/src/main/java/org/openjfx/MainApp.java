package org.openjfx;

import Customer_Controller.Customer;
import Damages.Damage_Report;
import Insurances.Boat_Insurance;
import Insurances.House_Household_Insurance;
import Insurances.Insurance;
import Serialisering.Serialization;
import javafx.application.Application;
import static javafx.application.Application.launch;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.Serializable;
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


        // Tester serialisering
        Customer customer3 = new Customer("07029633996", "Cato Aka", "12345",
                "asljd@hotmail.com", new Date(),
                "Goteborggata 26",  3900);

        Damage_Report damage_report2 = new Damage_Report(new Date(), 3, "A crash",
                "The window borke", "Bjornar", 3000,
                100);
        customer3.setDamageReport(damage_report2);


        Boat_Insurance boat_insurance2 = new Boat_Insurance("10%", new Date(), 4500,
                "Husk betaling!", "Sven", "CV45784", "BMW 44",
                2423.2, 2012, "V8 200HP", customer3);

        House_Household_Insurance sven =  new House_Household_Insurance("25%",
                new Date(), 3, "Betal", "faggots", 3,
                "Innbo", "Tre", "Bra", 25.5,
                2500, 3000, customer3);


        Serialization.serialiseInsurance(sven);
        Serialization.serialiseInsurance(boat_insurance2);




    }


}
