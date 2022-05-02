package stax;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;

public class CursorReaderApi {

    public static void main(String[] args) {
        try {
            var factory = XMLInputFactory.newInstance();
            var reader = factory.createXMLStreamReader(CursorReaderApi.class.getResourceAsStream("/catalog.xml"));

            while (reader.hasNext()) {
                reader.next();
                if (reader.getEventType() == XMLStreamConstants.START_ELEMENT) {
                    System.out.println(reader.getName().getLocalPart());
                    if (reader.getName().getLocalPart().equals("book")) {
                        System.out.println(reader.getAttributeValue(null, "isbn10"));
                    }
                    if (reader.getName().getLocalPart().equals("title")) {
                        System.out.println(reader.getElementText());
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
