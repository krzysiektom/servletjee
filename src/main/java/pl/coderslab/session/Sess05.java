package pl.coderslab.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet("/Sess05")
public class Sess05 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        HttpSession session = request.getSession();
        Integer captchaCookie = (Integer) session.getAttribute("captcha");
        String captcha = request.getParameter("captcha");
        if (String.valueOf(captchaCookie).equals(captcha)) {
            response.getWriter().append("Wynik prawidłowy");
        } else {
            response.getWriter().append("Wynik nieprawidłowy");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        Random random = new Random();
        int number1 = random.nextInt(101);
        int number2 = random.nextInt(101);
        Integer[] numbers = {number1, number2};

        HttpSession session = request.getSession();
        session.setAttribute("captcha", number1 + number2);
        response.getWriter().append(Form(numbers));
    }

    private String Form(Integer[] numbers) {
        StringBuilder builder = new StringBuilder();
        builder.append("<form method='POST'>")
                .append("<label>")
                .append("Imię:")
                .append("<input type=\"text\" name=\"name\">")
                .append("</label>")
                .append("<br>")
                .append("<label>")
                .append("Nazwisko:")
                .append("<input type=\"text\" name=\"surname\">")
                .append("</label>")
                .append("<br>")
                .append("<label>")
                .append("Mail:")
                .append("<input type=\"text\" name=\"email\">")
                .append("</label>")
                .append("<br>")
                .append("<label>")
                .append("Wpisz poniżej sumę ")
                .append(numbers[0])
                .append(" + ")
                .append(numbers[1])
                .append(":")
                .append("<br>")
                .append("<input type=\"number\" name=\"captcha\">")
                .append("</label>")
                .append("<br>")
                .append("<input type=\"submit\">")
                .append("</form>");
        return builder.toString();
    }
}
