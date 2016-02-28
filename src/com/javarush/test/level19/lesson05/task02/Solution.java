//package com.javarush.test.level19.lesson05.task02;
//
///* Считаем слово
//Считать с консоли имя файла.
//Файл содержит слова, разделенные знаками препинания.
//Вывести в консоль количество слов "world", которые встречаются в файле.
//Закрыть потоки. Не использовать try-with-resources
//*/
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//
//public class Solution {
//    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        FileReader fileReader = new FileReader(reader.readLine());
//        Scanner sc = new Scanner(fileReader);
//
//        int count = 0;
//
//        while (sc.hasNextLine()) {
//            String s = sc.nextLine();
//            String[] arr = s.split("[., !?;:-]");
//            for (int i = 0; i < arr.length; i++) {
//                if (arr[i].equals("world")) count++;
//            }
//        }
//
//        System.out.println(count);
//
//        sc.close();
//        fileReader.close();
//        reader.close();
//    }
//}
