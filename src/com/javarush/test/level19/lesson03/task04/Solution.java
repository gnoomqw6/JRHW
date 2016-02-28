//package com.javarush.test.level19.lesson03.task04;
//
//import java.io.IOException;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import java.util.Scanner;
//
///* И еще один адаптер
//Адаптировать Scanner к PersonScanner.
//Классом-адаптером является PersonScannerAdapter.
//Данные в файле хранятся в следующем виде:
//Иванов Иван Иванович 31 12 1950
//
//В файле хранится большое количество людей, данные одного человека находятся в одной строке.
//Метод read() должен читать данные одного человека.
//*/
//
//public class Solution {
//    public static class PersonScannerAdapter implements PersonScanner{
//        private Scanner scanner;
//
//        public PersonScannerAdapter(Scanner scanner) {
//            this.scanner = scanner;
//        }
//
//        @Override
//        public Person read() throws IOException {
//            String[] pers = this.scanner.nextLine().split(" ");
//            Calendar calendar = new GregorianCalendar(Integer.parseInt(pers[5]), Integer.parseInt(pers[4]) - 1, Integer.parseInt(pers[3]));
//            Person person = new Person(pers[1], pers[2], pers[0], calendar.getTime());
//            return person;
//        }
//
//        @Override
//        public void close() throws IOException {
//            this.scanner.close();
//        }
//    }
//}
