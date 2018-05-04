package de.gbsschulen.bookstore.book;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addBooks.do")
public class AddBooksServlet extends HttpServlet {

    @Inject  //Objekte werden durch Servlet-Container (Tomcat) bei Bedarf erzeugt! Bsp. Bookservice wird im Projekt mehrfach verwendet und durch CDI nur einmal erzeugt => Resscourcensparend!
    private BookService bookService;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/views/addBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Book book = new Book();
        book.setTitel(req.getParameter("titel"));
        book.setAuthor(req.getParameter("author"));
        book.setIsbn(req.getParameter("isbn"));
        bookService.save(book);
        resp.sendRedirect("listsBooks.do");
    }

}
