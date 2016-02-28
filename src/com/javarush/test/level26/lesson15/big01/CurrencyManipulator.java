package com.javarush.test.level26.lesson15.big01;

import java.util.HashMap;
import java.util.Map;

public class CurrencyManipulator
{
    private String currencyCode;
    private Map<Integer, Integer> denominations;
    public CurrencyManipulator(String currencyCode)
    {
        this.currencyCode = currencyCode;
        this.denominations = new HashMap<>();
    }
    public String getCurrencyCode()
    {
        return currencyCode;
    }
    public void addAmount(int denomination, int count)
    {
        if (denominations==null)
            denominations= new HashMap<>();
        if (denominations.keySet().contains(denomination))
        {
            denominations.put(denomination,denominations.get(denomination)+count);
        }
        else
            denominations.put(denomination,count);
    }
    public int getTotalAmount()
    {
        int sum=0;
        for (Map.Entry<Integer,Integer> entry: denominations.entrySet())
        {
            sum+=(entry.getKey()*entry.getValue());
        }
        return sum;
    }
    public boolean hasMoney()
    {
        return !(denominations.isEmpty() || getTotalAmount() == 0);

    }
}