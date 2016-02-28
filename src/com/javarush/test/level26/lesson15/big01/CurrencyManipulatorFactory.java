package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class CurrencyManipulatorFactory {

    private static Map<String, CurrencyManipulator> mapManipulator = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        if (mapManipulator.containsKey(currencyCode)) {
            return mapManipulator.get(currencyCode);
        }
        else {
            CurrencyManipulator cur = new CurrencyManipulator(currencyCode);
            mapManipulator.put(currencyCode, cur);
            return cur;
        }
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return mapManipulator.values();
    }
}
