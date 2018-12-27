package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

@WebServlet("/Get62")
public class Get62 extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String year = request.getParameter("year");
        Random random = new Random();
        for (int i = 0; i < 5; i++) {
            int mix=random.nextInt(21)-10;
            response.getWriter().append("<a href='/Get63?year=")
                    .append(year)
                    .append("&mix=")
                    .append(String.valueOf(mix))
                    .append("'> Link do roku ")
                    .append(year)
                    .append(", mix ")
                    .append(String.valueOf(mix))
                    .append(" </a><br>");

            //<a href='/Project_02/Get63?year=1985&mix=-2'> Rok 1985, mix -2 </a>
        }
    }
}
