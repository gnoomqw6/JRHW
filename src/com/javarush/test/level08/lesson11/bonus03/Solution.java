//package com.javarush.test.level08.lesson11.bonus03;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
///* Задача по алгоритмам
//Задача: Введи с клавиатуры 20 слов и выведи их в алфавитном порядке.
//*/
//
//public class Solution
//{
//    public static void main(String[] args) throws Exception
//    {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String[] array = new String[20];
//        for (int i = 0; i < array.length; i++)
//        {
//            array[i] = reader.readLine();
//        }
//
//        sort(array);
//
//        for (String x : array)
//        {
//            System.out.println(x);
//        }
//    }
//
//    public static void sort(String[] array)
//    {
//        //напишите тут ваш код
//        for (int i = 0; i < array.length; i++) {
//            String max = array[i];
//            for (int j = i; j < array.length; j++) {
//                if (isLessThan(array[j], max)) max = array[j];
//            }
//            for (int j = i; j < array.length; j++) {
//                if (max == array[j]) {
//                    array[j] = array[i];
//                    array[i] = max;
//                }
//            }
//        }
//    }
//
//    //Метод для сравнения строк: 'а' больше чем 'b'
//    public static boolean isLessThan(String a, String b)
//    {
//        return a.compareTo(b) < 0;
//    }
//}
