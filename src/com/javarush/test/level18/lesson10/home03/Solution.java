//package com.javarush.test.level18.lesson10.home03;
//
///* Два в одном
//Считать с консоли 3 имени файла
//Записать в первый файл содержимого второго файла, а потом дописать содержимое третьего файла
//Закрыть потоки. Не использовать try-with-resources
//*/
//
//import java.io.*;
//
//public class Solution {
//    public static void main(String[] args) throws Exception{
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String file1 = reader.readLine();
//        String file2 = reader.readLine();
//        String file3 = reader.readLine();
//
//        FileInputStream inputStream1 = new FileInputStream(file2);
//        FileOutputStream outputStream = new FileOutputStream(file1, true);
//
//        while (inputStream1.available() > 0) {
//            int i = inputStream1.read();
//            outputStream.write(i);
//        }
//
//        outputStream.write(System.lineSeparator().getBytes());
//
//        FileInputStream inputStream2 = new FileInputStream(file3);
//
//        while (inputStream2.available() > 0) {
//            int i = inputStream2.read();
//            outputStream.write(i);
//        }
//
//        reader.close();
//        outputStream.close();
//        inputStream1.close();
//        inputStream2.close();
//    }
//}
