package com.app.dictionary;


import com.app.dictionary.base.Question;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.SplitPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BearFindHoney extends GameController implements Initializable {
    private final String correct = "CORRECT";
    private final String wrong = "WRONG";
    private int countDie = 0;

    @FXML
    protected AnchorPane anchorPane;
    @FXML
    private ImageView bear;

    private double x;
    private double y;
    private List<Question> quest;
    @FXML
    private Button question;
    @FXML
    private Button answer1;
    @FXML
    private Button answer2;
    @FXML
    private Button answer3;
    @FXML
    private Button answer4;
    @FXML
    private Button ButtonKq;
    @FXML
    private ImageView imageWIN;
    @FXML
    private ImageView imageQuestion1, imageQuestion2, imageQuestion3, imageQuestion4,imageQuestion5,imageQuestion6;
    final double[] rock = {400, 0, 400, 80, 240, 80, 240, 240, 80, 160, 0
            , 160, 0, 320, 0, 400, 160, 400, 320, 480, 400, 320};
    final double[] quesConst = {160, 80, 320, 160, 80, 320, 160, 320, 320, 400, 160, 480};
    double [] ques  = new double[quesConst.length];

    private double step = 80.0;

    private final Image imgBear = new Image(getClass().getResourceAsStream("img/bear.png"));
    private final Image imgWin = new Image(getClass().getResourceAsStream("img/win.png"));
    private final Image imgPass = new Image(getClass().getResourceAsStream("img/pass.png"));
    private final Image imgQues = new Image(getClass().getResourceAsStream("img/q.png"));

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        load();
        move();
        hideToAll();
    }

    public void load() {

        bear.setImage(imgBear);
        imageQuestion1.setImage(imgQues);
        imageQuestion2.setImage(imgQues);
        imageQuestion3.setImage(imgQues);
        imageQuestion4.setImage(imgQues);
        imageQuestion5.setImage(imgQues);
        imageQuestion6.setImage(imgQues);
        for (int i = 0 ; i < quesConst.length; i++){
            ques[i] = quesConst[i];
        }
    }

    public void move() {

        anchorPane.setOnKeyPressed(e -> {

            KeyCode keyCode = e.getCode();
            switch (keyCode) {
                case W:
                    y -= step;
                    if (y < 0) y = 0;
                    if (isRock(x, y)) {
                        y += step;
                    }
                    break;

                case S:
                    y += step;
                    if (y > 480) y = 480;
                    if (isRock(x, y)) {
                        y -= step;
                    }

                    break;
                case A:
                    x -= step;
                    if (x < 0) {
                        x = 0;
                    }
                    if (isRock(x, y)) {
                        x += step;
                    }
                    break;
                case D:
                    x += step;
                    if (x > 400) {
                        x = 400;
                    }
                    if (isRock(x, y)) {
                        x -= step;
                    }

                    break;
                default:
                    break;
            }
            bear.setLayoutX(x);
            bear.setLayoutY(y);
            if (isQuestion(x, y) != 0) {
                turnOnToAll();
                setStep(0);

            }
            if (ButtonKq.getText().equals(correct)) {
                int tmp = isQuestion(x, y);
                setPass(tmp);
                ques[(tmp-1)*2] = -1;
                ques[(tmp-1)*2 + 1] = -1;
                setStep(80);
                hideToAll();

            }
            if ( countDie == 3) {
                youLose();
            }
            if (isWin()) {
                youWin();
            }
        });
        anchorPane.setFocusTraversable(true);
    }

    private void youLose() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Game Over");
        alert.setHeaderText(null);
        alert.setContentText("You Lose");
        alert.showAndWait();
    }

    public boolean isRock(double x, double y) {
        double valX, valY;
        for (int i = 0; i < rock.length; i += 2) {
            valX = rock[i];
            valY = rock[i + 1];
            if (x == valX && y == valY) {
                return true;
            }
        }
        return false;
    }

    public void left() {
        bear.setLayoutX(x += 0);
    }

    public int  isQuestion(double x, double y) {
        double valX, valY;
        for (int i = 0; i < ques.length; i += 2) {
            valX = ques[i];
            valY = ques[i + 1];
            if (x == valX && y == valY) {
                return i / 2 + 1;
            }
        }
        return 0;
    }

    public void checkButton(Question q) {
        int ans = Question.trueAnswer(q);
        answer1.setOnAction(event1 -> {
            ButtonKq.setVisible(true);
            if (ans == 1) {
                ButtonKq.setText(correct);

            } else {
                ButtonKq.setText(wrong);
                countDie ++;
            }
        });
        answer2.setOnAction(event1 -> {
            ButtonKq.setVisible(true);
            if (ans == 2) {
                ButtonKq.setText(correct);
            } else {
                ButtonKq.setText(wrong);
                countDie ++;
            }
        });
        answer3.setOnAction(event1 -> {
            ButtonKq.setVisible(true);
            if (ans == 3) {
                ButtonKq.setText(correct);
            } else {
                ButtonKq.setText(wrong);
                countDie ++;
            }
        });
        answer4.setOnAction(event1 -> {
            ButtonKq.setVisible(true);
            if (ans == 4) {
                ButtonKq.setText(correct);
            } else {
                ButtonKq.setText(wrong);
                countDie ++;
            }
        });

    }

    public void turnOnToAll() {
        question.setVisible(true);
        answer1.setVisible(true);
        answer2.setVisible(true);
        answer3.setVisible(true);
        answer4.setVisible(true);
        loadQuestionToMap();
    }

    public void loadQuestionToMap() {
        try {
            double randomDouble = Math.random();
            randomDouble = randomDouble * 6 + 1;
            int count = (int) randomDouble;
            quest = Question.loadQuestion();


            question.setText(quest.get(count).getQuestion());
            answer1.setText(quest.get(count).getAnswer1());
            answer2.setText(quest.get(count).getAnswer2());
            answer3.setText(quest.get(count).getAnswer3());
            answer4.setText(quest.get(count).getAnswer4());

            checkButton(quest.get(count));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void hideToAll() {
        question.setVisible(false);
        answer1.setVisible(false);
        answer2.setVisible(false);
        answer3.setVisible(false);
        answer4.setVisible(false);
        ButtonKq.setVisible(false);
        ButtonKq.setText("Button");
    }

    public boolean isWin() {
        if (bear.getLayoutX() == 400 && bear.getLayoutY() == 480) return true;
        return false;
    }
    public void setPass(int index) {
        if ( index == 1) {
            imageQuestion1.setImage(imgPass);
        }
        else if ( index  == 2) {
            imageQuestion2.setImage(imgPass);
        }
        else if ( index  == 3) {
            imageQuestion3.setImage(imgPass);
        }
        else if ( index  == 4) {
            imageQuestion4.setImage(imgPass);
        }
        else if ( index  == 5) {
            imageQuestion5.setImage(imgPass);
        }
        else if ( index  == 6) {
            imageQuestion6.setImage(imgPass);
        }
    }
    public void setStep(double step) {
        this.step = step;
    }
    public void youWin() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Thông báo");
        alert.setHeaderText(null);
        alert.setContentText("Bạn xứng đáng có 10 ny");


        alert.showAndWait();
    }
}

