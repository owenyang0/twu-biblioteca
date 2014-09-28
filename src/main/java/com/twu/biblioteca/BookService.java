package com.twu.biblioteca;

import com.twu.biblioteca.Modal.Book;

import java.io.PrintStream;
import java.util.List;

/**
 * Created by songyang on 9/19/14.
 */
public class BookService {
    public void list(PrintStream printStream) {
        List<Book> books = new BookDao().getAllBooks();
        String fmt = "%1$-40s %2$-10s %3$10s%n";

        printStream.format(fmt, "Book Name", "Author", "Published Year");
        printStream.format(fmt, "---------", "------", "--------------");

        for (Book book : books) {
            printStream.format(fmt, book.getName(), book.getAuthor(), book.getYear());
        }
    }

    public Book checkout(int index) {
        return new BookDao().getBook(index);
    }
}
