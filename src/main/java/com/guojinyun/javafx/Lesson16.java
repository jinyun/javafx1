package com.guojinyun.javafx;

import com.guojinyun.javafx.model.lesson16.ButtonTableCell;
import com.guojinyun.javafx.model.lesson16.PersonData;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ProgressBarTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Callback;

/**
 * @author guojinyun
 * @date 19-11-19
 */
public class Lesson16 extends Application {

    private final TableView table = new TableView();
    private final int screenWidth = 1200;
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
        primaryStage.setHeight(screenHeight+150);
        table.setPrefSize(screenWidth,screenHeight);
        table.setEditable(true);

        int colWidth = screenWidth/5;
        TableColumn nameCol = new TableColumn("姓名");
        nameCol.setPrefWidth(colWidth);
        nameCol.setCellValueFactory(new PropertyValueFactory<>("mNameProperty"));
        nameCol.setCellFactory(TextFieldTableCell.forTableColumn());
        nameCol.setOnEditCommit(event -> {
            TableColumn.CellEditEvent editEvent = (TableColumn.CellEditEvent<PersonData,String>) event;
            PersonData personData = (PersonData) editEvent.getTableView().getItems()
                    .get(editEvent.getTablePosition().getRow());
            personData.setmNameProperty((String) editEvent.getNewValue());
        });
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

        TableColumn progressCol = new TableColumn("工作进度");
        progressCol.setPrefWidth(colWidth);
        progressCol.setCellFactory(ProgressBarTableCell.forTableColumn());
        progressCol.setCellValueFactory(new PropertyValueFactory<>("mProgressProperty"));

        TableColumn submitCol = new TableColumn("提交记录");
        submitCol.setPrefWidth(colWidth);
        submitCol.setCellFactory(new Callback<TableColumn, TableCell>() {
            @Override
            public TableCell call(TableColumn param) {
                return new ButtonTableCell(new ButtonTableCell.ButtonTableCellActionListener() {
                    @Override
                    public void onClick(PersonData data) {
                        new Alert(Alert.AlertType.INFORMATION,data.getmNameProperty()).show();
                    }
                });
            }
        });

        table.setItems(dataList);
        table.getColumns().addAll(nameCol,addrCol,phoneCol,progressCol,submitCol);

        int tfWidth = 80;
        HBox box = new HBox();
        TextField mNameTF = new TextField();
        mNameTF.setPromptText("输入名称");
        mNameTF.setPrefWidth(tfWidth);
        TextField mAddrTF = new TextField();
        mAddrTF.setPromptText("输入地址");
        mAddrTF.setPrefWidth(tfWidth);
        TextField mPhone1TF = new TextField();
        mPhone1TF.setPromptText("输入座机号");
        mPhone1TF.setPrefWidth(tfWidth);
        TextField mPhone2TF = new TextField();
        mPhone2TF.setPromptText("输入手机");
        mPhone2TF.setPrefWidth(tfWidth);
        Button mSubmitBtn = new Button("提交");
        mSubmitBtn.setOnAction(event -> {
            dataList.add(new PersonData(mNameTF.getText(),mAddrTF.getText(),mPhone1TF.getText(),mPhone2TF.getText()));
        });
        box.getChildren().addAll(mNameTF,mAddrTF,mPhone1TF,mPhone2TF,mSubmitBtn);
        box.setLayoutY(table.getPrefHeight()+5);


        ((Group)scene.getRoot()).getChildren().addAll(table,box);
        primaryStage.setScene(scene);
        primaryStage.show();

    }



}
