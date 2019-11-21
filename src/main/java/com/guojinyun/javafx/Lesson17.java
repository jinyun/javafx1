package com.guojinyun.javafx;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author guojinyun
 * @date 19-11-19
 */
public class Lesson17 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();
        VBox vBox = new VBox(10);
        Button button1 = new Button("VButton1");
        Button button2 = new Button("VButton2");
        Separator separator = new Separator();
        Button button3 = new Button("VButton3");
        vBox.getChildren().addAll(button1,button2,separator,button3);

        HBox hBox = new HBox(10);
        Button hButton1 = new Button("HButton1");
        Button hButton2 = new Button("HButton2");
        Separator hSeparator = new Separator();
        hSeparator.setOrientation(Orientation.VERTICAL);
        Button hButton3 = new Button("HButton3");
        hBox.getChildren().addAll(hButton1,hButton2,hSeparator,hButton3);
        hBox.setLayoutX(100);

        root.getChildren().addAll(vBox,hBox);
        root.getStylesheets().add(getClass().getResource("/css/separator.css").toString());

        Scene scene = new Scene(root,500,300);
        primaryStage.setTitle("Separator的使用");
        primaryStage.setScene(scene);
        primaryStage.show();

    }



}
