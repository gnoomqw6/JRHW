package com.javarush.test.level27.lesson15.big01.statistic;

import com.javarush.test.level27.lesson15.big01.statistic.event.EventDataRow;
import com.javarush.test.level27.lesson15.big01.statistic.event.EventType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
    private StatisticStorage storage = new StatisticStorage();

    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {
    }

    public void register(EventDataRow data) {
        //TODO
    }

    private class StatisticStorage {
        Map<EventType, List<EventDataRow>> eventMap = new HashMap<>();

        public StatisticStorage() {
            for (EventType eventType : EventType.values())
                eventMap.put(eventType, new ArrayList<EventDataRow>());
        }
    }
}
