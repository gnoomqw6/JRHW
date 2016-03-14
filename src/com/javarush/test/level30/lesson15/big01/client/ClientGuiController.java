//package com.javarush.test.level30.lesson15.big01.client;
//
//public class ClientGuiController extends Client {
//    private ClientGuiModel model = new ClientGuiModel();
//    private ClientGuiView view = new ClientGuiView(this);
//    @Override
//    protected String getServerAddress() {
//        return view.getServerAddress();
//    }
//    @Override
//    protected int getServerPort() {
//        return view.getServerPort();
//    }
//    @Override
//    protected String getUserName() {
//        return view.getUserName();
//    }
//    @Override
//    protected SocketThread getSocketThread() {
//        return new GuiSocketThread();
//    }
//    @Override
//    public void run() {
//        getSocketThread().run();
//    }
//    public ClientGuiModel getModel() {
//        return model;
//    }
//    public static void main(String[] args) {
//        ClientGuiController clientGuiController = new ClientGuiController();
//        clientGuiController.run();
//    }
//    public class GuiSocketThread extends SocketThread {
//        protected void processIncomingMessage(String message) {
//            model.setNewMessage(message);
//            view.refreshMessages();
//        }
//        protected void informAboutAddingNewUser(String userName) {
//            model.addUser(userName);
//            view.refreshUsers();
//        }
//        protected void informAboutDeletingNewUser(String userName) {
//            model.deleteUser(userName);
//            view.refreshUsers();
//        }
//        protected void notifyConnectionStatusChanged(boolean clientConnected) {
//            view.notifyConnectionStatusChanged(clientConnected);
//        }
//    }
//}
