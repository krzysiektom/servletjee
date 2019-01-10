package pl.coderslab.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@WebServlet("/Cookie52")
public class Cookie52 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        Cookie[] cookies = request.getCookies();

        if (cookies == null || cookies.length == 0) {
            String message = "Nie odwiedziles jeszcze tej strony";
            response.sendRedirect("Cookie51?msg=" + URLEncoder.encode(message));
        } else {
            for (Cookie cookie : cookies) {
                if ("Cookie51".equals(cookie.getName()) && "yes".equals(cookie.getValue())) {
                    cookie.setMaxAge(0);
                    response.addCookie(cookie);
                    response.getWriter().append("Witamy na stronie Cookie52");
                }
            }
        }
    }
}
