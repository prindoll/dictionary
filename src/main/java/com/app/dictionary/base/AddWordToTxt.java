package com.app.dictionary.base;

import javafx.scene.control.Alert;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class AddWordToTxt extends FileName {
    public static void addBookmarkEn(String s) throws IOException {
        String[] tmp = s.split(SPLITTING_CHARACTERS);
        List<String> list = AddWordToTxt.getBookmarkEn();
        if(!list.contains(tmp[0])) {
            FileWriter fileWriter = new FileWriter(BookmarkEN, true);
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
    public static void addBookmarkVn(String s) throws IOException {
        String[] tmp = s.split(SPLITTING_CHARACTERS);
        List<String> list = AddWordToTxt.getBookmarkVn();
        if(!list.contains(tmp[0])) {
            FileWriter fileWriter = new FileWriter(BookmarkVN, true);
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
    public static List<String> getBookmarkEn() throws IOException {
        List<String> list = new ArrayList<>();
        FileReader fileReader = new FileReader(BookmarkEN);
        BufferedReader en = new BufferedReader(fileReader);
        String tmp;
        while ((tmp = en.readLine()) != null) {
            String[] res = tmp.split(SPLITTING_CHARACTERS);
            list.add(res[0]);
        }
        en.close();
        fileReader.close();
        return list;
    }
    public static List<String> getBookmarkVn() throws IOException {
        List<String> list = new ArrayList<>();
        FileReader fileReader = new FileReader(BookmarkVN);
        BufferedReader en = new BufferedReader(fileReader);
        String tmp;
        while ((tmp = en.readLine()) != null) {
            String[] res = tmp.split(SPLITTING_CHARACTERS);
            list.add(res[0]);
        }
        en.close();
        fileReader.close();
        return list;
    }
    public static void addHistoryEn(String s) throws IOException {
        List<String> list = AddWordToTxt.getHistoryEn();
        if(!list.contains(s)) {
            FileWriter fileWriter = new FileWriter(HistoryEN, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(s);
            writer.newLine();
            writer.close();
            fileWriter.close();
        }
        list.clear();
    }
    public static void addHistoryVn(String s) throws IOException {
        List<String> list = AddWordToTxt.getHistoryVn();
        if(!list.contains(s)) {
            FileWriter fileWriter = new FileWriter(HistoryVN, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(s);
            writer.newLine();
            writer.close();
            fileWriter.close();
        }
        list.clear();
    }
    public static List<String> getHistoryEn() throws IOException {
        List<String> list = new ArrayList<>();
        FileReader fileReader = new FileReader(HistoryEN);
        BufferedReader en = new BufferedReader(fileReader);
        String tmp;
        while ((tmp = en.readLine()) != null) {
            list.add(tmp);
        }
        en.close();
        fileReader.close();
        return list;
    }
    public static List<String> getHistoryVn() throws IOException {
        List<String> list = new ArrayList<>();
        FileReader fileReader = new FileReader(HistoryVN);
        BufferedReader en = new BufferedReader(fileReader);
        String tmp;
        while ((tmp = en.readLine()) != null) {
            list.add(tmp);
        }
        en.close();
        fileReader.close();
        return list;
    }
    public static void addE_V(String s) {
        try {
            FileWriter fileWriter = new FileWriter(DictionaryEtoV, true);
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
            FileWriter fileWriter = new FileWriter(DictionaryVtoE, true);
            BufferedWriter writer = new BufferedWriter(fileWriter);
            writer.write(s);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
