package com.example.cashio.FxmlController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        Label lbl = new Label();
        // StackPane root = new StackPane();
        Parent root= FXMLLoader.load(getClass().getResource("startingwindow.fxml"));

        // root.getChildren().add(lbl);
        Scene scene= new Scene(root, 1366,743);
        stage .setTitle("anik");
        stage.setScene(scene);
        stage.show();
        // lbl.textProperty().bind(Bindings.format("window size: %1$.0fx%2$.0f",stage.widthProperty(),stage.heightProperty()));
    }

    public static void main(String[] args) {
        launch(args);
    }


}
