package com.javarush.test.level27.lesson15.big01;

import com.javarush.test.level27.lesson15.big01.statistic.StatisticManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;

public class DirectorTablet {
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    public void printAdvertisementProfit() {
        Map<Date, Long> profitMap = StatisticManager.getInstance().getAdvertismentStatistic();
        long total = 0;
        for (Map.Entry<Date, Long> pair : profitMap.entrySet()) {
            System.out.println(dateFormat.format(pair.getKey()) + " - " + pair.getValue());
            total += pair.getValue();
        }
        System.out.println("Total - " + total);
    }

    public void printCookWorkloading() {
        Map<Date, Map<String, Integer>> cookMap = StatisticManager.getInstance().getCookStatistic();
        for (Map.Entry<Date, Map<String, Integer>> pair : cookMap.entrySet()) {
            System.out.println(dateFormat.format(pair.getKey()));
            for (Map.Entry<String, Integer> cooker : pair.getValue().entrySet()) {
                System.out.println(cooker.getKey() + " - " + cooker.getValue() + " min");
            }
            System.out.println();
        }
    }

    public void printActiveVideoSet() {

    }

    public void printArchivedVideoSet() {

    }
}
