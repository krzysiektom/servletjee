package pl.coderslab.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Get61")
public class Get61 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        for (int i = 1980; i < 2011; i++) {
            response.getWriter().append("<a href='/Get62?year=")
                    .append(String.valueOf(i))
                    .append("'> Link do roku ")
                    .append(String.valueOf(i))
                    .append(" </a><br>");
        }
    }
}
