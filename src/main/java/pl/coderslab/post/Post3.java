package pl.coderslab.post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Post3")
public class Post3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        Double a = Double.valueOf(request.getParameter("a"));
        Double b = Double.valueOf(request.getParameter("b"));
        Double c = Double.valueOf(request.getParameter("c"));
        if (a == 0) {
            response.getWriter().append("Wprowadzone dane nieopisują równania kwadratowego");

        } else {
            Double delta = b * b - 4 * a * c;
            if (delta < 0) {
                response.getWriter().append("Brak rozwiązań");
            } else if (delta == 0) {
                Double x = -b / 2 / a;
                response.getWriter().append("Jedno rozwiązanie x= ").append(x.toString());
            } else {
                Double x1 = (-b - Math.sqrt(delta)) / 2 / a;
                Double x2 = (-b + Math.sqrt(delta)) / 2 / a;
                response.getWriter().append("Dwa rozwiązania <br> x1= ").append(x1.toString()).append("<br>x2=").append(x2.toString());
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().append("Metoda doGet, nie o to chodziło");
    }
}
