package com.guojinyun.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * @author guojinyun
 * @date 19-11-19
 */
public class Lesson19 extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        StackPane root = new StackPane();

        ImageView folderIcon = new ImageView();
        Image folderImage = new Image(getClass().getResourceAsStream("/icon/folder.png"));
        folderIcon.setImage(folderImage);
        folderIcon.setFitWidth(16);
        folderIcon.setFitHeight(16);

        TreeItem<String> treeItem = new TreeItem<>("根目录");
        treeItem.setGraphic(folderIcon);
        treeItem.setExpanded(true);
        for (int i = 0; i < 5; i++) {
            TreeItem<String> item = new TreeItem<>("节点：" + i);
            treeItem.getChildren().add(item);
        }
        TreeView<TreeItem<String>> treeView = new TreeView(treeItem);

        ContextMenu menu = new ContextMenu();
        MenuItem addItem = new MenuItem("添加节点");
        addItem.setOnAction(event -> {
            treeItem.getChildren().add(new TreeItem<>("节点：" + treeItem.getChildren().size()));
        });
        MenuItem deleteItem = new MenuItem("删除节点");
        deleteItem.setOnAction(event -> {
            TreeItem selectItem = treeView.getSelectionModel().getSelectedItem();
            treeItem.getChildren().remove(selectItem);
        });
        menu.getItems().addAll(addItem,deleteItem);
        treeView.setContextMenu(menu);

        root.getChildren().add(treeView);

        Scene scene = new Scene(root, 500, 300);
        primaryStage.setTitle("TreeView的使用");
        primaryStage.setScene(scene);
        primaryStage.show();

    }


}
