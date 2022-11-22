package com.company;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class EchoServer {
    private final int port;
    private EchoServer(int port){
        this.port = port;
    }
    static EchoServer bindToPort(int port){
        return new EchoServer(port);
    }
    public  void run() throws IOException {
        try(var server = new ServerSocket(port)){
            try(var clientSocket = server.accept()) {
                handle(clientSocket);
            }
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private void handle(Socket socket) throws IOException {
        var input = socket.getInputStream();
        var streamReader = new InputStreamReader(input, "UTF-8");

        try(var scanner = new Scanner(streamReader)){
            var output = socket.getOutputStream();
            var writer = new PrintWriter(output);
            while (true){
                var message = scanner.nextLine().strip();

                System.out.printf("Got: %s%n", message);
                StringBuilder clientMsg = new StringBuilder(message).reverse();
                writer.write(String.valueOf(clientMsg));
                writer.write(System.lineSeparator());
                writer.flush();

                if ("bye".equalsIgnoreCase(message)){
                    System.out.println("  Bye bye!");
                    return;
                }
                System.out.printf("Sent: %s%n",clientMsg);
            }
        }
        catch (NoSuchElementException ex){
            System.out.println("Client dropped the connection!");
        }
    }
}
