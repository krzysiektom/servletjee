package pl.coderslab.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

@WebServlet("/rememberMe")
public class Cookie6 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String box = request.getParameter("agree");
        if ("on".equals(box)) {
            Cookie cookie = new Cookie("name", name);
            cookie.setMaxAge(60 * 60);
            response.addCookie(cookie);
        }
        response.getWriter().append("Cześć ").append(name);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length != 0) {
            for (Cookie cookie : cookies) {
                if ("name".equals(cookie.getName())) {
                    cookie.setMaxAge(60 * 60);
                    response.addCookie(cookie);
                    response.getWriter().append("Cześć ")
                            .append(cookie.getValue())
                            .append(". Twoje dane zostały wczytane z ciasteczka.");
                    return;
                }
            }
        }

        PrintWriter writer = response.getWriter();
        writer.append("<form method=\"post\">")
                .append("Podaj imię: ")
                .append("<input type=\"text\" name=\"name\">")
                .append("<br>")
                .append("Zapamiętaj mnie")
                .append("<input type=\"checkbox\" name=\"agree\">")
                .append("<br>")
                .append("<input type=\"submit\" value=\"Wyślij\">");
    }
}
