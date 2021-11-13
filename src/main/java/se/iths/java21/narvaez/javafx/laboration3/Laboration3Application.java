package se.iths.java21.narvaez.javafx.laboration3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Laboration3Application extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(Laboration3Application.class.getResource("laboration3-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850 , 850);
        stage.setTitle("Laboration 3");
        stage.setScene(scene);
        stage.show();
    }
}
