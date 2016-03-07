package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.ad.Advertisement;
import com.javarush.test.level27.lesson15.big01.ad.StatisticAdvertisementManager;
import com.javarush.test.level27.lesson15.big01.statistic.StatisticEventManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class DirectorTablet {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    public void printAdvertisementProfit() {
        Map<Date, Double> profitMap = StatisticEventManager.getInstance().getAdRevenue();
        double total = 0;
        for (Map.Entry<Date, Double> pair : profitMap.entrySet()) {
            System.out.println(dateFormat.format(pair.getKey()) + " - " + pair.getValue());
            total += pair.getValue();
        }
        System.out.println("Total - " + total);
    }

    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> cookMap = StatisticEventManager.getInstance().getCookWorkload();
        for (Map.Entry<Date, Map<String, Integer>> pair : cookMap.entrySet()) {
            System.out.println(dateFormat.format(pair.getKey()));
            for (Map.Entry<String, Integer> cooker : pair.getValue().entrySet()) {
                System.out.println(cooker.getKey() + " - " + cooker.getValue() + " min");
            }
            System.out.println();
        }
    }

    public void printActiveVideoSet() {
        Map<String, Advertisement> activeVideos = StatisticAdvertisementManager.getInstance().getActiveVideos();
        for (Map.Entry<String, Advertisement> pair : activeVideos.entrySet()) {
            System.out.println(pair.getValue().getName() + " - " + pair.getValue().getHits());
        }
    }

    public void printArchivedVideoSet() {
        Map<String, Advertisement> archivedVideos = StatisticAdvertisementManager.getInstance().getArchivedVideos();
        for (Map.Entry<String, Advertisement> pair : archivedVideos.entrySet()) {
            System.out.println(pair.getValue().getName());
        }
    }
}
