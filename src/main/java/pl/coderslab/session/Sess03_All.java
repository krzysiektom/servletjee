package pl.coderslab.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showAllSession")
public class Sess03_All extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        List<String[]> sess04 = (List<String[]>) request.getSession().getAttribute("Sess04");
        if (sess04 == null) {
            response.getWriter().append("Brak danych w sesji");
            return;
        }
        for (String[] ss : sess04) {
            response.getWriter()
                    .append("Klucz: ")
                    .append(ss[0])
                    .append(", Wartość: ")
                    .append(ss[1])
                    .append(";")
                    .append("<br>");
        }
    }
}
