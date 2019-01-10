package pl.coderslab.mvc;

public class Book {
    private String title;
    private String author;
    private String ismb;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book() {
    }

    public Book(String title, String author, String ismb) {
        this.title = title;
        this.author = author;
        this.ismb = ismb;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ismb='" + ismb + '\'' +
                '}';
    }
}
