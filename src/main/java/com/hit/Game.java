package main.java.com.hit;


import com.google.gson.Gson;

public class Game {
    String GameName;
    String Genre;
    String GameCompanyDevelop;

    String GameStoreName;
    String AddressStore;

    public Game(String gameName, String genre, String gameCompanyDevelop,String gameStoreName, String addressStore){

        this.GameName = gameName;
        this.Genre = genre;
        this.GameCompanyDevelop = gameCompanyDevelop;
        this.GameStoreName = gameStoreName;
        this.AddressStore = addressStore;
    }

    public Game(){}

    public static void main(String[] args) {

        Game testGame = new Game("gta","roleplay","rockstar","PlayHard", "north 97");

        Gson gson = new Gson();
        String json = gson.toJson(testGame);
        System.out.println(json);

    }
}


