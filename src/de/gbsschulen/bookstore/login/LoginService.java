package de.gbsschulen.bookstore.login;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped //Gültigkeitsbereich für CDI => nur ein Objekt von LoginService für ganze Anwendung/alle Sessions
public class LoginService {


    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;


    public LoginService() {
        entityManagerFactory = Persistence.createEntityManagerFactory("bookstore");
        entityManager = entityManagerFactory.createEntityManager();
    }

    public void saveLogin(User login){
        entityManager.getTransaction().begin();
        entityManager.persist(login);
        entityManager.getTransaction().commit();
    }



    public boolean checkPassword(String username, String password){
        if (username != null && username.length() == 0) {
            return false;
        }
        TypedQuery<User> query = entityManager.createQuery("Select l from User l where l.loginname = :username", User.class);
        query.setParameter("username", username);
        List<User> resultList = query.getResultList();
        System.out.println(resultList.size());
        for (User login : resultList) {
            if (login.getLoginname().equals(username) && login.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }

}
