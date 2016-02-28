//package com.javarush.test.level20.lesson10.bonus03;
//
//import java.util.ArrayList;
//import java.util.List;
//
///* Кроссворд
//1. Дан двумерный массив, который содержит буквы английского алфавита в нижнем регистре.
//2. Метод detectAllWords должен найти все слова из words в массиве crossword.
//3. Элемент(startX, startY) должен соответствовать первой букве слова, элемент(endX, endY) - последней.
//text - это само слово, располагается между начальным и конечным элементами
//4. Все слова есть в массиве.
//5. Слова могут быть расположены горизонтально, вертикально и по диагонали как в нормальном, так и в обратном порядке.
//6. Метод main не участвует в тестировании
//*/
//public class Solution {
//    public static void main(String[] args) {
//        int[][] crossword = new int[][]{
//                {'f', 'd', 'e', 'r', 'l', 'k'},
//                {'u', 's', 'a', 'm', 'e', 'o'},
//                {'l', 'n', 'g', 'r', 'o', 'v'},
//                {'m', 'l', 'p', 'r', 'r', 'h'},
//                {'p', 'o', 'e', 'e', 'j', 'j'}
//        };
//        detectAllWords(crossword, "home", "same");
//        /*
//Ожидаемый результат
//home - (5, 3) - (2, 0)
//same - (1, 1) - (4, 1)
//         */
//    }
//
//    public static List<Word> detectAllWords(int[][] crossword, String... words) {
//        List<Word> list = new ArrayList<>();
//        for (String word : words) {
//            boolean nextWord = false;
//            char[] wordarr = word.toCharArray();
//            for (int i = 0; i < crossword.length; i++) {
//                if (nextWord) break;
//                for (int j = 0; j < crossword[i].length; j++) {
//                    if (nextWord) break;
//                    if (wordarr[0] != crossword[i][j]) continue;
//                    Word w = findWord(i, j, word, crossword);
//                    if (w != null) {
//                        list.add(w);
//                        nextWord = true;
//                    }
//                }
//            }
//        }
//        return list;
//    }
//
//    public static Word findWord(int i, int j, String word, int[][] crossword) {
//        Word w = new Word(word);
//        w.setStartPoint(j, i);
//        int iEnd = 0;
//        int jEnd = 0;
//        boolean isFound = false;
//
//        if ((j + word.length() - 1) < crossword[i].length) {       //если можем двигаться вправо от найденной первой буквы
//            isFound = true;
//            for (int k = j + 1, a = 1; k < j + word.length(); k++, a++) {
//                if (word.charAt(a) != crossword[i][k]) {
//                    isFound = false;
//                    break;
//                }
//                iEnd = i;
//                jEnd = k;
//            }
//            if (isFound) {
//                w.setEndPoint(jEnd, iEnd);
//                return w;
//            }
//        }
//
//        if ((i + word.length() - 1) < crossword.length) {       //если можем двигаться вниз от найденной первой буквы
//            isFound = true;
//            for (int k = i + 1, a = 1; k < i + word.length(); k++, a++) {
//                if (word.charAt(a) != crossword[k][j]) {
//                    isFound = false;
//                    break;
//                }
//                iEnd = k;
//                jEnd = j;
//            }
//            if (isFound) {
//                w.setEndPoint(jEnd, iEnd);
//                return w;
//            }
//        }
//
//        if ((j - word.length() + 1) > -1) {       //если можем двигаться влево от найденной первой буквы
//            isFound = true;
//            for (int k = j - 1, a = 1; k > j - word.length(); k--, a++) {
//                if (word.charAt(a) != crossword[i][k]) {
//                    isFound = false;
//                    break;
//                }
//                iEnd = i;
//                jEnd = k;
//            }
//            if (isFound) {
//                w.setEndPoint(jEnd, iEnd);
//                return w;
//            }
//        }
//
//        if ((i - word.length() + 1) > -1) {       //если можем двигаться вверх от найденной первой буквы
//            isFound = true;
//            for (int k = i - 1, a = 1; k > i - word.length(); k--, a++) {
//                if (word.charAt(a) != crossword[k][j]) {
//                    isFound = false;
//                    break;
//                }
//                iEnd = k;
//                jEnd = j;
//            }
//            if (isFound) {
//                w.setEndPoint(jEnd, iEnd);
//                return w;
//            }
//        }
//
//        //если можем двигаться вправо и вниз от найденной первой буквы
//        if ((j + word.length() - 1) < crossword[i].length && (i + word.length() - 1) < crossword.length) {
//            isFound = true;
//            for (int l = i + 1, k = j + 1, a = 1; k < j + word.length(); l++, k++, a++) {
//                if (word.charAt(a) != crossword[l][k]) {
//                    isFound = false;
//                    break;
//                }
//                iEnd = l;
//                jEnd = k;
//            }
//            if (isFound) {
//                w.setEndPoint(jEnd, iEnd);
//                return w;
//            }
//        }
//
//        //если можем двигаться вправо и вверх от найденной первой буквы
//        if ((j + word.length() - 1) < crossword[i].length && (i - word.length() + 1) > -1) {
//            isFound = true;
//            for (int l = i - 1, k = j + 1, a = 1; k < j + word.length(); l--, k++, a++) {
//                if (word.charAt(a) != crossword[l][k]) {
//                    isFound = false;
//                    break;
//                }
//                iEnd = l;
//                jEnd = k;
//            }
//            if (isFound) {
//                w.setEndPoint(jEnd, iEnd);
//                return w;
//            }
//        }
//
//        //если можем двигаться влево и вниз от найденной первой буквы
//        if ((j - word.length() + 1) > -1 && (i + word.length() - 1) < crossword.length) {
//            isFound = true;
//            for (int l = i + 1, k = j - 1, a = 1; k > j - word.length(); l++, k--, a++) {
//                if (word.charAt(a) != crossword[l][k]) {
//                    isFound = false;
//                    break;
//                }
//                iEnd = l;
//                jEnd = k;
//            }
//            if (isFound) {
//                w.setEndPoint(jEnd, iEnd);
//                return w;
//            }
//        }
//
//        //если можем двигаться влево и вверх от найденной первой буквы
//        if ((j - word.length() + 1) > -1 && (i - word.length() + 1) > -1) {
//            isFound = true;
//            for (int l = i - 1, k = j - 1, a = 1; k > j - word.length(); l--, k--, a++) {
//                if (word.charAt(a) != crossword[l][k]) {
//                    isFound = false;
//                    break;
//                }
//                iEnd = l;
//                jEnd = k;
//            }
//            if (isFound) {
//                w.setEndPoint(jEnd, iEnd);
//                return w;
//            }
//        }
//
//        if (isFound == false) w = null;
//
//        return w;
//    }
//
//    public static class Word {
//        private String text;
//        private int startX;
//        private int startY;
//        private int endX;
//        private int endY;
//
//        public Word(String text) {
//            this.text = text;
//        }
//
//        public void setStartPoint(int i, int j) {
//            startX = i;
//            startY = j;
//        }
//
//        public void setEndPoint(int i, int j) {
//            endX = i;
//            endY = j;
//        }
//
//        @Override
//        public String toString() {
//            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
//        }
//    }
//}
