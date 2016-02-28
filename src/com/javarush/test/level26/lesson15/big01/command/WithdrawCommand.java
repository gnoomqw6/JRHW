package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;

import java.util.Map;

class WithdrawCommand implements Command{
    @Override
    public void execute() throws InterruptOperationException {
        String code = ConsoleHelper.askCurrencyCode();
        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        Map<Integer, Integer> result;

        while (true) {
            ConsoleHelper.writeMessage("Enter sum");
            try {
                int sum = Integer.parseInt(ConsoleHelper.readString());
                if (sum <= 0) throw new NumberFormatException();

                if (!manipulator.isAmountAvailable(sum)) {
                    throw new NotEnoughMoneyException();
                }
                result = manipulator.withdrawAmount(sum);
                for (Map.Entry<Integer, Integer> pair : result.entrySet()) {
                    ConsoleHelper.writeMessage("\t" + pair.getKey() + " - " + pair.getValue());
                }
                ConsoleHelper.writeMessage("Success");
                break;
            } catch (NumberFormatException e) {
                ConsoleHelper.writeMessage("Wrong sum");
            } catch (NotEnoughMoneyException e) {
                ConsoleHelper.writeMessage("Not enough money");
            }
        }
    }
}
