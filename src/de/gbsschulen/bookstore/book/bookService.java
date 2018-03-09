package de.gbsschulen.bookstore.book;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class bookService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public bookService() {
        this.entityManagerFactory = Persistence.createEntityManagerFactory("bookstore");
        this.entityManager = entityManagerFactory.createEntityManager();
    }

    public void save(Book book) {
        entityManager.getTransaction().begin();
        entityManager.persist(book);
        entityManager.getTransaction().commit();
    }

}
