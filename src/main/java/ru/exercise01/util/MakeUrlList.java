package ru.exercise01.util;

import ru.exercise01.model.UrlList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Egor on 18.12.16.
 */
public class MakeUrlList {

    public static void MakeUrlList(final String inUrl){
        try {

            URL PageUrl = new URL(inUrl);
            URLConnection GetConn = PageUrl.openConnection();
            GetConn.connect();

            InputStreamReader ReadIn = new InputStreamReader(GetConn.getInputStream());
            BufferedReader BufData = new BufferedReader(ReadIn);
//            String htmlFileName = ("\\hello111.html");
//            FileWriter FWriter = new FileWriter(htmlFileName);
//            BufferedWriter BWriter = new BufferedWriter(FWriter);
            String UrlData = null;
            while ((UrlData = BufData.readLine()) != null) {
                Pattern pattern = Pattern.compile("(?i)<a([^>]+)>(.+?)>");
                Matcher matcher = pattern.matcher(UrlData);
                if (matcher.find()) {
                  String eee =  matcher.group(1) ;
                }
                for (int i = 1; i < matcher.groupCount()-1; i++) {
                    UrlList.addUrlList(matcher.group(i));

                }
//                BWriter.write(UrlData);
//                BWriter.newLine();
            }
//            BWriter.close();
        }
        catch (IOException io) {
            System.out.println(io);
        }
    }


}
