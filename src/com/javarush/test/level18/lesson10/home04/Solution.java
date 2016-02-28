//package com.javarush.test.level18.lesson10.home04;
//
///* Объединение файлов
//Считать с консоли 2 имени файла
//В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов
//Закрыть потоки. Не использовать try-with-resources
//*/
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.io.FileInputStream;
//import java.io.FileOutputStream;
//
//public class Solution {
//    public static void main(String[] args) throws Exception{
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String file1 = reader.readLine();
//        String file2 = reader.readLine();
//        reader.close();
//
//        FileInputStream inputStream1 = new FileInputStream(file1);
//        FileInputStream inputStream2 = new FileInputStream(file2);
//
//        byte[] buf1 = new byte[inputStream1.available()];
//        byte[] buf2 = new byte[inputStream2.available()];
//
//        while (inputStream1.available() > 0) inputStream1.read(buf1);
//        while (inputStream2.available() > 0) inputStream2.read(buf2);
//
//
//        FileOutputStream outputStream1 = new FileOutputStream(file1, false);
//        outputStream1.write(buf2);
//        outputStream1.write(System.lineSeparator().getBytes());
//        FileOutputStream outputStream2 = new FileOutputStream(file1, true);
//        outputStream2.write(buf1);
//
//        inputStream1.close();
//        inputStream2.close();
//        outputStream1.close();
//        outputStream2.close();
//    }
//}
