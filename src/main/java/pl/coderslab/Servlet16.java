package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;

@WebServlet("/Servlet16")
public class Servlet16 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String AdressIP = request.getRemoteAddr();
        String browser= request.getHeader("user-agent");
        response.getWriter().append("Adress IP : ").append(AdressIP).append("\n");
        response.getWriter().append("User-agent : ").append(browser).append("\n");
        response.getWriter().append("Local time : ").append(LocalTime.now().toString());
    }
}
