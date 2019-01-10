package pl.coderslab.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Cookie4Show")
public class Cookie4Show extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) {
            response.getWriter().append("Brak ciasteczek");
        }
        PrintWriter writer = response.getWriter();
        for (Cookie cookie : cookies) {
            writer.append(cookie.getName())
                    .append(" ")
                    .append(cookie.getValue())
                    .append("<a href=\"/Cookie4Del?cookieName=")
                    .append(cookie.getName())
                    .append("\"> Usuń</a>")
                    .append("<br>");
        }
    }
}
