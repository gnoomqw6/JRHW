//package com.javarush.test.level06.lesson11.bonus03;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//
///* Задача по алгоритмам
//Задача: Написать программу, которая вводит с клавиатуры 5 чисел и выводит их в возрастающем порядке.
//Пример ввода:
//3
//2
//15
//6
//17
//Пример вывода:
//2
//3
//6
//15
//17
//*/
//
//public class Solution
//{
//    public static void main(String[] args) throws Exception
//    {
//        BufferedReader reader  = new BufferedReader(new InputStreamReader(System.in));
//
//        //напишите тут ваш код
//        int n1 = Integer.parseInt(reader.readLine());
//        int n2 = Integer.parseInt(reader.readLine());
//        int n3 = Integer.parseInt(reader.readLine());
//        int n4 = Integer.parseInt(reader.readLine());
//        int n5 = Integer.parseInt(reader.readLine());
//
//        int min = 0;
//
//        if (n1 < n2 && n1 < n3 && n1 < n4 && n1 < n5) min = n1;
//        if (n2 < n1 && n2 < n3 && n2 < n4 && n2 < n5) min = n2;
//        if (n3 < n2 && n3 < n1 && n3 < n4 && n3 < n5) min = n3;
//        if (n4 < n2 && n4 < n3 && n4 < n1 && n4 < n5) min = n4;
//        if (n5 < n2 && n5 < n3 && n5 < n4 && n5 < n1) min = n5;
//
//        if (min == n2) {
//            n2 = n1;
//            n1 = min;
//        }
//        else if (min == n3) {
//            n3 = n1;
//            n1 = min;
//        }
//        else if (min == n4) {
//            n4 = n1;
//            n1 = min;
//        }
//        else if (min == n5) {
//            n5 = n1;
//            n1 = min;
//        }
//
//        if (n2 < n3 && n2 < n4 && n2 < n5) min = n2;
//        if (n3 < n2 && n3 < n4 && n3 < n5) min = n3;
//        if (n4 < n2 && n4 < n3 && n4 < n5) min = n4;
//        if (n5 < n2 && n5 < n3 && n5 < n4) min = n5;
//
//        if (min == n3) {
//            n3 = n2;
//            n2 = min;
//        }
//        else if (min == n4) {
//            n4 = n2;
//            n2 = min;
//        }
//        else if (min == n5) {
//            n5 = n2;
//            n2 = min;
//        }
//
//        if (n3 < n4 && n3 < n5) min = n3;
//        if (n4 < n3 && n4 < n5) min = n4;
//        if (n5 < n3 && n5 < n4) min = n5;
//
//        if (min == n4) {
//            n4 = n3;
//            n3 = min;
//        }
//        else if (min == n5) {
//            n5 = n3;
//            n3 = min;
//        }
//
//        if (n4 < n5) min = n4;
//        if (n5 < n4) min = n5;
//
//        if (min == n5) {
//            n5 = n4;
//            n4 = min;
//        }
//
//        System.out.println(n1);
//        System.out.println(n2);
//        System.out.println(n3);
//        System.out.println(n4);
//        System.out.println(n5);
//    }
//}
