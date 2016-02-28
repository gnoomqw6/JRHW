//package com.javarush.test.level08.lesson08.task03;
//
//import java.util.HashMap;
//import java.util.Map;
//
///* Одинаковые имя и фамилия
//Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» - «Имя».
//Проверить сколько людей имеют совпадающие с заданным имя или фамилию.
//*/
//
//public class Solution
//{
//    public static void main(String[] args) {
//        HashMap<String, String> nf = createMap();
//        System.out.println(getCountTheSameFirstName(nf, "sss"));
//        System.out.println(getCountTheSameLastName(nf, "aaa"));
//    }
//
//
//    public static HashMap<String, String> createMap()
//    {
//        //напишите тут ваш код
//        HashMap<String, String> map = new HashMap<String, String>();
//
//        map.put("aaa", "ssf");
//        map.put("aaf", "ssd");
//        map.put("aab", "sss");
//        map.put("aar", "sse");
//        map.put("aad", "sss");
//        map.put("aaq", "sst");
//        map.put("aaj", "ssu");
//        map.put("aak", "ssi");
//        map.put("aae", "sss");
//        map.put("aao", "ssm");
//
//        return map;
//    }
//
//    public static int getCountTheSameFirstName(HashMap<String, String> map, String name)
//    {
//        //напишите тут ваш код
//        int nameCounter = 0;
//
//        for (String pair : map.values()) {
//            if (pair.equals(name)) nameCounter++;
//        }
//
//        return nameCounter;
//
//    }
//
//    public static int getCountTheSameLastName(HashMap<String, String> map, String familiya)
//    {
//        //напишите тут ваш код
//        int famCounter = 0;
//
//        for (String pair : map.keySet()) {
//            if (pair.equals(familiya)) famCounter++;
//        }
//
//        return famCounter;
//    }
//}
