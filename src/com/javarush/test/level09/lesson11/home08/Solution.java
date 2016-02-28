//package com.javarush.test.level09.lesson11.home08;
//
//import java.util.ArrayList;
//
///* Список из массивов чисел
//Создать список, элементами которого будут массивы чисел.
//Добавить в список пять объектов–массивов длиной 5, 2, 4, 7, 0 соответственно.
//Заполнить массивы любыми данными и вывести их на экран.
//*/
//
//public class Solution
//{
//    public static void main(String[] args)
//    {
//        ArrayList<int[]> list = createList();
//        printList(list);
//    }
//
//    public static ArrayList<int[]> createList()
//    {
//        //напишите тут ваш код
//        ArrayList<int[]> list = new ArrayList<int[]>();
//        int[] ar1 = {1, 1, 1, 1, 1};
//        int[] ar2 = {2, 2};
//        int[] ar3 = {3, 3, 3, 3};
//        int[] ar4 = {4, 4, 4, 4, 4, 4, 4};
//        int[] ar5 = {};
//        list.add(ar1);
//        list.add(ar2);
//        list.add(ar3);
//        list.add(ar4);
//        list.add(ar5);
//
//        return list;
//    }
//
//    public static void printList(ArrayList<int[]> list)
//    {
//        for (int[] array: list )
//        {
//            for (int x: array)
//            {
//                System.out.println(x);
//            }
//        }
//    }
//}
