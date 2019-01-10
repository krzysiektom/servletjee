package pl.coderslab.session;

import org.apache.commons.lang3.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet("/Sess02")
public class Sess02 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        HttpSession session = request.getSession();
        List<Integer> list = (List<Integer>) session.getAttribute("grade");
        response.getWriter().append(Form());
        String grade = request.getParameter("grade");
        if (StringUtils.isNumeric(grade)) {
            Integer gradeInt = Integer.valueOf(grade);
            if (gradeInt >= 1 && gradeInt <= 6) {
                list.add(gradeInt);
                response.getWriter().append("Wprowadzno ocenę: ").append(String.valueOf(gradeInt)).append("<br>");
            } else {
                response.getWriter().append("Wprowadzono nieprawidłowe dane").append("<br>");
            }
        } else {
            response.getWriter().append("Wprowadzono nieprawidłowe dane").append("<br>");
        }

        Integer sum = 0;
        for (Integer i : list) {
            sum += i;
        }
        double avr = Double.valueOf(sum) / list.size();
        response.getWriter().append("Ocena średnia: ").append(String.valueOf(avr)).append("<br>");
        response.getWriter().append("Oceny: ").append(Arrays.toString(list.toArray())).append(";<br>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        HttpSession session = request.getSession();
        List<Integer> list = new ArrayList<>();
        session.setAttribute("grade", list);
        response.getWriter().append(Form());
    }

    private String Form() {
        StringBuilder builder = new StringBuilder();
        builder.append("<form method='POST'>\n")
                .append("<label>")
                .append("Ocena:")
                .append("<input type=\"text\" name=\"grade\">")
                .append("</label>")
                .append("<input type=\"submit\">")
                .append("</form>");
        return builder.toString();
    }
}
