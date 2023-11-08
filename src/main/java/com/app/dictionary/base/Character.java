package com.app.dictionary.base;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

public class Character {
    private int val_x;
    private int val_y;

    public int getVal_x() {
        return val_x;
    }

    public void setVal_x(int val_x) {
        this.val_x = val_x;
    }

    public int getVal_y() {
        return val_y;
    }

    public void setVal_y(int val_y) {
        this.val_y = val_y;
    }

    public Character(int val_x, int val_y) {
        this.val_x = val_x;
        this.val_y = val_y;
    }
    public boolean LoadImg(AnchorPane pane ,String path){
        Image img = new Image(path);
        if ( img != null) {
            ImageView imageView = new ImageView(img);
            imageView.setFitWidth(300);
            imageView.setFitHeight(200);
            pane.getChildren().add(imageView);
            return true;
        }
        return false;
    }
}
