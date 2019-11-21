package com.guojinyun.javafx;

import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 * @author guojinyun
 * @date 19-11-19
 */
public class Lesson9 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ToggleGroup group = new ToggleGroup();
        ToggleButton tb1 = new ToggleButton();
        tb1.setToggleGroup(group);
        ToggleButton tb2 = new ToggleButton("press me");
        tb2.setToggleGroup(group);
        Image image = new Image(getClass().getResourceAsStream("/icon/agree.png"));
        ToggleButton tb3 = new ToggleButton("press me",new ImageView(image));
        tb3.setToggleGroup(group);

        VBox hBox = new VBox();
        hBox.setSpacing(20);
        hBox.getChildren().addAll(tb1,tb2,tb3);


        VBox right = new VBox();
        HBox menu = new HBox();
        final ToggleGroup rgroup = new ToggleGroup();
        ToggleButton tbr1 = new ToggleButton("Minor");
        tbr1.setUserData(Color.LIGHTGREEN);
        tbr1.setToggleGroup(rgroup);
        tbr1.setMinWidth(80);
        ToggleButton tbr2 = new ToggleButton("Major");
        tbr2.setUserData(Color.LIGHTBLUE);
        tbr2.setToggleGroup(rgroup);
        tbr2.setMinWidth(80);
        ToggleButton tbr3 = new ToggleButton("Critical");
        tbr3.setUserData(Color.SALMON);
        tbr3.setToggleGroup(rgroup);
        tbr3.setMinWidth(80);
        menu.getChildren().addAll(tbr1,tbr2,tbr3);
        menu.setMinWidth(200);


        Rectangle rect = new Rectangle();
        rect.setHeight(50);
        rect.setFill(Color.WHITE);
        rect.setStroke(Color.DARKGRAY);
        rect.setStrokeWidth(2);
        rect.setArcHeight(10);
        rect.setArcWidth(10);

        rgroup.selectedToggleProperty().addListener(
                (ObservableValue<? extends Toggle> observable, Toggle oldValue, Toggle newValue)->{

                    if(newValue == null){
                        rect.setFill(Color.WHITE);
                    }else{
                        rect.setFill((Color) rgroup.getSelectedToggle().getUserData());
                    }
                }
        );
        System.out.println(menu.getWidth());
//        rect.setWidth(menu.getWidth());// todo 不知道如何动态获取宽度
        rect.setWidth(240);
        right.getChildren().addAll(menu,rect);

        SplitPane root = new SplitPane();
        root.getItems().addAll(hBox,right);

        Scene scene = new Scene(root, 400,300);
        scene.getStylesheets().add("/css/toggle.css");
        tbr1.getStyleClass().add("toggle-button1");
        tbr2.getStyleClass().add("toggle-button2");
        tbr3.getStyleClass().add("toggle-button3");
        primaryStage.setScene(scene);
        primaryStage.setTitle("Toggle Button");
        primaryStage.show();

    }
}
