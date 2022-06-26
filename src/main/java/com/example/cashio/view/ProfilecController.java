package com.example.cashio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class ProfilecController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private Label Name;

    @FXML
    private Label Set;

    @FXML
    private TextField TextField;

    @FXML
    void BackCLicked(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("CashierDashboard.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();


    }

    @FXML
    void ChangeNameClicked(ActionEvent event) {

    }

    @FXML
    void ChangePassClicked(ActionEvent event) {

    }

}
