//package com.javarush.test.level17.lesson10.bonus02;
//
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//
///* CRUD 2
//CrUD Batch - multiple Creation, Updates, Deletion
//!!!РЕКОМЕНДУЕТСЯ выполнить level17.lesson10.bonus01 перед этой задачей!!!
//
//Программа запускается с одним из следующих наборов параметров:
//-c name1 sex1 bd1 name2 sex2 bd2 ...
//-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
//-d id1 id2 id3 id4 ...
//-i id1 id2 id3 id4 ...
//Значения параметров:
//name - имя, String
//sex - пол, "м" или "ж", одна буква
//bd - дата рождения в следующем формате 15/04/1990
//-с  - добавляет всех людей с заданными параметрами в конец allPeople,
//      выводит id (index) на экран в соответствующем порядке
//-u  - обновляет соответствующие данные людей с заданными id
//-d  - производит логическое удаление всех людей с заданными id
//-i  - выводит на экран информацию о всех людях с заданными id: name sex bd
//
//id соответствует индексу в списке
//Формат вывода даты рождения 15-Apr-1990
//Все люди должны храниться в allPeople
//Порядок вывода данных соответствует вводу данных
//Обеспечить корректную работу с данными для множества нитей (чтоб не было затирания данных)
//Используйте Locale.ENGLISH в качестве второго параметра для SimpleDateFormat
//*/
//
////public class Solution {
////    public static List<Person> allPeople = new ArrayList<Person>();
////    static {
////        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
////        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
////    }
////
////    public static void main(String[] args) throws Exception{
////        //start here - начни тут
////        if (args[0].equals("-c") && (args.length - 1) % 3 == 0) {
////            synchronized (Solution.class) {
////                int i = 1;
////                while (i < args.length) {
////                    String name = args[i++];
////                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
////                    if (args[i++].equals("м"))
////                        allPeople.add(Person.createMale(name, format.parse(args[i])));
////                    else
////                        allPeople.add(Person.createFemale(name, format.parse(args[i])));
////                    System.out.println(allPeople.size() - 1);
////                    if (i != (args.length - 1)) i++;
////                }
////            }
////        }
////
////        if (args[0].equals("-u") && (args.length - 1) % 4 == 0) {
////            synchronized (Solution.class) {
////                int i = 1;
////                while (i < args.length) {
////                    int personID = i;
////                    Person person = allPeople.get(Integer.parseInt(args[i++]));
////                    person.setName(args[i++]);
////                    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
////                    if (args[i++].equals("м")) person.setSex(Sex.MALE);
////                    else person.setSex(Sex.FEMALE);
////                    person.setBirthDay(format.parse(args[i]));
////                    allPeople.set(Integer.parseInt(args[personID]), person);
////                    if (i != (args.length - 1)) i++;
////                }
////            }
////        }
////
////        if (args[0].equals("-d") && args.length > 1) {
////            synchronized (Solution.class) {
////                int i = 1;
////                while (i < args.length) {
////                    allPeople.get(Integer.parseInt(args[i])).setName(null);
////                    allPeople.get(Integer.parseInt(args[i])).setBirthDay(null);
////                    allPeople.get(Integer.parseInt(args[i])).setSex(null);
////                    if (i != (args.length - 1)) i++;
////                }
////            }
////        }
////
////        if (args[0].equals("-i") && args.length > 1) {
////            synchronized (Solution.class) {
////                int i = 1;
////                while (i < args.length) {
////                    SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
////                    if (allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.MALE))
////                        System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " м " + sdf.format(allPeople.get(Integer.parseInt(args[i])).getBirthDay()));
////                    else if (allPeople.get(Integer.parseInt(args[i])).getSex().equals(Sex.FEMALE))
////                        System.out.println(allPeople.get(Integer.parseInt(args[i])).getName() + " ж " + sdf.format(allPeople.get(Integer.parseInt(args[i])).getBirthDay()));
////                    if (i != (args.length - 1)) i++;
////                }
////            }
////        }
////    }
////}
//
//public class Solution {
//    public static List<Person> allPeople = new ArrayList<Person>();
//    static {
//        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
//        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
//    }
//    public static void main(String[] args) throws Exception{
//        if(args.length<2) return;
//        if(args[0].equals("-c")){
//            createC(args);
//        }
//        else if(args[0].equals("-u")){
//            updateU(args);
//        }
//        else if(args[0].equals("-d")){
//            deleteD(args);
//        }
//        else if(args[0].equals("-i")){
//            informI(args);
//        }
//        else {
//            return;
//        }
//    }
//    public synchronized static void createC(String[] args) throws Exception {
//        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
//        Date date=null;
//        int id=0;
//        int checkSex=0;
//        if((args.length-1)%3!=0) return;  // почему,  может принять так как есть ???
//        //  просто обработать правильно
//        for (int i = 2; i <args.length; i=i+3) {
//            if(!(args[i].equals("м") || args[i].equals("ж"))){
//                checkSex++;
//            }
//        }
//        if(checkSex!=0)return;  // тоже самое ну и т.д.
//        for (int i = 1; i <args.length ; i=i+3) {
//            date = format.parse(args[i+2]);
//            if(args[i+1].equals("м")){
//                allPeople.add(allPeople.size(),Person.createMale(args[i], date));
//                System.out.println(allPeople.size() - 1);
//            }
//            else if(args[i+1].equals("ж")){
//                allPeople.add(allPeople.size(),Person.createFemale(args[i], date));
//                System.out.println(allPeople.size() - 1);
//            }
//        }
//    }
//    public synchronized static void updateU(String[] args) throws Exception{
//        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
//        Date date=null;
//        int id=0;
//        int checkSex=0;
//        if((args.length-1)%4!=0) return;
//        for (int i = 3; i <args.length; i=i+4) {
//            if(!(args[i].equals("м") || args[i].equals("ж"))){
//                checkSex++;
//            }
//        }
//        if(checkSex!=0)return;
//        for (int i = 1; i <args.length ; i=i+4) {
//            id =Integer.parseInt(args[i]);
//            date = format.parse(args[i+3]);
//            if(args[i+2].equals("м")){
//                allPeople.get(id).setSex(Sex.MALE);
//                allPeople.get(id).setName(args[i+1]);
//                allPeople.get(id).setBirthDay(date);
//            } else if(args[i+2].equals("ж")){
//                allPeople.get(id).setSex(Sex.FEMALE);
//                allPeople.get(id).setName(args[i+1]);
//                allPeople.get(id).setBirthDay(date);
//            }
//        }
//    }
//    public synchronized static void deleteD(String[] args){
//        int id=0;
//        for (int i = 1; i <args.length ; i++) {
//            id =Integer.parseInt(args[i]);
//            allPeople.get(id).setSex(null);
//            allPeople.get(id).setBirthDay(null);
//            allPeople.get(id).setName(null);
//        }
//    }
//    public static void informI(String[] args){
//        DateFormat format2 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
//        Date date=null;
//        int id=0;
//        for (int i = 1; i <args.length ; i++) {
//            id =Integer.parseInt(args[i]);
//            String sex="";
//            if(allPeople.get(id).getSex()==Sex.MALE){
//                sex="м";
//            }
//            else if(allPeople.get(id).getSex()==Sex.FEMALE){
//                sex="ж";
//            }
//            date = allPeople.get(id).getBirthDay();
//            System.out.println(allPeople.get(id).getName() + " " + sex + " " + format2.format(date));
//        }
//    }
//}
