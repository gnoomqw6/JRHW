//package com.javarush.test.level18.lesson10.bonus03;
//
///* Прайсы 2
//CrUD для таблицы внутри файла
//Считать с консоли имя файла для операций CrUD
//Программа запускается с одним из следующих наборов параметров:
//-u id productName price quantity
//-d id
//Значения параметров:
//где id - 8 символов
//productName - название товара, 30 chars (60 bytes)
//price - цена, 8 символов
//quantity - количество, 4 символа
//-u  - обновляет данные товара с заданным id
//-d  - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)
//
//В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
//id productName price quantity
//Данные дополнены пробелами до их длины
//
//Пример:
//19846   Шорты пляжные синие           159.00  12
//198478  Шорты пляжные черные с рисунко173.00  17
//19847983Куртка для сноубордистов, разм10173.991234
//*/
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        String argid = "";
//        String productName = "";
//        String price = "";
//        String quantity = "";
//
//        if (args.length == 5) {
//            if (args[1].length() > 8) {
//                return;
//            }
//            else {
//                while (args[1].length() < 8) {
//                    args[1] = args[1] + " ";
//                }
//                argid = args[1];
//            }
//            if (args[2].length() > 30) {
//                productName = args[2].substring(0, 30);
//            }
//            else {
//                while (args[2].length() < 30) {
//                    args[2] = args[2] + " ";
//                }
//                productName = args[2];
//            }
//
//            if (args[3].length() > 8) {
//                price = args[3].substring(0, 8);
//            }
//            else {
//                while (args[3].length() < 8) {
//                    args[3] = args[3] + " ";
//                }
//                price = args[3];
//            }
//
//            if (args[4].length() > 4) {
//                quantity = args[4].substring(0, 4);
//            }
//            else {
//                while (args[4].length() < 4) {
//                    args[4] = args[4] + " ";
//                }
//                quantity = args[4];
//            }
//        }
//        else if (args.length == 2) {
//            if (args[1].length() > 8) {
//                return;
//            }
//            else {
//                while (args[1].length() < 8) {
//                    args[1] = args[1] + " ";
//                }
//                argid = args[1];
//            }
//        }
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String filename = reader.readLine();
//        Scanner sc = new Scanner(new FileReader(filename));
//        List<String> list = new ArrayList<String>();
//
//        if (args[0].equals("-u") && args.length == 5) {
//            while (sc.hasNextLine()) list.add(sc.nextLine());
//            for (int i = 0; i < list.size(); i++) {
//                if (list.get(i).substring(0, 8).equals(argid)) {
//                    list.remove(i);
//                    list.add(i, argid + productName + price + quantity);
//                }
//            }
//            FileOutputStream out1 = new FileOutputStream(filename, false);
//            for (String s : list) {
//                out1.write(s.getBytes());
//                out1.write(System.lineSeparator().getBytes());
//            }
//            out1.close();
//        }
//        else if (args[0].equals("-d") && args.length == 2) {
//            while (sc.hasNextLine()) list.add(sc.nextLine());
//            for (int i = 0; i < list.size(); i++) {
//                if (list.get(i).substring(0, 8).equals(argid)) {
//                    list.remove(i);
//                }
//            }
//            FileOutputStream out2 = new FileOutputStream(filename, false);
//            for (String s : list) {
//                out2.write(s.getBytes());
//                out2.write(System.lineSeparator().getBytes());
//            }
//            out2.close();
//        }
//        else {
//            sc.close();
//            reader.close();
//            return;
//        }
//
//        sc.close();
//        reader.close();
//    }
//}
