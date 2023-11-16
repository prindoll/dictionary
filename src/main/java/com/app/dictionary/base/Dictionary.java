package com.app.dictionary.base;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Dictionary extends FileName {

    private Map<String, Word> dataEnglish = new HashMap<>();
    private Map<String, Word> dataVietnamese = new HashMap<>();


    public void loadDataE() throws IOException {
        FileReader fileReaderEn = new FileReader(DictionaryEtoV);
        BufferedReader en = new BufferedReader(fileReaderEn);
        String tmp;
        while ((tmp = en.readLine()) != null) {
            String[] parts = tmp.split(SPLITTING_CHARACTERS);
            String word = parts[0];
            String definition = SPLITTING_CHARACTERS + parts[1];
            Word wordObj = new Word(word, definition);
            dataEnglish.put(word, wordObj);
        }
        en.close();
        fileReaderEn.close();
    }
    public void loadDataV() throws IOException {
        FileReader fileReaderVn = new FileReader(DictionaryVtoE);
        BufferedReader vn = new BufferedReader(fileReaderVn);
        String tmp;
        while ((tmp = vn.readLine()) != null) {
            String[] parts = tmp.split(SPLITTING_CHARACTERS);
            String word = parts[0];
            String definition = SPLITTING_CHARACTERS + parts[1];
            Word wordObj = new Word(word, definition);
            dataVietnamese.put(word, wordObj);
        }
        vn.close();
        fileReaderVn.close();
    }


    public Map<String, Word> getMapEnglish() {
        return this.dataEnglish;
    }
    public Map<String, Word> getMapVietnamese(){return this.dataVietnamese;}

    public void freeMap() {
        this.dataEnglish = null;
        this.dataVietnamese = null;
    }

    public Map<String, Word> getBookmarkEnglish() throws IOException {
        Map<String, Word> map = new HashMap<>();
        FileReader fileReaderVn = new FileReader(BookmarkEN);
        BufferedReader vn = new BufferedReader(fileReaderVn);
        String tmp;
        while ((tmp = vn.readLine()) != null) {
            String[] parts = tmp.split(SPLITTING_CHARACTERS);
            String word = parts[0];
            String definition = SPLITTING_CHARACTERS + parts[1];
            Word wordObj = new Word(word, definition);
            map.put(word, wordObj);
        }
        vn.close();
        fileReaderVn.close();
        return map;
    }
    public Map<String, Word> getBookmarkVietnamese() throws IOException {
        Map<String, Word> map = new HashMap<>();
        FileReader fileReaderVn = new FileReader(BookmarkVN);
        BufferedReader vn = new BufferedReader(fileReaderVn);
        String tmp;
        while ((tmp = vn.readLine()) != null) {
            String[] parts = tmp.split(SPLITTING_CHARACTERS);
            String word = parts[0];
            String definition = SPLITTING_CHARACTERS + parts[1];
            Word wordObj = new Word(word, definition);
            map.put(word, wordObj);
        }
        vn.close();
        fileReaderVn.close();
        return map;
    }


}
