package de.gbsschulen.bookstore;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Login {

    @Id
    @GeneratedValue
    private int id;
    private String loginname;
    private String password;


    public Login() {
    }

    public Login(String loginname, String password) {
        this.loginname = loginname;
        this.password = password;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Login login = (Login) o;
        return Objects.equals(loginname, login.loginname) &&
                Objects.equals(password, login.password);
    }

    @Override
    public int hashCode() {

        return Objects.hash(loginname, password);
    }

    @Override
    public String toString() {
        return "Login{" +
                "loginname='" + loginname + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
