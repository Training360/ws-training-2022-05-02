package training.catalogjaxrs;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/api/books")
public class BookResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Book> getBooks() {
        return List.of(
                new Book("aaa", "Java and JSON"),
                new Book("bbb", "Java and REST")
        );
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{isbn10}")
    public Book getBookByIsbn10(@PathParam("isbn10") String isbn10) {
        if (isbn10.equals("aaa")) {
            return new Book("aaa", "Java and JSON");
        }
        else {
            return new Book("bbb", "Java and REST");
        }
    }

}
