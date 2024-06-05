module org.example.javafxdemo {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.ikonli.javafx;
    requires java.sql;

    opens page to javafx.fxml;
    opens org.example.entity to javafx.base;
    exports org.example;
    opens org.example to javafx.fxml;
    exports org.example.controller;
    opens org.example.controller to javafx.fxml;
}