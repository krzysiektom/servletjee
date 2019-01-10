package pl.coderslab.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/addToSession")
public class Sess03_Add extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();

        List<String[]> sess04 = (List<String[]>) session.getAttribute("Sess04");
        if (sess04==null){
            sess04 =new ArrayList<>();
        }
        String key = request.getParameter("key");
        String value = request.getParameter("value");
        String[] tab = {key, value};
        sess04.add(tab);
        request.getSession().setAttribute("Sess04", sess04);
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        response.getWriter().append(Form());
    }

    private String Form() {
        StringBuilder builder = new StringBuilder();
        builder.append("<form method='POST'>\n")
                .append("<label>")
                .append("Klucz:")
                .append("<input type=\"text\" name=\"key\">")
                .append("</label>")
                .append("<label>")
                .append("Wartość:")
                .append("<input type=\"text\" name=\"value\">")
                .append("</label>")
                .append("<input type=\"submit\">")
                .append("</form>");
        return builder.toString();
    }
}
