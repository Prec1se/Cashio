package com.example.cashio.fxmlController;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CashierDashBoardController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private int flag=-1;


    @FXML
    private TextArea textarea;

    @FXML
    void met(ActionEvent event) {
        try {
            // Create a buffered stream
            Scanner input = new Scanner(new File("/home/user/IdeaProjects/okkk/src/main/resources/com/example/myfirst/myFile.txt"));

            // Read a line and append the line to the text area
            while (input.hasNext()) {
                textarea.appendText(input.nextLine() + '\n');
            }
            input.close();
        } catch (
                FileNotFoundException ex) {
            System.out.println("File not found: ");
        }

    }
    @FXML
    void backbuttonpressed(ActionEvent event) throws IOException {


        if(StartingWindowController.flag==1)
        {

            root= FXMLLoader.load(getClass().getResource("admin_user_selection.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene= new Scene(root);
            stage.setScene(scene);
            stage.show();

        }
        else
        {
            root= FXMLLoader.load(getClass().getResource("cashier_user_selection.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene= new Scene(root);
            stage.setScene(scene);
            stage.show();

        }


    }
    @FXML
    void profileButtonclicked(ActionEvent event) throws IOException {

        root= FXMLLoader.load(getClass().getResource("profile.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @FXML
    void riceptButtonClick(ActionEvent event) throws IOException {

        root= FXMLLoader.load(getClass().getResource("receipt.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();


    }
    @FXML
    void lastreceiptClicked(ActionEvent event) throws IOException {

        root= FXMLLoader.load(getClass().getResource("receipt.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();


    }



    @FXML
    void logoutpressed(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("startingwindow.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

}
