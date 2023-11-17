package com.app.dictionary;

import com.app.dictionary.base.Translator;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import static javafx.scene.Cursor.*;

public class GameController extends MainController implements Initializable {
    @FXML
    private AnchorPane centerGame;

    @FXML
    private AnchorPane chooseGame;

    @FXML
    private Button game1;

    @FXML
    private ImageView bear;

    @FXML
    private Button game2;

    @FXML
    private ImageView game2Image;

    @FXML
    private AnchorPane gameMainPane;

    @FXML
    private HBox hboxGame;

    @FXML
    private Label label;
    @FXML
    private AnchorPane gameHangMan;
    @FXML
    private AnchorPane gameBearFindHoney;


    public void setCursorHand()  {
        game1.setCursor(HAND);
        game2.setCursor(HAND);
    }

    public void playHangman() {
        try {
            FXMLLoader file = new FXMLLoader(getClass().getResource("fxml/hangman.fxml"));
            gameHangMan = file.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        hboxGame.setVisible(true);
        centerGame.getChildren().setAll(gameHangMan);
    }
    public void playBearFindHoney() {
        try {
            FXMLLoader file = new FXMLLoader(getClass().getResource("fxml/bearfindhoney.fxml"));
            gameBearFindHoney = file.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        hboxGame.setVisible(true);
        centerGame.getChildren().setAll(gameBearFindHoney);
    }
    public void returnGame(){
        centerGame.getChildren().setAll(chooseGame);
        hboxGame.setVisible(false);
        gameHangMan = null;
        gameBearFindHoney = null;

    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setCursorHand();
    }

}
