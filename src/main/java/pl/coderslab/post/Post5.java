package pl.coderslab.post;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Post5")
public class Post5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        String type = request.getParameter("convertionType");
        String degrees = request.getParameter("degrees");
/*
        if (!StringUtils.isNumeric(degrees)) {
            response.getWriter().append("Wrowadzona wartość nie jest liczbą");
            return;
        }
*/
        double degreesDouble;
        try {
            degreesDouble = Double.parseDouble(degrees);
        } catch (NumberFormatException E) {
            response.getWriter().append("Wrowadzona wartość nie jest liczbą");
            return;
        }
        if ("celcToFahr".equals(type)) {
            response.getWriter().append("Wprowadzona wartość w skali Celsjusza ")
                    .append(String.valueOf(degreesDouble))
                    .append("<br>")
                    .append("Tempertura w skali Fahrenheita ")
                    .append(String.valueOf(degreesDouble * 9 / 5 + 32));
            return;
        }
        if ("fahrToCelc".equals(type)) {
            response.getWriter().append("Wprowadzona wartość w skali Fahrenheita ")
                    .append(String.valueOf(degreesDouble))
                    .append("<br>")
                    .append("Tempertura w skali Celsjusza ")
                    .append(String.valueOf((degreesDouble - 32) * 5 / 9));
            return;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().append("Metoda doGet, nie o to chodziło");
    }
}
