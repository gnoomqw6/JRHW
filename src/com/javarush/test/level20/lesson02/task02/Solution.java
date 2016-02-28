//package com.javarush.test.level20.lesson02.task02;
//
//
//import java.io.*;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//
///* Читаем и пишем в файл: JavaRush
//Реализуйте логику записи в файл и чтения из файла для класса JavaRush
//В файле your_file_name.tmp может быть несколько объектов JavaRush
//Метод main реализован только для вас и не участвует в тестировании
//*/
//public class Solution {
//    public static void main(String[] args) {
//        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
//        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
//        try {
////            File your_file_name = File.createTempFile("your_file_name", null);
//            OutputStream outputStream = new FileOutputStream("D:\\file11.txt");
//            InputStream inputStream = new FileInputStream("D:\\file11.txt");
//
//            JavaRush javaRush = new JavaRush();
//            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
//            User user = new User();
//            user.setFirstName("SSSSS");
//            user.setLastName("EEEE");
//            user.setBirthDate(new Date());
//            user.setMale(true);
//            user.setCountry(User.Country.OTHER);
//            javaRush.users.add(user);
//            User user2 = new User();
//            user2.setFirstName("S");
//            user2.setLastName("EE");
//            user2.setBirthDate(new Date());
//            user2.setMale(false);
//            user2.setCountry(User.Country.RUSSIA);
//            javaRush.users.add(user2);
//            javaRush.save(outputStream);
//            outputStream.flush();
//
//            JavaRush loadedObject = new JavaRush();
//            loadedObject.load(inputStream);
//            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны
//            if (javaRush.equals(loadedObject)) {
//                System.out.println("ok");
//            }
//            else System.out.println("no");
//            outputStream.close();
//            inputStream.close();
//
//        } catch (IOException e) {
//            //e.printStackTrace();
//            System.out.println("Oops, something wrong with my file");
//        } catch (Exception e) {
//            //e.printStackTrace();
//            System.out.println("Oops, something wrong with save/load method");
//        }
//    }
//
//    public static class JavaRush {
//        public List<User> users = new ArrayList<>();
//
//        public void save(OutputStream outputStream) {
//            //implement this method - реализуйте этот метод
//            PrintWriter printWriter = new PrintWriter(outputStream);
//            int size = users.size();
//            if (size != 0 && !users.isEmpty()) {
//                printWriter.println(size);
//                for (int i = 0; i < size; i++) {
//                    printWriter.println(users.get(i).getFirstName());
//                    printWriter.println(users.get(i).getLastName());
//                    printWriter.println(users.get(i).getBirthDate().getTime());
//                    printWriter.println(users.get(i).isMale());
//                    printWriter.println(users.get(i).getCountry().getDisplayedName());
//                }
//            }
//            printWriter.close();
//        }
//
//        public void load(InputStream inputStream) {
//            //implement this method - реализуйте этот метод
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            try {
//                if (reader.ready()) {
//                    int size = Integer.parseInt(reader.readLine());
//                    if (size != 0) {
//                        for (int i = 0; i < size; i++) {
//                            User user = new User();
//                            String firstName = reader.readLine();
//                            user.setFirstName(firstName);
//                            String lastName = reader.readLine();
//                            user.setLastName(lastName);
//                            Date birthDate = new Date(Long.parseLong(reader.readLine()));
//                            user.setBirthDate(birthDate);
//                            boolean isMale = Boolean.parseBoolean(reader.readLine());
//                            user.setMale(isMale);
//                            String countryName = reader.readLine();
//                            if (countryName.equals("Ukraine")) {
//                                user.setCountry(User.Country.UKRAINE);
//                            } else if (countryName.equals("Russia")) {
//                                user.setCountry(User.Country.RUSSIA);
//                            } else if (countryName.equals("Other")) {
//                                user.setCountry(User.Country.OTHER);
//                            }
//                            users.add(user);
//                        }
//                    }
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                reader.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}
