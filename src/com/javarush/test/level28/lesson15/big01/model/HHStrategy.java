//package com.javarush.test.level28.lesson15.big01.model;
//
//import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.List;
//
//public class HHStrategy implements Strategy {
//    private static final String URL_FORMAT = "http://hh.ua/search/vacancy?text=java+%s&page=%d";
//    private static final String USER_AGENT =
//            "Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36 OPR/35.0.2066.92";
//    private static final String REFERRER = "http://google.ru";
//
//    @Override
//    public List<Vacancy> getVacancies(String searchString) {
//        List<Vacancy> vacancyList = new ArrayList<>();
//        int i = 0;
//        Document document = null;
//        while (true) {
//            try {
//                document = getDocument(searchString, i++);
//            } catch (IOException e) {
//            }
//
//            Elements all = document.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy");
//
//            if (all.size() == 0) {
//                break;
//            }
//
//            for (Element element : all) {
//                Vacancy vacancy = new Vacancy();
//                vacancy.setUrl(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").attr("href"));
//                vacancy.setTitle(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-title").text());
//                vacancy.setSalary(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-compensation").text());
//                vacancy.setCity(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-address").text());
//                vacancy.setCompanyName(element.getElementsByAttributeValue("data-qa", "vacancy-serp__vacancy-employer").text());
//                vacancy.setSiteName(document.title());
//                vacancyList.add(vacancy);
//            }
//        }
//
//        return vacancyList;
//    }
//
//    protected Document getDocument(String searchString, int page) throws IOException{
//        String url = String.format(URL_FORMAT, searchString, page);
//        Document document = Jsoup.connect(url).userAgent(USER_AGENT).referrer(REFERRER).get();
//        System.out.println(document);
//        return document;
//    }
//}
