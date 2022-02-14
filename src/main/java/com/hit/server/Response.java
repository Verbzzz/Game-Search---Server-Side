package main.java.com.hit.server;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import main.java.com.hit.dm.Game;

import java.io.PrintWriter;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Response {
    public String json;
    public List<Game> game;

    public Response(){}


    public Response(List<Game> games){ this.game = games;}


    public Response(String string){
        json = string;
    }

    public String toString() {
        return  "{'Games':" + game + "', 'json':'" + json + "'}";
    }

//    public Gson gson;
//    public PrintWriter writer;
//    public Response response;
//    public Request request;
//    public Scanner reader;
//    public Socket toServer;
//    public int port;
//
//    public  Response sendResponse(List<Game> games)  {
//
//        try {
//            toServer = new Socket("localhost", port);
//            writer = new PrintWriter(toServer.getOutputStream());
//            reader = new Scanner(toServer.getInputStream());
//            request = new Request(games);
//            writer.println(gson.toJson(request));
//            writer.flush();
//            Type type = new TypeToken<Response>() {}.getType();
//            response = gson.fromJson(reader.next(), type);
//            writer.close();
//            reader.close();
//            toServer.close();
//            return response;
//        }
//        catch (Exception ex){ ex.printStackTrace();}
//        return new Response("Error");
//
//    }

//    public  Response sendResponse(String ok)  {
//
//        try {
//            toServer = new Socket("localhost", port);
//            writer = new PrintWriter(toServer.getOutputStream());
//            reader = new Scanner(toServer.getInputStream());
//            request = new Request(headers, body);
//            writer.println(gson.toJson(request));
//            writer.flush();
//            Type type = new TypeToken<Response>() {}.getType();
//            response = gson.fromJson(reader.next(), type);
//            writer.close();
//            reader.close();
//            toServer.close();
//            return response;
//        }
//        catch (Exception ex){ ex.printStackTrace();}
//        return new Response("Error");
//
//    }

}
