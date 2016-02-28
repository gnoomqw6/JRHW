//package com.javarush.test.level18.lesson03.task02;
//
//import java.io.FileInputStream;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
///* Минимальный байт
//Ввести с консоли имя файла
//Найти минимальный байт в файле, вывести его на экран.
//Закрыть поток ввода-вывода
//*/
//
//public class Solution {
//    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String name = reader.readLine();
//        reader.close();
//
//        FileInputStream inputStream = new FileInputStream(name);
//
//        int min = -1;
//
//        if (inputStream.available() > 0) {
//            min = inputStream.read();
//        }
//
//        while (inputStream.available() > 0) {
//            int temp = inputStream.read();
//            if (temp < min) min = temp;
//        }
//
//        System.out.println(min);
//
//        inputStream.close();
//    }
//}
