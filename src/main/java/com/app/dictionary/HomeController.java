package com.app.dictionary;

import com.app.dictionary.base.*;
import com.app.dictionary.base.Dictionary;
import javafx.animation.TranslateTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.web.HTMLEditor;
import javafx.scene.web.WebView;
import javafx.util.Callback;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.*;

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
    @FXML
    private VBox vbox;
    private boolean statusEng;

    public void loadData() {
        try {
            dictionary.loadDataE();
            dictionary.loadDataV();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        dataE = (dictionary != null) ? dictionary.getMapEnglish() : null;
        dataV = (dictionary != null) ? dictionary.getMapVietnamese() : null;

        if (dictionary != null) {
            dictionary.freeMap();
        }
    }

    public void resetItem() {
        this.labelText.setText("Từ đang tra");
        this.webSearch.getEngine().loadContent("");
        this.searchText.setText("");
    }


    public void checkSearch() {
        searchText.textProperty().addListener((observable, oldValue, newValue) -> {
            ObservableList<String> tmpItems = FXCollections.observableArrayList();

            if (newValue != null) {
                tmpItems.addAll(
                        allItems.stream()
                                .filter(item -> item.toLowerCase().startsWith(newValue.toLowerCase()))
                                .toList()
                );
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
                        if (statusEng) {
                            try {
                                AddWordToTxt.addHistoryEn(newValue);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        } else {
                            try {
                                AddWordToTxt.addHistoryVn(newValue);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
        );
    }

    public void clearSearchE() {
        this.searchText.setText("");
        List<String> list = new ArrayList<>();
        if (statusEng) {
            try {
                list = AddWordToTxt.getHistoryEn();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                list = AddWordToTxt.getHistoryVn();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        ObservableList<String> olist = FXCollections.observableArrayList();
        olist.setAll(list);
        listSearch.setItems(olist);
        list.clear();
    }

    @FXML
    public void addBookmark(ActionEvent event) {
        String tmp = labelText.getText();
        String s = tmp + data.get(tmp).getDefination();
        if (statusEng) {
            try {
                AddWordToTxt.addBookmarkEn(s);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                AddWordToTxt.addBookmarkVn(s);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
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
                            setStyle("-fx-font-size: 13px;");
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

    public void resetDictionaryE_V(ActionEvent e) {
        data = dataV;
        allItems.setAll(data.keySet());
        statusEng = false;
        Collections.sort(allItems);
        buttonV.setVisible(true);
        imgV.setVisible(true);
        buttonE.setVisible(false);
        imgE.setVisible(false);
        listSearch.setItems(allItems);
        us_.setVisible(false);
        uk_.setVisible(false);
        vie_.setVisible(true);
        resetItem();
    }

    public void resetDictionaryV_E(ActionEvent e) {
        data = dataE;
        allItems.setAll(data.keySet());
        statusEng = true;
        Collections.sort(allItems);
        imgV.setVisible(false);
        imgE.setVisible(true);
        buttonE.setVisible(true);
        buttonV.setVisible(false);
        listSearch.setItems(allItems);
        us_.setVisible(true);
        uk_.setVisible(true);
        vie_.setVisible(false);
        resetItem();
    }

    public void initialization() {
        data = dataE;
        allItems.setAll(data.keySet());
        statusEng = true;
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

    public void addE_V() {
        String word = addWord.getText();
        String def = htmlText.getHtmlText();
        Word newWord = new Word(word, def);
        if (!dataE.containsKey(word)) {
            dataE.put(word, newWord);
            StringBuilder sb = new StringBuilder(word + def);
            String s =  " dir=\"ltr\"";
            int position = sb.indexOf(s);
            sb.delete(position, position + s.length());
            AddWordToTxt.addE_V(sb.toString());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Đã thêm từ");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Từ đã có");
            alert.showAndWait();
        }
        updateDictionary();
    }

    public void addV_E() {
        String word = addWord.getText();
        String def = htmlText.getHtmlText();
        Word newWord = new Word(word, def);
        if (!dataV.containsKey(word)) {
            dataV.put(word, newWord);
            StringBuilder sb = new StringBuilder(word + def);
            String s =  " dir=\"ltr\"";
            int position = sb.indexOf(s);
            sb.delete(position, position + s.length());
            AddWordToTxt.addV_E(sb.toString());
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Đã thêm từ");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Từ đã có");
            alert.showAndWait();
        }
        updateDictionary();
    }

    public void updateDictionary() {
        if (statusEng) {
            data = dataE;
            allItems.setAll(dataE.keySet());
        } else {
            data = dataV;
            allItems.setAll(dataV.keySet());
        }
    }

    public void resetHtml() {
        htmlText.setHtmlText("<html>" + addWord.getText() + " /cách đọc/</i><br/><ul><li><b><i>" +
                "loại từ</i></b><ul><li><font color='#cc0000'><b> " +
                "nghĩa</b></font></li></ul></li></ul></html>");
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

    public void deleteWord() {
        String s = labelText.getText();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText("Ban co xoa tu khong");
        ButtonType buttonTypeOK = new ButtonType("OK");
        ButtonType buttonTypeCancel = new ButtonType("Hủy bỏ");
        alert.getButtonTypes().setAll(buttonTypeOK, buttonTypeCancel);
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == buttonTypeOK) {
            if (statusEng) {
                for (String tmp : dataE.keySet()) {
                    if (tmp.equals(s)) {
                        dataE.remove(tmp);
                        break;
                    }
                }
                try {
                    DeleteWordToTxt.deleteE_V(s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                for (String tmp : dataV.keySet()) {
                    if (tmp.equals(s)) {
                        dataV.remove(tmp);
                        break;
                    }
                }
                try {
                    DeleteWordToTxt.deleteV_E(s);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        alert.close();
        updateDictionary();
        resetItem();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        insertAnchorPane.setTranslateX(850);
        this.loadData();
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
