//package com.javarush.test.level27.lesson09.home01;
//
//public class TransferObject {
//    private int value;
//    protected volatile boolean isValuePresent = false; //use this variable
//
//    public synchronized int get() {
//        if (isValuePresent == true) {
//            System.out.println("Got: " + value);
//            isValuePresent = false;
//            notifyAll();
//            return value;
//        }
//        else try {
//            this.wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        return value;
//    }
//
//    public synchronized void put(int value) {
//        if (isValuePresent == false) {
//            this.value = value;
//            System.out.println("Put: " + value);
//            isValuePresent = true;
//            notifyAll();
//        }
//        else try {
//            this.wait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//}
