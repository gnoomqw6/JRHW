package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.kitchen.Order;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;

public class OrderManager implements Observer {
    private LinkedBlockingQueue<Order> queue = new LinkedBlockingQueue<>();

    public OrderManager() {
        Thread daemonCookChecker = new Thread(new Runnable() {
            StatisticEventManager statisticEventManager = StatisticEventManager.getInstance();
            Set<Cook> cooks = statisticEventManager.getCookSet();
            @Override
            public void run() {
                while (true){
                    if (!queue.isEmpty()) {
                        for (Cook cook : cooks) {
                            if (!cook.isBusy()) {
                                try {
                                    cook.startCookingOrder(queue.take());
                                } catch (InterruptedException e) {
                                }
                                if (queue.isEmpty()) {
                                    break;
                                }
                            }
                        }
                    }
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                    }
                }
            }
        });
        daemonCookChecker.setDaemon(true);
        daemonCookChecker.start();
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            queue.put((Order) arg);
        } catch (InterruptedException e) {
        }
    }
}