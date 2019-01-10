package pl.coderslab.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Cookie51")
public class Cookie51 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie cookie = new Cookie("Cookie51","yes");
        cookie.setMaxAge(60*60);
        response.addCookie(cookie);
        response.getWriter().append("<a href=\"/Cookie52\">Cookie52</a>");
    }
}
