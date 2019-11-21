package com.guojinyun.javafx.controller.lesson5;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;

/**
 * @author guojinyun
 * @date 19-11-19
 */
public class MainController {

    @FXML
    private Button mButton;

    @FXML
    private Label mLabel;

    @FXML
    public void onButtonClick(ActionEvent event){
        mLabel.setText("hello~");
    }

}
