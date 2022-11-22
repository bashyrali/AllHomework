package com.company;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class User {
    String name;
    Socket socket;
    boolean active;

    public User(String name, Socket socket) {
        this.name = name;
        this.socket = socket;
        this.active = true;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSocket(Socket socket) {
        this.socket = socket;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public Socket getSocket() {
        return socket;
    }

    public boolean isActive() {
        return active;
    }

    public static boolean isQuitMsg(String message) {
        return "bye".equalsIgnoreCase(message);
    }

    public static boolean isEmptyMsg(String message) {
        return message == null || message.isBlank();
    }

    public static void sendResponse(String message, PrintWriter writer) throws IOException {
        writer.write(message);
        writer.write(System.lineSeparator());
        writer.flush();
    }

    public static PrintWriter getWriter(Socket clientSocket) throws IOException  {
        OutputStream stream = clientSocket.getOutputStream();
        return new PrintWriter(stream);
    }

    public static Scanner getReader(Socket clientSocket) throws IOException {
        InputStream stream = clientSocket.getInputStream();
        InputStreamReader input = new InputStreamReader(stream,"UTF-8");
        return new Scanner(input);
    }
    public static String generatorName(){
        ArrayList<String> names = new ArrayList<>();
        names.add("A");
        names.add("B");
        names.add("C");
        names.add("D");
        Random random = new Random();
        return names.get(random.nextInt(names.size()));
    }


}
