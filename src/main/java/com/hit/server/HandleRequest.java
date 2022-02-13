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
////            StringBuilder reqStr = new StringBuilder();
////            String s = this.reader.nextLine();
////            while(s != null && !s.equals("")){
////                reqStr.append(s);
////            }
//
//            Request request = gson.fromJson(reqStr.toString(), Request.class);
//            Response response = null;
//
//
//
//
//
//            //Response response = null;
//            response = new Response();
//            Map<String, String> headers = request.getHeaders();
//            String command = headers.get("action");
//            String body = request.getBody();

            Type type = new TypeToken<Request>(){}.getType();
            Request request = gson.fromJson(reader.next(), type);
            Response response = null;
            //System.out.println("Got " + gson.toJson(request));
            //System.out.println(request.getBody());
            //System.out.println(request.getHeaders());


            String command = request.getHeaders().get("command");

            switch (command){
                case "Get":{
                    response = new Response(service.searchGame(request.getBody()));
                    System.out.println("case 1 - get");
                    break;
                }
                case "Save":{

                    String[] fields = {"GameName","Genre","GameCompanyDevelop","GameStoreName","AddressStore"};
                    for(int i=0; i<fields.length;i++)
                    {
                        fields[i] = request.getHeaders().get(fields[i]);
                    }

                    Game newGame = new Game();

                    newGame.setGameName(Objects.requireNonNull(
                            fields[0], "GameName cannot be null"));
                    newGame.setGenre(Objects.requireNonNull(
                            fields[1], "Genre cannot be null"));
                    newGame.setGameCompanyDevelop(Objects.requireNonNull(
                            fields[2], "GameCompanyDevelop cannot be null"));
                    newGame.setGameStoreName(Objects.requireNonNull(
                            fields[3], "GameStoreName cannot be null"));
                    newGame.setAddressStore(Objects.requireNonNull(
                            fields[4], "AddressStore cannot be null"));

                    service.saveGame(newGame);

                    response = new Response("Game saved");
                    System.out.println("case 2 - save");
                    break;
                }
                case "Update":{


                    String[] fields = {"GameName","toUpdate","Val"};

                    for(int i=0; i<fields.length;i++)
                    {
                        fields[i] = request.getHeaders().get(fields[i]);
                        //System.out.println(fields[i]);
                    }



                    String GameName = request.getHeaders().get(Objects.requireNonNull(
                            fields[0], "GameName cannot be null"));
                    String toUpdate = request.getHeaders().get(Objects.requireNonNull(
                            fields[1], "toUpdate cannot be null"));

                    String Val = request.getHeaders().get(Objects.requireNonNull(
                            fields[2], "Val cannot be null"));

//                    String GameName = "GTA";
//                    //String toUpdate = "fds";
//
//                    String Val = "HEN_GAME";



                    GameDaoImpl.GameKey gameKey = Enum.valueOf(GameDaoImpl.GameKey.class, "GameName");


//
//
//                    String GameName = "GTA";
//                    String Val = "NEW_NAME";
//                    String toUpdate = "GameName";


                    service.updateGame(GameName,gameKey,Val);

                    response = new Response("Game updated");
                    System.out.println("case 3 - update");
                    break;
                }
                case "Delete":{
                    String GameName = request.getBody();
                    service.deleteGame(GameName);
                    response = new Response("Game deleted");
                    System.out.println("case 4 - delete");
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
