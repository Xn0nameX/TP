module com.example.lr10 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.lr10 to javafx.fxml;
    exports com.example.lr10;
}