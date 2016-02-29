//package com.javarush.test.level26.lesson15.big01.command;
//
//import com.javarush.test.level26.lesson15.big01.CashMachine;
//import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
//import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
//import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
//import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
//
//import java.util.ResourceBundle;
//
//class DepositCommand implements Command {
//    private ResourceBundle res;
//
//    public DepositCommand() {
//        res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "deposit_en");
//    }
//
//    @Override
//    public void execute() throws InterruptOperationException {
//        ConsoleHelper.writeMessage(res.getString("before"));
//        String code = ConsoleHelper.askCurrencyCode();
//        CurrencyManipulator cur = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
//        String[] arg = ConsoleHelper.getValidTwoDigits(code);
//        try {
//            int k = Integer.parseInt(arg[0]);
//            int l = Integer.parseInt(arg[1]);
//            cur.addAmount(k, l);
//            ConsoleHelper.writeMessage(String.format(res.getString("success.format"), k * l, code));
//        } catch (NumberFormatException e) {
//            ConsoleHelper.writeMessage(res.getString("invalid.data"));
//        }
//    }
//}
