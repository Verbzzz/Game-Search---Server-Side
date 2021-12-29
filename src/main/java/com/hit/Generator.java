package main.java.com.hit;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class Generator {

    private final static String INDEX_JSON = "index.json";

    //add getter
    Set<String> idSet ;

    Generator() {
        Type setType = new TypeToken<HashSet<String>>(){}.getType();
        try(FileReader fileReader = new FileReader(INDEX_JSON)){
            idSet = new Gson().fromJson(fileReader,setType);
        } catch (IOException e) {
            idSet = new HashSet<>();
        }
    }


    //IMPLEMENET JASON FILE INTO DATABASE
    void newJson(Game newGame) {

        final String id = newGame.getUuid();
        final String filename = new StringBuilder(id).append(".json").toString();
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
}
