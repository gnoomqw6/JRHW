////package com.javarush.test.level18.lesson05.task03;
////
/////* Разделение файла
////Считать с консоли три имени файла: файл1, файл2, файл3.
////Разделить файл1 по следующему критерию:
////Первую половину байт записать в файл2, вторую половину байт записать в файл3.
////Если в файл1 количество байт нечетное, то файл2 должен содержать бОльшую часть.
////Закрыть потоки. Не использовать try-with-resources
////*/
////import java.io.*;
////
////public class Solution {         НЕ СМОГ ПРОВЕРИТЬ СВОЕ РЕШЕНИЕ
////    public static void main(String[] args) throws Exception{
////        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
////        String file1 = reader.readLine();
////        String file2 = reader.readLine();
////        String file3 = reader.readLine();
////
////        FileInputStream inputStream = new FileInputStream(file1);
////        FileOutputStream outputStream1 = new FileOutputStream(file2);
////        FileOutputStream outputStream2 = new FileOutputStream(file3);
////
////        byte[] buff = new byte[inputStream.available()];
////
////        if (inputStream.available() > 0) {
////            inputStream.read(buff);
////        }
////
////        int whole = inputStream.available();
////        int half = whole / 2;
////        if ((whole % 2) != 0) half++;
////
////        outputStream1.write(buff, 0, half);
////        outputStream2.write(buff, half, whole);
////
////        inputStream.close();
////        outputStream1.close();
////        outputStream2.close();
////        reader.close();
////
////
////    }
////}
//
//import java.io.*;
//public class Solution
//{
//    public static void main(String[] args) throws Exception
//    {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        FileInputStream fileInputStream = new FileInputStream(reader.readLine());
//        FileOutputStream fileOutputStream1 = new FileOutputStream(reader.readLine());
//        FileOutputStream fileOutputStream2 = new FileOutputStream(reader.readLine());
//        byte[] buffer = new byte[fileInputStream.available()];
//        if (fileInputStream.available() > 0) {fileInputStream.read(buffer);}
//        int middleOfRange = buffer.length / 2 + buffer.length % 2;
//        fileOutputStream1.write(buffer, 0, middleOfRange);
//        fileOutputStream2.write(buffer, middleOfRange, buffer.length - middleOfRange);
//        fileInputStream.close();
//        fileOutputStream1.close();
//        fileOutputStream2.close();
//        reader.close();
//    }
//}
