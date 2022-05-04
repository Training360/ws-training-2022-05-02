package training.catalogjaxrs;

import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    private List<Book> books = new ArrayList<>();

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
                .orElseThrow();
    }

    public void add(Book book) {
        books.add(book);
    }

    public void update(Book book) {
        Book found = findByIsbn10(book.getIsbn10());
        found.setTitle(book.getTitle());
    }

    public void delete(String isbn10) {
        books.removeIf(b -> b.getIsbn10().equals(isbn10));
    }
}
