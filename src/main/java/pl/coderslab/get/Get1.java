package pl.coderslab.get;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Get1")
public class Get1 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");

        String start = request.getParameter("start");
        String end = request.getParameter("end");

        if (StringUtils.isBlank(start) || StringUtils.isBlank(end) || !StringUtils.isNumeric(start) || !StringUtils.isNumeric(end)) {
            response.getWriter().append("Brak przesłanych zmiennych");
            return;
        }

        Integer startNumber = Integer.parseInt(start);
        Integer endNumber = Integer.parseInt(end);
        if (startNumber > endNumber) {
            response.getWriter().append("start musi być większe od end");
            return;
        }
        for (int i = startNumber; i <= endNumber; i++) {
response.getWriter().append(String.valueOf(i)).append(", ");
        }

    }
}
