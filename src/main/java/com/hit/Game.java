package main.java.com.hit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

import javax.swing.*;

public class Game {
    String GameName;
    String Genre;
    String GameCompanyDevelop;

    String GameStoreName;
    String AddressStore;
    boolean Available;

    public Game(String gameName, String genre, String gameCompanyDevelop,String gameStoreName, String addressStore, boolean available){

        this.GameName = gameName;
        this.Genre = genre;
        this.GameCompanyDevelop = gameCompanyDevelop;
        this.GameStoreName = gameStoreName;
        this.AddressStore = addressStore;
        this.Available = available;
    }

    public Game(){}

    public static void main(String[] args) {

        Game testGame1 = new Game("gta","roleplay","rockstar","PlayHard", "north 97",true);
        Game testGame2 = new Game("gta","roleplay","rockstar","PlayHard", "north 97",false);

        Gson gson = new Gson();
        String json1 = gson.toJson(testGame1);
        String json2 = gson.toJson(testGame2);

    //IMPLEMENET JASON FILE INTO DATABASE
        try {
            File file = new File("DataBase.json");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            System.out.println("writing to file....");
            fileWriter.write(json1);
            fileWriter.write(",\n");
            fileWriter.write(json2);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}


