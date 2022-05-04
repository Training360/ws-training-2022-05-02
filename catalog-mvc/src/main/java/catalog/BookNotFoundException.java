package catalog;

import org.zalando.problem.AbstractThrowableProblem;
import org.zalando.problem.Status;

import java.net.URI;

public class BookNotFoundException extends AbstractThrowableProblem {

    public BookNotFoundException(String message) {
        super(
                URI.create("books/book-not-found"),
                "Not found",
                Status.NOT_FOUND,
                message
        );
    }
}
