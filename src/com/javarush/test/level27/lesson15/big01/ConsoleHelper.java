//package com.javarush.test.level27.lesson15.big01;
//
//import com.javarush.test.level27.lesson15.big01.kitchen.Dish;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.List;
//
//public class ConsoleHelper {
//    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//
//    public static void writeMessage(String message) {
//        System.out.println(message);
//    }
//
//    public static String readString() throws IOException {
//        return reader.readLine();
//    }
//
//    public static List<Dish> getAllDishesForOrder() throws IOException
//    {
//        List<Dish> dishList = new ArrayList<>();
//        if (Dish.values().length > 0)
//        {
//            writeMessage("Choose a dish: " + Dish.allDishesToString());
//            String dish;
//            while (!"exit".equalsIgnoreCase(dish = readString()))
//            {
//                try
//                {
//                    dishList.add(Dish.valueOf(dish));
//                }
//                catch (IllegalArgumentException e)
//                {
//                    ConsoleHelper.writeMessage(dish + " is not detected");
//                }
//            }
//        }
//        return dishList;
//    }
//}
