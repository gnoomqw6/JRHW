//package com.javarush.test.level30.lesson15.big01.client;
//
//import com.javarush.test.level30.lesson15.big01.Connection;
//import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
//import com.javarush.test.level30.lesson15.big01.Message;
//import com.javarush.test.level30.lesson15.big01.MessageType;
//
//import java.io.IOException;
//import java.net.Socket;
//
//public class Client {
//    protected Connection connection;
//    private volatile boolean clientConnected = false;
//
//    public static void main(String[] args) {
//        Client client = new Client();
//        client.run();
//    }
//
//    public void run() {
//        SocketThread socketThread = getSocketThread();
//        socketThread.setDaemon(true);
//        socketThread.start();
//        synchronized (this) {
//            try {
//                wait();
//            } catch (InterruptedException e) {
//                ConsoleHelper.writeMessage("Connection failed");
//                return;
//            }
//            if (!clientConnected) {
//                ConsoleHelper.writeMessage("Произошла ошибка во время работы клиента.");
//            }
//            else {
//                ConsoleHelper.writeMessage("Соединение установлено. Для выхода наберите команду 'exit'.");
//                while (clientConnected) {
//                    String string = ConsoleHelper.readString();
//                    if (string.equals("exit")) {
//                        break;
//                    }
//                    if (shouldSentTextFromConsole()) {
//                        sendTextMessage(string);
//                    }
//                }
//            }
//        }
//    }
//
//    protected String getServerAddress() {
//        ConsoleHelper.writeMessage("Enter server address");
//        return ConsoleHelper.readString();
//    }
//
//    protected int getServerPort() {
//        ConsoleHelper.writeMessage("Enter server port");
//        return ConsoleHelper.readInt();
//    }
//
//    protected String getUserName() {
//        ConsoleHelper.writeMessage("Enter username");
//        return ConsoleHelper.readString();
//    }
//
//    protected boolean shouldSentTextFromConsole() {
//        return true;
//    }
//
//    protected SocketThread getSocketThread() {
//        return new SocketThread();
//    }
//
//    protected void sendTextMessage(String text) {
//        Message message = new Message(MessageType.TEXT, text);
//        try {
//            connection.send(message);
//        } catch (IOException e) {
//            ConsoleHelper.writeMessage("Connection fail");
//            clientConnected = false;
//        }
//    }
//
//    public class SocketThread extends Thread {
//        @Override
//        public void run() {
//            String address = getServerAddress();
//            int port = getServerPort();
//            try {
//                Socket socket = new Socket(address, port);
//                connection = new Connection(socket);
//                clientHandshake();
//                clientMainLoop();
//            } catch (IOException e) {
//                notifyConnectionStatusChanged(false);
//            } catch (ClassNotFoundException e) {
//                notifyConnectionStatusChanged(false);
//            }
//        }
//
//        protected void processIncomingMessage(String message) {
//            ConsoleHelper.writeMessage(message);
//        }
//
//        protected void informAboutAddingNewUser(String userName) {
//            ConsoleHelper.writeMessage(userName + " entered");
//        }
//
//        protected void informAboutDeletingNewUser(String userName) {
//            ConsoleHelper.writeMessage(userName + " has left");
//        }
//
//        protected void notifyConnectionStatusChanged(boolean clientConnected) {
//            Client.this.clientConnected = clientConnected;
//            synchronized (Client.this) {
//                Client.this.notify();
//            }
//        }
//
//        protected void clientHandshake() throws IOException, ClassNotFoundException {
//            while (true) {
//                Message message = connection.receive();
//                if (message.getType().equals(MessageType.NAME_REQUEST)) {
//                    String name = getUserName();
//                    Message nameMessage = new Message(MessageType.USER_NAME, name);
//                    connection.send(nameMessage);
//                }
//                else if (message.getType().equals(MessageType.NAME_ACCEPTED)) {
//                    notifyConnectionStatusChanged(true);
//                    return;
//                }
//                else {
//                    throw new IOException("Unexpected MessageType");
//                }
//            }
//        }
//
//        protected void clientMainLoop() throws IOException, ClassNotFoundException {
//            while (true) {
//                Message message = connection.receive();
//                switch (message.getType()) {
//                    case TEXT:
//                        processIncomingMessage(message.getData());
//                        break;
//                    case USER_ADDED:
//                        informAboutAddingNewUser(message.getData());
//                        break;
//                    case USER_REMOVED:
//                        informAboutDeletingNewUser(message.getData());
//                        break;
//                    default:
//                        throw new IOException("Unexpected MessageType");
//                }
//            }
//        }
//    }
//}
