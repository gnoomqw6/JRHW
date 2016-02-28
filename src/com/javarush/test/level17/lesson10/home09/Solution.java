//package com.javarush.test.level17.lesson10.home09;
//
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
///* Транзакционность
//Сделать метод joinData транзакционным, т.е. если произошел сбой, то данные не должны быть изменены.
//1. Считать с консоли 2 имени файла
//2. Считать построчно данные из файлов. Из первого файла - в allLines, из второго - в forRemoveLines
//В методе joinData:
//3. Если список allLines содержит все строки из forRemoveLines, то удалить из списка allLines все строки,
//   которые есть в forRemoveLines
//4. Если список allLines НЕ содержит каких-либо строк, которые есть в forRemoveLines, то
//4.1. очистить allLines от данных
//4.2. выбросить исключение CorruptedDataException
//Метод joinData должен вызываться в main. Все исключения обработайте в методе main.
//*/
//
//public class Solution {
//    public static List<String> allLines = new ArrayList<String>();
//    public static List<String> forRemoveLines = new ArrayList<String>();
//
//    public static void main(String[] args) {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String name1 = null;
//        String name2 = null;
//        try {
//            name1 = reader.readLine();
//            name2 = reader.readLine();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//
//        FileReader fileReader = null;
//        try {
//            fileReader = new FileReader(name1);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        Scanner scanner = new Scanner(fileReader);
//
//        while (scanner.hasNextLine()) {
//            allLines.add(scanner.nextLine());
//        }
//
//        try {
//            fileReader = new FileReader(name2);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        scanner = new Scanner(fileReader);
//
//        while (scanner.hasNextLine()) {
//            forRemoveLines.add(scanner.nextLine());
//        }
//
//        try {
//            reader.close();
//            fileReader.close();
//            scanner.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        Solution sol = new Solution();
//        try {
//            sol.joinData();
//        }
//        catch(CorruptedDataException e) {
//
//        }
//    }
//
//    public void joinData() throws CorruptedDataException {
//        for (String iter : forRemoveLines) {
//            int count = 0;
//            for (int i = 0; i < allLines.size(); i++) {
//                if (iter.equals(allLines.get(i))) {
//                    allLines.remove(i);
//                    count++;
//                    break;
//                }
//            }
//            if (count == 0) {
//                allLines.clear();
//                throw new CorruptedDataException();
//            }
//        }
//    }
//}
