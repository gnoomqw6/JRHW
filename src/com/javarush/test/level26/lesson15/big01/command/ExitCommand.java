package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.CashMachine;
import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

import java.util.ResourceBundle;

class ExitCommand implements Command {
    private ResourceBundle res;

    public ExitCommand() {
        res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "exit_en");
    }

    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage(res.getString("exit.question.y.n"));
        String exitAnswer = ConsoleHelper.readString();
            if (exitAnswer.equals(res.getString("yes"))) {
                ConsoleHelper.writeMessage(res.getString("thank.message"));
            }
    }
}
