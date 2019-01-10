package pl.coderslab.get;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Get5")
public class Get5 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        String company = request.getParameter("company");
        String[] learn = request.getParameterValues("learn");
        response.getWriter().append("company:")
                .append("<br>");
        response.getWriter().append("&nbsp&nbsp-&nbsp")
                .append(company)
                .append("<br>");
        response.getWriter().append("learn:")
                .append("<br>");
        for (String s: learn) {
            response.getWriter().append("&nbsp&nbsp-&nbsp")
                    .append(s)
                    .append("<br>");
        }


    }
}
