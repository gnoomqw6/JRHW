//package com.javarush.test.level19.lesson10.home08;
//
///* Перевертыши
//1 Считать с консоли имя файла.
//2 Для каждой строки в файле:
//2.1 переставить все символы в обратном порядке
//2.2 вывести на экран
//3 Закрыть потоки. Не использовать try-with-resources
//
//Пример тела входного файла:
//я - программист.
//Амиго
//
//Пример результата:
//.тсиммаргорп - я
//огимА
//*/
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//
//public class Solution {
//    public static void main(String[] args) throws Exception{
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String file = reader.readLine();
//        reader.close();
//
//        BufferedReader in = new BufferedReader(new FileReader(file));
//        while (in.ready()) {
//            String line = in.readLine();
//            char[] arr = line.toCharArray();
//            int l = arr.length - 1;
//            for (int i = 0; i < arr.length / 2; i++) {
//                char temp = arr[i];
//                arr[i] = arr[l - i];
//                arr[l - i] = temp;
//            }
//            String result = "";
//            for (char ch : arr) {
//                result += ch;
//            }
//            System.out.println(result);
//        }
//
//        in.close();
//    }
//}
