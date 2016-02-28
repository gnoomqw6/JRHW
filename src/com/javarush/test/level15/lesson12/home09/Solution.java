//package com.javarush.test.level15.lesson12.home09;
////
/////* Парсер реквестов
////Считать с консоли URl ссылку.
////Вывести на экран через пробел список всех параметров (Параметры идут после ? и разделяются &, например, lvl=15).
////URL содержит минимум 1 параметр.
////Если присутствует параметр obj, то передать его значение в нужный метод alert.
////alert(double value) - для чисел (дробные числа разделяются точкой)
////alert(String value) - для строк
////
////Пример 1
////Ввод:
////http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo
////Вывод:
////lvl view name
////
////Пример 2
////Ввод:
////http://javarush.ru/alpha/index.html?obj=3.14&name=Amigo
////Вывод:
////obj name
////double 3.14
////*/
////
////import java.io.BufferedReader;
////import java.io.IOException;
////import java.io.InputStreamReader;
////import java.util.ArrayList;
////import java.util.List;
////
////public class Solution {
////    public static void main(String[] args) throws IOException {
////        //add your code here
////        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
////        String url = reader.readLine();
////        String s = url.substring(url.indexOf('?'));
////        char[] arr = s.toCharArray();
////        List<String> params = new ArrayList<String>();
////        List<String> objParams = new ArrayList<String>();
////        for (int i = 0; i < arr.length; ) {
////
////            if (i == arr.length - 1) break;
////
////            if (i < arr.length - 1) {
////                i++;
////            }
////            else if (arr[i] == '&' || arr[i] == '?') break;
////
////            String temp = "";
////
////            while ((arr[i] != '=' && arr[i] != '&') && i < arr.length - 1) {
////                temp += arr[i];
////                i++;
////            }
////
////            if (!temp.equals("")) params.add(temp);
////
////            if (temp.equals("obj") && arr[i] == '=') {
////                i++;
////                String objTemp = "";
////
////                while (arr[i] != '&' && i < arr.length) {
////                    objTemp += arr[i];
////                    if (i == arr.length - 1) break;
////                    i++;
////                }
////
////                if (!objTemp.equals("")) objParams.add(objTemp);
////            }
////
////            while (arr[i] != '&' && i < arr.length - 1) {
////                i++;
////            }
////        }
////
////        for (String i : params) {
////            System.out.print(i + " ");
////        }
////        System.out.println();
////
////        for (String i : objParams) {
////            try {
////                alert(Double.parseDouble(i));
////            }
////            catch (Exception e) {
////                alert(i);
////            }
////        }
////    }
////
////    public static void alert(double value) {
////        System.out.println("double " + value);
////    }
////
////    public static void alert(String value) {
////        System.out.println("String " + value);
////    }
////}
//
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.HashMap;
//public class Solution {
//    public static void main(String[] args) throws IOException
//    {
//        //add your code here
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String s = reader.readLine();
//        String allArguments = s.substring(s.indexOf("?") + 1);
//        String[] parsed = allArguments.split("&");
//        for (int i = 0; i < parsed.length; i++) {
////            String currentArg = parsed[i];
//            String[] currentArgArr = parsed[i].split("=");
//            if(i == parsed.length - 1){
//                System.out.print(currentArgArr[0]);
//            }else{
//                System.out.print(currentArgArr[0] + " ");
//            }
//        }
//        System.out.println();
//        for (int i = 0; i < parsed.length; i++) {
////            String currentArg = parsed[i];
//            String[] currentArgArr = parsed[i].split("=");
//            if(currentArgArr[0].equals("obj")){
//                try {
//                    alert(Double.parseDouble(currentArgArr[1]));
//                }
//                catch (Exception e){
//                    alert(currentArgArr[1]);
//                }
//            }
//        }
//    }
//    public static void alert(double value) {
//        System.out.println("double " + value);
//    }
//    public static void alert(String value) {
//        System.out.println("String " + value);
//    }
//}