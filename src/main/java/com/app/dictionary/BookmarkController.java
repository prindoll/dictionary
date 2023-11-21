package com.app.dictionary;

import com.app.dictionary.base.AddWordToTxt;
import com.app.dictionary.base.DeleteWordToTxt;
import com.app.dictionary.base.Dictionary;
import com.app.dictionary.base.Word;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.web.WebView;
import javafx.util.Callback;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;

public class BookmarkController implements Initializable {

    @FXML
    private ChoiceBox<String> bookmarkChoice;

    @FXML
    private Label bookmarkLabel;

    @FXML
    private ListView<String> bookmarkList;

    @FXML
    private WebView bookmarkWebView;

    @FXML
    private Button deleteButton;
    String[] choicesBookmark = {"English", "Vietnamese"};

    private Map<String, Word> bookmarkEngLish = new HashMap<String, Word>();
    private Map<String, Word> bookmarkVietnamese = new HashMap<String, Word>();
    private Map<String, Word> bookmarks = new HashMap<String, Word>();
    private ObservableList<String> keyBookmark = FXCollections.observableArrayList();
    private Dictionary dictionary = new Dictionary();
    private boolean status = true;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bookmarkChoice.getItems().addAll(choicesBookmark);
        bookmarkChoice.setValue(choicesBookmark[0]);
        setInitialize();
        setBookmark();
        showBookmarks();
        setFont();
    }

    public void setInitialize() {
        try {
            bookmarkEngLish = dictionary.getBookmarkEnglish();
            bookmarkVietnamese = dictionary.getBookmarkVietnamese();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        bookmarks = bookmarkEngLish;
        keyBookmark.setAll(bookmarks.keySet());
        bookmarkList.setItems(keyBookmark);
    }
    public void setBookmarkV() {
        resetWeb();
        bookmarks = bookmarkVietnamese;
        keyBookmark.setAll(bookmarks.keySet());
        bookmarkList.setItems(keyBookmark);
    }
    public void setBookmarkE() {
        resetWeb();
        bookmarks = bookmarkEngLish;
        keyBookmark.setAll(bookmarks.keySet());
        bookmarkList.setItems(keyBookmark);
    }
    public void setBookmark() {
        String tmp = "";
        bookmarkChoice.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String value = "";
            value = newValue;
            if(value.equals(choicesBookmark[1])) {
                setBookmarkV();
            }
            else {
                setBookmarkE();
            }
        });

    }

    private void resetWeb() {
        bookmarkWebView.getEngine().loadContent("");
        bookmarkLabel.setText("Từ đã lưu");
    }

    public void showBookmarks() {
        bookmarkList.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                showBookmarkDetails(newValue.trim());
            }
        });
    }

    private void showBookmarkDetails(String newValue) {
        Word selectedWord = bookmarks.get(newValue);

        if (selectedWord != null) {
            String definition = selectedWord.getDefination();
            bookmarkWebView.getEngine().loadContent(definition, "text/html");
            bookmarkLabel.setText(newValue);
        }
    }

    public void setFont() {
        bookmarkList.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
            @Override
            public ListCell<String> call(ListView<String> param) {
                return new ListCell<String>() {
                    @Override
                    protected void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (item != null && !empty) {
                            setText(item);
                            setFont(javafx.scene.text.Font.font(14));
                        } else {
                            setText(null);
                        }
                    }
                };
            }
        });
    }
    public void deleteWordBookmark() {
        String s = "";
        if(!bookmarkLabel.getText().equals("Từ đã lưu")) {
            s = bookmarkLabel.getText();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setHeaderText("Ban co xoa tu khong");
            ButtonType buttonTypeOK = new ButtonType("OK");
            ButtonType buttonTypeCancel = new ButtonType("Hủy bỏ");
            alert.getButtonTypes().setAll(buttonTypeOK, buttonTypeCancel);
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == buttonTypeOK) {
                try {
                    if(status) {
                        DeleteWordToTxt.deleteBookmarkE(s);
                        bookmarkEngLish.remove(s);
                        setBookmarkE();
                    }
                    else {
                        DeleteWordToTxt.deleteBookmarkV(s);
                        bookmarkVietnamese.remove(s);
                        setBookmarkV();
                    }
                } catch (IOException e) {
                    System.out.println("loi mo file o bookmark");
                }
                alert.close();
            }
            else {
                alert.close();
            }
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Vui lòng chọn từ để xóa");
            alert.showAndWait();
            alert.close();
        }
    }
}
