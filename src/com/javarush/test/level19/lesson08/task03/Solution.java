//package com.javarush.test.level19.lesson08.task03;
//
///* Выводим только цифры
//В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
//Ваша ридер-обертка должна выводить только цифры
//Вызовите готовый метод printSomething(), воспользуйтесь testString
//Верните переменной System.out первоначальный поток
//Вывести модифицированную строку в консоль.
//
//Пример вывода:
//12345678
//*/
//
//import java.io.ByteArrayOutputStream;
//import java.io.PrintStream;
//
//public class Solution {
//    public static TestString testString = new TestString();
//
//    public static void main(String[] args) {
//        PrintStream console = System.out;
//        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        PrintStream stream = new PrintStream(outputStream);
//        System.setOut(stream);
//
//        testString.printSomething();
//
//        String temp = outputStream.toString();
//        char[] array = temp.toCharArray();
//        String result = "";
//        for (char i : array) {
//            switch (i) {
//                case '0':
//                    result += "0";
//                    break;
//                case '1':
//                    result += "1";
//                    break;
//                case '2':
//                    result += "2";
//                    break;
//                case '3':
//                    result += "3";
//                    break;
//                case '4':
//                    result += "4";
//                    break;
//                case '5':
//                    result += "5";
//                    break;
//                case '6':
//                    result += "6";
//                    break;
//                case '7':
//                    result += "7";
//                    break;
//                case '8':
//                    result += "8";
//                    break;
//                case '9':
//                    result += "9";
//                    break;
//                default:
//                    break;
//            }
//        }
//
//        System.setOut(console);
//
//        System.out.println(result);
//    }
//
//    public static class TestString {
//        public void printSomething() {
//            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
//        }
//    }
//}
