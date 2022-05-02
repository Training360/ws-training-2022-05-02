package dom;

public class Book {


    private String isbn10;

    private String title;


    public Book() {
    }

    public Book(String isbn10, String title) {
        this.isbn10 = isbn10;
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }
}
