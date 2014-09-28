package com.twu.biblioteca;

import com.twu.biblioteca.Modal.Book;

import java.util.List;

/**
 * Created by songyang on 9/19/14.
 */
public class BookService {
    public void list() {
        List<Book> books = new BookDao().getAllBooks();
        String fmt = "%1$-40s %2$-10s %3$10s%n";

        System.out.format(fmt, "Book Name", "Author", "Published Year");
        System.out.format(fmt, "---------", "------", "--------------");

        for (Book book : books) {
            System.out.format(fmt, book.getName(), book.getAuthor(), book.getYear());
        }
    }

    public Book checkout(int index) {
        return new BookDao().getBook(index);
    }
}
