//package com.javarush.test.level19.lesson05.task01;
//
///* Четные байты
//Считать с консоли 2 имени файла.
//Вывести во второй файл все байты с четным индексом.
//Пример: второй байт, четвертый байт, шестой байт и т.д.
//Закрыть потоки ввода-вывода.
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
//        String file1 = reader.readLine();
//        String file2 = reader.readLine();
//
//        FileInputStream inputStream = new FileInputStream(file1);
//        byte[] buf = new byte[inputStream.available()];
//        FileOutputStream outputStream = new FileOutputStream(file2);
//
//        while (inputStream.available() > 0) inputStream.read(buf);
//
//        for (int i = 1; i < buf.length; i += 2) {
//            outputStream.write(buf[i]);
//        }
//
//        outputStream.close();
//        inputStream.close();
//        reader.close();
//    }
//}
