package pl.coderslab.mvc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Mvc152")
public class Mvc152 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        List<Book> books= (List<Book>) request.getSession().getAttribute("books");
        if (books==null){
            books=new ArrayList<>();
        }
        for (int i = 1; i < 4; i++) {
            String title = request.getParameter("title"+i);
            String author = request.getParameter("author"+i);
            String isbn = request.getParameter("isbn"+i);
            Book book =new Book(title,author,isbn);
            books.add(book);
        }

        for (Book book: books) {
            System.out.println(book.toString());
        }

        request.getSession().setAttribute("books",books);
        response.sendRedirect("/Mvc154"); // przejście do serwletu

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/form2.jsp")
                .forward(request, response);
    }
}
