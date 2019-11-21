package com.guojinyun.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * @author guojinyun
 * @date 19-11-19
 */
public class Lesson18 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        AnchorPane root = new AnchorPane();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("打开文件");
        fileChooser.setInitialDirectory(
                new File(System.getProperty("user.dir"))
        );
        fileChooser.getExtensionFilters().addAll(
                new FileChooser.ExtensionFilter("All Images","*.*"),
                new FileChooser.ExtensionFilter("JPG","*.jpg"),
                new FileChooser.ExtensionFilter("PNG","*.png")
        );

        Label label = new Label();
        label.setLayoutY(40);
        Button button = new Button("打开文件");
        button.setOnAction(event -> {
            File file = fileChooser.showOpenDialog(primaryStage);
            if(file != null){
                label.setText(file.getAbsolutePath());
            }else {
                label.setText("没有打开任何文件");
            }
        });


        root.getChildren().addAll(button,label);
        Scene scene = new Scene(root,500,300);
        primaryStage.setTitle("文件选择FileChooser的使用");
        primaryStage.setScene(scene);
        primaryStage.show();

    }



}
