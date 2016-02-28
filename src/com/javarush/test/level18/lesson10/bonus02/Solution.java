//package com.javarush.test.level18.lesson10.bonus02;
//
///* Прайсы
//CrUD для таблицы внутри файла
//Считать с консоли имя файла для операций CrUD
//Программа запускается со следующим набором параметров:
//-c productName price quantity
//Значения параметров:
//где id - 8 символов
//productName - название товара, 30 chars (60 bytes)
//price - цена, 8 символов
//quantity - количество, 4 символа
//-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно,
//инкрементируя максимальный id, найденный в файле
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
//import java.io.BufferedReader;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//
//public class Solution {
//    public static void main(String[] args) throws Exception {
//        String productName = "";
//        String price = "";
//        String quantity = "";
//
//        if (args.length > 3) {
//            if (args[1].length() > 30) {
//                productName = args[1].substring(0, 30);
//            }
//            else {
//                while (args[1].length() < 30) {
//                    args[1] = args[1] + " ";
//                }
//                productName = args[1];
//            }
//
//            if (args[2].length() > 8) {
//                price = args[1].substring(0, 8);
//            }
//            else {
//                while (args[2].length() < 8) {
//                    args[2] = args[2] + " ";
//                }
//                price = args[2];
//            }
//
//            if (args[3].length() > 4) {
//                quantity = args[3].substring(0, 4);
//            }
//            else {
//                while (args[3].length() < 4) {
//                    args[3] = args[3] + " ";
//                }
//                quantity = args[3];
//            }
//        }
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String filename = reader.readLine();
//        Scanner sc = new Scanner(new FileReader(filename));
//
//        int maxid = 0;
//
//        while (sc.hasNextLine()) {
//            String line = sc.nextLine();
//            if (line.isEmpty()) continue;
//            int id = Integer.parseInt(line.substring(0, 8).trim());
//            if (id > maxid) maxid = id;
//        }
//
//        if (maxid < 99999999) {
//            maxid++;
//        }
//
//        String sid = Integer.toString(maxid);
//
//        if (sid.length() < 8) {
//            while (sid.length() < 8) sid = sid + " ";
//        }
//
//        String addstr = "";
//        if (args[0].equals("-c")) {
//            addstr = sid + productName + price + quantity;
//        }
//
//        FileOutputStream outputStream = new FileOutputStream(filename, true);
//        outputStream.write(System.lineSeparator().getBytes());
//        outputStream.write(addstr.getBytes());
//
//        outputStream.close();
//        sc.close();
//        reader.close();
//    }
//}
