package com.guojinyun.javafx.model.lesson16;

import javafx.scene.control.Button;
import javafx.scene.control.TableCell;

/**
 * @author guojinyun
 * @date 19-11-20
 */
public class ButtonTableCell extends TableCell<PersonData,String> {
    private Button submitBtn = new Button("提交记录");
    private ButtonTableCellActionListener mListener;
    public ButtonTableCell(ButtonTableCellActionListener listener){
        mListener = listener;
        submitBtn.setOnAction(event -> {
            if(mListener!=null){
                mListener.onClick((PersonData) getTableRow().getItem());
            }
        });
    }

    @Override
    protected void updateItem(String item, boolean empty) {
        super.updateItem(item, empty);
        if(!empty){
            setGraphic(submitBtn);
        }else {
            setGraphic(null);
        }
    }
    public interface ButtonTableCellActionListener{
        public void onClick(PersonData data);
    }
}
