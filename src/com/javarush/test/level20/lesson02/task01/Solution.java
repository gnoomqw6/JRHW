//package com.javarush.test.level20.lesson02.task01;
////
/////* Читаем и пишем в файл: Human
////Реализуйте логику записи в файл и чтения из файла для класса Human
////Поле name в классе Human не может быть пустым
////В файле your_file_name.tmp может быть несколько объектов Human
////Метод main реализован только для вас и не участвует в тестировании
////*/
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
///* Читаем и пишем в файл: Human
//Реализуйте логику записи в файл и чтения из файла для класса Human
//Поле name в классе Human не может быть пустым
//В файле your_file_name.tmp может быть несколько объектов Human
//Метод main реализован только для вас и не участвует в тестировании
//*/
//public class Solution {             //ЧУЖОЙ КОД, ДОЛГО РАЗБИРАЛСЯ, ЗАМУДРЕНО, НАВЕРНОЕ МОЖНО БЫЛО СДЕЛАТЬ ПРОЩЕ
//    public static void main(String[] args) {
//        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
//        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
//        try {
//            File your_file_name = File.createTempFile("C:\\200201.txt", null);
//            OutputStream outputStream = new FileOutputStream("C:\\200201.txt");
//            InputStream inputStream = new FileInputStream("C:\\200201.txt");
//            Asset as = new Asset("home1");
//            as.setPrice(123.124);
//            Human first = new Human("perviy", as, new Asset("car1"));
//            Human second = new Human("никитич", new Asset("home"), new Asset("car"));
//            first.save(outputStream);
//            second.save(outputStream);
//            //загружаем
//            Human FirstPerson = new Human();
//            FirstPerson.load(inputStream);
//            Human secondPerson = new Human();
//            secondPerson.load(inputStream);
//            //выдаем полученное имя
//            System.out.println(FirstPerson.name);
//            for (Asset a : FirstPerson.assets) System.out.println(a.getName() + " " + a.getPrice());
//            System.out.println(secondPerson.name);
//            for (Asset a : secondPerson.assets) System.out.println(a.getName() + " " + a.getPrice());
//            //Human ivanov = new Human("Ivanov", null);
//            //System.out.println(ivanov.assets==null);
//        /*ivanov.save(outputStream);
//        outputStream.flush();
//        Human ivanov2 = new Human("Ivanov", null);
//        ivanov2.save(outputStream);
//        outputStream.flush();
//        outputStream.close();
//        Human somePerson = new Human();
//        somePerson.load(inputStream);
//        inputStream.close();
//        System.out.println(ivanov.equals(somePerson));*/
//        } catch (IOException e) {
//            //e.printStackTrace();
//            System.out.println("Oops, something wrong with my file");
//        } catch (Exception e) {
//            //e.printStackTrace();
//            System.out.println("Oops, something wrong with save/load method");
//        }
//    }
//
//    public static class Human {
//        public String name;
//        public List<Asset> assets = new ArrayList<Asset>();
//
//        public Human() {
//        }
//
//        @Override
//        public boolean equals(Object obj) {
//            if (null == obj) return false;
//            if (obj.getClass() != this.getClass()) return false;
//            Human other = (Human) obj;
//            if (null == other.name) return false;
//            if (!other.name.equals(this.name)) return false;
//            if (other.name.isEmpty()) return false;
//            if (this.name.isEmpty()) return false;
//            //if (null == other.assets || null == assets) return false;
//            if (null == other.assets && null == this.assets) return true;
//            if (null != other.assets && null == assets) return false;
//            if (other.assets.isEmpty() && !this.assets.isEmpty()) return false;
//            if (other.assets.size() != this.assets.size()) return false;
//            for (int i = 0; i < this.assets.size(); i++) {
//                if (this.assets.get(i).getName() != null && other.assets.get(i).getName() != null) {
//                    if (!this.assets.get(i).getName().equals(other.assets.get(i).getName())) return false;
//                } else return false;
//                //if (this.assets.get(i).getPrice() != other.assets.get(i).getPrice())return false;
//            }
//            return true;
//        }
//
//        public Human(String name, Asset... assets) {
//            this.name = name;
//            if (assets != null) {
//                this.assets.addAll(Arrays.asList(assets));
//            }
//        }
//
//        public void save(OutputStream outputStream) throws Exception {
//            //PrintWriter printWriter = new PrintWriter(outputStream);
//            if (null != name && !name.isEmpty()) {
//                outputStream.write(name.getBytes());
//                outputStream.write("\r\n".getBytes());
//            } else return;
//            String isAssetsPresent = assets.isEmpty() ? "no" : "yes";
//            outputStream.write(String.valueOf(isAssetsPresent).getBytes());
//            outputStream.write("\r\n".getBytes());
//            if (isAssetsPresent.equals("yes")) {
//                outputStream.write(String.valueOf(assets.size()).getBytes());
//                outputStream.write("\r\n".getBytes());
//                for (Asset asset : assets) {
//                    outputStream.write(asset.getName().getBytes());
//                    outputStream.write("\r\n".getBytes());
//                    outputStream.write(String.valueOf(asset.getPrice()).getBytes());
//                    outputStream.write("\r\n".getBytes());
//                }
//            }
//        }
//
//        public void load(InputStream inputStream) throws Exception {
//            while (inputStream.available() > 0) {
//                this.name = readLine(inputStream);
//                String isAssetsPresent = "";
//                isAssetsPresent = readLine(inputStream);
//                if (isAssetsPresent.equals("yes")) {
//                    String s = "";
//                    int size = Integer.parseInt(readLine(inputStream));
//                    //if (size != 0) assets.removeAll(assets);
//                    for (int i = 0; i < size; i++) {
//                        s = readLine(inputStream);
//                        Asset as = new Asset(s);
//                        try {
//                            as.setPrice(Double.parseDouble(readLine(inputStream)));
//                        } catch (Exception e) {
//                        }
//                        this.assets.add(as);
//                    }
//                    return;
//                } else if (isAssetsPresent.equals("no")) {
//                    //this.assets.size()
//                    //System.out.println("AVALIABLE "+ inputStream.available());
//                    return;
//                }
//            }
//        }
//
//        public String readLine(InputStream inputStream) {
//            String s = "";
//            try {
//                while (inputStream.available() > 0) {
//                    char tmp = (char) inputStream.read();
//                    if (tmp == '\r') {
//                        tmp = (char) inputStream.read();
//                        if (tmp == '\n') {
//                            //inputStream.read();
//                            break;
//                        }
//                    }
//                    s += tmp;
//                }
//            } catch (IOException e) {
//                return null;
//            }
//            return s;
//        }
//    }
//}