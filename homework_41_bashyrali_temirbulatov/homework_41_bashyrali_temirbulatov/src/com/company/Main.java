package com.company;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        var echoServer = EchoServer.bindToPort(5555);
        echoServer.run();

    }
}
