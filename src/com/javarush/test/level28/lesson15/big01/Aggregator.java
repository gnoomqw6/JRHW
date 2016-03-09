package com.javarush.test.level28.lesson15.big01;

import com.javarush.test.level28.lesson15.big01.model.HHStrategy;
import com.javarush.test.level28.lesson15.big01.model.Provider;
import com.javarush.test.level28.lesson15.big01.model.Strategy;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;

import java.util.List;

public class Aggregator {
    public static void main(String[] args) {
        Strategy strategy = new HHStrategy();
        Provider provider = new Provider(strategy);
        Controller controller = new Controller(provider);
        controller.scan();
    }
}
