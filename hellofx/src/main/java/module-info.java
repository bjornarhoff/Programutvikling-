module hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.desktop;

    opens org.openjfx to javafx.fxml;
    opens CustomerModell to javafx.base;
    opens Damages to javafx.base;
    exports org.openjfx;
}