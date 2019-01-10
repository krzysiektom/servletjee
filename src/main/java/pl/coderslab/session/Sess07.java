package pl.coderslab.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/Sess07")
public class Sess07 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=utf-8");
        HttpSession session = request.getSession();
        String[][] country = (String[][]) session.getAttribute("Sess07");
        String[] answers = request.getParameterValues("country");
        int result = 0;
        for (int i = 0; i < country.length; i++) {
            if (country[i][1].equals(answers[i])) {
                result++;
            }
        }
        response.getWriter().append("Poprawnych odpowiedzi: ")
                .append(String.valueOf(result));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        String[][] country = {{"Niemcy", "Berlin"},
                {"Czechy", "Praga"},
                {"Słowacja", "Bratysława"},
                {"Ukraina", "Kijów"},
                {"Białoruś", "Mińsk"},
                {"Litwa", "Wilno"},
                {"Rosja", "Moskwa"}};
        HttpSession session = request.getSession();
        session.setAttribute("Sess07", country);
        response.getWriter().append(Form(country));
    }

    private String Form(String[][] country) {
        StringBuilder builder = new StringBuilder();
        builder.append("<form method='POST'>")
                .append("podaj stolicę dla państwa:")
                .append("<br>");
        for (int i = 0; i < country.length; i++) {
            builder.append("<label>")
                    .append(country[i][0])
                    .append(": ")
                    .append("<input type=\"text\" name=\"country\">")
                    .append("</label>")
                    .append("<br>");
        }
        builder.append("<input type=\"submit\">")
                .append("</form>");
        return builder.toString();
    }

}

