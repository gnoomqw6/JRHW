package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.Tablet;
import com.javarush.test.level27.lesson15.big01.ad.AdvertisementManager;
import com.javarush.test.level27.lesson15.big01.ad.NoVideoAvailableException;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cook extends Observable implements Observer {
    private final String name;
    private static Logger logger = Logger.getLogger(Tablet.class.getName());

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {

        //нужен ли пробел в выводе строки между %d и "min"?
        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin", arg, ((Order)arg).getTotalCookingTime()));
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(((Order) arg).getTablet().toString(), name, ((Order)arg).getTotalCookingTime() * 60, ((Order)arg).getDishes()));

        //перенес показ рекламы из Tablet
        AdvertisementManager manager = new AdvertisementManager(((Order)arg).getTotalCookingTime() * 60);
        try {
            manager.processVideos();
        } catch (NoVideoAvailableException e) {
            logger.log(Level.INFO, "No video is available for the order " + arg);
        }

        setChanged();
        notifyObservers(arg);
    }
}
