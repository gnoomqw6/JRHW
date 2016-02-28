//package com.javarush.test.level17.lesson10.bonus01;
//
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//
///* CRUD
//CrUD - Create, Update, Delete
//Программа запускается с одним из следующих наборов параметров:
//-c name sex bd
//-u id name sex bd
//-d id
//-i id
//Значения параметров:
//name - имя, String
//sex - пол, "м" или "ж", одна буква
//bd - дата рождения в следующем формате 15/04/1990
//-c  - добавляет человека с заданными параметрами в конец allPeople, выводит id (index) на экран
//-u  - обновляет данные человека с данным id
//-d  - производит логическое удаление человека с id
//-i  - выводит на экран информацию о человеке с id: name sex (м/ж) bd (формат 15-Apr-1990)
//
//id соответствует индексу в списке
//Все люди должны храниться в allPeople
//Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
//
//Пример параметров: -c Миронов м 15/04/1990
//*/
//
//
//public class Solution {
//    public static List<Person> allPeople = new ArrayList<Person>();
//
//    static {
//        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
//        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
//    }
//
//    public static void main(String[] args) throws Exception {
//        //start here - начни тут
//        if (args[0].equals("-c") && args.length == 4) {
//            String name = args[1];
//            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
//            if (args[2].equals("м"))
//                allPeople.add(Person.createMale(name, format.parse(args[3])));
//            else allPeople.add(Person.createFemale(name, format.parse(args[3])));
//            System.out.println(allPeople.size()-1);
//        }
//        if (args[0].equals("-u") && args.length == 5) {
//            Person person = allPeople.get(Integer.parseInt(args[1]));
//            person.setName(args[2]);
//            SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
//            person.setBirthDay(format.parse(args[4]));
//            if (args[3].equals("м")) person.setSex(Sex.MALE);
//            else person.setSex(Sex.FEMALE);
//            allPeople.set(Integer.parseInt(args[1]), person);
//        }
//        if (args[0].equals("-d") && args.length == 2) {
//            allPeople.get(Integer.parseInt(args[1])).setName(null);
//            allPeople.get(Integer.parseInt(args[1])).setBirthDay(null);
//            allPeople.get(Integer.parseInt(args[1])).setSex(null);
//        }
//        if (args[0].equals("-i") && args.length == 2) {
//            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//            if (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.MALE))
//                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " м " + sdf.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));
//            else if (allPeople.get(Integer.parseInt(args[1])).getSex().equals(Sex.FEMALE))
//                System.out.println(allPeople.get(Integer.parseInt(args[1])).getName() + " ж " + sdf.format(allPeople.get(Integer.parseInt(args[1])).getBirthDay()));
//        }
//    }
//}