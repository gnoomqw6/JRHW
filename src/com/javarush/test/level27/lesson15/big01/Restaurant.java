//package com.javarush.test.level27.lesson15.big01;
//
//import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
//import com.javarush.test.level27.lesson15.big01.kitchen.Order;
//import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;
//import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.LinkedBlockingQueue;
//
//public class Restaurant {
//    private final static int ORDER_CREATING_INTERVAL = 100;
//    private final static LinkedBlockingQueue<Order> QUEUE = new LinkedBlockingQueue<>();
//    public static void main(String[] args) {
//        Cook cook1 = new Cook("Amigo");
//        cook1.setQueue(QUEUE);
//        Cook cook2 = new Cook("Amigooooooooooo");
//        cook2.setQueue(QUEUE);
//        List<Tablet> tablets = new ArrayList<>();
//        for (int i = 0; i < 5; i++) {
//            Tablet tablet = new Tablet(i);
//            tablets.add(tablet);
//            tablet.setQueue(QUEUE);
//        }
//        Waitor waitor = new Waitor();
//        cook1.addObserver(waitor);
//        cook2.addObserver(waitor);
//
//        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
//        Thread cook1Thread = new Thread(cook1);
//        Thread cook2Thread = new Thread(cook2);
//        thread.start();
//        cook1Thread.start();
//        cook2Thread.start();
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//        }
//
//        thread.interrupt();
//
//        DirectorTablet directorTablet = new DirectorTablet();
//        directorTablet.printAdvertisementProfit();
//        directorTablet.printCookWorkloading();
//        directorTablet.printActiveVideoSet();
//        directorTablet.printArchivedVideoSet();
//    }
//}