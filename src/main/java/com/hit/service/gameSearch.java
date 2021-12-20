package main.java.com.hit.service;

import main.java.com.hit.dao.IDao;
import main.java.com.hit.dm.Game;



public class gameSearch extends Game implements IDao<Game> {

    Game game = new Game();

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
