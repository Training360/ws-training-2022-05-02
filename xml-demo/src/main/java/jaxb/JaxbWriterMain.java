package jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class JaxbWriterMain {

    public static void main(String[] args) {
        Catalog catalog = new Catalog();
        catalog.getBooks().add(new Book("abc", "John Doe", "Java and XML"));
        catalog.getBooks().add(new Book("def", "Jack Doe", "Java and JAXB"));

        try {
            var context = JAXBContext.newInstance(Catalog.class, Book.class);
            var marshaller = context.createMarshaller();

            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,
                    Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT,
                    Boolean.FALSE);

            marshaller.marshal(catalog, Files.newBufferedWriter(Path.of("books.xml")));

        }
        catch (JAXBException | IOException e) {
            e.printStackTrace();
        }

    }
}
