package com.app.dictionary.base;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private static final String DATA_ENG = "txt/E_V.txt";
    private static final String DATA_VN = "txt/V_E.txt";
    private static final String SPLITTING_CHARACTERS = "<html>";

    private Map<String, Word> dataEnglish = new HashMap<>();
    private Map<String, Word> dataVietnamese = new HashMap<>();


    public void loadData() throws IOException {
        FileReader fileReaderEn = new FileReader(DATA_ENG);
        BufferedReader en = new BufferedReader(fileReaderEn);
        String tmp;
        while ((tmp = en.readLine()) != null) {
            String[] parts = tmp.split(SPLITTING_CHARACTERS);
            String word = parts[0];
            String definition = SPLITTING_CHARACTERS + parts[1];
            Word wordObj = new Word(word, definition);
            dataEnglish.put(word, wordObj);
        }
        tmp = "";
        FileReader fileReaderVn = new FileReader(DATA_VN);
        BufferedReader vn = new BufferedReader(fileReaderVn);
        while ((tmp = vn.readLine()) != null) {
            String[] parts = tmp.split(SPLITTING_CHARACTERS);
            String word = parts[0];
            String definition = SPLITTING_CHARACTERS + parts[1];
            Word wordObj = new Word(word, definition);
            dataVietnamese.put(word, wordObj);
        }
    }

    public Map<String, Word> getMapEnglish() {
        return this.dataEnglish;
    }
    public Map<String, Word> getMapVietnamese(){return this.dataVietnamese;}

    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        try {
            dictionary.loadData();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(dictionary.dataEnglish.size());
    }

}
