//package com.javarush.test.level09.lesson11.bonus03;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
///* Задача по алгоритмам
//Задача: Пользователь вводит с клавиатуры список слов (и чисел).
//Слова вывести в возрастающем порядке, числа - в убывающем.
//Пример ввода:
//Вишня
//1
//Боб
//3
//Яблоко
//2
//0
//Арбуз
//Пример вывода:
//Арбуз
//3
//Боб
//2
//Вишня
//1
//0
//Яблоко
//*/
//
//public class Solution
//{
//    public static void main(String[] args) throws Exception
//    {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        ArrayList<String> list = new ArrayList<String>();
//        while (true)
//        {
//            String s = reader.readLine();
//            if (s.isEmpty()) break;
//            list.add(s);
//        }
//
//        String[] array = list.toArray(new String[list.size()]);
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
//        ArrayList<Integer> intList = new ArrayList<Integer>();
//        ArrayList<String> strList = new ArrayList<String>();
//
//        for (int i = 0; i < array.length; i++) {
//            if (isNumber(array[i])) {
//                intList.add(Integer.parseInt(array[i]));
//            }
//            else {
//                strList.add(array[i]);
//            }
//        }
//
//        for (int i = 0; i < intList.size(); i++) {
//            int max = intList.get(i);
//            for (int j = i; j < intList.size(); j++) {
//                if (intList.get(j) > max) max = intList.get(j);
//            }
//            for (int j = i; j < intList.size(); j++) {
//                if (intList.get(j) == max) {
//                    intList.set(j, intList.get(i));
//                    intList.set(i, max);
//                }
//            }
//        }
//
//        for (int i = 0; i < strList.size(); i++) {
//            String min = strList.get(i);
//            for (int j = i; j < strList.size(); j++) {
//                if (isLessThan(strList.get(j), min)) {
//                    min = strList.get(j);
//                }
//            }
//            for (int j = i; j < strList.size(); j++) {
//                if (strList.get(j).equals(min)) {
//                    strList.set(j, strList.get(i));
//                    strList.set(i, min);
//                }
//            }
//        }
//
//        int countint = 0;
//        int countstr = 0;
//
//        for (int i = 0; i < array.length; i++) {
//            if (isNumber(array[i])) {
//                array[i] = intList.get(countint).toString();
//                countint++;
//            }
//            else {
//                array[i] = strList.get(countstr);
//                countstr++;
//            }
//        }
//    }
//
//    //Метод для сравнения строк: 'а' больше чем 'b'
//    public static boolean isLessThan(String a, String b)
//    {
//        return a.compareTo(b) < 0;
//    }
//
//
//    //строка - это на самом деле число?
//    public static boolean isNumber(String s)
//    {
//        if (s.length() == 0) return false;
//
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length; i++)
//        {
//            char c = chars[i];
//            if ((i != 0 && c == '-') //есть '-' внутри строки
//                    || (!Character.isDigit(c) && c != '-') ) // не цифра и не начинается с '-'
//            {
//                return false;
//            }
//        }
//        return true;
//    }
//}
