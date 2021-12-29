package main.java.com.hit;

public interface IDao <T> {

    static String getGame(String searchKey,String userSearch) {
        return null;
    }
    void saveGame(T t);
    public void updateGame(String gameName, GameSearchService.GameKey key, String updateVal);
    void deleteGame(T t);
}
