package com.javarush.test.level30.lesson15.big01.client;

import com.javarush.test.level30.lesson15.big01.Connection;
import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
import com.javarush.test.level30.lesson15.big01.Message;
import com.javarush.test.level30.lesson15.big01.MessageType;

import java.io.IOException;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Enter server address");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Enter server port");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Enter username");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSentTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        Message message = new Message(MessageType.TEXT, text);
        try {
            connection.send(message);
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Connection fail");
            clientConnected = false;
        }
    }

    public class SocketThread extends Thread {

    }
}
