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
//public class MoikrugStrategy implements Strategy {
//    private static final String URL_FORMAT = "https://moikrug.ru/vacancies?q=java+%s&page=%d";
//    private static final String USER_AGENT =
//            "Mozilla/5.0 (Windows NT 10.0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36 OPR/35.0.2066.92";
//    private static final String REFERRER = "https://moikrug.ru";
//    @Override
//    public List<Vacancy> getVacancies(String searchString) {
//        List<Vacancy> vacancyList = new ArrayList<>();
//        int i = 1;
//        Document document = null;
//        while (true) {
//            try {
//                document = getDocument(searchString, i++);
//            } catch (IOException e) {
//            }
//
//            Elements all = document.getElementsByClass("job");
//
//            if (all.size() == 0) {
//                break;
//            }
//
//            for (Element element : all) {
//                Vacancy vacancy = new Vacancy();
//                vacancy.setUrl("https://moikrug.ru" + element.getElementsByClass("title").first().getElementsByTag("a").attr("href"));
//                vacancy.setTitle(element.getElementsByClass("info").first().getElementsByAttribute("title").text());
//                vacancy.setSalary(element.getElementsByClass("salary").first().getElementsByAttributeValue("title", "Зарплата").text());
//                vacancy.setCity(element.getElementsByClass("location").text());
//                vacancy.setCompanyName(element.getElementsByClass("company_name").first().getElementsByTag("a").text());
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
////        String url = "http://javarush.ru/testdata/big28data2.html";
//        Document document = Jsoup.connect(url).userAgent(USER_AGENT).referrer(REFERRER).get();
//        return document;
//    }
//}
