//package com.javarush.test.level18.lesson03.task05;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStreamReader;
//import java.util.*;
//
//
//
//
///* Сортировка байт
//Ввести с консоли имя файла
//Считать все байты из файла.
//Не учитывая повторений - отсортировать их по байт-коду в возрастающем порядке.
//Вывести на экран
//Закрыть поток ввода-вывода
//
//Пример байт входного файла
//44 83 44
//
//Пример вывода
//44 83
//*/
//
//public class Solution {
//    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        FileInputStream inputStream = new FileInputStream(reader.readLine());
//
//        Set<Integer> hset = new HashSet<Integer>();
//
//        while (inputStream.available() > 0) hset.add(inputStream.read());
//
//        int[] arr = new int[hset.size()];
//
//        Iterator<Integer> iterator = hset.iterator();
//        for (int i = 0; i < arr.length; i++) {
//            if (iterator.hasNext()) {
//                arr[i] = iterator.next();
//            }
//        }
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr.length - 1; j++) {
//                if (arr[j + 1] < arr[j]) {
//                    int temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//
//        for (int i : arr) System.out.print(i + " ");
//
//        inputStream.close();
//        reader.close();
//    }
//}
