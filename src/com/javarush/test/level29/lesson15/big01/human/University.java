//package com.javarush.test.level29.lesson15.big01.human;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class University {
//    private String name;
//    private int age;
//    private List<Student> students = new ArrayList<>();
//
//    public University(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//
//    public List<Student> getStudents() {
//        return students;
//    }
//
//    public void setStudents(List<Student> students) {
//        this.students = students;
//    }
//
//    public Student getStudentWithAverageGrade(double averageGrade) {
//        Student student = null;
//        for (Student iter : students) {
//            if (iter.getAverageGrade() == averageGrade) {
//                student = iter;
//                break;
//            }
//        }
//        return student;
//    }
//
//    public Student getStudentWithMaxAverageGrade() {
//        Student student = null;
//        double maxAverageGrade = 0;
//        for (Student iter : students) {
//            if (iter.getAverageGrade() > maxAverageGrade) {
//                maxAverageGrade = iter.getAverageGrade();
//                student = iter;
//            }
//        }
//        return student;
//    }
//
//    public Student getStudentWithMinAverageGrade() {
//        Student student = null;
//        double minAverageGrade = 100;
//        for (Student iter : students) {
//            if (iter.getAverageGrade() < minAverageGrade) {
//                minAverageGrade = iter.getAverageGrade();
//                student = iter;
//            }
//        }
//        return student;
//    }
//
//    public void expel(Student student) {
//        students.remove(student);
//    }
//}
