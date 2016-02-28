//package com.javarush.test.level07.lesson06.task03;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//
///* Самая короткая строка
//1. Создай список строк.
//2. Считай с клавиатуры 5 строк и добавь в список.
//3. Используя цикл, найди самую короткую строку в списке.
//4. Выведи найденную строку на экран.
//5. Если таких строк несколько, выведи каждую с новой строки.
//*/
//public class Solution
//{
//    public static void main(String[] args) throws Exception
//    {
//        //напишите тут ваш код
//        ArrayList<String> list = new ArrayList<String>();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        for (int i = 0; i < 5; i++) {
//            list.add(reader.readLine());
//        }
//
//        String sh = list.get(0);
//
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).length() < sh.length()) sh = list.get(i);
//        }
//
//        ArrayList<String> result = new ArrayList<String>();
//
//        for (int i = 0; i < list.size(); i++) {
//            if (list.get(i).length() == sh.length()) result.add(list.get(i));
//        }
//
//        for (int i = 0; i < result.size(); i++) {
//            System.out.println(result.get(i));
//        }
//    }
//}
