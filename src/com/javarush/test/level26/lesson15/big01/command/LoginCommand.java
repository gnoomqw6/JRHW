package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

public class LoginCommand implements Command {
    final static long CARDNUMBER = 123456789012L;
    final static int PIN = 1234;

    @Override
    public void execute() throws InterruptOperationException {
        while (true) {
            ConsoleHelper.writeMessage("Enter card number");
            String cardNum = ConsoleHelper.readString();
            ConsoleHelper.writeMessage("Enter pin");
            String pin = ConsoleHelper.readString();
            if (cardNum.length() != 12 || pin.length() != 4) {
                ConsoleHelper.writeMessage("Invalid data");
            }
            else {
                try {
                    long cardNumber = Long.parseLong(cardNum);
                    int pinCode = Integer.parseInt(pin);
                    if (cardNumber == CARDNUMBER && pinCode == PIN) {
                        ConsoleHelper.writeMessage("Verification ok");
                        break;
                    }
                    else
                        ConsoleHelper.writeMessage("Try again");
                } catch (NumberFormatException e) {
                    ConsoleHelper.writeMessage("Invalid data");
                }
            }
        }
    }
}
