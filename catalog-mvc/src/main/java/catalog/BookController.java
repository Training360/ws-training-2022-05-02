package catalog;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/books")
@AllArgsConstructor
public class BookController {

    private BookService service;

    @GetMapping
    @Operation(summary = "Find book", description = "Find all book")
    public List<Book> getBooks() {
        return service.findAll();
    }

    @GetMapping("/{isbn10}")
    public Book getBook(@PathVariable String isbn10) {
        return service.findByIsbn10(isbn10);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@RequestBody @Valid Book book) {
        service.add(book);
        return book;
    }

    @PutMapping("/{isbn10}")
    public Book update(@PathVariable String isbn10, @RequestBody Book book) {
        var updated = service.update(isbn10, book.getTitle());
        return updated;
    }

    @DeleteMapping("/{isbn10}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable String isbn10) {
        service.delete(isbn10);
    }

    @DeleteMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAll() {
        service.deleteAll();
    }


}
