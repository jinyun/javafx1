package com.guojinyun.javafx;

import com.guojinyun.javafx.model.lesson14.PersonData;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * @author guojinyun
 * @date 19-11-19
 */
public class Lesson14 extends Application {

    private final TableView table = new TableView();
    private final int screenWidth = 600;
    private final int screenHeight = 500;
    private ObservableList<PersonData> dataList = FXCollections.observableArrayList(
            new PersonData("张三","武汉","02711011","12345678"),
            new PersonData("张伟","武汉","02722011","12345678"),
            new PersonData("刘洋","深圳","02715321","12345678")
    );

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(new Group());
        primaryStage.setTitle("TableView 示例");
        primaryStage.setWidth(screenWidth);
        primaryStage.setHeight(screenHeight);
        table.setPrefSize(screenWidth,screenHeight);
//        table.setEditable(true);

        int colWidth = screenWidth/3;
        TableColumn nameCol = new TableColumn("姓名");
        nameCol.setPrefWidth(colWidth);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("mNameProperty"));
        TableColumn addrCol = new TableColumn("地址");
        addrCol.setPrefWidth(colWidth);
        addrCol.setCellValueFactory(new PropertyValueFactory<>("mAddrProperty"));
        TableColumn phoneCol = new TableColumn("电话");
        phoneCol.setPrefWidth(colWidth);
        TableColumn phone1Col = new TableColumn("座机");
        phone1Col.setPrefWidth(colWidth/2);
        phone1Col.setCellValueFactory(new PropertyValueFactory<>("mPhone1Property"));

        TableColumn phone2Col = new TableColumn("手机");
        phone2Col.setPrefWidth(colWidth/2);
        phone2Col.setCellValueFactory(new PropertyValueFactory<>("mPhone2Property"));
        phoneCol.getColumns().addAll(phone1Col,phone2Col);

        table.setItems(dataList);

        table.getColumns().addAll(nameCol,addrCol,phoneCol);
        ((Group)scene.getRoot()).getChildren().addAll(table);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}
