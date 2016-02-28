package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private ResourceBundle validCreditCards;

    public LoginCommand() {
        validCreditCards = ResourceBundle.getBundle("com.javarush.test.level26.lesson15.big01.resources.verifiedCards");
    }

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

                    if (validCreditCards.containsKey(cardNum) && pin.equals(validCreditCards.getString(cardNum))) {
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
