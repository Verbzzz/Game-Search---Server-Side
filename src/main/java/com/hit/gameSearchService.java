package main.java.com.hit;

import com.google.gson.Gson;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static main.java.com.hit.jsonMaker.newJson;

public class gameSearchService implements IDao<Game> {

    public static void main(String[] args){
        getGame("GameStoreName","PlayHard");
        System.out.println("main started");

//        Game game11 = new Game("mortal kombat10","jfj","fhfh","ddd", "fff 97",true);
//        saveGame(game11);
    }

//    @Override
    public static void getGame(String searchKey, String searchVal){
        System.out.println("get started");
        int index;
        int count = 0;
        List<Integer> gameList=new ArrayList<Integer>();

        try {
            // create a reader

            for (index=1;index<11;index++){
                Gson gson = new Gson();// create Gson instance
                Reader reader = Files.newBufferedReader(Paths.get(index + "JsonFile.json"));
                Map<String, String> game = gson.fromJson(reader, Map.class);// convert JSON file to map

                // print map entries
                for (Map.Entry<String,String> entry : game.entrySet()){
                    if(entry.getKey().equals(searchKey) && entry.getValue().equals(searchVal)){
                        count++;
                        gameList.add(index);
                    }
                }
                reader.close();

            }
            System.out.println(count);
            System.out.println(gameList);

//            Reader reader = Files.newBufferedReader(Paths.get(index+"JsonFile.json"));
//
//            Map<?, ?> map = gson.fromJson(reader, Map.class);// convert JSON file to map
//
//            // print map entries
//            for (Map.Entry<?, ?> entry : map.entrySet()) {
//                System.out.println(entry.getKey() + "=" + entry.getValue());
//            }
//
//            reader.close();// close reader

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("get finished");
    }

    @Override
    public void saveGame(Game game) {
        System.out.println("save started");
        int index=11;

        newJson(game,index);

        System.out.println("save finished");
        index++;
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
