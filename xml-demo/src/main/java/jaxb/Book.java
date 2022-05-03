package jaxb;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"title", "author"})
public class Book {

    private String isbn10;

    private String author;

    private String title;


    public Book() {
    }

    public Book(String isbn10, String title) {
        this.isbn10 = isbn10;
        this.title = title;
    }

    public Book(String isbn10, String author, String title) {
        this.isbn10 = isbn10;
        this.title = title;
        this.author = author;
    }

    @XmlAttribute
    public String getIsbn10() {
        return isbn10;
    }

    public void setIsbn10(String isbn10) {
        this.isbn10 = isbn10;
    }

//    @XmlElement(name = "book-title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
