//package com.javarush.test.level19.lesson08.task04;
//
///* Решаем пример
//В методе main подмените объект System.out написанной вами ридер-оберткой по аналогии с лекцией
//Ваша ридер-обертка должна выводить на консоль решенный пример
//Вызовите готовый метод printSomething(), воспользуйтесь testString
//Верните переменной System.out первоначальный поток
//
//Возможные операции: + - *
//Шаблон входных данных и вывода: a [знак] b = c
//Отрицательных и дробных чисел, унарных операторов - нет.
//
//Пример вывода:
//3 + 6 = 9
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
//        String str = outputStream.toString().trim();
//        String[] arr = str.split(" ");
//        int a = Integer.parseInt(arr[0]);
//        int b = Integer.parseInt(arr[2]);
//        int result = 0;
//        if (arr[1].equals("+")) result = a + b;
//        else if (arr[1].equals("-")) result = a - b;
//        else if (arr[1].equals("*")) result = a * b;
//
//        System.setOut(console);
//
//        System.out.println(str + " " + result);
//    }
//
//    public static class TestString {
//        public void printSomething() {
//            System.out.println("3 + 6 = ");
//        }
//    }
//}
//
