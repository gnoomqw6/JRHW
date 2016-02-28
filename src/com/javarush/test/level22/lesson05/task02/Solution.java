//package com.javarush.test.level22.lesson05.task02;
//
//import java.util.ArrayList;
//import java.util.List;
//
///* Между табуляциями
//Метод getPartOfString должен возвращать подстроку между первой и второй табуляцией.
//На некорректные данные бросить исключение TooShortStringException.
//Класс TooShortStringException не менять.
//*/
//public class Solution {
//    public static String getPartOfString(String string) throws TooShortStringException {
//        if (string == null) throw new TooShortStringException();
//        String result = null;
//        List<Integer> indexesOfTabs = new ArrayList<>();
//        char[] temp = string.toCharArray();
//        for (int i = 0; i < temp.length; i++) {
//            if (temp[i] == '\t') {
//                indexesOfTabs.add(i);
//            }
//        }
//        try {
//            result = string.substring(indexesOfTabs.get(0) + 1, indexesOfTabs.get(1));
//        } catch (Exception e) {
//            throw new TooShortStringException();
//        }
//        return result;
//    }
//
//    public static class TooShortStringException extends Exception {
//    }
//}
