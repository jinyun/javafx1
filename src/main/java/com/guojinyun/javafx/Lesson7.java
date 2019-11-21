package com.guojinyun.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author guojinyun
 * @date 19-11-19
 */
public class Lesson7 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Button n1 = new Button();

        Button n2 = new Button("Accept");
        n2.setStyle("-fx-font:50 arial;-fx-base: #b6e7c9");

        DropShadow shadow = new DropShadow();
        Image image = new Image(getClass().getResourceAsStream("/icon/ok.png"));
        Button n3 = new Button("Accept",new ImageView(image));
        n3.addEventHandler(MouseEvent.MOUSE_ENTERED,(e)->{
            n3.setEffect(shadow);
        });
        n3.addEventHandler(MouseEvent.MOUSE_EXITED,(e)->{
            n3.setEffect(null);
        });


        Image imageDecline = new Image(getClass().getResourceAsStream("/icon/not.png"));
        Button n4 = new Button();
        n4.setGraphic(new ImageView(imageDecline));

        HBox root = new HBox();
        root.getChildren().add(n1);
        root.getChildren().add(n2);
        root.getChildren().add(n3);
        root.getChildren().add(n4);
        Scene scene = new Scene(root, 400,300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Button");
        primaryStage.show();

    }
}
