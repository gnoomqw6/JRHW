//package com.javarush.test.level18.lesson10.bonus01;
//
///* Шифровка
//Придумать механизм шифровки/дешифровки
//
//Программа запускается с одним из следующих наборов параметров:
//-e fileName fileOutputName
//-d fileName fileOutputName
//где
//fileName - имя файла, который необходимо зашифровать/расшифровать
//fileOutputName - имя файла, куда необходимо записать результат шифрования/дешифрования
//-e - ключ указывает, что необходимо зашифровать данные
//-d - ключ указывает, что необходимо расшифровать данные
//*/
//
//import java.io.*;
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        if (args.length > 2) {
//            if (args[0].equals("-e")) cod(args[1], args[2]);
//            else if (args[0].equals("-d")) decod(args[1], args[2]);
//        }
//    }
//
//    public static void cod(String fileName, String fileOutputName) throws IOException {
//        FileInputStream inputStream = new FileInputStream(fileName);
//        FileOutputStream outputStream = new FileOutputStream(fileOutputName);
//        byte[] arr = new byte[inputStream.available()];
//
//        inputStream.read(arr);
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                byte temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//
//        outputStream.write(arr);
//
//        outputStream.close();
//        inputStream.close();
//    }
//
//    public static void decod(String fileName, String fileOutputName) throws IOException {
//        FileInputStream inputStream = new FileInputStream(fileName);
//        FileOutputStream outputStream = new FileOutputStream(fileOutputName);
//        byte[] arr = new byte[inputStream.available()];
//
//        inputStream.read(arr);
//
//        for (int i = 0; i < arr.length - 1; i++) {
//            for (int j = 0; j < arr.length - 1 - i; j++) {
//                byte temp = arr[j];
//                arr[j] = arr[j + 1];
//                arr[j + 1] = temp;
//            }
//        }
//
//        outputStream.write(arr);
//
//        outputStream.close();
//        inputStream.close();
//    }
//}
