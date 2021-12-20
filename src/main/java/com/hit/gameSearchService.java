package main.java.com.hit;

import main.java.com.hit.IDao;
import main.java.com.hit.Game;

public class gameSearchService implements IDao<Game> {

    @Override
    public String getGame(String userSearch){

        System.out.println("get started");
        System.out.println("get finished");
        return userSearch;
    }

    @Override
    public void saveGame(Game game) {
        System.out.println("save started");

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
