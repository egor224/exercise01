package ru.exercise01.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Egor on 18.12.16.
 */
public class UrlList {
    private static List<String> urlList;

    public static List<String> getUrlList() {
        if (urlList == null) {
            urlList = new ArrayList<>();
        }
        return urlList;
    }

    public static void addUrlList(String urlStr) {
        getUrlList().add(urlStr);
    }

}
