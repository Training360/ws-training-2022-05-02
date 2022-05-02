package sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class MyBookHandler extends DefaultHandler {

    private String lastTag;

    private List<String> titles = new ArrayList<>();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
//        System.out.println(qName);
        //attributes.getValue("isbn10")
        lastTag = qName;
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if ("title".equals(lastTag)) {
            String value = new String(ch, start, length);
            if (!value.isBlank()) {
                titles.add(value);
            }
        }
    }

    public List<String> getTitles() {
        return titles;
    }
}
