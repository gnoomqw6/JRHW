//package com.javarush.test.level19.lesson05.task03;
//
///* Выделяем числа
//Считать с консоли 2 имени файла.
//Вывести во второй файл все числа, которые есть в первом файле.
//Числа выводить через пробел.
//Закрыть потоки. Не использовать try-with-resources
//
//Пример тела файла:
//12 text var2 14 8v 1
//
//Результат:
//12 14 1
//*/
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Solution {
//    public static void main(String[] args) throws IOException{
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String file1 = reader.readLine();
//        String file2 = reader.readLine();
//        FileReader fileReader = new FileReader(file1);
//        Scanner sc = new Scanner(fileReader);
//        FileWriter fileWriter = new FileWriter(file2);
//        List<Integer> list = new ArrayList<Integer>();
//
//        while (sc.hasNextLine()) {
//            String line = sc.nextLine();
//            String[] arr = line.split(" ");
//            for (int i = 0; i < arr.length; i++) {
//                try {
//                    list.add(Integer.parseInt(arr[i]));
//                }
//                catch (Exception e) {
//                    continue;
//                }
//            }
//        }
//
//        for (int i : list) {
//            fileWriter.write(i + " ");
//        }
//
//        fileWriter.close();
//        sc.close();
//        fileReader.close();
//        reader.close();
//    }
//}
