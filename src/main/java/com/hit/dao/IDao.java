package main.java.com.hit.dao;

import main.java.com.hit.dm.Game;

import java.util.List;

public interface IDao <T> {

    List<Game> getGame(String searchVal);
    void saveGame(T t);
    void updateGame(String gameName, GameDaoImpl.GameKey key, String updateVal);
    void deleteGame(String gameName);
}
