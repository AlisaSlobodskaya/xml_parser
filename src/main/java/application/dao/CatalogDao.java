package application.dao;

import application.connection.DatabaseConnection;
import application.entity.Book;
import application.entity.Catalog;
import application.repository.CatalogRepository;

import java.sql.*;
import java.util.Set;

import static application.constant.Sql.DELETE_DUPLICATE_BOOKS;
import static application.constant.Sql.SAVE_BOOK;

public class CatalogDao implements CatalogRepository {
    private final DatabaseConnection databaseConnection;

    public CatalogDao() {
        this.databaseConnection = new DatabaseConnection();
    }

    //insert books into table with batch processing
    @Override
    public int[] saveCatalogBooks(Catalog catalog) {
        if (catalog == null) {
            throw new NullPointerException("Catalog is null");
        }
        try (Connection connection = databaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SAVE_BOOK)) {
            Set<Book> books = catalog.getBooks();
            for (Book book : books) {
                preparedStatement.setString(1, book.getVendorCode());
                preparedStatement.setString(2, book.getAuthor());
                preparedStatement.setString(3, book.getTitle());
                preparedStatement.setString(4, book.getGenre());
                preparedStatement.setFloat(5, book.getPrice());
                preparedStatement.setDate(6, Date.valueOf(book.getPublishDate()));
                preparedStatement.setString(7, book.getDescription());
                preparedStatement.addBatch();
            }
            var a = preparedStatement.executeBatch();
            deleteDuplicateBooks();
            return a;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return new int[]{0};
    }

    //avoiding duplicates from the database
    private void deleteDuplicateBooks() {
        try (Connection connection = databaseConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.execute(DELETE_DUPLICATE_BOOKS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
