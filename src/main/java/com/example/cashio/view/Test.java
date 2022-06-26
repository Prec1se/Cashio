package com.example.cashio;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Test {
    private Stage myStage= new Stage();
    private Scene scene;
    private Parent root;

/*
    @FXML
    void profileButtonclicked(ActionEvent event) throws IOException {
        root= FXMLLoader.load(getClass().getResource("startingwindow.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene= new Scene(root);
        stage.setScene(scene);
        stage.show();

    }
*/

    @FXML
    void Clicked(ActionEvent event){
        //myStage.close();

        System.out.println("I am clicked");
        //Image imge= new Image("C:\\Users\\Anik\\3D Objects\\download.jpeg");

        myStage.setTitle("Display an Image");
        // Use a FlowPane for the root node.
        FlowPane rootNode = new FlowPane();
        // Use center alignment.
       // rootNode.setAlignment(Pos.CENTER);
        // Create a scene.
        Scene myScene = new Scene(rootNode, 300, 200);
        // Set the scene on the stage.
        myStage.setScene(myScene);
        // Create an image.
      //  Image img = new Image("file:///e:/e.png");
        // Create an image view that uses the image.
        Image img= new Image("C:\\Users\\Anik\\IdeaProjects\\Cashio\\src\\main\\resources\\com\\example\\cashio\\img\\aboutButton.jpg");
        String Path= new String("C:\\Users\\Anik\\IdeaProjects\\Cashio\\src\\main\\resources\\com\\example\\cashio\\img\\avatar1.png");
      //  Extraclass4 ex= new Extraclass4(Path);
       // Image img= ex.img;
        //String Path= new String("C:\\Users\\Anik\\IdeaProjects\\Cashio\\src\\main\\resources\\com\\example\\cashio\\img\\avatar1.png");
        //Image img= new Image("C:\Users\Anik\IdeaProjects\Cashio\src\main\resources\com\example\cashio\img\avatar4.png");
      //  Image img= new Image(ex.Path);
        ImageView imageView1 = new ImageView(img);
        imageView1.setX(0);
        imageView1.setY(0);
        imageView1.setFitHeight(55);
        imageView1.setFitWidth(55);
        imageView1.setPreserveRatio(true);

        // Add the image to the scene graph.
        rootNode.getChildren().add(imageView1);

        Path= "C:\\Users\\Anik\\IdeaProjects\\Cashio\\src\\main\\resources\\com\\example\\cashio\\img\\avatar4.png";
      //  Extraclass4 ex1= new Extraclass4(Path);
      //  img= new Image(ex1.Path);
        ImageView imageView = new ImageView(img);
        imageView.setX(55);
        imageView.setY(0);
        imageView.setFitHeight(55);
        imageView.setFitWidth(55);
        imageView.setPreserveRatio(true);


        imageView.setPickOnBounds(true);

        imageView.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {

                System.out.println("clicked");

              /*  Stage mstage=new Stage();
                mstage.setTitle("Display an Image");
                // Use a FlowPane for the root node.
                FlowPane rootNode = new FlowPane();
                // Use center alignment.
                // rootNode.setAlignment(Pos.CENTER);
                // Create a scene.
                Scene myScene = new Scene(rootNode, 300, 200);
                // Set the scene on the stage.
                mstage.setScene(myScene);
                mstage.show();

               */

                myStage.close();

            }});

        imageView1.setOnMouseClicked(new EventHandler() {
            @Override
            public void handle(Event event) {

                System.out.println("clicked1");
                myStage.close();



               /* Parent root= null;
                try {
                    root = FXMLLoader.load(getClass().getResource("check.fxml"));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                scene= new Scene(root);
                stage.setScene(scene);
                stage.show();
                */



            }});

        rootNode.getChildren().add(imageView);



        myStage.show();


    }

}
