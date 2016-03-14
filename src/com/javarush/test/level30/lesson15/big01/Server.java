package com.javarush.test.level30.lesson15.big01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Server {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(ConsoleHelper.readInt());
            ConsoleHelper.writeMessage("Server started");
            while (true) {
                Socket socket = serverSocket.accept();
                Handler handler = new Handler(socket);
                handler.start();
            }
        } catch (Exception e) {
            try {
                serverSocket.close();
            } catch (IOException e1) {
            }
            ConsoleHelper.writeMessage("Server exception, serverSocket closed");
        }
    }

    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Connection connection : connectionMap.values()) {
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Can't send message");
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String clientName = null;
            Message askName = new Message(MessageType.NAME_REQUEST);
            connection.send(askName);
            Message answerName = connection.receive();
            if (answerName.getType().equals(MessageType.USER_NAME)) {
                clientName = answerName.getData();
                if (clientName.isEmpty() || clientName == null || connectionMap.containsKey(clientName)) {
                    clientName = serverHandshake(connection);
                }
                else {
                    connectionMap.put(clientName, connection);
                    Message nameAccepted = new Message(MessageType.NAME_ACCEPTED);
                    connection.send(nameAccepted);
                }
            }
            else {
                clientName = serverHandshake(connection);
            }
            return clientName;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (String name : connectionMap.keySet()) {
                if (name.equals(userName)) {
                    continue;
                }
                Message userAdded = new Message(MessageType.USER_ADDED, name);
                connection.send(userAdded);
            }
        }
    }
}
