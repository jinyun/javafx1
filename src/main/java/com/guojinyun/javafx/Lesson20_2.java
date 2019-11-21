package com.guojinyun.javafx;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;


/**
 * @author guojinyun
 * @date 19-11-19
 */
public class Lesson20_2 extends Application {

    List files = Arrays.asList(
            new File("123.txt", "1KB"),
            new File("223.txt", "3KB"),
            new File("323.txt", "15KB"),
            new File("423.txt", "12KB"),
            new File("523.txt", "7KB"));

    private final ImageView folderIcon = new ImageView (
            new Image(getClass().getResourceAsStream("/icon/folder.png"))
    );

    final TreeItem root =
            new TreeItem<>(new File("Folder", ""), folderIcon);
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        root.setExpanded(true);
        files.stream().forEach((file) -> {
            ImageView fileIcon = new ImageView(
                    new Image(getClass().getResourceAsStream("/icon/file.png")));
            root.getChildren().add(new TreeItem<>(file,fileIcon));
        });
        stage.setTitle("Tree Table View Sample");
        final Scene scene = new Scene(new Group(), 250, 400);
        scene.setFill(Color.LIGHTGRAY);
        Group sceneRoot = (Group) scene.getRoot();

        TreeTableColumn<File, String> fileColumn =
                new TreeTableColumn<>("文件");
        fileColumn.setPrefWidth(140);
        fileColumn.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<File, String> param) ->
                        new ReadOnlyStringWrapper(param.getValue().getValue().getName())
        );

        TreeTableColumn<File, String> fileSizeColumn =
                new TreeTableColumn<>("文件大小");
        fileSizeColumn.setPrefWidth(110);
        fileSizeColumn.setCellValueFactory(
                (TreeTableColumn.CellDataFeatures<File, String> param) ->
                        new ReadOnlyStringWrapper(param.getValue().getValue().getSize())
        );

        TreeTableView treeTableView = new TreeTableView<>(root);
        treeTableView.getColumns().setAll(fileColumn, fileSizeColumn);
        sceneRoot.getChildren().add(treeTableView);
        stage.setScene(scene);
        stage.show();
    }

    public class File {
        private SimpleStringProperty name;
        private SimpleStringProperty size;
        private File(String name, String size) {
            this.name = new SimpleStringProperty(name);
            this.size = new SimpleStringProperty(size);
        }
        public String getName() {
            return name.get();
        }
        public String getSize() {
            return size.get();
        }
    }



}
