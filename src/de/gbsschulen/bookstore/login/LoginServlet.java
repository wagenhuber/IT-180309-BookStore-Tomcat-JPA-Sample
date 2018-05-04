package de.gbsschulen.bookstore.login;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet{

    @Inject
    private LoginService loginService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String loginname = req.getParameter("loginname");
        String password = req.getParameter("password");
        System.out.println(loginname);
        System.out.println(password);
        if (loginService.checkPassword(loginname, password)) {
            req.getSession().setAttribute("loginname", loginname);


            //loginService.saveLogin(new User(loginname,password));

            //req.getRequestDispatcher("/WEB-INF/views/welcome.jsp").forward(req, resp);

            resp.sendRedirect("listsBooks.do");


        } else {
            req.setAttribute("error", "LoginServlet war falsch!");
            req.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(req, resp);

        }


    }
}
