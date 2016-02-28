package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;

class ExitCommand implements Command {
    @Override
    public void execute() throws InterruptOperationException {
        ConsoleHelper.writeMessage("R U really wanna quit? y/n");
        String exitAnswer = ConsoleHelper.readString();
            if (exitAnswer.equals("y")) {
                ConsoleHelper.writeMessage("Bye-bye");
            }
    }
}
