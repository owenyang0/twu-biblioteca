package com.twu.biblioteca;

import com.twu.biblioteca.Modal.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songyang on 9/19/14.
 */
public class BookDao {

    List<Book> books = new ArrayList<>();

    public BookDao() {
        books.add(new Book("ASync JavaScript", "Trevor", "2013"));
        books.add(new Book("Pragmatic Programmer", "Andrew", "2011"));
        books.add(new Book("Learning JavaScript Design Patterns", "Addy", "2013"));
    }


    public List<Book> getAllBooks() {
        return books;
    }

    public Book getBook(int bookIndex) {
        try {
            return books.get(bookIndex - 1);
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
