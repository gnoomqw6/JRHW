//package com.javarush.test.level19.lesson10.home05;
//
///* Слова с цифрами
//В метод main первым параметром приходит имя файла1, вторым - файла2.
//Файл1 содержит строки со слов, разделенные пробелом.
//Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
//Закрыть потоки. Не использовать try-with-resources
//*/
//
//import java.io.BufferedReader;
//import java.io.BufferedWriter;
//import java.io.FileReader;
//import java.io.FileWriter;
//
//public class Solution {
//    public static void main(String[] args) throws Exception {
//        if (args.length > 1) {
//            BufferedReader in = new BufferedReader(new FileReader(args[0]));
//            BufferedWriter out = new BufferedWriter(new FileWriter(args[1]));
//
//            while (in.ready()) {
//                String line = in.readLine();
//                String[] sarr = line.split(" ");
//                for (String s : sarr) {
//                    char[] charr = s.toCharArray();
//                    for (char ch : charr) {
//                        if (ch=='0'||ch=='1'||ch=='2'||ch=='3'||ch=='4'||ch=='5'||ch=='6'||ch=='7'||ch=='8'||ch=='9') {
//                            out.write(s + " ");
//                            break;
//                        }
//                    }
//                }
//            }
//
//            out.close();
//            in.close();
//        }
//    }
//}
