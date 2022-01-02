package main.java.com.hit.service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.java.com.hit.dm.Game;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

public class Generator {
    public static void main(String[] args) {

    }

    private final static String INDEX_JSON = "UUID.json";

    //add getter
    Set<String> idSet;

    Generator() {
        Type setType = new TypeToken<HashSet<String>>() {
        }.getType();
        try (FileReader fileReader = new FileReader(INDEX_JSON)) {
            idSet = new Gson().fromJson(fileReader, setType);
        } catch (IOException e) {
            idSet = new HashSet<>();
        }
    }

    void createJson(Game newGame){
        System.out.println("create");

        final String id = newGame.getUuid();

        final String filename = id + ".json";
        try (FileWriter fileWriter = new FileWriter(filename)) {
            new Gson().toJson(newGame, fileWriter);
            idSet.add(newGame.getUuid());
            try (FileWriter fileWriter1 = new FileWriter(INDEX_JSON)) {
                new Gson().toJson(idSet, fileWriter1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void updateJson(Game newGame){
        System.out.println("update");

        final String id = newGame.getUuid();

        final String filename = id + ".json";
        try (FileWriter fileWriter = new FileWriter(filename)) {
            new Gson().toJson(newGame, fileWriter);
//            idSet.add(newGame.getUuid());
//            try (FileWriter fileWriter1 = new FileWriter(INDEX_JSON)) {
//                new Gson().toJson(idSet, fileWriter1);
//            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //IMPLEMENET JASON FILE INTO DATABASE
    void jsonBuilder(Game newGame) {

        final String id = newGame.getUuid();

        try(Reader reader = Files.newBufferedReader(Paths.get(id +".json"))) {
//            create a reader
//            Gson gson = new Gson();// create Gson instance
//            Reader reader = Files.newBufferedReader(Paths.get("index.json"));
            //Reader reader =
            updateJson(newGame);

        } catch (Exception ex) {
            createJson(newGame);
            ex.printStackTrace();
        }
    }
}


