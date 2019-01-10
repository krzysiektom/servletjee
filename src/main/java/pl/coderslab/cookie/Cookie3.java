package pl.coderslab.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Cookie3")
public class Cookie3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        int select = Integer.parseInt(request.getParameter("select"));
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(select*60*60);
        response.addCookie(cookie);
        response.getWriter().append("Ciasteczko dodane");
    }
}