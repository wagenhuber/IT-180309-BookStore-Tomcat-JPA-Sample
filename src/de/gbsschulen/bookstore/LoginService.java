package de.gbsschulen.bookstore;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class LoginService {

    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public LoginService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("bookstore");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void saveLogin(Login login){
        entityManager.getTransaction().begin();
        entityManager.persist(login);
        entityManager.getTransaction().commit();
    }



    public boolean checkPassword(String username, String password){
        if (username != null && username.length() == 0) {
            return false;
        }
        TypedQuery<Login> query = entityManager.createQuery("Select l from Login l where l.loginname = :username", Login.class);
        query.setParameter("username", username);
        List<Login> resultList = query.getResultList();
        System.out.println(resultList.size());
        for (Login login : resultList) {
            if (login.getLoginname().equals(username) && login.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
