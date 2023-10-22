package com.app.dictionary;

import com.app.dictionary.base.Dictionary;
import com.app.dictionary.base.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.ResourceBundle;

public class HomeController implements Initializable {

    @FXML
    private ImageView buttonDelete;

    @FXML
    private Label labelText;

    @FXML
    private ListView<String> listSearch;

    @FXML
    private TextField searchText;
    @FXML
    private Button clear;

    @FXML
    private WebView webSearch;

    private Map<String, Word> dataE;
    private Map<String, Word> dataV;
    private Map<String, Word> data;

    private Dictionary dictionary = new Dictionary();

    private ObservableList<String> allItemsE = FXCollections.observableArrayList();
    private ObservableList<String> allItemsV = FXCollections.observableArrayList();
    private ObservableList<String> allItems = FXCollections.observableArrayList();

    private ObservableList<String> searchE = FXCollections.observableArrayList();
    private ObservableList<String> searchV = FXCollections.observableArrayList();
    @FXML
    private Button buttonE;
    @FXML
    private Button buttonV;
    @FXML
    private ImageView imgV;
    @FXML
    private ImageView imgE;



    public void loadDatainMap() throws IOException {
        dictionary.loadData();
        dataE = dictionary.getMapEnglish();
        dataV = dictionary.getMapVietnamese();
        allItemsE.setAll(dataE.keySet());
        allItemsV.setAll(dataV.keySet());
        Collections.sort(allItemsE);
        Collections.sort(allItemsV);
    }

    public void checkSearchE() {
        this.searchText.textProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<String> tmpItems = FXCollections.observableArrayList();
            if (newValue != null) {
                for (String item : allItems) {
                    if (item.toLowerCase().startsWith(newValue.toLowerCase())) {
                        tmpItems.add(item);
                    }
                }
            }
            listSearch.setItems(tmpItems);
        });
    }

    public void initWebViewE() {
        this.listSearch.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    if (newValue != null) {
                        Word selectedWord = data.get(newValue.trim());
                        String definition = selectedWord.getDefination();
                        this.webSearch.getEngine().loadContent(definition, "text/html");
                        this.labelText.setText(newValue);
                    }
                }
        );
    }
    public void clearSearchE() {
        this.searchText.setText("");
        listSearch.setItems(null);
    }

    public void setColorListView() {
        this.listSearch.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null) {
                            setText(item);
                            setTextFill(Color.WHITE);
                            setBackground(new Background(new BackgroundFill(Color.GRAY, null, null)));
                        } else {
                            setText(null);
                            setBackground(new Background(new BackgroundFill(Color.WHITE, null, null)));
                        }
                    }
                };
            }
        });
    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonV.setVisible(false);
        imgV.setVisible(false);
        data = dictionary.getMapEnglish();
        allItems = allItemsE;
        try {
            this.loadDatainMap();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        this.setColorListView();
        buttonE.setOnMouseClicked(event -> {
            data = dictionary.getMapVietnamese();
            allItems = allItemsV;
            buttonV.setVisible(true);
            imgV.setVisible(true);
            buttonE.setVisible(false);
            imgE.setVisible(false);
        });
        buttonV.setOnMouseClicked(event -> {
            data = data = dictionary.getMapEnglish();
            allItems = allItemsE;
            imgV.setVisible(false);
            imgE.setVisible(true);
            buttonE.setVisible(true);
            buttonV.setVisible(false);
        });
            this.checkSearchE();
            this.initWebViewE();


    }
}
