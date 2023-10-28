package com.app.dictionary;
import com.app.dictionary.base.Dictionary;
import com.app.dictionary.base.Voicerss;
import com.app.dictionary.base.Word;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;
import javafx.util.Callback;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.ResourceBundle;
public class HomeController extends MainController implements Initializable {
    @FXML
    private AnchorPane homeAnchorPane;
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
    private static Map<String, Word> data;
    private static Map<String, Word> dataE;
    private static Map<String, Word> dataV;
    private Dictionary dictionary = new Dictionary();
    private static ObservableList<String> allItems = FXCollections.observableArrayList();
    private ObservableList<String> bookMarkE = FXCollections.observableArrayList();
    private ObservableList<String> bookMarkV = FXCollections.observableArrayList();
    @FXML
    private Button buttonE;
    @FXML
    private Button buttonV;
    @FXML
    private ImageView imgV;
    @FXML
    private ImageView imgE;
    @FXML
    private Button us;
    @FXML
    private Button uk;
    @FXML
    private Button vie;
    @FXML
    private HBox us_;
    @FXML
    private HBox uk_;
    @FXML
    private HBox vie_;
    @FXML
    private AnchorPane insertAnchorPane;
    @FXML
    private TextField addWord;
    @FXML
    private HTMLEditor htmlText;
    public void loadMap() {
        try {
            dictionary.loadDataE();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            dictionary.loadDataV();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        dataE = dictionary.getMapEnglish();
        dataV = dictionary.getMapVietnamese();
        dictionary.freeMap();
    }


    public void checkSearch() {
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


    public void initWebView() {
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
    public void checkButtonE(ActionEvent e) {
        data = dataV;
        allItems.setAll(data.keySet());
        Collections.sort(allItems);
        buttonV.setVisible(true);
        imgV.setVisible(true);
        buttonE.setVisible(false);
        imgE.setVisible(false);
        listSearch.setItems(allItems);
        us_.setVisible(false);
        uk_.setVisible(false);
        vie_.setVisible(true);
    }
    public void checkButtonV(ActionEvent e) {
        data = dataE;
        allItems.setAll(data.keySet());
        Collections.sort(allItems);
        imgV.setVisible(false);
        imgE.setVisible(true);
        buttonE.setVisible(true);
        buttonV.setVisible(false);
        listSearch.setItems(allItems);
        us_.setVisible(true);
        uk_.setVisible(true);
        vie_.setVisible(false);
    }

    public void initialization() {
        data = dataE;
        allItems.setAll(data.keySet());
        Collections.sort(allItems);
        imgV.setVisible(false);
        imgE.setVisible(true);
        buttonE.setVisible(true);
        buttonV.setVisible(false);
        listSearch.setItems(allItems);
        us_.setVisible(true);
        uk_.setVisible(true);
        vie_.setVisible(false);
        labelText.setText("I love Gwen bro :))");
    }

    //Xu ly them tu
    public void addE_V() {
        String word = addWord.getText();
        String def = htmlText.getHtmlText();
        Word newWord = new Word(word, def);
        if(!dataE.containsKey(word)) {
            dataE.put(word, newWord);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Đã thêm từ");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Từ đã có");
            alert.showAndWait();
        }
    }
    public void addV_E() {
        String word = addWord.getText();
        String def = htmlText.getHtmlText();
        Word newWord = new Word(word, def);
        if(!dataV.containsKey(word)) {
            dataV.put(word, newWord);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Đã thêm từ");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Từ đã có");
            alert.showAndWait();
        }
    }
    public void reset() {
        htmlText.setHtmlText("<html>" + addWord.getText() + " /" +  "cách đọc" + "/"
                + "<ul><li><b><i> loại từ: </i></b><ul><li><font color='#cc0000'><b> Nghĩa:" +
                "</b></font><ul></li></ul></ul></li></ul><ul><li><b><i>loại từ</i></b><ul><li>" +
                "<font color='#cc0000'><b> Nghĩa: </b></font></li></ul></li></ul></html>");
    }
    public void hideInsert() {
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(1));
        slide.setNode(insertAnchorPane);
        slide.setToX(850);
        slide.play();
        insertAnchorPane.setTranslateX(0);
        slide.setOnFinished((ActionEvent event) -> {
            insertAnchorPane.setVisible(false);
        });
    }
    public void visibleInsert() {
        insertAnchorPane.setVisible(true);
        TranslateTransition slide = new TranslateTransition();
        slide.setDuration(Duration.seconds(1));
        slide.setNode(insertAnchorPane);
        slide.setToX(0);
        slide.play();
        insertAnchorPane.setTranslateX(850);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        insertAnchorPane.setTranslateX(850);
        this.loadMap();
        this.initialization();
        this.setColorListView();
        this.checkSearch();
        this.initWebView();
        us.setOnAction(event -> {
            Voicerss.Name = "Linda";
            Voicerss.language = "en-us";
            try {
                Voicerss.speakWord(labelText.getText());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        uk.setOnAction(event -> {
            Voicerss.Name = "Alice";
            Voicerss.language = "en-gb";
            try {
                Voicerss.speakWord(labelText.getText());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        vie.setOnAction(event -> {
            Voicerss.Name = "Chi";
            Voicerss.language = "vi-vn";
            try {
                Voicerss.speakWord(labelText.getText());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
    }
}
