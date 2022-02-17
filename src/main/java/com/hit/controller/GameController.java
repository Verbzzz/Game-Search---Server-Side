package main.java.com.hit.controller;

import main.java.com.hit.dao.GameDaoImpl;
import main.java.com.hit.dm.Game;
import main.java.com.hit.service.GameService;

import java.io.IOException;
import java.util.List;

public class GameController {

    static GameService service = new GameService();


    public List<Game> searchGame(String searchVal) {
        return service.searchGame(searchVal);
    }

    public void saveGame(Game game) throws IOException {
        service.saveGame(game);
    }

    public void updateGame(String gameName, GameDaoImpl.GameKey key, String updateVal){
        service.updateGame(gameName,key,updateVal);
    }

    public void deleteGame(String gameName){
        service.deleteGame(gameName);
    }

}
