package com.app.dictionary;

import com.app.dictionary.base.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class Hangman extends GameController implements Initializable {
    @FXML
    protected AnchorPane hangmanAP;
    @FXML
    protected ImageView img;
    private Image image1 = new Image(getClass().getResourceAsStream("img/1.png"));
    private Image image2 = new Image(getClass().getResourceAsStream("img/2.png"));
    private Image image3 = new Image(getClass().getResourceAsStream("img/3.png"));
    private Image image4 = new Image(getClass().getResourceAsStream("img/4.png"));
    private Image image5 = new Image(getClass().getResourceAsStream("img/5.png"));
    private Image image6 = new Image(getClass().getResourceAsStream("img/6.png"));
    private Image image7 = new Image(getClass().getResourceAsStream("img/7.png"));

    @FXML
    private TextField tf1;
    @FXML
    private TextField tf2;
    @FXML
    private TextField tf3;
    @FXML
    private TextField tf4;
    @FXML
    private TextField tf5;
    @FXML
    private TextField tf6;
    @FXML
    private TextField tf7;
    @FXML
    private TextField tf8;
    @FXML
    private TextField tf9;
    @FXML
    private TextField tf10;
    @FXML
    private TextField input;
    @FXML
    private Label hint;
    @FXML
    private Label hint_label;
    @FXML
    private Label textwin = new Label("");

    private int random;
    private String word_hint;
    private String[] split;
    private String word;
    private String hint_str;
    private int letter_size;
    private int life = 6;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            loadData();
            setWord();
            setHint();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    List<String> words = new ArrayList<String>();
    public void loadData() throws IOException {
        FileReader fileReader = new FileReader("txt/game.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        String tmp;
        while ((tmp = reader.readLine()) != null) {
            words.add(tmp);
        }
    }
    public void setWord() {
        random = new Random().nextInt(words.size());
        word_hint = words.get(random);
        split = word_hint.split(" - ", 2);
        word = split[0];
        hint_str = split[1];
        letter_size = word.length();
    }

    public void setHint() {
        hint.setText(hint_str);
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
        tf5.setText("");
        tf6.setText("");
        tf7.setText("");
        tf8.setText("");
        tf9.setText("");
        tf10.setText("");

        tf5.setVisible(true);
        tf6.setVisible(true);
        tf7.setVisible(true);
        tf8.setVisible(true);
        tf9.setVisible(true);
        tf10.setVisible(true);
        if (letter_size == 9) {
            tf10.setVisible(false);
        }
        if (letter_size == 8) {
            tf9.setVisible(false);
            tf10.setVisible(false);
        }
        if (letter_size == 7) {
            tf8.setVisible(false);
            tf9.setVisible(false);
            tf10.setVisible(false);
        }
        if (letter_size == 6) {
            tf7.setVisible(false);
            tf8.setVisible(false);
            tf9.setVisible(false);
            tf10.setVisible(false);
        }
        if (letter_size == 5) {
            tf6.setVisible(false);
            tf7.setVisible(false);
            tf8.setVisible(false);
            tf9.setVisible(false);
            tf10.setVisible(false);
        }
        if (letter_size == 4) {
            tf5.setVisible(false);
            tf6.setVisible(false);
            tf7.setVisible(false);
            tf8.setVisible(false);
            tf9.setVisible(false);
            tf10.setVisible(false);
        }
    }


    public void CheckInput() {
        String str = input.getText().toUpperCase();
        if (word.contains(str)) {
            int index = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (String.valueOf(c).equals(str)) {
                    setLetter(index, Character.toString(c));
                }
                index++;
            }

        } else {
            setImage();
        }
    }

    public void setLetter(int index, String str) {
        if (index == 0)
            tf1.setText(str);
        else if (index == 1)
            tf2.setText(str);
        else if (index == 2)
            tf3.setText(str);
        else if (index == 3)
            tf4.setText(str);
        else if (index == 4)
            tf5.setText(str);
        else if (index == 5)
            tf6.setText(str);
        else if (index == 6)
            tf7.setText(str);
        else if (index == 7)
            tf8.setText(str);
    }

    public void setImage() {
        life--;
        if (life == 5)
            img.setImage(image2);
        else if (life == 4)
            img.setImage(image3);
        else if (life == 3)
            img.setImage(image4);
        else if (life == 2)
            img.setImage(image5);
        else if (life == 1)
            img.setImage(image6);
        else if (life == 0)
            img.setImage(image7);
    }


    public void restart(ActionEvent event) throws IOException {
        life = 6;
        img.setImage(image1);
        setWord();
        setHint();
    }
}
