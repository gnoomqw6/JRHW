package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.kitchen.Cook;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

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

    private class StatisticStorage {
        Map<EventType, List<EventDataRow>> eventMap = new HashMap<>();

        public StatisticStorage() {
            for (EventType eventType : EventType.values())
                eventMap.put(eventType, new ArrayList<EventDataRow>());
        }

        private void put(EventDataRow data) {
            eventMap.get(data.getType()).add(data);
        }
    }

    public void register(Cook cook) {
        cookSet.add(cook);
    }
}
