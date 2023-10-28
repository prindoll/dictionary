package com.app.dictionary;

import com.app.dictionary.base.Translator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.Cursor.*;

public class GameController extends MainController implements Initializable {
    @FXML
    protected AnchorPane gameMainPane; // cai nay la cai boc ben ngoai dung de set các fxml khac ne
    @FXML
    private AnchorPane gameAnchorPane;
    @FXML
    private Label label;
    @FXML
    private ImageView game1Image, game2Image;
    @FXML
    private Button game1, game2;
    @FXML
    protected AnchorPane game1Controller; // cai nay la hangman dung khong

    public void setCursorHand() {
        game1.setCursor(HAND);
        game2.setCursor(HAND);
    }

    public void setAcPane(){
        try {
            FXMLLoader file = new FXMLLoader(getClass().getResource("fxml/hangman.fxml"));
            game1Controller = file.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void playHangman() {
        gameMainPane.getChildren().setAll(game1Controller); // cai them vao ne
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setAcPane();
        setCursorHand();
    }
}
