package com.app.dictionary;

import com.app.dictionary.base.Translator;
import com.app.dictionary.base.Voicerss;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ApiController extends MainController implements Initializable {

    @FXML
    private ChoiceBox<String> choiceBox1;

    @FXML
    private ChoiceBox<String> choiceBox2;
    @FXML
    private TextField textField1;

    @FXML
    private TextField textField2;

    private final String[] choices = {"English", "Vietnamese", "Korean", "Chinaese", "Japanese"};
    private final String[] nameRs = {"en-us", "vi-vn", "ko-kr", "zh-cn", "ja-jp"};
    private final String[] voiceName = {"Linda", "Chi", "Nari", "Luli", "Hina"};
    private String str1, str2, vo1, vo2;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        choiceBox1.getItems().addAll(choices);
        choiceBox2.getItems().addAll(choices);
        choiceBox1.setValue("Chọn ngôn ngữ");
        choiceBox2.setValue("Chọn ngôn ngữ");
        setChoiceBox1();
        setChoiceBox2();
    }

    public void setChoiceBox1() {
        choiceBox1.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            str1 = newValue;
        });
    }
    public void setChoiceBox2() {
        choiceBox2.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            str2 = newValue;
        });
    }
    public void translateClick() {
        for(int i = 0; i < choices.length; i++) {
            if(str1.equals(choices[i])) {
                str1 = nameRs[i];
                vo1 = voiceName[i];
            }
            if(str2.equals(choices[i])) {
                str2 = nameRs[i];
                vo2 = voiceName[i];
            }
        }
        String str = textField1.getText();
        try {
            textField2.setText(Translator.translate(str1.substring(0, 2), str2.substring(0, 2), str));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public void speak1() {
        Voicerss.speed = 1.5;
        Voicerss.Name = vo1;
        Voicerss.language = str1;
        try {
            Voicerss.speakWord(textField1.getText());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public void speak2() {
        Voicerss.Name = vo2;
        Voicerss.language = str2;
        try {
            Voicerss.speakWord(textField2.getText());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}