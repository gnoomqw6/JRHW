package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        String url = String.format(URL_FORMAT, "Киев", 1);
        try {
            Document document = Jsoup.connect(url).get();
            System.out.println(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
