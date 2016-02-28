//package com.javarush.test.level20.lesson07.task04;
//
//import java.io.*;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//
///* Serializable Solution
//Сериализуйте класс Solution.
//Подумайте, какие поля не нужно сериализовать, пометить ненужные поля — transient.
//Объект всегда должен содержать актуальные итоговые данные.
//Метод main не участвует в тестировании.
//Написать код проверки самостоятельно в методе main:
//1) создать файл, открыть поток на чтение (input stream) и на запись(output stream)
//2) создать экземпляр класса Solution - savedObject
//3) записать в поток на запись savedObject (убедитесь, что они там действительно есть)
//4) создать другой экземпляр класса Solution с другим параметром
//5) загрузить из потока на чтение объект - loadedObject
//6) проверить, что savedObject.string равна loadedObject.string
//7) обработать исключения
//*/
//public class Solution implements Serializable {
//    public static void main(String[] args) {
//        File file = new File("D:\\file11.txt");
//        InputStream inputStream = null;
//        try {
//            inputStream = new FileInputStream(file);
//        } catch (FileNotFoundException e) {
//            System.out.println("FIS error");
//        }
//        OutputStream outputStream = null;
//        try {
//            outputStream = new FileOutputStream(file);
//        } catch (FileNotFoundException e) {
//            System.out.println("FOS error");
//        }
//        Solution savedObject = new Solution(8);
//        ObjectOutputStream out = null;
//        try {
//            out = new ObjectOutputStream(outputStream);
//        } catch (IOException e) {
//            System.out.println("out creation error");
//        }
//        try {
//            out.writeObject(savedObject);
//        } catch (IOException e) {
//            System.out.println("write error");
//        }
//        Solution loadedObject = null;
//        ObjectInputStream in = null;
//        try {
//            in = new ObjectInputStream(inputStream);
//        } catch (IOException e) {
//            System.out.println("in creation error");
//        }
//        try {
//            loadedObject = (Solution) in.readObject();
//        } catch (IOException e) {
//            System.out.println("read error");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        if (savedObject.string.equals(loadedObject.string)) {
//            System.out.println("ok");
//        }
//    }
//
//    transient private final String pattern = "dd MMMM yyyy, EEEE";
//    transient private Date currentDate;
//    transient private int temperature;
//    String string;
//
//    public Solution(int temperature) {
//        this.currentDate = new Date();
//        this.temperature = temperature;
//
//        string = "Today is %s, and current temperature is %s C";
//        SimpleDateFormat format = new SimpleDateFormat(pattern);
//        this.string = String.format(string, format.format(currentDate), temperature);
//    }
//
//    @Override
//    public String toString() {
//        return this.string;
//    }
//}
