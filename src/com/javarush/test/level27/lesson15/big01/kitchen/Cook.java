//package com.javarush.test.level27.lesson15.big01.kitchen;
//
//import com.javarush.test.level27.lesson15.big01.ConsoleHelper;
//import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;
//import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
//
//import java.util.Observable;
//import java.util.concurrent.LinkedBlockingQueue;
//
//public class Cook extends Observable implements Runnable {
//    private final String name;
//    private boolean busy;
//    private LinkedBlockingQueue<Order> queue;
//
//    public boolean isBusy() {
//        return busy;
//    }
//
//    public void setQueue(LinkedBlockingQueue<Order> queue) {
//        this.queue = queue;
//    }
//
//    public Cook(String name) {
//        this.name = name;
//    }
//
//    @Override
//    public String toString() {
//        return name;
//    }
//
//    public synchronized void startCookingOrder(Order order) {
//        busy = true;
//        ConsoleHelper.writeMessage(String.format
//                ("Start cooking - %s, cooking time %dmin", order, order.getTotalCookingTime()));
//
//        try {
//            Thread.sleep(order.getTotalCookingTime() * 10);
//        } catch (InterruptedException e) {
//        }
//
//        StatisticEventManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(),
//                name, order.getTotalCookingTime() * 60, order.getDishes()));
//
//        setChanged();
//        notifyObservers(order);
//
//        busy = false;
//    }
//
//    @Override
//    public void run() {
//        while (true) {
//            if (!queue.isEmpty()) {
//                if (!isBusy()) {
//                    try {
//                        startCookingOrder(queue.take());
//                    } catch (InterruptedException e) {
//                    }
//                    if (queue.isEmpty()) {
//                        break;
//                    }
//                }
//            }
//            try {
//                Thread.sleep(10);
//            } catch (InterruptedException e) {
//            }
//        }
//    }
//}