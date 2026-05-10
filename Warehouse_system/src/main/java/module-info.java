module com.example.assessmentstartercode.warehousesystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.assessmentstartercode.warehousesystem to javafx.fxml;
    exports com.example.assessmentstartercode.warehousesystem;
}