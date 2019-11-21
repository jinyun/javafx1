package com.guojinyun.javafx;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * @author guojinyun
 * @date 19-11-19
 */
public class Lesson8 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ToggleGroup group = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Home");
        rb1.setUserData("home");
        rb1.setSelected(true);
        rb1.setToggleGroup(group);
        RadioButton rb2 = new RadioButton("Calendar");
        rb2.setUserData("calendar");
        rb2.setToggleGroup(group);
        RadioButton rb3 = new RadioButton("Contacts");
        rb3.setUserData("contacts");
        rb3.setToggleGroup(group);
//        Image image = new Image(getClass().getResourceAsStream("/icon/ok.png"));
//        RadioButton rb4 = new RadioButton("Agree");
//        rb4.setUserData("agree");
//        rb4.setGraphic(new ImageView(image));
//        rb4.setToggleGroup(group);

        ImageView icon = new ImageView();
        icon.setFitHeight(100);
        icon.setFitWidth(100);
        icon.setImage( new Image(getClass().getResourceAsStream("/icon/home.png")));
        group.selectedToggleProperty().addListener(
                (ObservableValue<? extends Toggle > observable, Toggle oldValue, Toggle newValue) ->{
                    String imageFileName = group.getSelectedToggle().getUserData().toString()+".png";
                    final Image imageFinal = new Image(getClass().getResourceAsStream("/icon/"+imageFileName));
                    icon.setImage(imageFinal);
                }
        );
        VBox hBox = new VBox();
        hBox.setSpacing(20);
        hBox.getChildren().addAll(rb1,rb2,rb3);
        SplitPane root = new SplitPane();
        root.getItems().addAll(hBox,icon);

        Scene scene = new Scene(root, 400,300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Radio Button");
        primaryStage.show();

    }
}
