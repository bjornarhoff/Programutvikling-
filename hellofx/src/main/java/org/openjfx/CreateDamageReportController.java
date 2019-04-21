package org.openjfx;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class CreateDamageReportController {

    @FXML
    private BorderPane createDamageReport;

    @FXML
    private Label customerName;

    @FXML
    private TextField txt_date, txt_damageType;

    @FXML
    private TextArea txta_DaDescription, txta_potWitnesses, txta_info;

    @FXML
    private JFXButton btn_cancel, btn_apply, btn_ok;

    @FXML
    private void cancel(ActionEvent event){
        HandlerFxml handlerFxml = new HandlerFxml();
        handlerFxml.toDamageReport(createDamageReport);
    }

}
