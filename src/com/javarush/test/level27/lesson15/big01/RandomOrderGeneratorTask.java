package com.javarush.test.level27.lesson15.big01;

import java.util.ArrayList;
import java.util.List;

public class RandomOrderGeneratorTask implements Runnable {
    private List<Tablet> tabletList = new ArrayList<>();
    private int INTERVAL;

    public RandomOrderGeneratorTask(List<Tablet> tabletList, int INTERVAL) {
        this.tabletList = tabletList;
        this.INTERVAL = INTERVAL;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Tablet tablet = tabletList.get((int) (Math.random() * tabletList.size()));
            tablet.createTestOrder();
            try {
                Thread.sleep(INTERVAL);
            } catch (InterruptedException e) {
            }
        }
    }
}
