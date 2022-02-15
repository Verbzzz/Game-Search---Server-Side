package main.java.com.hit.tests;

import main.java.com.hit.dao.GameDaoImpl;
import main.java.com.hit.dm.Game;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class GameServiceTest {

    GameDaoImpl gameDao = new GameDaoImpl();


    @Test
    public void saveGameTest() {
        Game game1 = new Game("test", "test", "test", "test", "test");

        gameDao.saveGame(game1);
        List<Game> GameList = gameDao.getGame("test");

        for (Game game : GameList)
            assertEquals(game1, game);
    }

    @Test
    public void getGameTest() {
        Game game1 = new Game("test", "test", "test", "test", "test");
        List<Game> GameList = gameDao.getGame("test");
        for (Game game : GameList)
            assertEquals(game1.getGameName(), game.getGameName());
    }

    @Test
    public void updateGameTest() {
        gameDao.updateGame("test", GameDaoImpl.GameKey.Genre, "updated test");

        List<Game> GameList = gameDao.getGame("test");

        for (Game game : GameList)
            assertEquals("updated test", game.getGenre());
    }

    @Test
    public void deleteGameTest() {
        gameDao.deleteGame("test");
        List<Game> GameList = gameDao.getGame("test");

        for (Game game : GameList)
            assertEquals(null, game);
    }
}
