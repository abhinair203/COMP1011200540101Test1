module com.example.comp1011200540101test1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.comp1011200540101test1 to javafx.fxml;
    exports com.example.comp1011200540101test1;
}