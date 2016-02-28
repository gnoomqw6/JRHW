package com.javarush.test.level26.lesson15.big01;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public final class CurrencyManipulatorFactory {

    private static Map<String, CurrencyManipulator> mapManipulator = new HashMap<>();

    private CurrencyManipulatorFactory() {
    }

    public static CurrencyManipulator getManipulatorByCurrencyCode(String currencyCode) {
        for (Map.Entry<String, CurrencyManipulator> pair : mapManipulator.entrySet()) {
            if (currencyCode.equals(pair.getKey())) return pair.getValue();
        }
        CurrencyManipulator currencyManipulator = new CurrencyManipulator(currencyCode);
        mapManipulator.put(currencyCode, currencyManipulator);
        return currencyManipulator;
    }

    public static Collection<CurrencyManipulator> getAllCurrencyManipulators() {
        return mapManipulator.values();
    }
}
