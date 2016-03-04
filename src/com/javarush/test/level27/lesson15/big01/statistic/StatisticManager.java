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

    //подозреваю я, что беда начинается здесь
    public void register(Cook cook) {
        cookSet.add(cook);
    }

    public Map<Date, Double> getAdvertismentStatistic() {
        Map<Date, Double> result = new TreeMap<>(Collections.reverseOrder());
        for (EventDataRow event : storage.getEventList(EventType.SELECTED_VIDEOS)) {
            Date date = event.getDate();
            //приводим дату к виду (дата такая-то)00ч:00м:00с:000мс
            //чтобы использовать как ключ в мапе
            Date dateKey = new Date(date.getTime() / 86400000 * 86400000);
            double amount = ((VideoSelectedEventDataRow)event).getAmount();

            if (result.containsKey(dateKey)) {
                double sumAmount = result.get(dateKey) + amount;
                result.put(dateKey, sumAmount);
            }
            else {
                result.put(dateKey, amount);
            }
        }
        return result;
    }

    //я нигде не использовал сет поваров, который мы объявляли
    //да и в голову не приходит мысль, как его использовать
    //подскажите
    public Map<Date, Map<String, Integer>> getCookStatistic() {
        Map<Date, Map<String, Integer>> result = new TreeMap<>(Collections.reverseOrder());

        for (EventDataRow event : storage.getEventList(EventType.COOKED_ORDER)) {
            Date date = event.getDate();
            //приводим дату к виду (дата такая-то)00ч:00м:00с:000мс
            //чтобы использовать как ключ в мапе
            Date dateKey = new Date(date.getTime() / 86400000 * 86400000);
            String name = ((CookedOrderEventDataRow)event).getCookName();
            int time = event.getTime();
            if (time != 0) {
                if (time % 60 == 0) time = time / 60;
                else time = time / 60 + 1;

                if (result.containsKey(dateKey)) {
                    Map<String, Integer> tempMap = result.get(dateKey);
                    if (tempMap.containsKey(name)) {
                        int tempTime = tempMap.get(name) + time;
                        tempMap.put(name, tempTime);
                    }
                    else {
                        tempMap.put(name, time);
                    }
                    result.put(dateKey, tempMap);
                }
                else {
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
                eventMap.put(eventType, new ArrayList<EventDataRow>());
        }

        private void put(EventDataRow data) {
            eventMap.get(data.getType()).add(data);
        }

        public List<EventDataRow> getEventList(EventType eventType) {
            return eventMap.get(eventType);
        }
    }
}
