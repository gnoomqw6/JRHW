//package com.javarush.test.level30.lesson15.big01.client;
//
//import com.javarush.test.level30.lesson15.big01.ConsoleHelper;
//import com.javarush.test.level30.lesson15.big01.Message;
//import com.javarush.test.level30.lesson15.big01.MessageType;
//
//import java.io.IOException;
//import java.text.SimpleDateFormat;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
//
//public class BotClient extends Client {
//    public static void main(String[] args) {
//        BotClient bot = new BotClient();
//        bot.run();
//    }
//
//    @Override
//    protected SocketThread getSocketThread() {
//        return new BotSocketThread();
//    }
//
//    @Override
//    protected boolean shouldSentTextFromConsole() {
//        return false;
//    }
//
//    @Override
//    protected String getUserName() {
//        String botName = new Date().toLocaleString().substring(0, 10) + "_bot_" + (int) (Math.random() * 100);
//        return botName;
//    }
//
//    public class BotSocketThread extends SocketThread {
//        @Override
//        protected void clientMainLoop() throws IOException, ClassNotFoundException {
//            sendTextMessage("Привет чатику. Я бот. Понимаю команды: дата, день, месяц, год, время, час, минуты, секунды.");
//            super.clientMainLoop();
//        }
//
//        @Override
//        protected void processIncomingMessage(String message) {
//            ConsoleHelper.writeMessage(message);
//            String[] str = message.split(": ");
//            SimpleDateFormat sdp;
//            if (str.length >= 2) {
//                if (str[1].equals("дата")) {
//                    sdp = new SimpleDateFormat("d.MM.YYYY");
//                } else if (str[1].equals("день")) {
//                    sdp = new SimpleDateFormat("d");
//                } else if (str[1].equals("месяц")) {
//                    sdp = new SimpleDateFormat("MMMM");
//                } else if (str[1].equals("год")) {
//                    sdp = new SimpleDateFormat("YYYY");
//                } else if (str[1].equals("время")) {
//                    sdp = new SimpleDateFormat("H:mm:ss");
//                } else if (str[1].equals("час")) {
//                    sdp = new SimpleDateFormat("H");
//                } else if (str[1].equals("минуты")) {
//                    sdp = new SimpleDateFormat("m");
//                } else if (str[1].equals("секунды")) {
//                    sdp = new SimpleDateFormat("s");
//                } else sdp = null;
//            } else sdp = null;
//            Calendar cal = Calendar.getInstance();
//            Date d = cal.getTime();
//            if (sdp != null) {
//                Message newMessage = new Message(MessageType.TEXT, String.format("Информация для %s: %s", str[0], sdp.format(d)));
//                sendTextMessage(newMessage.getData());
//            }
//        }
//    }
//}
