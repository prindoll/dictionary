package com.app.dictionary;

import com.app.dictionary.base.Character;
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
    protected AnchorPane hmAnchorPane;
    @FXML
    private Rectangle bear;

    private final Image imgBear = new Image("img/bear.png");
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        load();

    }
    public void load() {

    }


}
