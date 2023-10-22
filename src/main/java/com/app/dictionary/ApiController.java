package com.app.dictionary;

import com.app.dictionary.base.Translator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ApiController implements Initializable {

    @FXML
    private Button chinese1;

    @FXML
    private Button chinese2;

    @FXML
    private Label choose1;

    @FXML
    private Label choose2;

    @FXML
    private Button english1;

    @FXML
    private Button english2;

    @FXML
    private Button japanese1;

    @FXML
    private Button japanese2;

    @FXML
    private TextArea text1;

    @FXML
    private TextArea text2;

    @FXML
    private Button translate;

    @FXML
    private Button vietnamese1;

    @FXML
    private Button vietnamese2;


    private static final String ENGLISH = "en";
    private static final String VIETNAMESE = "vn";
    private static final String CHINESE = "cn";
    private static final String JAPANESE = "jp";
    private String tmp1 = null;
    private String tmp2 = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        vietnamese1.setOnAction(event -> {
            choose1.setText("Vietnamese");
            tmp1 = VIETNAMESE;
        });
        vietnamese2.setOnAction(event -> {
            choose2.setText("Vietnamese");
            tmp2 = VIETNAMESE;
        });
        english1.setOnAction(event -> {
            choose1.setText("English");
            tmp1 = ENGLISH;
        });
        english2.setOnAction(event -> {
            choose2.setText("English");
            tmp2 = ENGLISH;
        });
        japanese1.setOnAction(event -> {
            choose1.setText("Japanese");
            tmp1 = JAPANESE;
        });
        japanese2.setOnAction(event -> {
            choose2.setText("Japanese");
            tmp2 = JAPANESE;
        });
        chinese1.setOnAction(event -> {
            choose1.setText("Chinese");
            tmp1 = CHINESE;
        });
        chinese2.setOnAction(event -> {
            choose2.setText("Chinese");
            tmp2 = CHINESE;
        });
        translate.setOnAction(event -> {
            String text = text1.getText();
            String res = null;
            try {
                res = Translator.translate( "en", "vn", text);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            text2.setText(res);
        });
    }
}
