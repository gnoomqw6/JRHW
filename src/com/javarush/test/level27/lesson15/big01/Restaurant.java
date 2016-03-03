package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Waitor;

public class Restaurant {
    public static void main(String[] args) {
        Tablet tablet = new Tablet(5);
        Cook cook = new Cook("Amigo");
        Waitor waitor = new Waitor();
        tablet.addObserver(cook);
        cook.addObserver(waitor);
        tablet.createOrder();

        Tablet tablet1 = new Tablet(6);
        Cook cook1 = new Cook("Amigooooooo");
        tablet1.addObserver(cook1);
        cook1.addObserver(waitor);
        tablet1.createOrder();

        Tablet tablet2 = new Tablet(7);
        tablet2.addObserver(cook);
        cook.addObserver(waitor);
        tablet2.createOrder();

        DirectorTablet directorTablet = new DirectorTablet();
        directorTablet.printAdvertisementProfit();
        directorTablet.printCookWorkloading();
        directorTablet.printActiveVideoSet();
        directorTablet.printArchivedVideoSet();
    }
}
