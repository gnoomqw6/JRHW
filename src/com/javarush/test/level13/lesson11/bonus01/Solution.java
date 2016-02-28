//package com.javarush.test.level13.lesson11.bonus01;
//
///* Сортировка четных чисел из файла
//1. Ввести имя файла с консоли.
//2. Прочитать из него набор чисел.
//3. Вывести на консоль только четные, отсортированные по возрастанию.
//Пример ввода:
//5
//8
//11
//3
//2
//10
//Пример вывода:
//2
//8
//10
//*/
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.Scanner;
//
//public class Solution
//{
//    public static void main(String[] args) throws Exception
//    {
//        // напишите тут ваш код
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String name = reader.readLine();
//        File file = new File(name);
//        Scanner scanner = new Scanner(file);
//        List<Integer> list = new ArrayList<Integer>();
//
//        while (scanner.hasNextInt()) {
//            int data = scanner.nextInt();
//            if (data % 2 == 0) list.add(data);
//        }
//
//        scanner.close();
//
//        Collections.sort(list);
//
//        for (int iter : list) {
//            System.out.println(iter);
//        }
//    }
//
//}
