package com.app.dictionary;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    private static final String COLOR_RED_CSS = "-fx-background-color: red;";
    private static final String COLOR_GRAY_CSS = "-fx-background-color: #808080;";
    @FXML
    private Button apiButton;

    @FXML
    private Button bookmakeButton;
    @FXML
    private AnchorPane centerAnchorPane;

    @FXML
    private Button button;

    @FXML
    private Button buttonClose;

    @FXML
    private Button gameButton;

    @FXML
    private Button historyButton;

    @FXML
    private Button homeButton;

    @FXML
    protected BorderPane myBorderPane;

    @FXML
    protected AnchorPane sidebar;
    @FXML
    protected AnchorPane homeController;
    @FXML
    protected AnchorPane historyController;
    @FXML
    protected AnchorPane bookmarkController;
    @FXML
    protected AnchorPane apiController;
    @FXML
    protected AnchorPane gameController;

    public void setAnchorPane() {
        try {
            FXMLLoader file = new FXMLLoader(getClass().getResource("fxml/home.fxml"));
            homeController = file.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
//        try {
//            FXMLLoader file = new FXMLLoader(getClass().getResource("fxml/bookmark.fxml"));
//            bookmarkController = file.load();
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            FXMLLoader file = new FXMLLoader(getClass().getResource("fxml/history.fxml"));
//            historyButton = file.load();
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
//        try {
//            FXMLLoader file = new FXMLLoader(getClass().getResource("fxml/game.fxml"));
//            gameController = file.load();
//        } catch(IOException e) {
//            e.printStackTrace();
//        }
        try {
            FXMLLoader file = new FXMLLoader(getClass().getResource("fxml/api.fxml"));
            apiController = file.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        //Phan nay de an hien cai sidebar ne
        sidebar.setTranslateX(0);
        button.setVisible(false);
        button.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(sidebar);

            slide.setToX(0);
            slide.play();
            sidebar.setTranslateX(-200);
            slide.setOnFinished((ActionEvent e) -> {
                button.setVisible(false);
                buttonClose.setVisible(true);
            });
        });
        buttonClose.setOnMouseClicked(event -> {
            TranslateTransition slide = new TranslateTransition();
            slide.setDuration(Duration.seconds(0.5));
            slide.setNode(sidebar);

            slide.setToX(-200);
            slide.play();
            sidebar.setTranslateX(0);
            slide.setOnFinished((ActionEvent e) -> {
                button.setVisible(true);
                buttonClose.setVisible(false);
            });
        });
        setAnchorPane();

        // Cai nay khong can quan tam dau them vao cho dep
        buttonClose.setCursor(Cursor.HAND);
        button.setCursor(Cursor.HAND);
        homeButton.setCursor(Cursor.HAND);
        historyButton.setCursor(Cursor.HAND);
        bookmakeButton.setCursor(Cursor.HAND);
        apiButton.setCursor(Cursor.HAND);
        gameButton.setCursor(Cursor.HAND);


        homeButton.setOnAction(event -> {
            myBorderPane.setCenter(null);
            myBorderPane.setCenter(homeController);
        });
        historyButton.setOnAction(event -> {
            myBorderPane.setCenter(null);
            myBorderPane.setCenter(historyController);
        });
        bookmakeButton.setOnAction(event -> {
            myBorderPane.setCenter(null);
            myBorderPane.setCenter(bookmarkController);
        });
        apiButton.setOnAction(event -> {
            myBorderPane.setCenter(null);
            myBorderPane.setCenter(apiController);
        });
        gameButton.setOnAction(event -> {
            myBorderPane.setCenter(null);
            myBorderPane.setCenter(gameController);
        });
        myBorderPane.setCenter(homeController);

    }
}
