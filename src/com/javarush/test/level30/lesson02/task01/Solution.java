//package com.javarush.test.level30.lesson02.task01;
//
///* Осваиваем методы класса Integer
//Используя метод Integer.parseInt(String, int) реализуйте логику метода convertToDecimalSystem,
//который должен переводить переданную строку в десятичное число и возвращать его в виде строки.
//*/
//public class Solution {
//
//    public static void main(String[] args) {
//        System.out.println(convertToDecimalSystem("0x16")); //22
//        System.out.println(convertToDecimalSystem("012"));  //10
//        System.out.println(convertToDecimalSystem("0b10")); //2
//        System.out.println(convertToDecimalSystem("62"));   //62
//    }
//
//    public static String convertToDecimalSystem(String s) {
//        if (s.charAt(0) == '0') {
//            if (s.indexOf('x') > -1) {
//                String substr = s.substring(2);
//                int i = Integer.parseInt(substr, 16);
//                return String.valueOf(i);
//            }
//            if (s.indexOf('b') > -1) {
//                String substr = s.substring(2);
//                int i = Integer.parseInt(substr, 2);
//                return String.valueOf(i);
//            }
//            String substr = s.substring(1);
//            int i = Integer.parseInt(substr, 8);
//            return String.valueOf(i);
//        }
//        return s;
//    }
//}
