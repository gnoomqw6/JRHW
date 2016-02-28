//package com.javarush.test.level18.lesson03.task03;
//
//import java.io.FileInputStream;
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Map;
//import java.util.HashMap;
//
///* Самые частые байты
//Ввести с консоли имя файла
//Найти байт или байты с максимальным количеством повторов
//Вывести их на экран через пробел
//Закрыть поток ввода-вывода
//*/
//
//// МОЕ РЕШЕНИЕ НЕВЕРНОЕ
//
////public class Solution {
////    public static void main(String[] args) throws Exception {
////        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
////        String name = reader.readLine();
////        reader.close();
////
////        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
////
////        FileInputStream inputStream = new FileInputStream(name);
////        int max = 0;
////
////        if (inputStream.available() > 0) {
////            map.put(inputStream.read(), 0);
////        }
////
////        while (inputStream.available() > 0) {
////            boolean isFound = false;
////            int temp = inputStream.read();
////            for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
////                if (temp == pair.getKey()) {
////                    isFound = true;
////                    int n = pair.getValue();
////                    pair.setValue(++n);
////                    max = map.get(temp);
////                    break;
////                }
////                if (isFound == false) map.put(temp, 0);
////                max = map.get(temp);
////            }
////        }
////
////        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
////            if (pair.getValue() > max) max = pair.getValue();
////        }
////
////        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
////            if (pair.getValue() == max) System.out.print(pair.getKey() + " ");
////        }
////        System.out.println();
////
////        inputStream.close();
////    }
////}
//
//public class Solution {
//    public static void main(String[] args) throws Exception {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        FileInputStream file = new FileInputStream(reader.readLine());
//        int[] bytesArray = new int[256];
//        while (file.available() > 0)
//        {
//            int currentByte = file.read();
//            bytesArray[currentByte]++;
//        }
//        int max=0;
//        for(int x=0;x<bytesArray.length;x++){
//            if(bytesArray[x]>max){max=bytesArray[x];
//            }
//        }
//        for(int x=0;x<bytesArray.length;x++){
//            if(bytesArray[x]==max) System.out.print(x + " ");
//        }
//        reader.close();
//        file.close();
//    }
//}