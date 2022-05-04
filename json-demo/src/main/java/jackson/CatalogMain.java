package jackson;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class CatalogMain {

    public static void main(String[] args) {
        var catalog = new Catalog();
        catalog.setBooks(List.of(
                new Book("abc", "Java and JSON"),
                new Book("xyz", "Java and REST")
        ));

        try {
            var mapper = new ObjectMapper();
            System.out.println(mapper.writeValueAsString(catalog));
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
