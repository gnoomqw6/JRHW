//package com.javarush.test.level22.lesson13.task02;
//
//import java.io.*;
//
///* Смена кодировки
//В метод main первым параметром приходит имя файла, тело которого в кодировке Windows-1251.
//В метод main вторым параметром приходит имя файла, в который необходимо записать содержимое первого файла в кодировке UTF-8.
//*/
//public class Solution {
//    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing
//
//    public static void main(String[] args) throws IOException {
//        if (args.length > 1) {
//            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
//            FileOutputStream out = new FileOutputStream(args[1]);
//            while (input.ready()) {
//                byte[] buf = input.readLine().getBytes("Windows-1251");
//                String s = new String(buf, "UTF-8");
//                out.write(s.getBytes());
//            }
//            input.close();
//            out.close();
//        }
//    }
//}
