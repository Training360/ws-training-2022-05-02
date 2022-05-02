package sax;

import javax.xml.parsers.SAXParserFactory;

public class SaxReaderApi {

    public static void main(String[] args) {
        try {
            var factory = SAXParserFactory.newInstance();
            var parser = factory.newSAXParser();

            MyBookHandler myHandler = new MyBookHandler();

            parser.parse(SaxReaderApi.class.getResourceAsStream("/catalog.xml"), myHandler
                    );

            System.out.println(myHandler.getTitles());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
