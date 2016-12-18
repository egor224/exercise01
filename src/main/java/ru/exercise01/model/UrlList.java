package ru.exercise01.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Egor on 18.12.16.
 */
public class UrlList {
    private List<String> urlList;

    public List<String> getUrlList() {
        if (urlList == null) {
            urlList = new ArrayList<>();
        }
        return urlList;
    }

    public void addUrlList(String urlStr) {
        getUrlList().add(urlStr);
    }

}
