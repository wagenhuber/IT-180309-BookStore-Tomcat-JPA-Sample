package de.gbsschulen.bookstore;

public class LoginService {

    public boolean checkPassword(String username, String password){
        if (username != null && password != null && "zukurz".equals(password) && "P.Enis".equals(username)) {
            return true;
        }
        return false;
    }

}
