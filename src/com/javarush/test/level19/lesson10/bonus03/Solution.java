//package com.javarush.test.level19.lesson10.bonus03;
//
///* Знакомство с тегами
//Считайте с консоли имя файла, который имеет HTML-формат
//Пример:
//Info about Leela <span xml:lang="en" lang="en"><b><span>Turanga Leela
//</span></b></span>
//Первым параметром в метод main приходит тег. Например, "span"
//Вывести на консоль все теги, которые соответствуют заданному тегу
//Каждый тег на новой строке, порядок должен соответствовать порядку следования в файле
//Количество пробелов, \n, \r не влияют на результат
//Файл не содержит тег CDATA, для всех открывающих тегов имеется отдельный закрывающий тег, одиночных тегов нету
//Тег может содержать вложенные теги
//Пример вывода:
//<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
//<span>Turanga Leela</span>
//
//Шаблон тега:
//<tag>text1</tag>
//<tag text2>text1</tag>
//<tag
//text2>text1</tag>
//
//text1, text2 могут быть пустыми
//*/
//                                //МНОГО ЗАПУТАННОЙ ЛОГИКИ, СКОПИПАСТИЛ
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String fileName = reader.readLine();
//        reader.close();
//        String tag = args[0];
//        BufferedReader in = new BufferedReader(new FileReader(fileName));
//        String str = "";
//        while (in.ready()) {
//            str += in.readLine();
//        }
//        String prepare = str.replaceAll("[\\n\\r]", "");
//        char[] c = prepare.toCharArray();
//        String result = "";
//        for (int i = 0; i < c.length ; i++) {
//            if(String.valueOf(c[i]).equals(">"))
//                result += String.valueOf(c[i]) + " ";
//            else if(String.valueOf(c[i]).equals("<") && i != 0)
//                result += " " + String.valueOf(c[i]);
//            else
//                result += String.valueOf(c[i]);
//        }
//        while (result.contains("  ")){
//            result = result.replace("  ", " ");
//        }
//        if(result.startsWith(" "))
//            result = result.substring(1, result.length());
//        if(result.endsWith(" "))
//            result = result.substring(0, result.length() - 1);
//        String[] split = result.split(" ");
//        String key1 = "<" + tag;
//        String key2 =  "</" + tag + ">";
//        int count_key1 = 0;
//        int count_key2 = 0;
//        String line = "";
//        ArrayList<String> list = new ArrayList<>();
//        for (int i = 0; i < split.length ; i++) {
//            line += split[i] + " ";
//            if(split[i].contains(key1)) count_key1++;
//            else if(split[i].contains(key2)) count_key2++;
//            if(count_key1 == count_key2){
//                if(line.contains(key1)) {
//                    if (line.endsWith(" ")) line = line.substring(0, line.length() - 1);
//                    if(count_key1 == 1) list.add(line);
//                    else {
//                        list.add(line);
//                        while (true){
//                            int sb1 = line.indexOf("<" + tag, 1);
//                            int sb2 = line.lastIndexOf("</" + tag + ">");
//                            line = line.substring(sb1, sb2);
//                            if(line.endsWith("</" + tag + ">")) list.add(line);
//                            else{
//                                line = line.substring(0, line.lastIndexOf("</" + tag + ">") + tag.length() + 3);
//                                list.add(line);
//                            }
//                            String end = line.replaceFirst("</" + tag + ">", "");
//                            if(!end.contains("</" + tag + ">")) break;
//                        }
//                    }
//                }
//                line = "";
//                count_key1 = 0;
//                count_key2 = 0;
//            }
//        }
//        for (int i = 0; i < list.size() ; i++) {
//            System.out.println(list.get(i));
//        }
//    }
//}