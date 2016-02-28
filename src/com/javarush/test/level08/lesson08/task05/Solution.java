//package com.javarush.test.level08.lesson08.task05;
//
//import java.util.HashMap;
//import java.util.Iterator;
//import java.util.Map;
//
///* Удалить людей, имеющих одинаковые имена
//Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» - «имя».
//Удалить людей, имеющих одинаковые имена.
//*/
//
//public class Solution
//{
//    public static void main(String[] args) {
//        HashMap<String, String> map = createMap();
//
//        removeTheFirstNameDuplicates(map);
//
//        for (Map.Entry<String, String> pairs : map.entrySet()) {
//            System.out.println(pairs.getKey() + " : " + pairs.getValue());
//        }
//    }
//
//    public static HashMap<String, String> createMap()
//    {
//        //напишите тут ваш код
//        HashMap<String, String> map = new HashMap<String, String>();
//        map.put("1", "a");
//        map.put("2", "s");
//        map.put("3", "d");
//        map.put("4", "f");
//        map.put("5", "g");
//        map.put("6", "a");
//        map.put("7", "d");
//        map.put("8", "h");
//        map.put("9", "j");
//        map.put("0", "k");
//
//        return map;
//    }
//
//    public static void removeTheFirstNameDuplicates(HashMap<String, String> map)
//    {
//        //напишите тут ваш код
//        HashMap<String, String> copy = new HashMap<String, String>(map);
//
//        Iterator<Map.Entry<String, String>> iter2 = copy.entrySet().iterator();
//
//        while (iter2.hasNext()) {
//            int count = 0;
//            HashMap<String, String> copy2 = new HashMap<String, String>(map);
//            Iterator<Map.Entry<String, String>> iter1 = map.entrySet().iterator();
//            String temp = iter2.next().getValue();
//            while (iter1.hasNext()) {
//                String del = iter1.next().getValue();
//                if (del.equals(temp)) {
//                    count++;
//                }
//            }
//            if (count > 1) {
//                removeItemFromMapByValue(map, temp);
//            }
//        }
//
//    }
//
//    public static void removeItemFromMapByValue(HashMap<String, String> map, String value)
//    {
//        HashMap<String, String> copy = new HashMap<String, String>(map);
//        for (Map.Entry<String, String> pair: copy.entrySet())
//        {
//            if (pair.getValue().equals(value))
//                map.remove(pair.getKey());
//        }
//    }
//}
