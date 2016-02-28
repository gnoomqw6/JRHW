//package com.javarush.test.level21.lesson16.big01;
//
//import java.util.ArrayList;
//
///**
// * Created by Sergey on 10.11.2015.
// */
//public class Hippodrome {
//    public static void main(String[] args) throws InterruptedException {
//        game = new Hippodrome();
//        Horse horse1 = new Horse("AAA", 3, 0);
//        Horse horse2 = new Horse("BBB", 3, 0);
//        Horse horse3 = new Horse("CCC", 3, 0);
//
//        game.getHorses().add(horse1);
//        game.getHorses().add(horse2);
//        game.getHorses().add(horse3);
//
//        game.run();
//        game.printWinner();
//    }
//    public static Hippodrome game;
//
//    private ArrayList<Horse> horses = new ArrayList<Horse>();
//
//    public ArrayList<Horse> getHorses() {
//        return horses;
//    }
//
//    public void run() throws InterruptedException {
//        for (int i = 0; i < 100; i++) {
//            move();
//            print();
//            Thread.sleep(200);
//        }
//    }
//
//    public void move() {
//        for (Horse h : horses) {
//            h.move();
//        }
//    }
//
//    public void print() {
//        for (Horse h : horses) {
//            h.print();
//        }
//        System.out.println();
//        System.out.println();
//        System.out.println();
//    }
//
//    public Horse getWinner() {
//        double max = 0;
//        Horse winner = null;
//        for (Horse h : horses) {
//            if (h.getDistance() > max) {
//                max = h.getDistance();
//                winner = h;
//            }
//        }
//        return winner;
//    }
//
//    public void printWinner() {
//        System.out.println("Winner is " + getWinner().getName() + "!");
//    }
//}
