package com.app.dictionary;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class Hangman extends GameController implements Initializable {
    @FXML
    protected AnchorPane hmAnchorPane;
    @FXML
    private Button exit;

    public void QuitGame() {
        super.QuitGame();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
