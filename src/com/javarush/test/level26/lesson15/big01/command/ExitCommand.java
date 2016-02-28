package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;

class ExitCommand implements Command {
    @Override
    public void execute() {
        ConsoleHelper.writeMessage("R U really wanna quit? y/n");
        String exitAnswer = ConsoleHelper.readString();
        while (true) {
            if (exitAnswer.equals("y")) {
                ConsoleHelper.writeMessage("Bye-bye");
                System.exit(1);
            }
            else if (exitAnswer.equals("n")) {

            }
            else ConsoleHelper.writeMessage("Wrong input");
        }
    }
}
