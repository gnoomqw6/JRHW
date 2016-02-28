//package com.javarush.test.level14.lesson08.bonus02;
//
///* НОД
//Наибольший общий делитель (НОД).
//Ввести с клавиатуры 2 целых положительных числа.
//Вывести в консоль наибольший общий делитель.
//*/
//
//import java.io.*;
//import java.util.*;
//
//public class Solution
//{
//    public static void main(String[] args) throws Exception
//    {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int a, b;
//        while (true) {
//            int n1 = Integer.parseInt(reader.readLine());
//            if (n1 > 0) {
//                a = n1;
//                break;
//            }
//        }
//        while (true) {
//            int n2 = Integer.parseInt(reader.readLine());
//            if (n2 > 0) {
//                b = n2;
//                break;
//            }
//        }
//
//        int min = a < b ? a : b;
//        int max = min == b ? a : b;
//
//        List<Integer> list = new ArrayList<Integer>();
//
//        for (int i = min; i > 0; i--) {
//            if (min % i == 0) list.add(i);
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            if (max % list.get(i) == 0) {
//                System.out.println(list.get(i));
//                break;
//            }
//        }
//    }
//}
