module csc180 {
    requires javafx.controls;
    requires javafx.fxml;


    exports View;
    opens csc180 to javafx.fxml;
}