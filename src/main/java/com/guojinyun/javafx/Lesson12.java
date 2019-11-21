package com.guojinyun.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

/**
 * @author guojinyun
 * @date 19-11-19
 */
public class Lesson12 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        final PasswordField pf = new PasswordField();
        final Tooltip tooltip = new Tooltip();
        tooltip.setText(
                "Your password must be\n"+
                        "at least 8 characters in length\n"
        );
        tooltip.setGraphic(new ImageView(
                new Image(getClass().getResourceAsStream("/icon/warn.png"))
        ));
        pf.setTooltip(tooltip);

        root.add(pf,0,0);


        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Tooltip");
        primaryStage.show();

    }
}
