//package com.javarush.test.level22.lesson13.task01;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.List;
//import java.util.StringTokenizer;
//
///* StringTokenizer
//Используя StringTokenizer разделить query на части по разделителю delimiter.
//Пример,
//getTokens("level22.lesson13.task01", ".") == {"level22", "lesson13", "task01"}
//*/
//public class Solution {
//    public static String [] getTokens(String query, String delimiter) {
//        List<String> listResult = new ArrayList<>();
//        StringTokenizer st = new StringTokenizer(query, delimiter);
//        while (st.hasMoreTokens()) {
//            listResult.add(st.nextToken());
//        }
//        String[] result = new String[listResult.size()];
//        for (int i = 0; i < result.length; i++) {
//            result[i] = listResult.get(i);
//        }
//        return result;
//    }
//}
