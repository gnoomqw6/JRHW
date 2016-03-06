package com.javarush.test.level27.lesson15.big01.kitchen;

import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.Observer;

public class Cook extends Observable {
    private final String name;

    public Cook(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order) {
        ConsoleHelper.writeMessage(String.format
                ("Start cooking - %s, cooking time %dmin", order, order.getTotalCookingTime()));
        StatisticEventManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(),
                name, order.getTotalCookingTime() * 60, order.getDishes()));

        setChanged();
        notifyObservers(order);
    }
}
