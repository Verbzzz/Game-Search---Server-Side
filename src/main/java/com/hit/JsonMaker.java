package main.java.com.hit;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

public class JsonMaker {

    private final static String INDEX_JSON = "index.json";

    //add getter
    Set<String> idSet ;

    JsonMaker() {
        Type setType = new TypeToken<HashSet<String>>(){}.getType();
        try(FileReader fileReader = new FileReader(INDEX_JSON)){
            idSet = new Gson().fromJson(fileReader,setType);
        } catch (IOException e) {
            idSet = new HashSet<>();
        }
    }

    public void generate() {

        Game game1 = new Game("GTA", "Roleplay", "Rockstar", "PlayHard", "north 97", true);
        newJson(game1, 1);

        Game game2 = new Game("Just Dance", "Music", "Ubisoft", "PlayHard", "north 97", true);
        newJson(game2, 2);

        Game game3 = new Game("Assassins Creed", "Adventure", "Ubisoft Montreal", "PlayHard", "north 97", true);
        newJson(game3, 3);

        Game game4 = new Game("Lego Star Wars", "Adventure", "TT Fusion", "PlayHard", "north 97", true);
        newJson(game4, 4);

        Game game5 = new Game(" Kung Fu Panda", "Platform", "Beenox", "PlayHard", "north 97", true);
        newJson(game5, 5);

        Game game6 = new Game(" Spider-Man 3", "Platform", "rockstar", "PlayHard", "north 97", true);
        newJson(game6, 6);

        Game game7 = new Game("Crazy Taxi", "Racing", "Hitmaker", "PlayHard", "north 97", true);
        newJson(game7, 7);

        Game game8 = new Game("Call of Duty:Black Ops", "Shooter", "Treyarch", "PlayHard", "north 97", true);
        newJson(game8, 8);

        Game game9 = new Game("Battlefield 3", "Shooter", "Dice", "PlayHard", "north 97", true);
        newJson(game9, 9);

        Game game10 = new Game("NBA 2K14", "Sports", "Visual Concepts", "PlayHard", "north 97", true);
        newJson(game10, 10);
    }

    //IMPLEMENET JASON FILE INTO DATABASE
    public void newJson(Game newGame, int index) {

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
