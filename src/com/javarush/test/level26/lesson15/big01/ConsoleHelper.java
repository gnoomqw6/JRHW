package com.javarush.test.level26.lesson15.big01;

import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ResourceBundle;

public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static ResourceBundle res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "common_en");

    public static void writeMessage(String message) {
        System.out.println(message);
    }

    public static String readString() throws InterruptOperationException {
        String message = "";
        try {
            message = reader.readLine();
            if (message.equalsIgnoreCase("exit")) {
                throw new InterruptOperationException();
            }
        } catch (IOException ignored) {
        }
        return message;
    }

    public static String askCurrencyCode() throws InterruptOperationException {
        String s = "";
        while (true) {
            ConsoleHelper.writeMessage(res.getString("choose.currency.code"));
            s = readString();
            if (s.length() == 3) {
                return s.toUpperCase();
            }
            ConsoleHelper.writeMessage(res.getString("invalid.data"));
        }
    }

    public static String[] getValidTwoDigits(String currencyCode) throws InterruptOperationException, NumberFormatException {
        String[] arr;

        while (true) {
            ConsoleHelper.writeMessage(String.format(res.getString("choose.denomination.and.count.format"), currencyCode));
            String s = readString();
            arr = s.split(" ");
            if (arr.length != 2) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
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
            ConsoleHelper.writeMessage(res.getString("choose.operation"));
            ConsoleHelper.writeMessage(res.getString("operation.INFO"));
            ConsoleHelper.writeMessage(res.getString("operation.DEPOSIT"));
            ConsoleHelper.writeMessage(res.getString("operation.WITHDRAW"));
            ConsoleHelper.writeMessage(res.getString("operation.EXIT"));
            try {
                return Operation.getAllowableOperationByOrdinal(Integer.parseInt(readString()));
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage(res.getString("invalid.data"));
            }
        }
    }

    public static void printExitMessage() {
        ConsoleHelper.writeMessage(res.getString("the.end"));
    }
}
