//package com.javarush.test.level28.lesson06.home01;
//
//public class MyThread extends Thread {
//    private static int prior = 1;
//
//    public MyThread() {
//        this.setPr();
//    }
//
//    public MyThread(Runnable target) {
//        super(target);
//        this.setPr();
//    }
//
//    public MyThread(ThreadGroup group, Runnable target) {
//        super(group, target);
//        this.setPr();
//    }
//
//    public MyThread(String name) {
//        super(name);
//        this.setPr();
//    }
//
//    public MyThread(ThreadGroup group, String name) {
//        super(group, name);
//        this.setPr();
//    }
//
//    public MyThread(Runnable target, String name) {
//        super(target, name);
//        this.setPr();
//    }
//
//    public MyThread(ThreadGroup group, Runnable target, String name) {
//        super(group, target, name);
//        this.setPr();
//    }
//
//    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
//        super(group, target, name, stackSize);
//        this.setPr();
//    }
//
//    private void setPr() {
//        if (!this.getThreadGroup().getName().equals("main")) {
//            int groupPriority = this.getThreadGroup().getMaxPriority();
//            int priorForSet = prior % 10;
//            if (priorForSet == 0) {
//                priorForSet = 10;
//            }
//            if (priorForSet <= groupPriority) {
//                this.setPriority(priorForSet);
//            } else {
//                this.setPriority(groupPriority);
//            }
//            prior++;
//        } else {
//            int priorForSet = prior % 10;
//            if (priorForSet == 0) {
//                priorForSet = 10;
//            }
//            this.setPriority(priorForSet);
//            prior++;
//        }
//    }
//}
