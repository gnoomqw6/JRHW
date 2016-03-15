package com.javarush.test.level31.lesson15.big01;

import com.javarush.test.level31.lesson15.big01.command.ExitCommand;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;

public class Archiver {
    public static void main(String[] args) throws Exception {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            System.out.println("Enter full path and name of NEW zip file");
            String pathToZip = reader.readLine();
            ZipFileManager zipFileManager = new ZipFileManager(Paths.get(pathToZip));

            System.out.println("Enter full path and name of your file to zip");
            String pathToFile = reader.readLine();
            zipFileManager.createZip(Paths.get(pathToFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        new ExitCommand().execute();
    }
}
