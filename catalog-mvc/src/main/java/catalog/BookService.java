package catalog;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

    @PostConstruct
    public void init() {
        books.add(new Book("aaa", "Java and JSON"));
        books.add(new Book("bbb", "Java and REST"));
    }

    public List<Book> findAll() {
        return books;
    }

    public Book findByIsbn10(String isbn10) {
        return books.stream()
                .filter(b -> b.getIsbn10().equals(isbn10))
                .findAny()
                .orElseThrow(() ->
                        new BookNotFoundException("Book not found with isbn10: " + isbn10));
    }

    public void add(Book book) {
        books.add(book);
    }

    public Book update(String isbn10, String title) {
        Book found = findByIsbn10(isbn10);
        found.setTitle(title);
        return found;
    }

    public void delete(String isbn10) {
        books.removeIf(b -> b.getIsbn10().equals(isbn10));
    }

    public void deleteAll() {
        books.clear();
    }
}
