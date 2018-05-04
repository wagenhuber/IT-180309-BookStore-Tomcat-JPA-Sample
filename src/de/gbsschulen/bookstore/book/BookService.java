package de.gbsschulen.bookstore.book;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;

@SessionScoped //Gültigkeitsbereich für CDI, damit jeder User nur seine eignen Bücher sieht => jede Session eigenes BookService Objekt
public class BookService implements Serializable{

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;


    public BookService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("bookstore");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }


    //Abfragesprache für JPA heißt "JPQL"
    public List<Book> readAllBooks() {
        TypedQuery<Book> query = entityManager.createQuery("select b from Book b", Book.class);
        return query.getResultList();
    }


    public List<Book> readBooksFromAuthor(String author) {
        TypedQuery<Book> query = entityManager.createQuery("select b from Book b where b.Author= :author", Book.class);
        query.setParameter("author", author);
        return query.getResultList();
    }

    public Book findBook(int id) {
        return entityManager.find(Book.class, id);
    }


    public void deleteBook(int id) {
        entityManager.getTransaction().begin();
        entityManager.remove(findBook(id));
        entityManager.getTransaction().commit();
    }





    public List<String> readAllAuthors() {
        TypedQuery<String> query = entityManager.createQuery("select DISTINCT b.Author from Book b", String.class);
        return query.getResultList();
    }



    public void close() {
        if (entityManager != null) {
            entityManager.close();
        }
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
        }
    }



    public static void main(String[] args) {
        System.out.println("Hallo Welt");

//        Book book1 = new Book("234", "Effective Java", "Joshua Block");
//        Book book2 = new Book("453","Java für Anfänger", "Andreas Meier");
//Book book3 = new Book()
        BookService BookService = new BookService();
//        BookService.save(book1);
//        BookService.save(book2);
        List<Book> books = BookService.readAllBooks();
        for (Book book : books) {
            System.out.println(book);
        }

        List<Book> booksFromAuthor = BookService.readBooksFromAuthor("Andreas Meier");
        for (Book book : books) {
            System.out.println(book);
        }

        System.out.println("Alle Authoren ausgeben:");
        List<String> allAuthors = BookService.readAllAuthors();
        for (String allAuthor : allAuthors) {
            System.out.println(allAuthor);
        }

        BookService.close();

    }

}
