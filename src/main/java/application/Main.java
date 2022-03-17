package application;

import application.dao.CatalogDao;
import application.entity.Book;
import application.entity.Catalog;
import application.parser.Dom;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        //specify your file in class constructor
        Dom dom = new Dom(new File("books.xml"));
        Catalog bookCatalog = dom.getBookCatalog();

        //import data into database
        CatalogDao catalogDao = new CatalogDao();
        catalogDao.saveCatalogBooks(bookCatalog);
    }
}
