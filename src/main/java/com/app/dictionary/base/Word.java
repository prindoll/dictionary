package com.app.dictionary.base;

public class Word {
    private String word;
    private String defination;

    public Word(String word, String def) {
        this.word = word;
        this.defination = def;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefination() {
        return defination;
    }

    public void setDefination(String def) {
        this.defination = def;
    }
}
