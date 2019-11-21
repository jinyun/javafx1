package com.guojinyun.javafx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * @author guojinyun
 * @date 19-11-19
 */
public class Lesson5 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("/view/MainView.fxml"));
        Label mLabel = (Label) parent.lookup("#mLabel");
        Button mButton = (Button) parent.lookup("#mButton");
        mButton.setOnAction(e -> {
            mLabel.setText("Lesson 5");
        });
        Scene scene = new Scene(parent,400,325);
        primaryStage.setScene(scene);
        primaryStage.setTitle("FXController");
        primaryStage.show();

    }
}
