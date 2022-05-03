package jaxb;

import javax.xml.bind.JAXBContext;

public class JaxbReaderMain {

    public static void main(String[] args) {
        try {
            var context = JAXBContext.newInstance(Catalog.class, Book.class);
            var unmarshaller = context.createUnmarshaller();

            Catalog catalog = (Catalog)
                    unmarshaller.unmarshal(JaxbReaderMain.class.getResourceAsStream("/catalog.xml"));

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
