//package com.javarush.test.level20.lesson10.home02;
//
//import java.io.IOException;
//import java.io.ObjectInputStream;
//import java.io.Serializable;
//
///* Десериализация
//На вход подается поток, в который записан сериализованный объект класса A либо класса B.
//Десериализуйте объект в методе getOriginalObject предварительно определив, какого именно типа там объект.
//Реализуйте интерфейс Serializable где необходимо.
//*/
//public class Solution implements Serializable {
//    private final static long serialVersionUID = 3L;
//    public A getOriginalObject(ObjectInputStream objectStream) {
//        A obj = null;
//        try {
//            obj = (A) objectStream.readObject();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        if (obj.serialVersionUID == 1L) return obj;
//        else return (B) obj;
//    }
//
//    public class A implements Serializable {
//        private final static long serialVersionUID = 1L;
//    }
//
//    public class B extends A {
//        private final static long serialVersionUID = 2L;
//        public B() {
//            System.out.println("inside B");
//        }
//    }
//}
