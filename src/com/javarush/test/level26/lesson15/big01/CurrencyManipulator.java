//package com.javarush.test.level26.lesson15.big01;
//
//import com.javarush.test.level26.lesson15.big01.exception.NotEnoughMoneyException;
//
//import java.util.*;
//
//public class CurrencyManipulator {
//    private String currencyCode;
//    private Map<Integer, Integer> denominations;
//
//    public CurrencyManipulator(String currencyCode) {
//        this.currencyCode = currencyCode;
//        this.denominations = new TreeMap<>(Collections.reverseOrder());
//    }
//
//    public String getCurrencyCode() {
//        return currencyCode;
//    }
//
//    public void addAmount(int denomination, int count) {
//        if (denominations == null)
//            denominations = new TreeMap<>(Collections.reverseOrder());
//        if (denominations.keySet().contains(denomination)) {
//            denominations.put(denomination, denominations.get(denomination) + count);
//        } else
//            denominations.put(denomination, count);
//    }
//
//    public int getTotalAmount() {
//        int sum = 0;
//        for (Map.Entry<Integer, Integer> entry : denominations.entrySet()) {
//            sum += (entry.getKey() * entry.getValue());
//        }
//        return sum;
//    }
//
//    public boolean hasMoney() {
//        return !(denominations.isEmpty() || getTotalAmount() == 0);
//
//    }
//
//    public boolean isAmountAvailable(int expectedAmount) {
//        return getTotalAmount() >= expectedAmount;
//    }
//
//    public Map<Integer, Integer> withdrawAmount(int expectedAmount) throws NotEnoughMoneyException {
//        Map<Integer, Integer> result = new TreeMap<>(Collections.reverseOrder());
//        int ostatok = expectedAmount;
//        List<Integer> nominals = new ArrayList<>();
//        for (Integer iter : denominations.keySet()) {
//            nominals.add(iter);
//        }
//
//        boolean isReady = false;
//
//        if (expectedAmount < nominals.get(nominals.size() - 1))
//            return new TreeMap<>();
//
//        for (int i = 0; i < nominals.size(); i++) {
//            int currentBill = nominals.get(i);
//            if (currentBill <= ostatok) {
//                int billCount = ostatok / currentBill;
//                if (billCount <= denominations.get(currentBill)) {
//                    result.put(currentBill, billCount);
//                    ostatok %= currentBill;
//                    if (ostatok == 0) {
//                        isReady = true;
//                        break;
//                    }
//                }
//                else if (denominations.get(currentBill) != 0){
//                    billCount = denominations.get(currentBill);
//                    result.put(currentBill, billCount);
//                    ostatok -= currentBill * billCount;
//                }
//            }
//        }
//        if (isReady) {
//            for (Map.Entry<Integer, Integer> pair : result.entrySet()) {
//                denominations.put(pair.getKey(), denominations.get(pair.getKey()) - pair.getValue());
//            }
//            return result;
//        }
//        else throw new ArrayIndexOutOfBoundsException();
//    }
//}