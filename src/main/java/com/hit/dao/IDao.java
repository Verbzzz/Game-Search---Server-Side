package main.java.com.hit.dao;

import main.java.com.hit.dm.Game;

import java.util.List;

public interface IDao <T> {

    public List<Game> getGame(String searchVal);
    void saveGame(T t);
    public void updateGame(String gameName, GameDaoImpl.GameKey key, String updateVal);
    public void deleteGame(String gameName);
}
