module hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.desktop;

    opens org.openjfx to javafx.fxml;
    exports org.openjfx;
}