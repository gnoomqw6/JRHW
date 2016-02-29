package com.javarush.test.level27.lesson15.big01.kitchen;

import java.util.Arrays;

public enum Dish {
    Fish,
    Steak,
    Soup,
    Juice,
    Water;

    public static String allDishesToString() {
        String dishes = Arrays.toString(values());
        return dishes.substring(1, dishes.length() - 1);
    }
}
