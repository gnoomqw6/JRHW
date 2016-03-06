package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final static int ORDER_CREATING_INTERVAL = 100;
    public static void main(String[] args) {
        OrderManager orderManager = new OrderManager();
        Cook cook1 = new Cook("Amigo");
        Cook cook2 = new Cook("Amigooooooooooo");
        StatisticEventManager.getInstance().register(cook1);
        StatisticEventManager.getInstance().register(cook2);
        List<Tablet> tablets = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            Tablet tablet = new Tablet(i);
            tablets.add(tablet);
            tablet.addObserver(orderManager);
            tablet.addObserver(orderManager);
        }
        Waitor waitor = new Waitor();
        cook1.addObserver(waitor);
        cook2.addObserver(waitor);
        Thread thread = new Thread(new RandomOrderGeneratorTask(tablets, ORDER_CREATING_INTERVAL));
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }

        thread.interrupt();

//        List<Tablet> tabletList = new ArrayList<>();
//        Waitor waitor = new Waitor();
//        Cook cook1 = new Cook("Chef Cook");
//        Cook cook2 = new Cook("Cook");
//        cook1.addObserver(waitor);
//        cook2.addObserver(waitor);
//
//        for (int i = 0; i < 9; i++) {
//            Tablet tablet = new Tablet(i);
//            tabletList.add(tablet);
//            if (i % 2 == 0) {
//                tablet.addObserver(cook1);
//            }
//            else {
//                tablet.addObserver(cook2);
//            }
//        }
//
//        Thread thread = new Thread(new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL));
//        thread.start();
//
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        thread.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
