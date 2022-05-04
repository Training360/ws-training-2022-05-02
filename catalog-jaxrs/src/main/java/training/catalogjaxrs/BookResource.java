package training.catalogjaxrs;

import lombok.AllArgsConstructor;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
    public Response getBookByIsbn10(@PathParam("isbn10") String isbn10) {
        try {
            var book = bookService.findByIsbn10(isbn10);
            return Response
                    .status(Response.Status.OK)
                    .entity(book)
                    .build();
        } catch (Exception e) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .entity(new Error("Book not found"))
                    .build();
        }

    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Book book) {
        bookService.add(book);
        return Response
                .status(Response.Status.CREATED)
                .entity(book)
                .build();

    }

    @PUT // idempotens
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("{isbn10}")
    public Book update(@PathParam("isbn10") String isbn10, Book book) {
        var updated = bookService.update(isbn10, book.getTitle());
        return updated;
    }

    @DELETE
    @Path("{isbn10}")
    public void delete(@PathParam("isbn10") String isbn10) {
        bookService.delete(isbn10);
    }

}
