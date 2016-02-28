package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String message = "";
        try {
            message = reader.readLine();
            if (message.equalsIgnoreCase("exit"))
                throw new InterruptOperationException();
        } catch (IOException ignored) {
        }
        return message;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String s = "";
        while (true) {
            writeMessage("Enter currency code:");
            s = readString();
            if (s.length() == 3) {
                return s.toUpperCase();
            }
            writeMessage("Wrong currency code");
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException, NumberFormatException {
        String[] arr;

        while (true) {
            writeMessage("Enter nominal and count of bills for " + currencyCode);
            String s = readString();
            arr = s.split(" ");
            if (arr.length != 2) {
                writeMessage("Wrong nominal or count value");
                continue;
            }
            int i1 = Integer.parseInt(arr[0]);
            int i2 = Integer.parseInt(arr[1]);
            if (i1 > 0 && i2 > 0) {
                return arr;
            }
        }
    }

    public static Operation askOperation() throws InterruptOperationException {
        while (true) {
            System.out.println("Choose operation (1-4)");
            try {
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            } catch (NumberFormatException e) {
                System.out.println("Wrong input, try again");
            }
        }
    }
}
