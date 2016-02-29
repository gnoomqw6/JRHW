//package com.javarush.test.level26.lesson15.big01.command;
//
//import com.javarush.test.level26.lesson15.big01.CashMachine;
//import com.javarush.test.level26.lesson15.big01.ConsoleHelper;
//import com.javarush.test.level26.lesson15.big01.CurrencyManipulator;
//import com.javarush.test.level26.lesson15.big01.CurrencyManipulatorFactory;
//import com.javarush.test.level26.lesson15.big01.exception.InterruptOperationException;
//import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;
//
//import java.util.Map;
//import java.util.ResourceBundle;
//
//class WithdrawCommand implements Command {
//    private ResourceBundle res;
//
//    public WithdrawCommand() {
//        res = ResourceBundle.getBundle(CashMachine.RESOURCE_PATH + "withdraw_en");
//    }
//
//    @Override
//    public void execute() throws InterruptOperationException {
//        ConsoleHelper.writeMessage(res.getString("before"));
//        String code = ConsoleHelper.askCurrencyCode();
//        CurrencyManipulator manipulator = CurrencyManipulatorFactory.getManipulatorByCurrencyCode(code);
//        Map<Integer, Integer> result;
//
//        while (true) {
//            ConsoleHelper.writeMessage(res.getString("specify.amount"));
//            try {
//                int sum = Integer.parseInt(ConsoleHelper.readString());
//                if (sum <= 0) throw new NumberFormatException();
//
//                if (!manipulator.isAmountAvailable(sum)) {
//                    throw new NotEnoughMoneyException();
//                }
//                result = manipulator.withdrawAmount(sum);
//                for (Map.Entry<Integer, Integer> pair : result.entrySet()) {
//                    ConsoleHelper.writeMessage(String.format(res.getString("success.format"), pair.getKey() * pair.getValue(), code));
//                }
//                break;
//            } catch (NumberFormatException e) {
//                ConsoleHelper.writeMessage(res.getString("specify.not.empty.amount"));
//            } catch (NotEnoughMoneyException e) {
//                ConsoleHelper.writeMessage(res.getString("not.enough.money"));
//            } catch (ArrayIndexOutOfBoundsException e) {
//                ConsoleHelper.writeMessage(res.getString("exact.amount.not.available"));
//            }
//        }
//    }
//}
