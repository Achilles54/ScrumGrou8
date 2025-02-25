module csc180 {
    requires javafx.controls;
    requires javafx.fxml;

    opens Controller;
    exports View;
    exports Controller;
    opens csc180 to javafx.fxml;
}