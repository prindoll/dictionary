package com.app.dictionary.base;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeleteWordToTxt {
    public static final String BookmarkEN = "txt/bookmarkE.txt";
    public static final String HistoryEN = "txt/historyE.txt";
    public static final String DictionaryEtoV = "txt/E_V.txt";
    public static final String DictionaryVtoE = "txt/V_E.txt";
    public static final String HistoryVN = "txt/historyV.txt";
    public static final String BookmarkVN = "txt/bookmarkV.txt";
    public static void deleteV_E(String s) throws IOException {
        List<String> list = new ArrayList<>();
        FileReader file = new FileReader(DictionaryVtoE);
        BufferedReader br = new BufferedReader(file);
        String tmp;
        while((tmp = br.readLine()) != null) {
            String[] res = tmp.split("<html>");
            if(!s.equals(res[0])) {
                list.add(tmp);
            }
        }
        FileWriter fileWriter = new FileWriter(DictionaryVtoE);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        for(String write : list) {
            bw.write(write);
            bw.newLine();
        }
        bw.close();
        br.close();
        file.close();
        fileWriter.close();
    }
    public static void deleteE_V(String s) throws IOException {
        List<String> list = new ArrayList<>();
        FileReader file = new FileReader(DictionaryEtoV);
        BufferedReader br = new BufferedReader(file);
        String tmp;
        while((tmp = br.readLine()) != null) {
            String[] res = tmp.split("<html>");
            if(!s.equals(res[0])) {
                list.add(tmp);
            }
        }
        FileWriter fileWriter = new FileWriter(DictionaryEtoV);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        for(String write : list) {
            bw.write(write);
            bw.newLine();
        }
        bw.close();
        br.close();
        file.close();
        fileWriter.close();
    }
    public static void deleteBookmarkE(String s) throws IOException {
        List<String> list = new ArrayList<>();
        FileReader file = new FileReader(BookmarkEN);
        BufferedReader br = new BufferedReader(file);
        String tmp;
        while((tmp = br.readLine()) != null) {
            String[] res = tmp.split("<html>");
            if(!s.equals(res[0])) {
                list.add(tmp);
            }
        }
        FileWriter fileWriter = new FileWriter(BookmarkEN);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        for(String write : list) {
            bw.write(write);
            bw.newLine();
        }
        bw.close();
        br.close();
        file.close();
        fileWriter.close();
    }
    public static void deleteBookmarkV(String s) throws IOException {
        List<String> list = new ArrayList<>();
        FileReader file = new FileReader(BookmarkVN);
        BufferedReader br = new BufferedReader(file);
        String tmp;
        while((tmp = br.readLine()) != null) {
            String[] res = tmp.split("<html>");
            if(!s.equals(res[0])) {
                list.add(tmp);
            }
        }
        FileWriter fileWriter = new FileWriter(BookmarkVN);
        BufferedWriter bw = new BufferedWriter(fileWriter);
        for(String write : list) {
            bw.write(write);
            bw.newLine();
        }
        bw.close();
        br.close();
        file.close();
        fileWriter.close();
    }
}

