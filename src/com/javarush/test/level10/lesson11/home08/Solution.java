//package com.javarush.test.level10.lesson11.home08;
//
//import java.util.ArrayList;
//
///* Массив списков строк
//Создать массив, элементами которого будут списки строк. Заполнить массив любыми данными и вывести их на экран.
//*/
//
//public class Solution
//{
//    public static void main(String[] args)
//    {
//        ArrayList<String>[] arrayOfStringList =  createList();
//        printList(arrayOfStringList);
//    }
//
//    public static ArrayList<String>[] createList()
//    {
//        //напишите тут ваш код
//        ArrayList<String>[] arr = new ArrayList[3];
//        ArrayList<String> list1 = new ArrayList<String>();
//        list1.add("aaa");
//        list1.add("bbb");
//        list1.add("ccc");
//        ArrayList<String> list2 = new ArrayList<String>();
//        list2.add("dddd");
//        list2.add("eeee");
//        list2.add("ffff");
//        list2.add("gggg");
//        ArrayList<String> list3 = new ArrayList<String>();
//        list3.add("hh");
//        list3.add("ii");
//
//        arr[0] = list1;
//        arr[1] = list2;
//        arr[2] = list3;
//
//        return arr;
//    }
//
//    public static void printList(ArrayList<String>[] arrayOfStringList)
//    {
//        for (ArrayList<String> list: arrayOfStringList)
//        {
//            for (String s : list)
//            {
//                System.out.println(s);
//            }
//        }
//    }
//}