//package com.javarush.test.level22.lesson09.task01;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.LinkedList;
//import java.util.List;
//
///* Обращенные слова
//В методе main с консоли считать имя файла, который содержит слова, разделенные пробелами.
//Найти в тексте все пары слов, которые являются обращением друг друга. Добавить их в result.
//Порядок слов first/second не влияет на тестирование.
//Использовать StringBuilder.
//Пример содержимого файла
//рот тор торт о
//о тот тот тот
//Вывод:
//рот тор
//о о
//тот тот
//*/
//public class Solution {
//    public static List<Pair> result = new LinkedList<>();
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedReader input = new BufferedReader(new FileReader(reader.readLine()));
//        reader.close();
//
//        String[] strArr;
//        while (input.ready()) {
//            strArr = input.readLine().split(" ");
//            for (int i = 0; i < strArr.length - 1; i++) {
//                if (strArr[i] == null) continue;
//                StringBuilder sb = new StringBuilder(strArr[i]);
//                String compare = sb.reverse().toString();
//                for (int j = i + 1; j < strArr.length; j++) {
//                    if (strArr[j] == null) continue;
//                    if (compare.equals(strArr[j])) {
//                        Pair addPair = new Pair();
//                        addPair.first = strArr[i];
//                        addPair.second = strArr[j];
//                        result.add(addPair);
//                        strArr[i] = null;
//                        strArr[j] = null;
//                        break;
//                    }
//                }
//            }
//        }
//    }
//
//    public static class Pair {
//        String first;
//        String second;
//
//        @Override
//        public String toString() {
//            return  first == null && second == null ? "" :
//                    first == null && second != null ? second :
//                    second == null && first != null ? first :
//                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;
//
//        }
//    }
//
//}
