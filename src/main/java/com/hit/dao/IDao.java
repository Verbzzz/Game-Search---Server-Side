package main.java.com.hit.dao;

import main.java.com.hit.service.GameSearchService;

public interface IDao <T> {

    public void getGame(GameSearchService.GameKey key, String searchVal);
    void saveGame(T t);
    public void updateGame(String gameName, GameSearchService.GameKey key, String updateVal);
    public void deleteGame(String gameName);
}
