package main.java.com.hit.database;

import main.java.com.hit.dao.Generator;
import main.java.com.hit.dm.Game;

public class DataBaseInitialization {
    public static void main(String[] args) {
        DataBaseInitialization dataBase = new DataBaseInitialization();
        dataBase.gamesInitialization();
    }

    public static void gamesInitialization(){
        Generator generator = new Generator();

        Game game1 = new Game("GTA", "Roleplay", "Rockstar", "PlayHard", "north 97");
        generator.jsonBuilder(game1);

        Game game2 = new Game("Just Dance", "Music", "Ubisoft", "PlayHard", "north 97");
        generator.jsonBuilder(game2);

        Game game3 = new Game("Assassins Creed", "Adventure", "Ubisoft Montreal", "PlayHard", "north 97");
        generator.jsonBuilder(game3);

        Game game4 = new Game("Lego Star Wars", "Adventure", "TT Fusion", "PlayHard", "north 97");
        generator.jsonBuilder(game4);

        Game game5 = new Game("Kung Fu Panda", "Platform", "Beenox", "PlayHard", "north 97");
        generator.jsonBuilder(game5);

        Game game6 = new Game("Spider-Man 3", "Platform", "rockstar", "PlayHard", "north 97");
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
