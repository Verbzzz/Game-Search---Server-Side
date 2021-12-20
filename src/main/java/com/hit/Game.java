package main.java.com.hit;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;

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

        Game testGame = new Game("gta","roleplay","rockstar","PlayHard", "north 97",true);

        Gson gson = new Gson();
        String json = gson.toJson(testGame);
        System.out.println(json);

        File file = new File()
    }
}


