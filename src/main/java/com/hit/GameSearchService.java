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
        Genre,
        GameCompanyDevelop,
        GameStoreName,
        AddressStore,
        //Available
    };



    public static void main(String[] args){

        //dataBaseInitialization();
        GameSearchService gss = new GameSearchService();



        //gss.getGame(GameKey.Genre,"Adventure");
        //gss.updateGame("GTA",GameKey.Genre,"blabla");

        Game saveGame = new Game("new game", "Roleplay", "Rockstar", "PlayHard", "north 97", true);
        gss.saveGame(saveGame);


    }


    private String enumMapper(GameKey key, Game game){
        switch (key){
            case GameName: return game.getGameName();
            case Genre:return game.getGenre();
            case GameCompanyDevelop:return game.getGameCompanyDevelop();
            case GameStoreName:return game.getGameStoreName();
            case AddressStore:return game.getAddressStore();
            //case Available:return game.getAvailable().toString();
            default:return null;
        }
    }


    //@Override
    public void getGame(GameKey key, String searchVal){

        Generator generator = new Generator();
        List<Game> gameList=new ArrayList<>();

        try {
            // create a reader
            for(String id: generator.idSet) {
                Gson gson = new Gson();// create Gson instance
                Reader reader = Files.newBufferedReader(Paths.get(id + ".json"));
                Game game = gson.fromJson(reader, Game.class);// convert JSON file to map

                String value = enumMapper(key, game);
                if (value != null && value.equals(searchVal))
                    gameList.add(game);
            }

            System.out.println(gameList);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void saveGame(Game game) {
        new Generator().newJson(game);
    }

    @Override
    public void updateGame(String gameName, GameKey key, String updateVal) {
        System.out.println("save started");

        Generator generator = new Generator();
        List<Game> gameList=new ArrayList<>();

        try {
            // create a reader
            for(String id: generator.idSet) {
                Gson gson = new Gson();// create Gson instance
                Reader reader = Files.newBufferedReader(Paths.get(id + ".json"));
                Game game = gson.fromJson(reader, Game.class);// convert JSON file to map

                String name = game.getGameName();

                if (name != null && name.equals(gameName)){
                    switch (key){
                        case GameName: game.setGameName(updateVal);
                        case Genre:game.setGenre(updateVal);
                        case GameCompanyDevelop:game.setGameCompanyDevelop(updateVal);
                        case GameStoreName:game.setGameStoreName(updateVal);
                        case AddressStore:game.setAddressStore(updateVal);
                        //case Available:return game.getAvailable().toString();
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        System.out.println("save finished");
    }

    @Override
    public void deleteGame(Game game) {
        System.out.println("save started");

        System.out.println("save finished");
    }


    public static void dataBaseInitialization(){
        Game game1 = new Game("GTA", "Roleplay", "Rockstar", "PlayHard", "north 97", true);
        new Generator().newJson(game1);

        Game game2 = new Game("Just Dance", "Music", "Ubisoft", "PlayHard", "north 97", true);
        new Generator().newJson(game2);

        Game game3 = new Game("Assassins Creed", "Adventure", "Ubisoft Montreal", "PlayHard", "north 97", true);
        new Generator().newJson(game3);

        Game game4 = new Game("Lego Star Wars", "Adventure", "TT Fusion", "PlayHard", "north 97", true);
        new Generator().newJson(game4);

        Game game5 = new Game(" Kung Fu Panda", "Platform", "Beenox", "PlayHard", "north 97", true);
        new Generator().newJson(game5);

        Game game6 = new Game(" Spider-Man 3", "Platform", "rockstar", "PlayHard", "north 97", true);
        new Generator().newJson(game6);

        Game game7 = new Game("Crazy Taxi", "Racing", "Hitmaker", "PlayHard", "north 97", true);
        new Generator().newJson(game7);

        Game game8 = new Game("Call of Duty:Black Ops", "Shooter", "Treyarch", "PlayHard", "north 97", true);
        new Generator().newJson(game8);

        Game game9 = new Game("Battlefield 3", "Shooter", "Dice", "PlayHard", "north 97", true);
        new Generator().newJson(game9);

        Game game10 = new Game("NBA 2K14", "Sports", "Visual Concepts", "PlayHard", "north 97", true);
        new Generator().newJson(game10);

    }
}
