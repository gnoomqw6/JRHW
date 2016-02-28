package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

public class LoginCommand implements Command {
    private ResourceBundle validCreditCards;
    private ResourceBundle res;

    public LoginCommand() {
        validCreditCards = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "verifiedCards");
        res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "login_en");
    }

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("before"));
        while (true) {
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String cardNum = ConsoleHelper.readString();
            ConsoleHelper.writeMessage(res.getString("specify.data"));
            String pin = ConsoleHelper.readString();
            if (cardNum.length() != 12 || pin.length() != 4) {
                ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
            }
            else {
                try {
                    long cardNumber = Long.parseLong(cardNum);
                    int pinCode = Integer.parseInt(pin);

                    if (validCreditCards.containsKey(cardNum) && pin.equals(validCreditCards.getString(cardNum))) {
                        ConsoleHelper.writeMessage(String.format(res.getString("success.format"), cardNum));
                        break;
                    }
                    else {
                        ConsoleHelper.writeMessage(String.format(res.getString("not.verified.format"), cardNum));
                        ConsoleHelper.writeMessage(res.getString("try.again.or.exit"));
                    }
                } catch (NumberFormatException e) {
                    ConsoleHelper.writeMessage(res.getString("try.again.with.details"));
                }
            }
        }
    }
}
