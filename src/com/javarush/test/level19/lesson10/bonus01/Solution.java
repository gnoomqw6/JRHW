//package com.javarush.test.level19.lesson10.bonus01;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
///* Отслеживаем изменения
//Считать в консоли 2 имени файла - file1, file2.
//Файлы содержат строки, file2 является обновленной версией file1, часть строк совпадают.
//Нужно создать объединенную версию строк, записать их в список lines
//Операции ADDED и REMOVED не могут идти подряд, они всегда разделены SAME
//Пример:
//[Файл 1]
//строка1
//строка2
//строка3
//
//[Файл 2]
//строка1
//строка3
//строка4
//
//[Результат - список lines]
//SAME строка1
//REMOVED строка2
//SAME строка3
//ADDED строка4
//*/
//
//public class Solution {             //СЛОЖНАЯ И ИНТЕРЕСНАЯ ЗАДАЧКА НА СООБРАЗИТЕЛЬНОСТЬ ПРИ СОСТАВЛЕНИИ АЛГОРИТМА
//    public static List<LineItem> lines = new ArrayList<LineItem>();
//
//    public static void main(String[] args) throws IOException{
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String file1 = reader.readLine();
//        String file2 = reader.readLine();
//        reader.close();
//
//        BufferedReader in1 = new BufferedReader(new FileReader(file1));
//        BufferedReader in2 = new BufferedReader(new FileReader(file2));
//
//        List<String> list1 = new ArrayList<String>();
//        List<String> list2 = new ArrayList<String>();
//
//        while (in1.ready()) {
//            list1.add(in1.readLine());
//        }
//        while (in2.ready()) {
//            list2.add(in2.readLine());
//        }
//
//        while (list1.size() != 0 && list2.size() != 0) {
//            if (list1.get(0).equals(list2.get(0))) {
//                lines.add(new LineItem(Type.SAME, list1.get(0)));
//                list1.remove(0);
//                list2.remove(0);
//            }
//            else if (list1.contains(list2.get(0))) {
//                lines.add(new LineItem(Type.REMOVED, list1.get(0)));
//                list1.remove(0);
//            }
//            else {
//                lines.add(new LineItem(Type.ADDED, list2.get(0)));
//                list2.remove(0);
//            }
//        }
//
//        if (list1.size() != 0) {
//            for (String s : list1) {
//                lines.add(new LineItem(Type.REMOVED, s));
//            }
//        }
//        else if (list2.size() != 0) {
//            for (String s : list2) {
//                lines.add(new LineItem(Type.ADDED, s));
//            }
//        }
//
//        in1.close();
//        in2.close();
//    }
//
//
//    public static enum Type {
//        ADDED,        //добавлена новая строка
//        REMOVED,      //удалена строка
//        SAME          //без изменений
//    }
//
//    public static class LineItem {
//        public Type type;
//        public String line;
//
//        public LineItem(Type type, String line) {
//            this.type = type;
//            this.line = line;
//        }
//    }
//}
