package com.javarush.test.level28.lesson15.big01.view;

import com.javarush.test.level28.lesson15.big01.Controller;
import com.javarush.test.level28.lesson15.big01.vo.Vacancy;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.*;
import java.util.List;

public class HtmlView implements View {
    private Controller controller;
    private final String filePath = this.getClass().getPackage().toString().replace('.', '/').replaceFirst("package ", "./src/") + "/vacancies.html";

    @Override
    public void update(List<Vacancy> vacancies) {
        try {
            updateFile(getUpdatedFileContent(vacancies));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Some exception occurred");
        }
    }

    @Override
    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void userCitySelectEmulationMethod() {
        controller.onCitySelect("Odessa");
    }

    private String getUpdatedFileContent(List<Vacancy> list) throws IOException {
        Document document = getDocument();

        Element template = document.getElementsByClass("template").first();

        Element cloneTemp = template.clone();
        cloneTemp.removeAttr("style");
        cloneTemp.removeClass("template");

        document.select("tr[class=vacancy]").remove();

        for (Vacancy vacancy : list) {
            Element clon = cloneTemp.clone();
            clon.getElementsByClass("city").get(0).text(vacancy.getCity());
            clon.getElementsByClass("companyName").get(0).text(vacancy.getCompanyName());
            clon.getElementsByClass("salary").get(0).text(vacancy.getSalary());
            Element link = clon.getElementsByTag("a").first();
            link.text(vacancy.getTitle());
            link.attr("href", vacancy.getUrl());
            template.before(clon.outerHtml());
        }

        return document.html();
    }

    private void updateFile(String file) throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"));
        pw.print(file);
        pw.close();
    }

    protected Document getDocument() throws IOException {
        return Jsoup.parse(new File(filePath), "UTF-8");
    }
}
