package main.java.com.hit.service;

import main.java.com.hit.dao.GameDaoImpl;
import main.java.com.hit.dm.Game;

import java.util.List;

import static main.java.com.hit.dao.GameDaoImpl.GameKey.GameName;

public class GameService {

    GameDaoImpl gameDao = new GameDaoImpl();

    public List<Game> searchGame(String searchVal){
        return gameDao.getGame(searchVal);
    }

    public void saveGame(Game game) {
        gameDao.saveGame(game);
    }

    public void updateGame(String gameName, GameDaoImpl.GameKey key, String updateVal) {
        gameDao.updateGame(gameName,key,updateVal);
    }

    public void deleteGame(String gameName){
        gameDao.deleteGame(gameName);
    }

}
