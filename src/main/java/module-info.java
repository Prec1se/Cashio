module com.example.cashio {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.cashio to javafx.fxml;
    exports com.example.cashio.model;
    opens com.example.cashio.model to javafx.fxml;
    exports com.example.cashio.dbHandler;
    opens com.example.cashio.dbHandler to javafx.fxml;
}