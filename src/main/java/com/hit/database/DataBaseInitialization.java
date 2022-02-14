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

        Game game1 = new Game("GTA", "Roleplay", "Rockstar", "PlayHard", "NorthWay97");
        generator.jsonBuilder(game1);

        Game game2 = new Game("JustDance", "Music", "Ubisoft", "PlayHard", "ArvinLane15");
        generator.jsonBuilder(game2);

        Game game3 = new Game("AssassinsCreed", "Adventure", "UbisoftMontreal", "PlayHard", "EmmaCourt48");
        generator.jsonBuilder(game3);

        Game game4 = new Game("LegoStarWars", "Adventure", "TTFusion", "PlayHard", "EvansWay12");
        generator.jsonBuilder(game4);

        Game game5 = new Game("KungFuPanda", "Platform", "Beenox", "PlayHard", "Foggy18");
        generator.jsonBuilder(game5);

        Game game6 = new Game("SpiderMan3", "Platform", "rockstar", "PlayHard", "Fulton9");
        generator.jsonBuilder(game6);

        Game game7 = new Game("CrazyTaxi", "Racing", "Hitmaker", "PlayHard", "TelHai59");
        generator.jsonBuilder(game7);

        Game game8 = new Game("CallofDuty", "Shooter", "Treyarch", "PlayHard", "Rothschild37");
        generator.jsonBuilder(game8);

        Game game9 = new Game("Battlefield", "Shooter", "Dice", "PlayHard", "GreyLane27");
        generator.jsonBuilder(game9);

        Game game10 = new Game("NBA2K14", "Sports", "VisualConcepts", "PlayHard", "Harmes48");
        generator.jsonBuilder(game10);

    }
}
