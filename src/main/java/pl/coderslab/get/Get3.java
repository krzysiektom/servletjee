package pl.coderslab.get;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Get3")
public class Get3 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        String width = request.getParameter("width");
        String height = request.getParameter("height");
        Integer widthNumber;
        Integer heightNumber;
        if (!StringUtils.isNumeric(width) || !StringUtils.isNumeric(height)) {
            widthNumber = 5;
            heightNumber = 10;
        } else {
            widthNumber = Integer.parseInt(width);
            heightNumber = Integer.parseInt(height);
        }
        for (int i = 0; i <= widthNumber; i++) {
            for (int j = 0; j <= heightNumber; j++) {
                response.getWriter().append(String.valueOf(i))
                        .append(" * ")
                        .append(String.valueOf(j))
                        .append(" = ")
                        .append(String.valueOf(i*j))
                        .append("<br>");
            }
            response.getWriter().append("<br>");
        }

    }
}
