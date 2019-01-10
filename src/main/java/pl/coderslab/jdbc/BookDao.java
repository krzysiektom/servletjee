package pl.coderslab.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDao {

    private static BookDao instance;
    private final String dbName = "jdbc_test";
    private final String URL = "jdbc:mysql://localhost:3306/" + dbName + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false&characterEncoding=UTF-8";
    private final String USER = "root";
    private final String PASSWORD = "coderslab";

    private BookDao() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static BookDao getInstance() {
        if (instance == null) {
            instance = new BookDao();
        }
        return instance;
    }

    public void save(Book book) {
        //zapis do bazy danych
        //1. stworzenie polaczenia
        //2. z polaczenia pobieramy preparedStatement
        //3. zapytanie (INSERT) + setInt(index,value)/setString(index,value)...
        //4. executeUpdate()<- TYLKO TA FUNKCJA MA UPRAWNIENIA DO insertów/updatetów/delete
        //5. zamykamy połączenie


        try (Connection conn = DriverManager.getConnection(URL,
                USER, PASSWORD)) {
            if (book.getId() == 0) {
                PreparedStatement stmt = conn.prepareStatement(
                        "INSERT INTO Book(title,author,isbn) VALUES(?,?,?)");
                stmt.setString(1, book.getTitle());
                stmt.setString(2, book.getAuthor());
                stmt.setString(3, book.getIsbn());
                stmt.executeUpdate();
            } else {
                PreparedStatement stmt = conn.prepareStatement(
                        "UPDATE Book SET title=?, author=?,isbn=? where id = ?");
                stmt.setString(1, book.getTitle());
                stmt.setString(2, book.getAuthor());
                stmt.setString(3, book.getIsbn());
                stmt.setInt(4, book.getId());
                stmt.executeUpdate();
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove(int id) {
        try (Connection conn = DriverManager.getConnection(URL,
                USER, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(
                    "DELETE FROM Book WHERE id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(URL,
                USER, PASSWORD)) {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT * FROM Book");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String isbn = rs.getString("isbn");
                Book b = new Book(id, title, author, isbn);
                list.add(b);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
