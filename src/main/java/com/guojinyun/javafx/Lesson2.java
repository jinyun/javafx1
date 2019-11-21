package com.guojinyun.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author guojinyun
 * @date 19-11-19
 */
public class Lesson2 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25));

        Text sceneTitle = new Text("WelCome");
        sceneTitle.setFont(Font.font("Karumbi",FontWeight.BOLD,50));
        gridPane.add(sceneTitle,0,0,2,1);

        Label userName = new Label("UserName:");
        gridPane.add(userName,0,1);
        TextField userTextField = new TextField();
        gridPane.add(userTextField,1,1);

        Label password = new Label("Password:");
        gridPane.add(password,0,2);
        TextField passwordTextField = new TextField();
        gridPane.add(passwordTextField,1,2);

        Button btn = new Button();
        btn.setText("Sign in");

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().add(btn);
        gridPane.add(hBox,1,4);

        final Text actionTarget = new Text();
        gridPane.add(actionTarget,1,6);

        btn.setOnAction((ActionEvent event) -> {
            actionTarget.setFill(Color.FIREBRICK);
            actionTarget.setText("Sign in button pressed");
        });

        StackPane root = new StackPane();
        root.getChildren().add(gridPane);
        Scene scene = new Scene(root,300,250);
        primaryStage.setTitle("Lesson 2 Login demo");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
