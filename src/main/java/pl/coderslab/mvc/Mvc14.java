package pl.coderslab.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/Mvc14")
public class Mvc14 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        List<Book> books = new ArrayList<>();
        for (int i = 1; i < 6; i++) {
            String title = request.getParameter("title"+i);
            String author = request.getParameter("author"+i);
            String isbn = request.getParameter("isbn"+i);
            Book book =new Book(title,author,isbn);
            books.add(book);
        }
        for (Book book: books) {
            System.out.println(book.toString());
        }

        request.setAttribute("books", books);
        getServletContext().getRequestDispatcher("/result.jsp")
                .forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/form.jsp")
                .forward(request, response);
    }
}
