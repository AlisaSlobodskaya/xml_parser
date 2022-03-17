package application.parser;

import application.entity.Book;
import application.entity.Catalog;
import application.exception.InvalidCatalogException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class Dom {
    private Document document;

    public Dom(File file) {
        parseXmlFile(file);
    }

    public Catalog getBookCatalog() {
        Catalog bookCatalog = new Catalog();
        bookCatalog.setBooks(parseBookList());
        return bookCatalog;
    }

    //parse elements by "book" tag
    private Set<Book> parseBookList() {
        NodeList bookList = document.getElementsByTagName("book");
        Set<Book> books = new HashSet<>();
        for (int i = 0; i < bookList.getLength(); i++) {
            Node bookNode = bookList.item(i);
            if (bookNode.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            books.add(fillBookFields((Element) bookNode));
        }
        if (books.isEmpty()) {
            throw new InvalidCatalogException("Catalog is empty");
        }
        return books;
    }

    private Book fillBookFields(Element bookElement) {
        Book newBook = new Book();
        newBook.setVendorCode(bookElement.getAttribute("vendor_code"));
        newBook.setAuthor(bookElement.getElementsByTagName("author").item(0).getTextContent());
        newBook.setTitle(bookElement.getElementsByTagName("title").item(0).getTextContent());
        newBook.setGenre(bookElement.getElementsByTagName("genre").item(0).getTextContent());
        newBook.setPrice(
                Float.parseFloat(bookElement.getElementsByTagName("price").item(0).getTextContent()));
        newBook.setPublishDate(
                LocalDate.parse(bookElement.getElementsByTagName("publish_date").item(0).getTextContent()));
        newBook.setDescription(bookElement.getElementsByTagName("description").item(0).getTextContent());
        return newBook;
    }

    //create DOM-tree from xml-file
    private void parseXmlFile(File file) {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            document = dbf.newDocumentBuilder().parse(file);
            if (document == null) {
                throw new NullPointerException("Document is null");
            }
        } catch (SAXException | ParserConfigurationException | IOException e) {
            e.printStackTrace();
        }
    }
}
