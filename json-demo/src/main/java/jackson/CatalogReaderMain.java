package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CatalogReaderMain {

    public static void main(String[] args) {
        try {
            var mapper = new ObjectMapper();
            var catalog = mapper.readValue(
                    CatalogReaderMain.class.getResourceAsStream("/catalog.json"), Catalog.class);

            for (var book: catalog.getBooks()) {
                System.out.println(book.getIsbn10() + ", " + book.getTitle());
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
