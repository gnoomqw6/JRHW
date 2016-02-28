//package com.javarush.test.level18.lesson05.task04;
//
///* Реверс файла
//Считать с консоли 2 имени файла: файл1, файл2.
//Записать в файл2 все байты из файл1, но в обратном порядке
//Закрыть потоки. Не использовать try-with-resources
//*/
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//import java.io.InputStreamReader;
//
//public class Solution {
//    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        FileInputStream inputStream = new FileInputStream(reader.readLine());
//        FileOutputStream outputStream = new FileOutputStream(reader.readLine());
//
//        byte[] buf = new byte[inputStream.available()];
//        inputStream.read(buf);
//
//        for (int i = 0; i < buf.length - 1; i++) {
//            for (int j = 0; j < buf.length - 1 - i; j++) {
//                byte temp = buf[j];
//                buf[j] = buf[j + 1];
//                buf[j + 1] = temp;
//            }
//        }
//
//        outputStream.write(buf);
//
//        inputStream.close();
//        outputStream.close();
//        reader.close();
//    }
//}
