package com.app.dictionary;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class BearFindHoney extends GameController implements Initializable {
    @FXML
    protected AnchorPane anchorPane;
    @FXML
    private ImageView bear;
    private double x;
    private double y;

    final double[] rock = {400, 0, 400, 80, 240, 80, 240, 240, 80, 160, 0
            , 160, 0, 320, 0, 400, 160, 400, 320, 480, 400, 320};
    final double[] ques = {160, 80, 320, 160, 80, 320, 160, 320, 320, 400, 160, 480};
    private double step = 80.0;

    private final Image imgBear = new Image(getClass().getResourceAsStream("img/bear.png"));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        load();
        move();
    }

    public void load() {
        bear.setImage(imgBear);
    }

    public void move() {
        anchorPane.setOnKeyPressed(e -> {
            KeyCode keyCode = e.getCode();
            switch (keyCode) {
                case W:
                    y -= step;
                    if (y < 0) y = 0;
                    if (isRock(x, y)) {
                        y += step;
                    }
                    break;

                case S:
                    y += step;
                    if (y > 480) y = 480;
                    if (isRock(x, y)) {
                        y -= step;
                    }

                    break;
                case A:
                    x -= step;
                    if (x < 0) {
                        x = 0;
                    }
                    if (isRock(x, y)) {
                        x += step;
                    }
                    break;
                case D:
                    x += step;
                    if (x > 400) {
                        x = 400;
                    }
                    if (isRock(x, y)) {
                        x -= step;
                    }

                    break;
                default:
                    break;
            }
            bear.setLayoutX(x);
            bear.setLayoutY(y);
            if(isQuestion(x,y)) {

            }
        });
        anchorPane.setFocusTraversable(true);
    }

    public boolean isRock(double x, double y) {
        double valX, valY;
        for (int i = 0; i < rock.length; i += 2) {
            valX = rock[i];
            valY = rock[i + 1];
            if (x == valX && y == valY) {
                return true;
            }
        }
        return false;
    }

    public void left() {
        bear.setLayoutX(x += 0);
    }

    public boolean isQuestion(double x, double y) {
        double valX, valY;
        for (int i = 0; i < ques.length; i += 2) {
            valX = ques[i];
            valY = ques[i + 1];
            if (x == valX && y == valY) {
                return true;
            }
        }
        return false;
    }

}

