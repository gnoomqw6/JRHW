//package com.javarush.test.level19.lesson10.home02;
//
///* Самый богатый
//В метод main первым параметром приходит имя файла.
//В этом файле каждая строка имеет следующий вид:
//имя значение
//где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом
//
//Для каждого имени посчитать сумму всех его значений
//Вывести в консоль имена, у которых максимальная сумма
//Имена разделять пробелом либо выводить с новой строки
//Закрыть потоки. Не использовать try-with-resources
//
//Пример входного файла:
//Петров 0.501
//Иванов 1.35
//Петров 0.85
//
//Пример вывода:
//Петров
//*/
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.util.Map;
//import java.util.TreeMap;
//
//public class Solution {
//    public static void main(String[] args) throws Exception {
//
//        if (args.length > 0) {
//            String file = args[0];
//
//            Map<String, Double> map = new TreeMap<String, Double>();
//
//            BufferedReader in = new BufferedReader(new FileReader(file));
//
//            while (in.ready()) {
//                String[] s = in.readLine().split(" ");
//                String name = s[0];
//                double value = Double.parseDouble(s[1]);
//                if (map.containsKey(name)) {
//                    map.put(name, map.get(name) + value);
//                }
//                else map.put(name, value);
//            }
//            double max = 0;
//            for (Map.Entry<String, Double> pair : map.entrySet()) {
//                if (pair.getValue() > max) max = pair.getValue();
//            }
//
//            for (Map.Entry<String, Double> pair : map.entrySet()) {
//                if (pair.getValue() == max) System.out.println(pair.getKey());
//            }
//
//
//            in.close();
//        }
//
//    }
//}
