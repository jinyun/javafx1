package com.guojinyun.javafx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 * @author guojinyun
 * @date 19-11-19
 */
public class Lesson11 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane root = new GridPane();
        final String[] fruits = new String[]{"Hello,Apple","Hello,Banana","hello,Orange"};
        final Label label = new Label();
        final ChoiceBox cbFruits = new ChoiceBox(FXCollections.observableArrayList("Apple","Banana","Orange"));
        cbFruits.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                label.setText(fruits[newValue.intValue()]);
            }
        });

        HBox hbox = new HBox();
        hbox.setStyle("-fx-background-color: grey");

        ChoiceBox cb = new ChoiceBox(FXCollections.observableArrayList("First",new Separator(),"Second","Third"));
        cb.setTooltip(new Tooltip("select one item"));
        hbox.getChildren().add(cb);

        root.add(hbox,0,0);
        root.add(cbFruits,0,1);
        root.add(label,1,1);


        Scene scene = new Scene(root, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ChoiceBox Button");
        primaryStage.show();

    }
}
