package main.java.com.hit.dao;

public interface IDao <T> {

    String getGame(String userSearch);
    void saveGame(T t);
    void updateGame(T t, String[] params);
    void deleteGame(T t);
}
