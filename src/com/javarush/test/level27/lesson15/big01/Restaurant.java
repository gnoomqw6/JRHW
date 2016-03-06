package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private final static int ORDER_CREATING_INTERVAL = 100;
    public static void main(String[] args) {
//        Tablet tablet = new Tablet(5);
//        Cook cook = new Cook("Amigo");
//        Waitor waitor = new Waitor();
//        tablet.addObserver(cook);
//        cook.addObserver(waitor);
//        tablet.createOrder();

        List<Tablet> tabletList = new ArrayList<>();
        Waitor waitor = new Waitor();
        Cook cook1 = new Cook("Chef Cook");
        Cook cook2 = new Cook("Cook");
        cook1.addObserver(waitor);
        cook2.addObserver(waitor);

        for (int i = 0; i < 9; i++) {
            Tablet tablet = new Tablet(i);
            tabletList.add(tablet);
            if (i % 2 == 0) {
                tablet.addObserver(cook1);
            }
            else {
                tablet.addObserver(cook2);
            }
        }

        Thread thread = new Thread(new RandomOrderGeneratorTask(tabletList, ORDER_CREATING_INTERVAL));
        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
