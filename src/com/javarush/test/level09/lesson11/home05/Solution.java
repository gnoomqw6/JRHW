//package com.javarush.test.level09.lesson11.home05;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
///* Гласные и согласные буквы
//Написать программу, которая вводит с клавиатуры строку текста.
//Программа должна вывести на экран две строки:
//1. первая строка содержит только гласные буквы
//2. вторая - только согласные буквы и знаки препинания из введённой строки.
//Буквы соединять пробелом, каждая строка должна заканчиваться пробелом.
//
//Пример ввода:
//Мама мыла раму.
//Пример вывода:
//а а ы а а у
//М м м л р м .
//*/
//
//public class Solution
//{
//    public static void main(String[] args) throws Exception
//    {
//        //напишите тут ваш код
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String s = reader.readLine();
//        List<Character> glas = new ArrayList<Character>();
//        List<Character> soglas = new ArrayList<Character>();
//        char[] arr = s.toCharArray();
//
//        for (int i = 0; i < arr.length; i++) {
//            if (arr[i] == ' ') continue;
//            else if (isVowel(arr[i])) {
//                glas.add(arr[i]);
//                glas.add(' ');
//            }
//            else {
//                soglas.add(arr[i]);
//                soglas.add(' ');
//            }
//        }
//
//        for (char i : glas) {
//            System.out.print(i);
//        }
//
//        System.out.println();
//
//        for (char i : soglas) {
//            System.out.print(i);
//        }
//
//        System.out.println();
//    }
//
//
//    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};
//
//    //метод проверяет, гласная ли буква
//    public static boolean isVowel(char c)
//    {
//        c = Character.toLowerCase(c);  //приводим символ в нижний регистр - от заглавных к строчным буквам
//
//        for (char d : vowels)   //ищем среди массива гласных
//        {
//            if (c == d)
//                return true;
//        }
//        return false;
//    }
//}
