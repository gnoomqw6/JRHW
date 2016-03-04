package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.CookedOrderEventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;
import com.javarush.test.level27.lesson15.big01.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage storage = new StatisticStorage();
    private Set<Cook> cookSet = new HashSet<>();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        storage.put(data);
    }

    public void register(Cook cook) {
        cookSet.add(cook);
    }

    private Date dateToStringMidnight(Date date) {
        GregorianCalendar roundedDate = new GregorianCalendar();
        roundedDate.setTime(date);
        roundedDate.set(Calendar.HOUR_OF_DAY, 0);
        roundedDate.set(Calendar.MINUTE, 0);
        roundedDate.set(Calendar.SECOND, 0);
        roundedDate.set(Calendar.MILLISECOND, 0);
        return roundedDate.getTime();
    }

    public Map<Date, Double> getAdvertismentStatistic() {
        Map<Date, Double> result = new TreeMap<>(Collections.reverseOrder());
        for (EventDataRow event : storage.getEventList(EventType.SELECTED_VIDEOS)) {
            Date dateKey = dateToStringMidnight(event.getDate());
            double amount = ((VideoSelectedEventDataRow) event).getAmount();

            if (result.containsKey(dateKey)) {
                double sumAmount = result.get(dateKey) + amount;
                result.put(dateKey, sumAmount);
            } else {
                result.put(dateKey, amount);
            }
        }
        return result;
    }

    public Map<Date, Map<String, Integer>> getCookStatistic() {
        Map<Date, Map<String, Integer>> result = new TreeMap<>(Collections.reverseOrder());

        for (EventDataRow event : storage.getEventList(EventType.COOKED_ORDER)) {
            Date dateKey = dateToStringMidnight(event.getDate());
            String name = ((CookedOrderEventDataRow) event).getCookName();
            int time = event.getTime();
            if (time != 0) {
                if (time % 60 == 0) time = time / 60;
                else time = time / 60 + 1;

                if (result.containsKey(dateKey)) {
                    Map<String, Integer> tempMap = result.get(dateKey);
                    if (tempMap.containsKey(name)) {
                        int tempTime = tempMap.get(name) + time;
                        tempMap.put(name, tempTime);
                    } else {
                        tempMap.put(name, time);
                    }
                    result.put(dateKey, tempMap);
                } else {
                    Map<String, Integer> tempMap = new TreeMap<>();
                    tempMap.put(name, time);
                    result.put(dateKey, tempMap);
                }
            }
        }
        return result;
    }

    private class StatisticStorage {
        private Map<EventType, List<EventDataRow>> eventMap = new HashMap<>();

        public StatisticStorage() {
            for (EventType eventType : EventType.values())
                eventMap.put(eventType, new ArrayList<>());
        }

        private void put(EventDataRow data) {
            eventMap.get(data.getType()).add(data);
        }

        public List<EventDataRow> getEventList(EventType eventType) {
            return eventMap.get(eventType);
        }
    }
}
