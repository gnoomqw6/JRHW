package com.javarush.test.level26.lesson15.big01.command;

import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;

class DepositCommand implements Command
{
    @Override
    public void execute()
    {
        String code =  ConsoleHelper.askCurrencyCode();
        CurrencyManipulator cur = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
        String[] arg = ConsoleHelper.getValidTwoDigits(code);
        int k = Integer.parseInt(arg[0]);
        int l = Integer.parseInt(arg[1]);
        cur.addAmount(k,l);
    }
}
