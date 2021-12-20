package main.java.com.hit;


public class Game {
    private String GameName;
    private String Genre;
    private String GameCompanyDevelop;
    private String GameStoreName;
    private String AddressStore;
    private boolean Available;

    //methods
    public Game(){}
    public Game(String gameName, String genre, String gameCompanyDevelop,String gameStoreName, String addressStore, boolean available){

        this.GameName = gameName;
        this.Genre = genre;
        this.GameCompanyDevelop = gameCompanyDevelop;
        this.GameStoreName = gameStoreName;
        this.AddressStore = addressStore;
        this.Available = available;
    }
    public String getGameName() {
        return GameName;
    }
    public String getGenre() {
        return Genre;
    }
    public String getGameCompanyDevelop() {
        return GameCompanyDevelop;
    }
    public String getGameStoreName() {
        return GameStoreName;
    }
    public String getAddressStore() {
        return AddressStore;
    }
    public boolean getAvailable(){
        return Available;
    }

}


