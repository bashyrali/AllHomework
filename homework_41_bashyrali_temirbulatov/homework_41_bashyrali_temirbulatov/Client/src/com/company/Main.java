package com.company;

public class Main {

    public static void main(String[] args) {
	var client = ClientServer.connectTo(5555);
	client.run();
    }
}
