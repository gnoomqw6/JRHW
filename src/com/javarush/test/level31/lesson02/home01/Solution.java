//package com.javarush.test.level31.lesson02.home01;
//
///* Проход по дереву файлов
//1. На вход метода main подаются два параметра.
//Первый - path - путь к директории, второй - resultFileAbsolutePath - имя файла, который будет содержать результат.
//2. Для каждого файла в директории path и в ее всех вложенных поддиректориях выполнить следующее:
//2.1. Если у файла длина в байтах больше 50, то удалить его.
//2.2. Если у файла длина в байтах НЕ больше 50, то для всех таких файлов:
//2.2.1. отсортировать их по имени файла в возрастающем порядке, путь не учитывать при сортировке
//2.2.2. переименовать resultFileAbsolutePath в 'allFilesContent.txt'
//2.2.3. в allFilesContent.txt последовательно записать содержимое всех файлов из п. 2.2.1. Тела файлов разделять "\n"
//2.3. Удалить директории без файлов (пустые).
//Все файлы имеют расширение txt.
//*/
//public class Solution {
//    public static void main(String[] args) {
//
//    }
//}
