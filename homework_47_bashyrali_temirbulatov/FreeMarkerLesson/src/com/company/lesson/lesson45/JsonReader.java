package com.company.lesson.lesson45;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonReader {
    private Gson gson = new Gson();


    public Books putBooksFromJson(String filePath){
        try (FileReader reader = new FileReader(filePath)) {

            Books yourList = gson.fromJson(reader, Books.class);
            return yourList;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Users putUsersFromJson(String filePath){
        try (FileReader reader = new FileReader(filePath)) {

            Users yourList = gson.fromJson(reader, Users.class);
            return yourList;
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addBooksToJson(Books books , String filepath){
        String  json = gson.toJson(books);

        try (FileWriter writer = new FileWriter(filepath)) {
            writer.write(json);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void addUsersToJson(Users users , String filepath){
         String  json = gson.toJson(users);

        try (FileWriter writer = new FileWriter(filepath)) {
            writer.write(json);
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
