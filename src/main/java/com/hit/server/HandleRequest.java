package main.java.com.hit.server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import com.google.gson.reflect.TypeToken;
import main.java.com.hit.dao.GameDaoImpl;
import main.java.com.hit.dm.Game;
import main.java.com.hit.service.GameService;

import java.io.*;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.Objects;
import java.util.Scanner;

public class HandleRequest implements Runnable {
    Socket socket;
    Scanner reader;
    PrintWriter writer;
    Gson gson = new GsonBuilder().create();
    GameService service = new GameService();

    public HandleRequest(Socket client) throws IOException{
        socket = client;
        reader = new Scanner((new InputStreamReader(client.getInputStream())));
        writer = new PrintWriter(new OutputStreamWriter(client.getOutputStream()));
    }

    @Override
    public void run(){
        try{

            Type type = new TypeToken<Request>(){}.getType();
            Request request = gson.fromJson(reader.next(), type);
            Response response = null;

            String command = request.getHeaders().get("command");

            switch (command){
                case "Get":{
                    response = new Response(service.searchGame(request.getBody()));
                    break;
                }
                case "Save":{

                    Game newGame = new Game();
                    newGame.setGameName(request.getHeaders().get("GameName"));
                    newGame.setGenre(request.getHeaders().get("Genre"));
                    newGame.setGameCompanyDevelop(request.getHeaders().get("GameCompanyDevelop"));
                    newGame.setGameStoreName(request.getHeaders().get("GameStoreName"));
                    newGame.setAddressStore(request.getHeaders().get("AddressStore"));

                    service.saveGame(newGame);
                    response = new Response("1");

                    break;
                }
                case "Update":{

                    String name = request.getHeaders().get("Name");
                    String update = request.getHeaders().get("toUpdate");
                    String val = request.getHeaders().get("Val");

                    GameDaoImpl.GameKey gameKey = Enum.valueOf(GameDaoImpl.GameKey.class, update);

                    service.updateGame(name,gameKey,val);

                    response = new Response("1");
                    break;
                }
                case "Delete":{
                    String GameName = request.getBody();
                    service.deleteGame(GameName);
                    response = new Response("1");
                    break;
                }
            }
            if(response != null) {
                writer.println(gson.toJson(response));
                writer.flush();
                System.out.println(gson.toJson(response));
            }
            writer.close();
            reader.close();
            socket.close();
        } catch (IOException e){
            System.out.println("Server error");
        }
    }
}
