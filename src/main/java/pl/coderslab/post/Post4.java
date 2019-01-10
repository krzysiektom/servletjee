package pl.coderslab.post;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet("/Post4")
public class Post4 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        String[] strings = request.getParameterValues("numbers");
        List<Double> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            try {
                Double temp = Double.valueOf(strings[i]);
                list.add(temp);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        Collections.sort(list);
        response.getWriter().append(Arrays.toString(list.toArray()));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");

        Random random = new Random();
        int numbers = random.nextInt(6) + 5;
        PrintWriter writer = response.getWriter();
        writer.append("<form action='' method='post'>");
        for (int i = 0; i < numbers; i++) {
            writer.append("<input type=\"text\" name='numbers'/><br/>");
        }
        writer.append(new StringBuilder().append("<input type='submit'/>\n").append("</form>").toString());
    }
}
