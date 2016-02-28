//package com.javarush.test.level25.lesson11.task02;
//
///* Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
//Обеспечьте переуступку кванта времени (переход хода для текущей нити) для последовательных выводов текста в консоль
//*/
//public class Solution {         //непонятно - все и так вроде выводится нормально. решить, когда будет подписка
//    public static class YieldRunnable implements Runnable {
//        private int index;
//
//        public YieldRunnable(int index) {
//            this.index = index;
//        }
//
//        public void run() {
//            System.out.println("begin-" + index);
//            Thread.yield();
//            System.out.println("end-" + index);
//        }
//    }
//}
