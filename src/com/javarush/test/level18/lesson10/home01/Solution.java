//package com.javarush.test.level18.lesson10.home01;
//
///* Английские буквы
//В метод main первым параметром приходит имя файла.
//Посчитать количество букв английского алфавита, которое есть в этом файле.
//Вывести на экран число (количество букв)
//Закрыть потоки. Не использовать try-with-resources
//*/
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.IOException;
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        FileInputStream inputStream = new FileInputStream(args[0]);
//
//        byte[] buf = new byte[inputStream.available()];
//
//        inputStream.read(buf);
//
//        int counter = 0;
//
//        for (int i = 0; i < buf.length; i++) {
//            if ((buf[i] > 64 && buf[i] < 91) || (buf[i] > 96 && buf[i] < 123)) counter++;
//        }
//
//        System.out.println(counter);
//
//        inputStream.close();
//    }
//}
