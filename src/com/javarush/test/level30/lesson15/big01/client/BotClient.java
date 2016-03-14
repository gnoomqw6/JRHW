package com.javarush.test.level30.lesson15.big01.client;

import java.util.Date;

public class BotClient extends Client {
    public static void main(String[] args) {
        BotClient bot = new BotClient();
        bot.run();
    }

    @Override
    protected SocketThread getSocketThread() {
        return new BotSocketThread();
    }

    @Override
    protected boolean shouldSentTextFromConsole() {
        return false;
    }

    @Override
    protected String getUserName() {
        String botName = new Date().toLocaleString().substring(0,10)+"_bot_"+ (int) (Math.random()*100);
        return botName;
    }

    public class BotSocketThread extends SocketThread {

    }
}
