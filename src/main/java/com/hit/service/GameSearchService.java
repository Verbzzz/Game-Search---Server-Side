package main.java.com.hit.service;

import com.google.gson.Gson;
import main.java.com.hit.dao.IDao;
import main.java.com.hit.dm.Game;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GameSearchService implements IDao<Game> {


    public enum GameKey {
        GameName,
        Genre,
        GameCompanyDevelop,
        GameStoreName,
        AddressStore,
    }


    public static void main(String[] args){

        dataBaseInitialization();
        GameSearchService gss = new GameSearchService();


        //gss.updateGame("Just Dance",GameKey.Genre,"Music");
        //gss.getGame(GameKey.Genre,"Music");

        //Game saveGame = new Game("new game", "Roleplay", "Rockstar", "PlayHard", "north 97");
        //gss.saveGame(saveGame);

        //gss.deleteGame("GTA");

    }


    private String enumMapper(GameKey key, Game game){
        switch (key){
            case GameName: return game.getGameName();
            case Genre:return game.getGenre();
            case GameCompanyDevelop:return game.getGameCompanyDevelop();
            case GameStoreName:return game.getGameStoreName();
            case AddressStore:return game.getAddressStore();
            default:return null;
        }
    }


    @Override
    public void getGame(GameKey key, String searchVal){

        Generator generator = new Generator();
        List<Game> gameList=new ArrayList<>();

        try {
            // create a reader
            for(String id: generator.idSet) {
                Gson gson = new Gson();// create Gson instance
                Reader reader = Files.newBufferedReader(Paths.get(id + ".json"));
                Game game = gson.fromJson(reader, Game.class);// convert JSON file to game object

                String value = enumMapper(key, game);
                if (value != null && value.equals(searchVal))
                    gameList.add(game);
            }
            if (gameList.isEmpty()) {
                System.out.println("No game matches the search");
            } else {
                System.out.println(gameList);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void saveGame(Game game) {
        new Generator().jsonBuilder(game);
        System.out.println("The game saved successfully");
    }

    @Override
    public void updateGame(String gameName, GameKey key, String updateVal) {

        Generator generator = new Generator();
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
                        break;
                        case Genre:game.setGenre(updateVal);
                        break;
                        case GameCompanyDevelop:game.setGameCompanyDevelop(updateVal);
                        break;
                        case GameStoreName:game.setGameStoreName(updateVal);
                        break;
                        case AddressStore:game.setAddressStore(updateVal);
                        break;
                        default:
                            break;
                    }
                    generator.jsonBuilder(game);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void deleteGame(String gameName) {

        Generator generator = new Generator();

        try {
            // create a reader
            for(String id: generator.idSet) {
                Gson gson = new Gson();// create Gson instance
                Reader reader = Files.newBufferedReader(Paths.get(id + ".json"));
                Game game = gson.fromJson(reader, Game.class);// convert JSON file to map

                String name = game.getGameName();

                if (name != null && name.equals(gameName)) {
                    try {
                        Files.delete(Paths.get(id + ".json"));
                        generator.idSet.remove(game.getUuid());
                        try (FileWriter fileWriter1 = new FileWriter("UUID.json")) {
                            new Gson().toJson(generator.idSet, fileWriter1);
                        }
                    } catch (IOException e){

                        e.printStackTrace();
                    }
                }
            }
            } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("The game" + gameName+ "deleted!");
    }

    public static void dataBaseInitialization(){
        Generator generator = new Generator();

        Game game1 = new Game("GTA", "Roleplay", "Rockstar", "PlayHard", "north 97");
        generator.jsonBuilder(game1);

        Game game2 = new Game("Just Dance", "Music", "Ubisoft", "PlayHard", "north 97");
        generator.jsonBuilder(game2);

        Game game3 = new Game("Assassins Creed", "Adventure", "Ubisoft Montreal", "PlayHard", "north 97");
        generator.jsonBuilder(game3);

        Game game4 = new Game("Lego Star Wars", "Adventure", "TT Fusion", "PlayHard", "north 97");
        generator.jsonBuilder(game4);

        Game game5 = new Game(" Kung Fu Panda", "Platform", "Beenox", "PlayHard", "north 97");
        generator.jsonBuilder(game5);

        Game game6 = new Game(" Spider-Man 3", "Platform", "rockstar", "PlayHard", "north 97");
        generator.jsonBuilder(game6);

        Game game7 = new Game("Crazy Taxi", "Racing", "Hitmaker", "PlayHard", "north 97");
        generator.jsonBuilder(game7);

        Game game8 = new Game("Call of Duty:Black Ops", "Shooter", "Treyarch", "PlayHard", "north 97");
        generator.jsonBuilder(game8);

        Game game9 = new Game("Battlefield 3", "Shooter", "Dice", "PlayHard", "north 97");
        generator.jsonBuilder(game9);

        Game game10 = new Game("NBA 2K14", "Sports", "Visual Concepts", "PlayHard", "north 97");
        generator.jsonBuilder(game10);

    }
}
