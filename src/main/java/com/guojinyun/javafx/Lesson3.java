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
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author guojinyun
 * @date 19-11-19
 */
public class Lesson3 extends Application {

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
        sceneTitle.setId("welcome-text");
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
        actionTarget.setId("actiontarget");
        gridPane.add(actionTarget,1,6);

        btn.setOnAction((ActionEvent event) -> {
            actionTarget.setText("Sign in button pressed");
        });

        StackPane root = new StackPane();
        root.getChildren().add(gridPane);
        Scene scene = new Scene(root,400,325);
        primaryStage.setTitle("Lesson 3 Login demo With css");
        scene.getStylesheets()
                .add(Lesson3.class.getResource("/css/Login.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
