package de.gbsschulen.bookstore.book;

import javax.persistence.*;
import java.util.Objects;

@Entity
//@Table(name = "Buch")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String isbn;
    private String titel;
    private String Author;


    public Book() {
    }

    public Book(String isbn, String titel, String author) {
        this.isbn = isbn;
        this.titel = titel;
        Author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(titel, book.titel) &&
                Objects.equals(Author, book.Author);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, isbn, titel, Author);
    }


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", titel='" + titel + '\'' +
                ", Author='" + Author + '\'' +
                '}';
    }
}
