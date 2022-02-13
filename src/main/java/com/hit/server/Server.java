package main.java.com.hit.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;



public class Server {

    private static boolean serverUp = true;

    public static void main(String[] args) throws Exception {

        ServerSocket server = new ServerSocket(3000);
        System.out.println("Server is alive");
        Socket client;

        while (serverUp) {
            try {
                client = server.accept();
                System.out.println("Client connected :) ");
                new Thread(new HandleRequest(client)).start();
            } catch (IOException e) {
                System.out.println("tiered of waiting for connection :( ");
            }
        }
        server.close();
    }
}
