//package com.javarush.test.level08.lesson11.home06;
//
///* Вся семья в сборе
//1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
//2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
//3. Вывести все объекты Human на экран.
//*/
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class Solution
//{
//    public static void main(String[] args)
//    {
//        //напишите тут ваш код
//        List<Human> list = new ArrayList<Human>();
//
//        Human ch1 = new Human();
//        ch1.name = "childa";
//        ch1.sex = true;
//        ch1.age = 24;
//        list.add(ch1);
//
//        Human ch2 = new Human();
//        ch2.name = "childb";
//        ch2.sex = true;
//        ch2.age = 17;
//        list.add(ch2);
//
//        Human ch3 = new Human();
//        ch3.name = "childc";
//        ch3.sex = false;
//        ch3.age = 14;
//        list.add(ch3);
//
//        Human pa = new Human();
//        pa.name = "papa";
//        pa.sex = true;
//        pa.age = 47;
//        pa.children.add(ch1);
//        pa.children.add(ch2);
//        pa.children.add(ch3);
//        list.add(pa);
//
//        Human ma = new Human();
//        ma.name = "mama";
//        ma.sex = false;
//        ma.age = 42;
//        ma.children.add(ch1);
//        ma.children.add(ch2);
//        ma.children.add(ch3);
//        list.add(ma);
//
//        Human gpa1 = new Human();
//        gpa1.name = "grandpa1";
//        gpa1.sex = true;
//        gpa1.age = 86;
//        gpa1.children.add(pa);
//        list.add(gpa1);
//
//        Human gpa2 = new Human();
//        gpa2.name = "grandpa2";
//        gpa2.sex = true;
//        gpa2.age = 84;
//        gpa2.children.add(ma);
//        list.add(gpa2);
//
//        Human gma1 = new Human();
//        gma1.name = "grandma1";
//        gma1.sex = false;
//        gma1.age = 78;
//        gma1.children.add(pa);
//        list.add(gma1);
//
//        Human gma2 = new Human();
//        gma2.name = "grandma2";
//        gma2.sex = false;
//        gma2.age = 73;
//        gma2.children.add(ma);
//        list.add(gma2);
//
//        for (Human i : list) {
//            System.out.println(i);
//        }
//    }
//
//    public static class Human
//    {
//        //напишите тут ваш код
//        String name;
//        boolean sex;
//        int age;
//        ArrayList<Human> children = new ArrayList<Human>();
//
//        public String toString()
//        {
//            String text = "";
//            text += "Имя: " + this.name;
//            text += ", пол: " + (this.sex ? "мужской" : "женский");
//            text += ", возраст: " + this.age;
//
//            int childCount = this.children.size();
//            if (childCount > 0)
//            {
//                text += ", дети: "+this.children.get(0).name;
//
//                for (int i = 1; i < childCount; i++)
//                {
//                    Human child = this.children.get(i);
//                    text += ", "+child.name;
//                }
//            }
//
//            return text;
//        }
//    }
//
//}
