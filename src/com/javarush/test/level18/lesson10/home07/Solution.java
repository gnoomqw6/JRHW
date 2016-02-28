//package com.javarush.test.level18.lesson10.home07;
//
///* Поиск данных внутри файла
//Считать с консоли имя файла
//Найти в файле информацию, которая относится к заданному id, и вывести ее на экран в виде, в котором она записана в файле.
//Программа запускается с одним параметром: id (int)
//Закрыть потоки. Не использовать try-with-resources
//
//В файле данные разделены пробелом и хранятся в следующей последовательности:
//id productName price quantity
//
//где id - int
//productName - название товара, может содержать пробелы, String
//price - цена, double
//quantity - количество, int
//
//Информация по каждому товару хранится в отдельной строке
//*/
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//
//public class Solution {
//    public static void main(String[] args) throws Exception {
//
//        FileReader freader = new FileReader(new BufferedReader(new InputStreamReader(System.in)).readLine());
//
//        Scanner sc = new Scanner(freader);
//
//        while (sc.hasNextLine()) {
//            String line = sc.nextLine();
//            String[] arr = line.split(" ");
//            if (arr[0].equals(args[0])) {
//                System.out.println(line);
//                break;
//            }
//        }
//
//        freader.close();
//        sc.close();
//    }
//}
