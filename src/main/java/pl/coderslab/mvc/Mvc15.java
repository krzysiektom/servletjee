package pl.coderslab.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Mvc15")
public class Mvc15 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        List<Book> books= (List<Book>) request.getSession().getAttribute("books");
        if (books==null){
            books=new ArrayList<>();
        }
        response.setContentType("text/html; charset=utf-8");
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");
        Book book =new Book(title,author,isbn);
        books.add(book);

        request.getSession().setAttribute("books",books);
        doGet(request,response);

    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/form1.jsp")
                .forward(request, response);
    }
}
