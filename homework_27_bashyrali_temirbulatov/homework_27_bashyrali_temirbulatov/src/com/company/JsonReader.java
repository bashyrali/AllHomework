package com.company;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class JsonReader {
    private Gson gson = new Gson();


    public Root FromJson(String filePath){
        try (FileReader reader = new FileReader(filePath)) {

            Root yourList = gson.fromJson(reader, Root.class);
            return yourList;
        }
        catch (IOException e) {
            System.out.println("Error!");
        }
        return null;}
}
