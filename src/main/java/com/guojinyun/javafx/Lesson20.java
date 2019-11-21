package com.guojinyun.javafx;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.stage.Stage;


/**
 * @author guojinyun
 * @date 19-11-19
 */
public class Lesson20 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Tree Table View Samples");
        final Scene scene = new Scene(new Group(), 200, 400);
        Group sceneRoot = (Group)scene.getRoot();

        //创建子节点
        final TreeItem childNode1 = new TreeItem<>("Child Node 1");
        final TreeItem childNode2 = new TreeItem<>("Child Node 2");
        final TreeItem childNode3 = new TreeItem<>("Child Node 3");

        //创建根节点
        final TreeItem root = new TreeItem<>("Root node");
        root.setExpanded(true);

        //将子节点加入到根节点中红
        root.getChildren().setAll(childNode1, childNode2, childNode3);

        //创建一个列
        TreeTableColumn<String,String> column = new TreeTableColumn<>("Column");
        column.setPrefWidth(150);

        //定义列的单元格内容
        column.setCellValueFactory((TreeTableColumn.CellDataFeatures<String, String> p) ->
                new ReadOnlyStringWrapper(p.getValue().getValue()));

        //创建一个TreeTableView
        final TreeTableView treeTableView = new TreeTableView<>(root);
        treeTableView.getColumns().add(column);
        treeTableView.setPrefWidth(152);
        treeTableView.setShowRoot(true);
        sceneRoot.getChildren().add(treeTableView);
        primaryStage.setScene(scene);
        primaryStage.show();

    }



}
