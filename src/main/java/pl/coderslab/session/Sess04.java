package pl.coderslab.session;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/Sess04")
public class Sess04 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("UTF-8");

        List<CartItem> cartItems = (List<CartItem>) request.getSession().getAttribute("basket");
        if (cartItems == null) {
            cartItems = new ArrayList<>();
        }

        String name = request.getParameter("name");
        String quantity = request.getParameter("quantity");
        String price = request.getParameter("price");
        if (name != null && quantity != null && price != null) {
            try {
                CartItem cartItem = new CartItem(name, Integer.parseInt(quantity), Double.parseDouble(price));
                cartItems.add(cartItem);
                request.getSession().setAttribute("basket", cartItems);
            } catch (NumberFormatException e) {
                response.getWriter().append("Błąd w dodaniu produktu<br>");
            }
        }
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=utf-8");
        List<CartItem> cartItems = (List<CartItem>) request.getSession().getAttribute("basket");
        PrintWriter writer = response.getWriter();
        if (cartItems == null) {
            writer.append("Brak zamówień w koszyku<br>");
        } else {
            double sum = 0;
            for (CartItem cartItem : cartItems) {
                writer.append(cartItem.toString()).append("<br>");
                sum += cartItem.getSum();
            }
            writer.append("SUMA: ").append(String.valueOf(sum)).append("zł<br>");
        }
        writer.append("Aby dodać produkt kliknij na łącze: ").append("<a href=\"/index_04.html\">index_04.html</a>");
    }



    //post indeksowanie koszyka
    //get wyświetlanie koszyka
    // pod koszykiem link do strony index
    class CartItem {
        private String name;
        private int quantity;
        private double price;

        public CartItem() {
        }

        public CartItem(String name, int quantity, double price) {
            this.name = name;
            this.quantity = quantity;
            this.price = price;
        }

        public double getSum() {
            return quantity * price;
        }

        @Override
        public String toString() {
            return new StringBuilder().append(name)
                    .append(" - ").append(quantity)
                    .append(" x ").append(price).append("zł = ")
                    .append(quantity * price)
                    .append("zł").toString();
        }
    }
}
