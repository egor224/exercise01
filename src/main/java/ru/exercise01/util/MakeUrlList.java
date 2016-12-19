package ru.exercise01.util;


import org.slf4j.Logger;
import ru.exercise01.model.Link;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Arrays;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

/**
 * Created by Egor on 18.12.16.
 */
public class MakeUrlList {

    private  static final Logger LOG = getLogger(MakeUrlList.class);

    private List<Link> list ;

    public List<Link> getList() {
        return list;
    }

    public void setList(List<Link> list) {
        this.list = list;
    }

    public  MakeUrlList(final String inUrl){
        try {

            URL PageUrl = new URL(inUrl);
            URLConnection GetConn = PageUrl.openConnection();
            GetConn.connect();

            InputStreamReader ReadIn = new InputStreamReader(GetConn.getInputStream());
            ExtractLinks extractLinks = new ExtractLinks(ReadIn,inUrl);
            setList(extractLinks.getLinkList());

        }
        catch (IOException io) {
            Arrays.stream(io.getStackTrace()).forEach(ee->LOG.info(ee.toString()));

        }
    }


}
