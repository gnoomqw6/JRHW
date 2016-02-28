//package com.javarush.test.level20.lesson02.task03;
//
//
//import java.io.*;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Properties;
//
///* Знакомство с properties
//В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
//Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
//Реализуйте логику записи в файл и чтения из файла для карты properties.
//*/
//public class Solution {
//    public static Map<String, String> properties = new HashMap<>();
//
////    public static void main(String[] args) {
////        Solution solution = new Solution();
////        solution.fillInPropertiesMap();
////        for (Map.Entry<String, String> pair : properties.entrySet()) {
////            System.out.println(pair.getKey() + "........" + pair.getValue());
////        }
////        try {
////            OutputStream outputStream = new FileOutputStream("D:\\file12.txt");
////            solution.save(outputStream);
////            outputStream.close();
////        } catch (FileNotFoundException e) {
////            e.printStackTrace();
////        } catch (Exception e) {
////            e.printStackTrace();
////        }
////    }
//
//    public void fillInPropertiesMap() {
//        //implement this method - реализуйте этот метод
//        try {
//            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//            String file = reader.readLine();
//            reader.close();
//            InputStream inputStream = new FileInputStream(file);
//            load(inputStream);
//            inputStream.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void save(OutputStream outputStream) throws Exception {
//        //implement this method - реализуйте этот метод
//        Properties property = new Properties();
//        for (Map.Entry<String, String> pair : properties.entrySet()) {
//            property.put(pair.getKey(), pair.getValue());
//        }
//        property.store(outputStream, "");
//    }
//
//    public void load(InputStream inputStream) throws Exception {
//        //implement this method - реализуйте этот метод
//        Properties property = new Properties();
//        try {
//            property.load(inputStream);
//            for (String prop : property.stringPropertyNames()) {
//                properties.put(prop, property.getProperty(prop));
//            }
//        }
//        catch (Exception e) {
//            System.out.println("что-то не так с чтением");
//        }
//    }
//}
