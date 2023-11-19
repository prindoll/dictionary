package com.app.dictionary.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Question {
    private String question;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String correctAnswer;

    public Question(String question, String answer1, String answer2, String answer3, String answer4, String correctAnswer) {
        this.question = question;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.correctAnswer = correctAnswer;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public static List<Question> loadQuestion() throws IOException {
        List<Question> questions = new ArrayList<Question>();
        FileReader fileReader = new FileReader("txt/question.txt");
        BufferedReader reader = new BufferedReader(fileReader);
        String tmp;
        while ((tmp = reader.readLine()) != null) {
            String[] lines = tmp.split("=");
            //System.out.println(lines.length);
            if(lines.length == 6) {
                Question question = new Question(lines[0], lines[1], lines[2], lines[3], lines[4], lines[5]);
                questions.add(question);
            }
        }
        return questions;
    }
    public static int trueAnswer(Question question) {
        if(question.getCorrectAnswer().equals(question.getAnswer1())){
            return 1;
        }
        else if(question.getCorrectAnswer().equals(question.getAnswer2())){
            return 2;
        }
        else if(question.getCorrectAnswer().equals(question.getAnswer3())){
            return 3;
        }
        else
            return 4;
    }
    public static void main(String[] args) {
        try {
            List<Question> questions = loadQuestion();
            System.out.println(questions.size());
            for (Question question : questions) {
                System.out.println(trueAnswer(question));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
