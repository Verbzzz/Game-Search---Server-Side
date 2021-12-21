package main.java.com.hit;

public interface IDao <T> {

    static String getGame(String searchKey,String userSearch) {
        return null;
    }

    default void saveGame(T t){};
    void updateGame(T t, String[] params);
    void deleteGame(T t);
}
