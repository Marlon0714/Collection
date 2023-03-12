module application {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.logging;

    opens application to javafx.fxml;
    exports application;
    opens controller to javafx.fxml;
    exports controller;
    exports model;
}
