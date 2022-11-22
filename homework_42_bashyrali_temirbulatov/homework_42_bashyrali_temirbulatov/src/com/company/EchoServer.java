package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EchoServer {
    private final int port;
    private final ExecutorService pool = Executors.newCachedThreadPool();
    static ArrayList<User> users = new ArrayList<>();

    private EchoServer(int port){
        this.port = port;

    }

    static EchoServer bindToPort(int port){
        return new EchoServer(port);
    }

    public  void run() throws IOException {
        System.out.println("Cервер запущен на порту "+ port);

        try(ServerSocket server = new ServerSocket(port);){
            while (!server.isClosed()){
                Socket clientSocket = server.accept();
                User user = new User(User.generatorName(), clientSocket);
                users.add(user);
                pool.submit( () -> handle(user));
            }

        }
    }

    private void handle(User user) {
        System.out.printf("Connected client: %s%n", user.getName());

        try(Scanner reader = User.getReader(user.getSocket());
            PrintWriter writer = User.getWriter(user.getSocket())) {
            try (reader){
                while (true){
                    var message = reader.nextLine().strip();
                    if (User.isEmptyMsg(message) ||User.isQuitMsg(message)){
                        System.out.println("клиент отключился");
                        User.sendResponse("Досвидания",writer);
                        user.setActive(false);
                    }else{
                        String fullMsg = "from: " + user.getName() + " " +message;
                        users.stream()
                                .filter(client ->!client.equals(user) )
                                .filter(User::isActive)
                                .forEach(client -> send(fullMsg,client.getSocket()));
                    }
            }
        }
        catch (NoSuchElementException ex){
            System.out.println("Client dropped the connection!");
        }
            System.out.printf("Client disconnected: %s%n", user.getName());
    } catch (IOException e) {
            e.printStackTrace();
        }


    }
    public void send(String msg, Socket socket){
        try{
            User.sendResponse(msg, User.getWriter(socket));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
