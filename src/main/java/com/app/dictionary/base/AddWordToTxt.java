package com.app.dictionary.base;

import javafx.scene.control.Alert;

import java.awt.print.Book;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddWordToTxt {
    public static final String BOOKMARK = "txt/bookmark.txt";
    public static final String HISTORY = "txt/history.txt";
    public static final String E_V = "txt/E_V.txt";
    public static final String V_E = "txt/V_E.txt";

    public static void addBookmark(String s) throws IOException {
        String[] tmp = s.split("<html>");
        List<String> list = AddWordToTxt.bookmark();
        if(!list.contains(tmp[0])) {
            FileWriter fileWriter = new FileWriter(BOOKMARK, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            writer.write(s);
            writer.newLine();
            writer.close();
            fileWriter.close();
            alert.setHeaderText("Đã thêm từ vào bookmark");
            alert.showAndWait();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Từ đã có trong bookmark");
            alert.showAndWait();
        }
        list.clear();
    }

    public static List<String> bookmark() throws IOException {
        List<String> list = new ArrayList<>();
        FileReader fileReaderEn = new FileReader(BOOKMARK);
        BufferedReader en = new BufferedReader(fileReaderEn);
        String tmp;
        while ((tmp = en.readLine()) != null) {
            String[] res = tmp.split("<html>");
            list.add(res[0]);
        }
        en.close();
        fileReaderEn.close();
        return list;
    }

    public static void addHistory(String s) throws IOException {
        List<String> list = AddWordToTxt.hisory();
        if(!list.contains(s)) {
            FileWriter fileWriter = new FileWriter(HISTORY, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(s);
            writer.newLine();
            writer.close();
            fileWriter.close();
        }
        list.clear();
    }
    public static List<String> hisory() throws IOException {
        List<String> list = new ArrayList<>();
        FileReader fileReaderEn = new FileReader(HISTORY);
        BufferedReader en = new BufferedReader(fileReaderEn);
        String tmp;
        while ((tmp = en.readLine()) != null) {
            list.add(tmp);
        }
        en.close();
        fileReaderEn.close();
        return list;
    }
    public static void addE_V(String s) {
        try {
            FileWriter fileWriter = new FileWriter(E_V, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(s);
            writer.newLine();
            writer.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void addV_E(String s) {
        try {
            FileWriter fileWriter = new FileWriter(V_E, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(s);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
