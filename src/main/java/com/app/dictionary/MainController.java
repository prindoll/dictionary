package com.app.dictionary;

import com.app.dictionary.base.Translator;
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
    protected AnchorPane center;
    @FXML
    private Button button;
    @FXML
    private Button buttonClose;
    @FXML
    private Button gameButton;
    @FXML
    private Button homeButton;
    @FXML
    protected BorderPane myBorderPane;
    @FXML
    protected AnchorPane sidebar;
    @FXML
    protected AnchorPane homeController;
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
        try {
            FXMLLoader file = new FXMLLoader(getClass().getResource("fxml/bookmark.fxml"));
            bookmarkController = file.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FXMLLoader file = new FXMLLoader(getClass().getResource("fxml/game.fxml"));
            gameController = file.load();
        } catch(IOException e) {
            e.printStackTrace();
        }
        try {
            FXMLLoader file = new FXMLLoader(getClass().getResource("fxml/api.fxml"));
            apiController = file.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCursorHand() {

        buttonClose.setCursor(Cursor.HAND);
        button.setCursor(Cursor.HAND);
        homeButton.setCursor(Cursor.HAND);
        bookmakeButton.setCursor(Cursor.HAND);
        apiButton.setCursor(Cursor.HAND);
        gameButton.setCursor(Cursor.HAND);
    }

    public void translateTransitionSideBar1(ActionEvent e) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.5));
        slide.setNode(sidebar);
        slide.setToX(0);
        TranslateTransition slide2 = new TranslateTransition();
        slide2.setDuration(Duration.seconds(0.5));
        slide2.setNode(center);
        slide2.setToX(0);
        slide.play();
        slide2.play();
        sidebar.setTranslateX(-200);
        center.setTranslateX(-100);
        slide.setOnFinished((ActionEvent event) -> {
            button.setVisible(false);
            buttonClose.setVisible(true);
        });
    }
    public void translateTransitionSideBar2(ActionEvent e) {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(0.5));
        slide.setNode(sidebar);
        slide.setToX(-200);
        TranslateTransition slide2 = new TranslateTransition();
        slide2.setDuration(Duration.seconds(0.5));
        slide2.setNode(center);
        slide2.setToX(-100);
        slide.play();
        slide2.play();

        sidebar.setTranslateX(0);
        center.setTranslateX(0);

        slide.setOnFinished((ActionEvent event) -> {
            button.setVisible(true);
            buttonClose.setVisible(false);
        });
    }


    public void setCenterAnchorPaneHomeButton() {
        center.getChildren().setAll(homeController);
    }

    public void setCenterAnchorPaneBookmark() {
        center.getChildren().setAll(bookmarkController);
    }

    public void setCenterAnchorPaneApi() {
        center.getChildren().setAll(apiController);
    }

    public void setCenterAnchorPaneGame() {
        center.getChildren().setAll(gameController);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        sidebar.setTranslateX(0);
        button.setVisible(false);
        setAnchorPane();
        setCursorHand();
        setCenterAnchorPaneHomeButton();
    }
}
