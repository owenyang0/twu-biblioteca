package com.twu.biblioteca;

import com.twu.biblioteca.Modal.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songyang on 9/19/14.
 */
public class BookDao {

    List<Book> books = new ArrayList<>();
    List<Book> checkedBooks = new ArrayList<>();

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
            Book book = books.remove(bookIndex - 1);
            checkedBooks.add(book);

            return book;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }

    public List<Book> getCheckedBooks() {
        return checkedBooks;
    }
}
