package de.gbsschulen.bookstore.book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteBooks.do")
public class DeleteBooksServlet extends HttpServlet {

    private BookService bookService = new BookService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(req.getParameter("id"));
        String id = req.getParameter("id");
        bookService.deleteBook(Integer.parseInt(id));
        resp.sendRedirect("/listsBooks.do");
    }
}
