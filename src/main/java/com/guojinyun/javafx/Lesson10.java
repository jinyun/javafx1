package com.guojinyun.javafx;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author guojinyun
 * @date 19-11-19
 */
public class Lesson10 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        HBox hbox = new HBox();
        hbox.setStyle("-fx-background-color: grey");
        final String[] names = new String[]{"Security", "Project", "Chart"};
        final Image[] images = new Image[names.length];
        final ImageView[] icons = new ImageView[names.length];
        final CheckBox[] cbs = new CheckBox[names.length];
        for (int i = 0; i < names.length; i++) {
            String imagePath = "/icon/"+names[i] + ".png";
            final Image image = images[i]
                    = new Image(getClass().getResourceAsStream(imagePath));
            final ImageView icon = icons[i] = new ImageView();
            icon.setFitWidth(30);
            icon.setFitHeight(30);
            final CheckBox cb = cbs[i] = new CheckBox(names[i]);
            cb.selectedProperty().addListener(
                    (ObservableValue<? extends Boolean> ov, Boolean old_val, Boolean new_val) -> {
                        icon.setImage(new_val ? image : null);
                    });
            root.add(cb,0,i);
            hbox.getChildren().add(icon);
        }
        root.add(hbox,2,1);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("CheckBox Button");
        primaryStage.show();

    }
}
