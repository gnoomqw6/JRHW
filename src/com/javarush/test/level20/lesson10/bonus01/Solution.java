//package com.javarush.test.level20.lesson10.bonus01;
//
//import java.util.*;
//
///* Алгоритмы-числа
//Число S состоит из M чисел, например, S=370 и M(количество цифр)=3
//Реализовать логику метода getNumbers, который должен среди натуральных чисел меньше N (long)
//находить все числа, удовлетворяющие следующему критерию:
//число S равно сумме его цифр, возведенных в M степень
//getNumbers должен возвращать все такие числа в порядке возрастания
//
//Пример искомого числа:
//370 = 3*3*3 + 7*7*7 + 0*0*0
//8208 = 8*8*8*8 + 2*2*2*2 + 0*0*0*0 + 8*8*8*8
//
//На выполнение дается 10 секунд и 50 МБ памяти.
//*/
//public class Solution {         //РЕШЕНО НА КОМПЕ
//
//    public static void main(String[] args) throws InterruptedException {
//        Date startDate = new Date();
//        long startMem = Runtime.getRuntime().freeMemory();
//        int[] arra = getNumbers(Integer.MAX_VALUE);
//        for (int anArra : arra) {
//            System.out.print(anArra + " ");
//        }
//        Date endDate = new Date();
//        long endMem = Runtime.getRuntime().freeMemory();
//        System.out.println();
//        long time = endDate.getTime() - startDate.getTime();
//        long mem = (startMem - endMem) / 1024;
//        System.out.printf("Это заняло %d мс и %d кб памяти\n", time, mem);
//    }
//
//    static List<Integer> listResult = new ArrayList<>();   //лист реально найденных чисел Армстронга
//    static double[][] matrix;           //матрица вычисленных значений степени
//
//    public static int[] getNumbers(int N) throws InterruptedException {
//
//        //находим максимальное количество цифр в числе
//        int stepen = getCountsOfDigits(N);
//
//        matrix = new double[10][stepen + 1];            //заполняем матрицу результатами возведения в степень
//        for (int i = 0; i < 10; i++) {                  //далее для возведения числа в нужную степень надо будет
//            for (int j = 0; j < stepen + 1; j++) {      //вернуть matrix[n][m], где n - число, m - степень
//                matrix[i][j] = Math.pow(i, j);
//            }
//        }
//
//        for (int i1 = 0; i1 < 10; i1++) {
//
//        }
//
//        int[] result = new int[listResult.size()];
//
//        for (int i = 0; i < result.length; i++) {
//            result[i] = listResult.get(i);
//        }
//
//        Arrays.sort(result);
//
//        return result;
//    }
//
//    public static int getCountsOfDigits(int number) {
//        return (int)(Math.log10(number)+1);
//    }
//
//    public static void toArray(int[] array, int n) {
//        int ind = array.length - 1;
//        while (n > 0) {
//            array[ind] = n % 10;
//            n /= 10;
//            ind--;
//        }
//    }
//}
