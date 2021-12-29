package main.java.com.hit;


import java.io.Serializable;
import java.util.UUID;

public class Game implements Serializable {
    private final String uuid = UUID.randomUUID().toString();
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
    public String getUuid(){ return uuid;}
    public boolean getAvailable(){
        return Available;
    }
    public String getUuid(){ return uuid;}

    public void setGameName(String Name){ this.GameName = Name; }
    public void setGenre(String Genre){ this.Genre = Genre; }
    public void setGameCompanyDevelop(String GameCompanyDevelop){ this.GameCompanyDevelop = GameCompanyDevelop; }
    public void setGameStoreName(String GameStoreName){ this.GameStoreName = GameStoreName; }
    public void setAddressStore(String AddressStore){ this.AddressStore = AddressStore; }
    public void setAvailable(boolean Available){ this.Available = Available; }



    @Override
    public String toString() {
        return "Game{" +
                "uuid='" + uuid + '\'' +
                ", GameName='" + GameName + '\'' +
                ", Genre='" + Genre + '\'' +
                ", GameCompanyDevelop='" + GameCompanyDevelop + '\'' +
                ", GameStoreName='" + GameStoreName + '\'' +
                ", AddressStore='" + AddressStore + '\'' +
                ", Available=" + Available +
                '}';
    }

    @Override
    public String toString() {
        return "Game{" +
                "uuid='" + uuid + '\'' +
                ", GameName='" + GameName + '\'' +
                ", Genre='" + Genre + '\'' +
                ", GameCompanyDevelop='" + GameCompanyDevelop + '\'' +
                ", GameStoreName='" + GameStoreName + '\'' +
                ", AddressStore='" + AddressStore + '\'' +
                ", Available=" + Available +
                '}';
    }
}


