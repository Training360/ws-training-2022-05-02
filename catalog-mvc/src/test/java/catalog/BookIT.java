package catalog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.nio.charset.StandardCharsets;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class BookIT {

    @Autowired
    WebTestClient client;

    @Test
    void testCreateTwoBooksThanListThem() {
        // Összes könyv törlése
        client
                .delete()
                .uri("/api/books")
                .exchange()
                .expectStatus().isNoContent();

        // Első könyv létrehozása
        client
                .post()
                .uri("/api/books")
                .bodyValue(new Book("aaa", "Test 1"))
                .exchange()
                .expectStatus().isCreated();

        // Második könyv létrehozása
        client
                .post()
                .uri("/api/books")
                .bodyValue(new Book("bbb", "Test 2"))
                .exchange()
                .expectStatus().isCreated() // status ellenőrzése
                .expectBody(Book.class)
                .isEqualTo(new Book("bbb", "Test 2")) // konkrét objektum példánnyal összehasonlítás
                .value(b -> assertEquals("Test 2", b.getTitle())); // assert használata

        // Összes könyv lekérdezése
        client
                .get()
                .uri("/api/books")
                .exchange()
                .expectBody().
                jsonPath("$[1].title").isEqualTo("Test 2"); // Ellenőrzés JSON PATH-szal

        client
                .get()
                .uri("/api/books")
                .exchange()
                .expectBodyList(Book.class)// Ellenőrzés, támaszkodva arra, hogy egy lista
                .value(books -> System.out.println(books)) // Debugolásképp kiírva
                .hasSize(2)
                .contains(new Book("aaa", "Test 1"), new Book("bbb", "Test 2"));

        var typeReference = new ParameterizedTypeReference<List<Book>>() {
        };
        client
                .get()
                .uri("/api/books")
                .exchange()
                .expectBody(typeReference) // Ellenőrzés, a visszatérési értéket csak objektumként kezelve
                .value(books -> assertEquals(2, books.size()));

        // Objektum direkt lekérése, hogy külön assert-eket lehessen rajta végrehajtani

        var books = client
                .get()
                .uri("/api/books")
                .exchange()
                .expectBody(typeReference)
                .returnResult().getResponseBody();
        assertEquals(2, books.size());

        // Válasz json kiírása a konzolra
        var json = client
                .get()
                .uri("/api/books")
                .exchange()
                .expectBody()
                .returnResult().getResponseBody();
        System.out.println(new String(json, StandardCharsets.UTF_8));
    }
}
