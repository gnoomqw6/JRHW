//package com.javarush.test.level08.lesson08.task04;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
///* Удалить всех людей, родившихся летом
//Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» - «дата рождения».
//Удалить из словаря всех людей, родившихся летом.
//*/
//
//public class Solution
//{
//    public static void main(String[] args) {
//        HashMap<String, Date> map = createMap();
//
//        System.out.println(map);
//    }
//
//    public static HashMap<String, Date> createMap()
//    {
//        HashMap<String, Date> map = new HashMap<String, Date>();
//        map.put("Stallone", new Date("JUNE 1 1980"));
//        map.put("Stallon", new Date("MAY 1 1980"));
//        map.put("Stallo", new Date("MARCH 1 1980"));
//        map.put("Stall", new Date("JUNE 18 1980"));
//        map.put("Stal", new Date("APRIL 1 1980"));
//        map.put("Sta", new Date("JULY 1 1980"));
//        map.put("St", new Date("JULY 15 1980"));
//        map.put("S", new Date("SEPTEMBER 1 1980"));
//        map.put("Slone", new Date("JUNE 1 1980"));
//        map.put("Sne", new Date("JUNE 1 1980"));
//
//        return map;
//
//    }
//
//    public static void removeAllSummerPeople(HashMap<String, Date> map)
//    {
//        //напишите тут ваш код
//        Iterator<Map.Entry<String, Date>> iter = map.entrySet().iterator();
//
//        while (iter.hasNext()) {
//            Map.Entry<String, Date> temp = iter.next();
//            if (temp.getValue().getMonth() > 4 && temp.getValue().getMonth() < 8) iter.remove();
//        }
//
//    }
//}
