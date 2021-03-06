//package com.javarush.test.level21.lesson08.task01;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
///* Глубокое клонирование карты
//Клонируйтие объект класса Solution используя глубокое клонирование.
//Данные в карте users также должны клонироваться.
//*/
//public class Solution implements Cloneable {
//
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//        solution.users.put("Hubert", new User(172, "Hubert"));
//        solution.users.put("Zapp", new User(41, "Zapp"));
//        Solution clone = null;
//        clone = solution.clone();
//        System.out.println(solution);
//        System.out.println(clone);
//
//        System.out.println(solution.users);
//        System.out.println(clone.users);
//
//    }
//
//    public Solution clone() {
//        Solution s = new Solution();
//        for (Map.Entry<String, User> pair : this.users.entrySet()) {
//            s.users.put(pair.getKey(), pair.getValue().clone());
//        }
//        return s;
//    }
//
//    protected Map<String, User> users = new LinkedHashMap();
//
//    public static class User implements Cloneable {
//        int age;
//        String name;
//
//        public User(int age, String name) {
//            this.age = age;
//            this.name = name;
//        }
//
//        public User clone() {
//            User u = new User(this.age, this.name);
//            return u;
//        }
//    }
//}
