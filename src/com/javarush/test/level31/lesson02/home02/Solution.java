//package com.javarush.test.level31.lesson02.home02;
//
//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Queue;
//import java.util.concurrent.ArrayBlockingQueue;
//
///* Находим все файлы
//Реализовать логику метода getFileTree, который должен в директории root найти список всех файлов включая вложенные.
//Используйте очередь, рекурсию не используйте.
//Верните список всех путей к найденным файлам, путь к директориям возвращать не надо.
//Путь должен быть абсолютный.
//*/
//public class Solution {
//    public static List<String> getFileTree(String root) throws IOException {
//        List<String> fileTree = new ArrayList<>();
//        File rootDir = new File(root);
//        Queue<File> queue = new ArrayBlockingQueue<File>(100);
//        queue.add(rootDir);
//        while (!queue.isEmpty()) {
//            File dir = queue.poll();
//            for (File file : dir.listFiles()) {
//                if (file.isDirectory()) {
//                    queue.add(file);
//                }
//                else {
//                    fileTree.add(file.getAbsolutePath());
//                }
//            }
//        }
//        return fileTree;
//    }
//}
