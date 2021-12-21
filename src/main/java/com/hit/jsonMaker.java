package main.java.com.hit;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class jsonMaker {
    public static void main(String[] args) {

        Game game1 = new Game("GTA","Roleplay","Rockstar","PlayHard", "north 97",true);
        newJson(game1,1);

        Game game2 = new Game("Just Dance","Music","Ubisoft","PlayHard", "north 97",true);
        newJson(game2,2);

        Game game3 = new Game("Assassins Creed","Adventure","Ubisoft Montreal","PlayHard", "north 97",true);
        newJson(game3,3);

        Game game4 = new Game("Lego Star Wars","Adventure","TT Fusion","PlayHard", "north 97",true);
        newJson(game4,4);

        Game game5 = new Game(" Kung Fu Panda","Platform","Beenox","PlayHard", "north 97",true);
        newJson(game5,5);

        Game game6 = new Game(" Spider-Man 3","Platform","rockstar","PlayHard", "north 97",true);
        newJson(game6,6);

        Game game7 = new Game("Crazy Taxi","Racing","Hitmaker","PlayHard", "north 97",true);
        newJson(game7,7);

        Game game8 = new Game("Call of Duty:Black Ops","Shooter","Treyarch","PlayHard", "north 97",true);
        newJson(game8,8);

        Game game9 = new Game("Battlefield 3","Shooter","Dice","PlayHard", "north 97",true);
        newJson(game9,9);

        Game game10 = new Game("NBA 2K14","Sports","Visual Concepts","PlayHard", "north 97",true);
        newJson(game10,10);
    }

    //IMPLEMENET JASON FILE INTO DATABASE
    public static void newJson(Game newGame, int index){

        Gson gson = new Gson();
        String json = gson.toJson(newGame);

        try {
            File file = new File(index + "JsonFile.json");
            file.createNewFile();
            FileWriter fileWriter = new FileWriter(file);
            System.out.println("writing to file....");
            fileWriter.write(json);
            fileWriter.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
