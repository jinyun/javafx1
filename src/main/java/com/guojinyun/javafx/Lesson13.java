package com.guojinyun.javafx;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.stage.Stage;

/**
 * @author guojinyun
 * @date 19-11-19
 */
public class Lesson13 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        ListView<String> list = new ListView<>();
        ObservableList<String> items = FXCollections.observableArrayList(
                "Single","Double","Suite","Family App"
        );
        list.setItems(items);
        list.setPrefWidth(100);
        list.setPrefHeight(70);

        list.getSelectionModel().selectionModeProperty().addListener(
                new ChangeListener<SelectionMode>() {
                    @Override
                    public void changed(ObservableValue<? extends SelectionMode> observable, SelectionMode oldValue, SelectionMode newValue) {
                        System.out.println(newValue);
                    }
                }
        );



        Scene scene = new Scene(list, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Listview");
        primaryStage.show();

    }
}
