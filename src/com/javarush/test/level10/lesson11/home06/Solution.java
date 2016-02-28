//package com.javarush.test.level10.lesson11.home06;
//
///* Конструкторы класса Human
//Напиши класс Human с 6 полями. Придумай и реализуй 10 различных конструкторов для него.
//Каждый конструктор должен иметь смысл.
//*/
//
//public class Solution
//{
//    public static void main(String[] args)
//    {
//
//    }
//
//    public static class Human
//    {
//        //напишите тут ваши переменные и конструкторы
//        public String name;
//        public int age;
//        public boolean sex;
//        public boolean father = true;
//        public boolean mother = true;
//        public int countChild = 0;
//
//        public Human(String name) {
//            this.name = name;
//        }
//        public Human(String name, int age) {
//            this.name = name;
//            this.age = age;
//        }
//        public Human(String name, int age, boolean sex) {
//            this.name = name;
//            this.age = age;
//            this.sex = sex;
//        }
//        public Human(String name, boolean sex) {
//            this.name = name;
//            this.sex = sex;
//        }
//        public Human(String name, boolean father, boolean mother) {
//            this.name = name;
//            this.father = father;
//            this.mother = mother;
//        }
//        public Human(String name, int age, boolean father, boolean mother) {
//            this.name = name;
//            this.age = age;
//            this.father = father;
//            this.mother = mother;
//        }
//        public Human(String name, int age, boolean sex, boolean father, boolean mother, int countChild) {
//            this.name = name;
//            this.age = age;
//            this.sex = sex;
//            this.father = father;
//            this.mother = mother;
//            this.countChild = countChild;
//        }
//        public Human(String name, int age, int countChild) {
//            this.name = name;
//            this.age = age;
//            this.countChild = countChild;
//        }
//        public Human(String name, boolean father, boolean mother, int countChild) {
//            this.name = name;
//            this.father = father;
//            this.mother = mother;
//            this.countChild = countChild;
//        }
//        public Human(int age, boolean sex) {
//            this.age = age;
//            this.sex = sex;
//        }
//    }
//}
