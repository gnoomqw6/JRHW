//package com.javarush.test.level07.lesson12.home06;
//
///* Семья
//Создай класс Human с полями имя(String), пол(boolean),возраст(int), отец(Human), мать(Human).
//Создай объекты и заполни их так, чтобы получилось: Два дедушки, две бабушки, отец, мать, трое детей.
//Вывести объекты на экран.
//Примечание:
//Если написать свой метод String toString() в классе Human, то именно он будет использоваться
//при выводе объекта на экран.
//Пример вывода:
//Имя: Аня, пол: женский, возраст: 21, отец: Павел, мать: Катя
//Имя: Катя, пол: женский, возраст: 55
//Имя: Игорь, пол: мужской, возраст: 2, отец: Михаил, мать: Аня
//…
//*/
//
//public class Solution
//{
//    public static void main(String[] args)
//    {
//        //напишите тут ваш код
//        Human grandpa1 = new Human();
//        grandpa1.name = "gp1";
//        grandpa1.sex = true;
//        grandpa1.age = 68;
//        //напишите тут ваш код
//        Human grandpa2 = new Human();
//        grandpa2.name = "gp2";
//        grandpa2.sex = true;
//        grandpa2.age = 81;
//        //напишите тут ваш код
//        Human grandma1 = new Human();
//        grandma1.name = "gm1";
//        grandma1.sex = false;
//        grandma1.age = 64;
//        //напишите тут ваш код
//        Human grandma2 = new Human();
//        grandma2.name = "gm2";
//        grandma2.sex = false;
//        grandma2.age = 61;
//
//        Human father = new Human();
//        father.name = "fa";
//        father.sex = true;
//        father.age = 40;
//        father.father = grandpa1;
//        father.mother = grandma1;
//
//        Human mother = new Human();
//        mother.name = "ma";
//        mother.sex = false;
//        mother.age = 37;
//        mother.father = grandpa2;
//        mother.mother = grandma2;
//
//        Human child1 = new Human();
//        child1.name = "ch1";
//        child1.sex = true;
//        child1.age = 19;
//        child1.father = father;
//        child1.mother = mother;
//
//        Human child2 = new Human();
//        child2.name = "ch2";
//        child2.sex = false;
//        child2.age = 15;
//        child2.father = father;
//        child2.mother = mother;
//
//        Human child3 = new Human();
//        child3.name = "ch3";
//        child3.sex = true;
//        child3.age = 10;
//        child3.father = father;
//        child3.mother = mother;
//
//        System.out.println(grandpa1.toString());
//        System.out.println(grandpa2.toString());
//        System.out.println(grandma1.toString());
//        System.out.println(grandma2.toString());
//        System.out.println(father.toString());
//        System.out.println(mother.toString());
//        System.out.println(child1.toString());
//        System.out.println(child2.toString());
//        System.out.println(child3.toString());
//    }
//
//    public static class Human
//    {
//        //напишите тут ваш код
//        String name;
//        boolean sex;
//        int age;
//        Human father;
//        Human mother;
//
//        public String toString()
//        {
//            String text = "";
//            text += "Имя: " + this.name;
//            text += ", пол: " + (this.sex ? "мужской" : "женский");
//            text += ", возраст: " + this.age;
//
//            if (this.father != null)
//                text += ", отец: " + this.father.name;
//
//            if (this.mother != null)
//                text += ", мать: " + this.mother.name;
//
//            return text;
//        }
//    }
//
//}
