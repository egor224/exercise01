package ru.exercise01.util;

import ru.exercise01.model.Link;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Egor on 19.12.16.
 */
public class ExtractLinks {


    private List<Link> linkList;
    final private Pattern tagPattern;
    final private Pattern linkPattern;
    private Matcher tagMatcher;
    private Matcher linkMatcher;
    final private InputStreamReader inputStreamReader;

    final private static String tagText = "(?i)<a([^>]+)>(.+?)>";
    final private static String linkText = "\\s*(?i)href\\s*=\\s*(\\\"([^\"]*\\\")|'[^']*'|([^'\">\\s]+))";

    public List<Link> getLinkList() {
        if (linkList == null) {
            linkList = new ArrayList<>();
        }
        return linkList;
    }

    public Matcher getTagMatcher(String inStr) {
        tagMatcher = tagPattern.matcher(inStr);
        return tagMatcher;
    }

    public Matcher getLinkMatcher(String inStr) {
        linkMatcher = linkPattern.matcher(inStr);
        return linkMatcher;
    }


    public ExtractLinks(InputStreamReader readIn) {
        inputStreamReader = readIn;
        tagPattern = Pattern.compile(tagText);
        linkPattern = Pattern.compile(linkText);
        startWork();
    }

    private void startWork() {
        try {
            BufferedReader BufData = new BufferedReader(inputStreamReader);
            String UrlData = null;
            while ((UrlData = BufData.readLine()) != null) {
                getLinkFromText(getTagMatcher(UrlData));
            }
        } catch (IOException io) {
            System.out.println(io);

        }


    }

    private void getLinkFromText(Matcher inMatcher) {
        String outStr = null;
        while (inMatcher.find()) {

            Matcher matcher = getLinkMatcher(inMatcher.group(1));
            if (matcher.find()) {
                outStr = matcher.group(1).substring(1, matcher.group(1).length() - 1);
                if (outStr != null && !outStr.isEmpty()) {
                    final Link link = new Link();
                    link.setLinks(outStr);
                    getLinkList().add(link);
                }
            }
        }
    }


}
