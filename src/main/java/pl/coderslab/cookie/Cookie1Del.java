package pl.coderslab.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "Cookie1Del", urlPatterns = "/deleteCookie")
public class Cookie1Del extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        Cookie[] cookies = request.getCookies();
        if (cookies==null || cookies.length==0){
            response.getWriter().append("Brak ciasteczek");
        }
        for (Cookie cookie : cookies) {
            if ("User".equals(cookie.getName())) {
                cookie.setMaxAge(0);
                response.addCookie(cookie);
                response.getWriter().append("Skasowano ciasteczko");
                return;
            }
        }
        response.getWriter().append("Nie znaleziono ciasteczka: User");
    }
}
