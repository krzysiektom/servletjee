package pl.coderslab.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Mvc154")
public class Mvc154 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Book> books = (List<Book>) request.getSession().getAttribute("books");
        request.setAttribute("books", books);
        getServletContext().getRequestDispatcher("/form3.jsp")
                .forward(request, response);
    }
}
