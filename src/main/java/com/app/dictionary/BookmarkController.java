package com.app.dictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.web.WebView;

public class BookmarkController {

    @FXML
    private ListView<String> bookmarkList;

    @FXML
    private ListView<String> historyList;

    @FXML
    private Label labelBookMark;

    @FXML
    private Label labelHistory;

    @FXML
    private Tab tabBookmark;

    @FXML
    private Tab tabHistory;

    @FXML
    private TabPane tabPane;

    @FXML
    private WebView webBookmark;

    @FXML
    private WebView webHistory;

}