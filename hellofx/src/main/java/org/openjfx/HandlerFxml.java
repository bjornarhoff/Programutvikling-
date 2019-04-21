package org.openjfx;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class HandlerFxml {

    public void toHome(Pane a){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) a.getParent().getScene().getWindow();
            stage.setScene(scene);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void toDamageReport(Pane a){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("damageReport.fxml"));
            Scene scene = new Scene(root);
            Stage stage = (Stage) a.getParent().getScene().getWindow();
            stage.setScene(scene);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}