package training.catalogjaxrs;

import lombok.AllArgsConstructor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/books")
@AllArgsConstructor
public class BookResource {

    private BookService bookService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {
        return bookService.findAll();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{isbn10}")
    public Book getBookByIsbn10(@PathParam("isbn10") String isbn10) {
        return bookService.findByIsbn10(isbn10);
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Book create(Book book) {
        bookService.add(book);
        return book;
    }

    @PUT // idempotens
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{isbn10}")
    public Book update(@PathParam("isbn10") String isbn10, Book book) {
        return bookService.update(isbn10, book.getTitle());
    }

    @DELETE
    @Path("{isbn10}")
    public void delete(@PathParam("isbn10") String isbn10) {
        bookService.delete(isbn10);
    }

}
