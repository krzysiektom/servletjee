package pl.coderslab.post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Post1")
public class Post1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        String name = request.getParameter("name");
        String surname = request.getParameter("surname");
        response.getWriter().append("Witaj, ")
                .append(name)
                .append(" ")
                .append(surname);
    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().append("Metoda doGet, nie o to chodziło");
    }

}
