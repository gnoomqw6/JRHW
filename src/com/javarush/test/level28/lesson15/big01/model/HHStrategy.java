package com.javarush.test.level28.lesson15.big01.model;

import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.List;

public class HHStrategy implements Strategy {
    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
    private static final String USER_AGENT =
            "Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36 OPR/35.0.2066.92";
    private static final String REFERRER = "http://google.ru";

    @Override
    public List<Vacancy> getVacancies(String searchString) {
        String url = String.format(URL_FORMAT, "Киев", 1);
        try {
            Document document = Jsoup.connect(url).userAgent(USER_AGENT).referrer(REFERRER).get();
            System.out.println(document);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
