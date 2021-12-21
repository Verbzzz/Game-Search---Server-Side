package main.java.com.hit;

import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class GameSearchService implements IDao<Game> {


    public enum GameKey {
        GameName,
        Genre

    }

    public static void main(String[] args){
        GameSearchService gss = new GameSearchService();
//        new JsonMaker().newJson(new Game( ///מופע יחיד
//                "aa","
//        ));
        gss.getGame(GameKey.Genre,"Adventure");
        System.out.println("main started");


    }


    private String enumMapper(GameKey key, Game game){
        switch (key){
            case GameName: return game.getGameName();
            case Genre:return game.getGenre();
            default:return null;
        }
    }

//    @Override
    public void getGame(GameKey key, String searchVal){
        System.out.println("get started");
        JsonMaker jsonMaker = new JsonMaker();

        int index;
        int count = 0;
        List<Game> gameList=new ArrayList<>();

        try {
            // create a reader
            for(String id: jsonMaker.idSet) {
                Gson gson = new Gson();// create Gson instance
                Reader reader = Files.newBufferedReader(Paths.get(id + ".json"));
                Game game = gson.fromJson(reader, Game.class);// convert JSON file to map

                String value = enumMapper(key, game);
                if (value != null && value.equals(searchVal))
                    gameList.add(game);
            }

            System.out.println(count);
            System.out.println(gameList);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
//
        System.out.println("get finished");
    }

    @Override
    public void saveGame(Game game) {
        System.out.println("save started");

//        new JsonMaker().newJson(new Game( ///מופע יחיד
//                "aa","
//        ));

        System.out.println("save finished");

    }

    @Override
    public void updateGame(Game game, String[] params) {
        System.out.println("save started");

        System.out.println("save finished");
    }

    @Override
    public void deleteGame(Game game) {
        System.out.println("save started");

        System.out.println("save finished");
    }
}
