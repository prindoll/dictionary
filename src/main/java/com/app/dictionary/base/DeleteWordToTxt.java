package com.app.dictionary.base;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DeleteWordToTxt {
    public static final String BOOKMARK = "txt/bookmark.txt";
    public static final String HISTORY = "txt/history.txt";
    public static final String E_V = "txt/E_V.txt";
    public static final String V_E = "txt/V_E.txt";

    public static void deleteV_E(String s) throws IOException {
        List<String> list = new ArrayList<>();
        FileReader file = new FileReader(V_E);
        BufferedReader br = new BufferedReader(file);
        String tmp;
        while((tmp = br.readLine()) != null) {
            String[] res = tmp.split("<html>");
            if(!s.equals(res[0])) {
                list.add(tmp);
            }
        }
        FileWriter fileWriter = new FileWriter(V_E);
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
        FileReader file = new FileReader(E_V);
        BufferedReader br = new BufferedReader(file);
        String tmp;
        while((tmp = br.readLine()) != null) {
            String[] res = tmp.split("<html>");
            if(!s.equals(res[0])) {
                list.add(tmp);
            }
        }
        FileWriter fileWriter = new FileWriter(E_V);
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
    public static void deleteBookmark(String s) throws IOException {
        List<String> list = new ArrayList<>();
        FileReader file = new FileReader(BOOKMARK);
        BufferedReader br = new BufferedReader(file);
        String tmp;
        while((tmp = br.readLine()) != null) {
            String[] res = tmp.split("<html>");
            if(!s.equals(res[0])) {
                list.add(tmp);
            }
        }
        FileWriter fileWriter = new FileWriter(BOOKMARK);
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

    public static void main(String[] args) {
        String s = "nice";
        try {
            DeleteWordToTxt.deleteBookmark(s);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

