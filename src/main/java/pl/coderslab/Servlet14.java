package pl.coderslab;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Servlet14")
public class Servlet14 extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("To wyświetla się raz");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("To wyświetla się za każdym razem");
    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("To się wyświetla przy usuwaniu servletu");
    }
}
