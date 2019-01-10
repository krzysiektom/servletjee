package pl.coderslab.jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/search-book")
public class MvcJdbc04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> searchBooks = new ArrayList<>();
        List<Book> books = BookDao.getInstance().findAll();

        String searchTitle = request.getParameter("searchTitle");
        Pattern pattern = Pattern.compile(searchTitle, Pattern.CASE_INSENSITIVE);
        for (Book book : books) {
            Matcher matcher = pattern.matcher(book.getTitle());
            if (matcher.find()) {
                searchBooks.add(book);
            }
        }
        request.setAttribute("books", searchBooks);
        getServletContext().getRequestDispatcher("/all-books.jsp")
                .forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/all-books.jsp")
                .forward(request, response);
    }
}
