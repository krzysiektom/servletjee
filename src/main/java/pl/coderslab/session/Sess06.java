package pl.coderslab.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Random;

@WebServlet("/Sess06")
public class Sess06 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        HttpSession session = request.getSession();
        Integer[] numbers = (Integer[]) session.getAttribute("Sess06");
        int addResult;
        int subResult;
        int mulResult;
        try {
            addResult = Integer.parseInt(request.getParameter("add"));
            subResult = Integer.parseInt(request.getParameter("subtract"));
            mulResult = Integer.parseInt(request.getParameter("multiply"));
        } catch (NumberFormatException e) {
            response.getWriter().append("Wprowadzone wartości nie są liczbami");
            return;
        }
        response.getWriter().append(Form2(numbers, addResult, subResult, mulResult));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        Random random = new Random();
        int number1 = random.nextInt(10);
        int number2 = random.nextInt(10);
        Integer[] numbers = {number1, number2};
        HttpSession session = request.getSession();
        session.setAttribute("Sess06", numbers);
        response.getWriter().append(Form(numbers));
    }

    private String Form(Integer[] numbers) {
        StringBuilder builder = new StringBuilder();
        builder.append("<form method='POST'>")
                .append("Wprowadz wyniki działąń na liczbach:")
                .append(numbers[0])
                .append(" i ")
                .append(numbers[1])
                .append("<br>")
                .append("<label>")
                .append("Dodawanie:")
                .append("<input type=\"number\" name=\"add\">")
                .append("</label>")
                .append("<br>")
                .append("<label>")
                .append("Odejmowania:")
                .append("<input type=\"number\" name=\"subtract\">")
                .append("</label>")
                .append("<br>")
                .append("<label>")
                .append("Mnożenia:")
                .append("<input type=\"number\" name=\"multiply\">")
                .append("</label>")
                .append("<br>")
                .append("<input type=\"submit\">")
                .append("</form>");
        return builder.toString();
    }

    private String Form2(Integer[] numbers, int add, int sub, int mul) {
        StringBuilder builder = new StringBuilder();
        builder.append("Wyniki działań:")
                .append("<br>")
                .append(numbers[0])
                .append(" + ")
                .append(numbers[1])
                .append(" = ")
                .append(add)
                .append(" ")
                .append(add == numbers[0] + numbers[1] ? "Correct" : "Wrong")
                .append("<br>")
                .append(numbers[0])
                .append(" - ")
                .append(numbers[1])
                .append(" = ")
                .append(sub)
                .append(" ")
                .append(sub == numbers[0] - numbers[1] ? "Correct" : "Wrong")
                .append("<br>")
                .append(numbers[0])
                .append(" * ")
                .append(numbers[1])
                .append(" = ")
                .append(mul)
                .append(" ")
                .append(mul == numbers[0] * numbers[1] ? "Correct" : "Wrong")
                .append("<br>");
        return builder.toString();
    }
}
