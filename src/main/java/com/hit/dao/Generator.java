package main.java.com.hit.dao;

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

    private final static String INDEX_JSON = "UUID.json";

    Set<String> idSet;
    public String path = "src/main/java/com/hit/resource/";

    public Generator() {
        Type setType = new TypeToken<HashSet<String>>() {
        }.getType();
        try (FileReader fileReader = new FileReader(path + INDEX_JSON)) {
            idSet = new Gson().fromJson(fileReader, setType);
        } catch (IOException e) {
            idSet = new HashSet<>();
        }
    }

    public void createJson(Game newGame) {
        final String id = newGame.getUuid();

        final String filename = path + id + ".json";
        try (FileWriter fileWriter = new FileWriter(filename)) {
            new Gson().toJson(newGame, fileWriter);
            idSet.add(newGame.getUuid());
            try (FileWriter fileWriter1 = new FileWriter(path + INDEX_JSON)) {
                new Gson().toJson(idSet, fileWriter1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateJson(Game newGame) {
        final String id = newGame.getUuid();

        final String filename = path + id + ".json";
        try (FileWriter fileWriter = new FileWriter(filename)) {
            new Gson().toJson(newGame, fileWriter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void jsonBuilder(Game newGame){
        final String id = newGame.getUuid();
        if(Files.exists(Paths.get(path + id + ".json"))){
            updateJson(newGame);
        }
        else{
            createJson(newGame);
        }
    }
}


