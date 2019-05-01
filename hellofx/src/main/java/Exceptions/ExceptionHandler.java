package Exceptions;

import javafx.scene.control.Alert;

public class ExceptionHandler {

    public static Alert alertBox(String title, String header, String contet){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(contet);
        alert.showAndWait();
        return alert;
    }

}
