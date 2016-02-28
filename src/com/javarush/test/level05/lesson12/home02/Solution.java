//package com.javarush.test.level05.lesson12.home02;
//
///* Man and Woman
//1. Внутри класса Solution создай public static классы Man и Woman.
//2. У классов должны быть поля: name(String), age(int), address(String).
//3. Создай конструкторы, в которые передаются все возможные параметры.
//4. Создай по два объекта каждого класса со всеми данными используя конструктор.
//5. Объекты выведи на экран в таком формате [name + " " + age + " " + address].
//*/
//
//public class Solution
//{
//    public static void main(String[] args)
//    {
//        //создай по два объекта каждого класса тут
//        Man man1 = new Man("aaa", 19, "aaaaaaa");
//        Man man2 = new Man("bbb", 21, "bbbbbbb");
//
//        Woman woman1 = new Woman("ccc", 18, "ccccccc");
//        Woman woman2 = new Woman("ddd", 25, "ddddddd");
//
//        //выведи их на экран тут
//        man1.print();
//        man2.print();
//        woman1.print();
//        woman2.print();
//    }
//
//    //добавьте тут ваши классы
//    public static class Man {
//        private String name;
//        private int age;
//        private String address;
//
//        public Man(String name, int age, String address) {
//            this.name = name;
//            this.age = age;
//            this.address = address;
//        }
//
//        public void print() {
//            System.out.println(this.name + " " + this.age + " " + this.address);
//        }
//    }
//
//    public static class Woman {
//        private String name;
//        private int age;
//        private String address;
//
//        public Woman(String name, int age, String address) {
//            this.name = name;
//            this.age = age;
//            this.address = address;
//        }
//
//        public void print() {
//            System.out.println(this.name + " " + this.age + " " + this.address);
//        }
//    }
//}
