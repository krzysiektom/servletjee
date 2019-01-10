package pl.coderslab.mvc;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Mvc12")
public class Mvc12 extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String start = request.getParameter("start");
        String end = request.getParameter("end");
        if (StringUtils.isBlank(start) || StringUtils.isBlank(start)) {
            response.getWriter().append("Brak wyników");
            return;
        }
        if (!StringUtils.isNumeric(start) || !StringUtils.isNumeric(end)) {
            response.getWriter().append("Wprowadzone dane nie są liczbami");
            return;
        }

        Double startDouble = Double.parseDouble(start) + 10;
        Double endDouble = Double.parseDouble(end) + 10;
        request.setAttribute("start", startDouble);
        request.setAttribute("end", endDouble);
        getServletContext().getRequestDispatcher("/jsp12.jsp").forward(request,response);
    }
}
