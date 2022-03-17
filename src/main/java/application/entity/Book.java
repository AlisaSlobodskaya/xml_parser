package application.entity;

import java.time.LocalDate;
import java.util.Objects;

public class Book {
    private String vendorCode;
    private String author;
    private String title;
    private String genre;
    private float price;
    private LocalDate publishDate;
    private String description;

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(LocalDate publishDate) {
        this.publishDate = publishDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Float.compare(book.price, price) == 0
                && Objects.equals(vendorCode, book.vendorCode)
                && Objects.equals(author, book.author)
                && Objects.equals(title, book.title)
                && Objects.equals(genre, book.genre)
                && Objects.equals(publishDate, book.publishDate)
                && Objects.equals(description, book.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendorCode, author, title, genre, price, publishDate, description);
    }
}
