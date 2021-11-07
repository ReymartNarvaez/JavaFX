module se.iths.java21.narvaez.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;
    requires javafx.swing;
    requires java.base;
    requires se.iths.narvaez.shapes;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;

    opens se.iths.java21.narvaez.javafx to javafx.fxml;
    opens se.iths.java21.narvaez.javafx.laboration3 to javafx.fxml;
    opens se.iths.java21.narvaez.javafx.test to javafx.fxml;

    exports se.iths.java21.narvaez.javafx;
    exports se.iths.java21.narvaez.javafx.laboration3;
    exports se.iths.java21.narvaez.javafx.test;

}