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

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void update(Observable o, Object arg) {

        ConsoleHelper.writeMessage(String.format("Start cooking - %s, cooking time %dmin", arg, ((Order)arg).getTotalCookingTime()));
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(((Order) arg).getTablet().toString(), name, ((Order)arg).getTotalCookingTime() * 60, ((Order)arg).getDishes()));

        setChanged();
        notifyObservers(arg);
    }
}
