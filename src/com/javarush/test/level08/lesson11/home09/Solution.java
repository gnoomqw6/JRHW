//package com.javarush.test.level08.lesson11.home09;
//
//import java.util.Date;
//
///* Работа с датой
//1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true,
//если количество дней с начала года - нечетное число, иначе false
//2. String date передается в формате MAY 1 2013
//Не забудьте учесть первый день года.
//Пример:
//JANUARY 1 2000 = true
//JANUARY 2 2020 = false
//*/
//
//public class Solution
//{
//    public static void main(String[] args)
//    {
//        isDateOdd("MAY 1 2000");
//    }
//
//    public static boolean isDateOdd(String date)
//    {
//        Date dateBegin = new Date(date);
//        Date dateset = new Date(date);
//
//        dateBegin.setSeconds(0);
//        dateBegin.setMinutes(0);
//        dateBegin.setHours(0);
//        dateBegin.setDate(0);
//        dateBegin.setMonth(0);
//
//        long timeDistance = dateset.getTime() - dateBegin.getTime();
//        long Day = 1000 * 60 * 60 * 24;
//        int result = (int)(timeDistance / Day);
//
//        return !(result % 2 == 0);
//    }
//}
