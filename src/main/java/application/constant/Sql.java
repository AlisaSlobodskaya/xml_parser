package application.constant;

public class Sql {
    public static final String SAVE_BOOK =
            "INSERT INTO books (vendorCode, author, title, genre, price, publishDate, description)" +
                    " VALUES (?,?,?,?,?,?,?)";
    public static final String DELETE_DUPLICATE_BOOKS =
            "DELETE FROM books WHERE ctid NOT IN (SELECT max(ctid) FROM books " +
                    "GROUP BY vendorCode, author, title, genre, price, publishDate, description)";

    private Sql() {
    }
}