//package com.javarush.test.level18.lesson03.task04;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Map;
//
///* Самые редкие байты
//Ввести с консоли имя файла
//Найти байт или байты с минимальным количеством повторов
//Вывести их на экран через пробел
//Закрыть поток ввода-вывода
//*/
//
//public class Solution {
//    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        FileInputStream inputStream = new FileInputStream(reader.readLine());
//
//        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//        while (inputStream.available() > 0) {
//            int temp = inputStream.read();
//            boolean isFound = false;
//            if (map.isEmpty()) map.put(temp, 0);
//            else {
//                for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
//                    if (pair.getKey() == temp) {
//                        isFound = true;
//                        int n = pair.getValue();
//                        n++;
//                        pair.setValue(n);
//                        break;
//                    }
//                }
//                if (isFound == false) {
//                    map.put(temp, 0);
//                }
//            }
//        }
//
//        int min = 1000;
//
//        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
//            if (pair.getValue() < min) min = pair.getValue();
//        }
//
//        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
//            if (pair.getValue() == min) System.out.print(pair.getKey() + " ");
//        }
//        inputStream.close();
//        reader.close();
//    }
//}
