package com.guojinyun.javafx;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 * @author guojinyun
 * @date 19-11-19
 */
public class Lesson6 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        Label l1 = new Label();
        l1.setText("label1");


        Label l2 = new Label("label2");
        l2.setFont(Font.font("Cambria", 32));
        l2.setRotate(270);
        l2.setTranslateY(50);

        Image image = new Image(getClass().getResourceAsStream("/icon/labels.png"));
        Label l3 = new Label("label3",new ImageView(image));
        l3.setTextFill(Color.web("#0076a3"));
        l3.setOnMouseEntered((MouseEvent e) -> {
            l3.setScaleX(1.5);
            l3.setScaleY(1.5);
        });

        l3.setOnMouseExited((MouseEvent e) -> {
            l3.setScaleX(1);
            l3.setScaleY(1);
        });

        Group root = new Group();
        root.getChildren().add(l1);
        root.getChildren().add(l2);
        root.getChildren().add(l3);
        Scene scene = new Scene(root, 400,300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Label");
        primaryStage.show();

    }
}
