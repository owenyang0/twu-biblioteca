package com.twu.biblioteca.Dao;

import com.twu.biblioteca.Modal.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by songyang on 9/19/14.
 */
public class BookDao {

    private List<Book> books = new ArrayList<>();
    private List<Book> checkedBooks = new ArrayList<>();

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

    public boolean returnBook(Book book) {
        if (checkedBooks.contains(book) && checkedBooks.remove(book)) {
            return books.add(book);
        } else {
            return false;
        }
    }

    public Book getCheckedBook(int index) {
        try {
            Book book = checkedBooks.get(index - 1);
            return returnBook(book) ? book : null;
        } catch (IndexOutOfBoundsException e) {
            return null;
        }
    }
}
