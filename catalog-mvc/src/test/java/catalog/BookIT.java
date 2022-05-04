package catalog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class BookIT {

    @Autowired
    WebTestClient client;

    @Test
    void testCreateTwoBooksThanListThem() {
        client
                .post()
                .uri("/api/books")
                .bodyValue(new Book("aaa", "Test"))
                .exchange()
                .expectStatus().isCreated();

        client
                .post()
                .uri("/api/books")
                .bodyValue(new Book("bbb", "Test"))
                .exchange()
                .expectStatus().isCreated()
                .expectBody(Book.class)
                .value(b -> assertEquals("bbb" ,b.getTitle()));

        // List<Book>.class

//        ParameterizedTypeReference<List<Book>> typeReference = new ParameterizedTypeReference<List<Book>>(){};
//        client
//                .get().uri("/api/books")
//
//                .exchange()
//
//                .expectBodyList(typeReference).hasSize(2).contains(
//                        List.of(new Book("aaa", "Test"), new Book("bbb", "Test"))
//                );
    }
}
