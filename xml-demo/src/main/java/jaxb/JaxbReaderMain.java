package jaxb;

import javax.xml.XMLConstants;
import javax.xml.bind.JAXBContext;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

public class JaxbReaderMain {

    public static void main(String[] args) {
        try {
            var context = JAXBContext.newInstance(Catalog.class, Book.class);
            var unmarshaller = context.createUnmarshaller();

            var factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            var schema = factory.newSchema(new StreamSource(JaxbReaderMain.class.getResourceAsStream("/catalog.xsd")));
            unmarshaller.setSchema(schema);

            Catalog catalog = (Catalog)
                    unmarshaller.unmarshal(JaxbReaderMain.class.getResourceAsStream("/catalogns.xml"));

            for (Book book: catalog.getBooks()) {
                System.out.println(book.getIsbn10());
                System.out.println(book.getTitle());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
