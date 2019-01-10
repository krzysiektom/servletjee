package pl.coderslab.mvc;

import pl.coderslab.jdbc.BookDao;
import pl.coderslab.jdbc.Book;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Mvc13")
public class Mvc13 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");
        Book book =new Book(title,author,isbn);
        request.setAttribute("book", book);

        BookDao.getInstance().save(book);

        getServletContext().getRequestDispatcher("/result.jsp")
                .forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/Mvc13.jsp")
                .forward(request, response);
    }
}
