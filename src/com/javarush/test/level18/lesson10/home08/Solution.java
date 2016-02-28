//package com.javarush.test.level18.lesson10.home08;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.InputStreamReader;
//import java.util.HashMap;
//import java.util.Map;
//
///* Нити и байты
//Читайте с консоли имена файлов, пока не будет введено слово "exit"
//Передайте имя файла в нить ReadThread
//Нить ReadThread должна найти байт, который встречается в файле максимальное число раз,
//и добавить его в словарь resultMap,
//где параметр String - это имя файла, параметр Integer - это искомый байт.
//Закрыть потоки. Не использовать try-with-resources
//*/
//
//public class Solution {
//    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();
//
//    public static void main(String[] args) throws Exception {
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//        while (true) {
//            String file = reader.readLine();
//            if (file.equals("exit")) break;
//            new ReadThread(file).start();
//        }
//
//        reader.close();
//
//    }
//
//    public static class ReadThread extends Thread {
//        private String filename;
//
//        public ReadThread(String fileName) {
//            //implement constructor body
//            this.filename = fileName;
//        }
//        // implement file reading here - реализуйте чтение из файла тут
//        public synchronized void run() {
//            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//
//            try {
//                FileInputStream inputStream = new FileInputStream(filename);
//                while (inputStream.available() > 0) {
//                    int i = inputStream.read();
//                    if (map.containsKey(i)) map.put(i, map.get(i) + 1);
//                    else map.put(i, 1);
//                }
//
//                int max = 0;
//
//                for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
//                    max = Math.max(max, pair.getValue());
//                }
//
//                for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
//                    if (pair.getValue() == max) {
//                        resultMap.put(filename, pair.getKey());
//                    }
//                }
//
//                inputStream.close();
//            }
//            catch (Exception e) {
//
//            }
//        }
//    }
//}
