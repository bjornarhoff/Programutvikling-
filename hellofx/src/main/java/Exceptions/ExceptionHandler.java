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

    public static void modifyAlertbox(String title) {
        ExceptionHandler.alertBox(title, "You are now able to modify text in the table view", "There are specific Items that" +
            " you can now edit by double clicking the desired box. Not all Items are editable");}
}
