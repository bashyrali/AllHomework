package com.company;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Locale;
import java.util.Scanner;

public class ClientServer {
    private int port;
    private String host;

    public ClientServer(int port, String host) {
        this.port = port;
        this.host = host;
    }
    public static ClientServer connectTo(int port){
        var localhost = "127.0.0.1";
        return new ClientServer(port, localhost);
    }
    public void run(){
        System.out.printf("напиши 'bye' чтобы выйти %n%n%n");
        try (var socket = new Socket(host,port)){
            var scanner = new Scanner(System.in, "UTF-8");
            var output = socket.getOutputStream();
            var writer = new PrintWriter(output);
            var input = socket.getInputStream();
            var streamReader = new InputStreamReader(input, "UTF-8");
            var scan = new Scanner(streamReader);
            try(scanner;writer;scan){
                while(true){
                    String message = scanner.nextLine();
                    writer.write(message);
                    writer.write(System.lineSeparator());
                    writer.flush();
                    var serverMessage = scan.nextLine().strip();

                    if ("bye".equals(message.toLowerCase())){
                        System.out.println("Connection dropped!");
                        return;
                    }

                    System.out.printf("Got: %s\n",serverMessage);
                }
            }
        } catch (UnknownHostException e) {
            System.out.println("Connection dropped!");
            e.printStackTrace();
        } catch (IOException e) {
            var msg = "Can't connect to %s:%n";
            System.out.printf(msg, host, port);
            e.printStackTrace();
        }
    }
}
