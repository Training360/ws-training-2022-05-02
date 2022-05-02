package dom;

import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

public class DomReaderApi {

    public static void main(String[] args) {
        try {
            var factory = DocumentBuilderFactory.newDefaultInstance();
            var builder = factory.newDocumentBuilder();
            var document = builder.parse(DomReaderApi.class.getResourceAsStream("/catalog.xml"));

            var books = document.getElementsByTagName("book");
            for (int i = 0; i < books.getLength(); i++) {
                var book = (Element) books.item(i);
                System.out.println(book.getAttribute("isbn10"));
                //System.out.println(book.getElementsByTagName("title").item(0).getTextContent());
                System.out.println(book.getChildNodes().getLength());
                System.out.println(book.getChildNodes().item(1).getNodeName());
                System.out.println(book.getChildNodes().item(3).getNodeName());
            }

        } catch (SAXException | IOException | ParserConfigurationException e) {
            System.out.println("Can not parse");
        }
    }
}
